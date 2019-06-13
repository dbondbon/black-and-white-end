package top.dbon.blackandwhite.util;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 生成6位随机用户名
 */
public class UsernameUtils {

  public static String getNextUsername() {
    String username = RandomStringUtils.random(6, "1234567890");
    while (username.startsWith("0")) {
      username = RandomStringUtils.random(6, "1234567890");
    }
    return username;
  }

//  public static void main(String[] args) {
//    for (int i = 0 ; i < 30;i++) {
//      System.out.println(UsernameUtils.getNextUsername());
//    }
//  }

}
