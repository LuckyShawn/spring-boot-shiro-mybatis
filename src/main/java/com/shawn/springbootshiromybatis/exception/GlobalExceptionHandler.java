package com.shawn.springbootshiromybatis.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: TODO
 * @Author: yang.xiao
 * @Date: 2018/12/25 0025
 */
@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    public static final String ERROR_VIEW_403 = "403";

    @ExceptionHandler(value = Exception.class)
    //@ResponseBody //返回Json数据而不是html
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = AuthorizationException.class)
    public ModelAndView handleAuthorizationException(HttpServletRequest req, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.addObject("exception", e);
        modelAndView.setViewName(ERROR_VIEW_403);
        return modelAndView;
    }

}
