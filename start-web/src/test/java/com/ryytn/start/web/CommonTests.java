package com.ryytn.start.web;

import com.alibaba.fastjson2.JSON;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.util.text.AES256TextEncryptor;
import org.junit.jupiter.api.Test;

/**
 * CommonTests
 *
 * @author tony
 * @date 4/19/23
 */
@Slf4j
public class CommonTests {

  @Test
  public void testEncrypt() {
    AES256TextEncryptor encryptor = new AES256TextEncryptor();
    encryptor.setPassword("Ryytn!123456");
    String encrypt = encryptor.encrypt("test1");
    System.out.println(encrypt);
  }

  @Test
  public void testSort() {
    int[][] coupons = {{53, 15}, {60, 15}, {100, 20}};
    Arrays.sort(coupons, (a, b) -> {
      if (a[1] != b[1]) {
        return Integer.compare(b[1], a[1]);
      } else {
        return Integer.compare(a[0], b[0]);
      }
    });
    System.out.println(JSON.toJSONString(coupons));
    System.out.println(JSON.toJSONString(coupons[2]));
  }

}
