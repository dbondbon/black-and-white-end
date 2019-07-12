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
import top.dbon.blackandwhite.util.JwtUtils;

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
public class WebAuthenticationAspect {

    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * top.dbon.blackandwhite.controller..*.*(..))")
    public void webAuthentication(){}

    @Order(1)
    @Before("webAuthentication()")
    public void doBefore(JoinPoint joinPoin) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("Authorization");
        if ("login".equals(joinPoin.getSignature().getName()) || "register".equals(joinPoin.getSignature().getName())) {
            logger.debug("注册和登录操作不需要验证token令牌");
        } else {
            logger.debug("接收到Web请求,用户携带的令牌为：{}", token);
            JwtUtils.parseJWT(token);
        }
    }
}
