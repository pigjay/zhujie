package com.pigganme.framework.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pigganme.framework.result.Result;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	@ExceptionHandler(value = Exception.class)
    public Result defaultErrorHandler(HttpServletRequest request,Exception e)throws Exception{
    	Result result =new Result();
    	e.printStackTrace();
    	result.setMessage(e.getMessage());
    	return result;
    }
}
