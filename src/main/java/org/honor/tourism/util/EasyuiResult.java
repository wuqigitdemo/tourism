package org.honor.tourism.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * EasyUi 返回
 * @author keiwu
 *
 */
public class EasyuiResult {

	public static final String SUCCESS = "success";
	public static final String ERROR_MSG = "errorMsg";
	public static final String MSG = "msg";
	public static final String ROWS = "rows";
	public static final String TOTAL = "total";
	
	public static Map<String, Object> result(Boolean success) {
		Map<String, Object> map = new HashMap<>();
		map.put(EasyuiResult.SUCCESS, success);
		return map;
	}
	
	public static Map<String, Object> result(Boolean success, String msg) {
		Map<String, Object> map = new HashMap<>();
		map.put(EasyuiResult.SUCCESS, success);
		if (success == false) {
			map.put(EasyuiResult.ERROR_MSG, msg);	
		} else {
			map.put(EasyuiResult.MSG, msg);	
		}
		return map;
	}
	
	public static Map<String, Object> result(List<?> rows, Long total) {
		Map<String, Object> map = new HashMap<>();
		map.put(EasyuiResult.ROWS, rows);
		map.put(EasyuiResult.TOTAL, total);
		return map;
	}
	
	public static Map<String, Object> result(BindingResult result) {
		List<ObjectError> allErrors = result.getAllErrors();
		Map<String, Object> map = new HashMap<>();
		map.put(EasyuiResult.SUCCESS, false);
		StringBuffer sb = new StringBuffer();
		for (int i = (allErrors.size() - 1); i > -1; i--) {
			ObjectError objectError = allErrors.get(i);
			sb.append(objectError.getDefaultMessage());
			sb.append("，");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("。");
		map.put(EasyuiResult.ERROR_MSG, sb.toString());	
		return map;
	}
	
}
