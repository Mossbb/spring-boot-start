package com.ryytn.start.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yinxin
 * @since 2020-10-13
 */
@Controller
@Slf4j
public class HealthController {

  @RequestMapping("/status")
  @ResponseBody
  public String doHC(HttpServletRequest request, HttpServletResponse response) {
    return "success";
  }
}
