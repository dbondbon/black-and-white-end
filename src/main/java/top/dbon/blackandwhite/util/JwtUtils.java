//package top.dbon.blackandwhite.util;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import java.security.Key;
//
///**
// * @ClassName JwtUtils
// * @Descrcription jwt工具类，用来生成及解析token令牌
// * @Author zzc
// * @Date 2019/7/9 10:45
// * @Version 1.0
// */
//public class JwtUtils {
//
//    public static String createJws() {
//        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//        return Jwts.builder().setSubject("Joe").signWith(key).compact();
//    }
//
//}
