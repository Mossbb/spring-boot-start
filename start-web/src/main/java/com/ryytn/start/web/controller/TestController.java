package com.ryytn.start.web.controller;

import com.ryytn.start.common.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yinxin
 * @since 2020-10-14
 */
@Controller
@Slf4j
public class TestController {

    @RequestMapping("/test/status")
    @ResponseBody
    public Result<String> doTest(HttpServletRequest request, HttpServletResponse response) {
        return Result.buildSuccess("OK");
    }
}
