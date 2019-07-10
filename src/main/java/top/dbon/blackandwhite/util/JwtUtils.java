package top.dbon.blackandwhite.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import top.dbon.blackandwhite.common.Constant;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @ClassName JwtUtils
 * @Descrcription jwt工具类，用来生成及解析token令牌
 * @Author zzc
 * @Date 2019/7/9 10:45
 * @Version 1.0
 */
public class JwtUtils {

    /**
     * 生成令牌
     * @param id
     * @param issuer 签发人
     * @param subject 主题
     * @param ttlMillis 过期时间
     * @return
     */
    public static String createJWT(String id, String issuer, String subject, long ttlMillis) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; //指定签名的时候使用的签名算法

        long nowMillis = System.currentTimeMillis(); //生成JWT的时间
        Date now = new Date(nowMillis);

        //生成密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(Constant.JWT_SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //设置JWT声明
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        //添加过期时间
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //构建JWT并将其序列化为紧凑的、url安全的字符串
        return builder.compact();
    }

    /**
     * 解码和验证令牌
     * @param jwt
     */
    public static void parseJWT(String jwt) {
        //如果不是签名的JWS，这一行将抛出异常(如预期的那样)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(Constant.JWT_SECRET))
                .parseClaimsJws(jwt).getBody();
        System.out.println("ID: " + claims.getId());
        System.out.println("Subject: " + claims.getSubject());
        System.out.println("Issuer: " + claims.getIssuer());
        System.out.println("Expiration: " + claims.getExpiration());
    }

}
