package org.honor.tourism.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.honor.tourism.util.EasyuiResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}
	
    @ExceptionHandler(value = EasyuiJSONException.class)
    @ResponseBody
    public Map<String, Object> easyuiJSONErrorHandler(HttpServletRequest req, EasyuiJSONException e) throws Exception {
        return EasyuiResult.result(false, e.getMessage());
    }

}
