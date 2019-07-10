package top.dbon.blackandwhite.common;

import ch.qos.logback.classic.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName WebAuthenticationAspect
 * @Descrcription 对Web层接收到的请求统一根据token令牌进行身份验证
 * @Author zzc
 * @Date 2019/7/10 20:01
 * @Version 1.0
 */

@Aspect
@Component
@Order(1)
public class WebAuthenticationAspect {

    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * top.dbon.blackandwhite.controller..*.*(..))")
    public void webAuthentication(){}

    @Before("webAuthentication()")
    public void doBefore(JoinPoint joinPoin) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("Authorization");
        logger.debug("接收到Web请求,用户携带的令牌为：{}", token);
    }

}
