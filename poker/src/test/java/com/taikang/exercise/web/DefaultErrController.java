package com.taikang.exercise.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.slt.base.exception.SysException;


/**
 * 测试各种程序错误的情况下使用统一处理方式返回，而不是在页面显示异常栈信息。
 * 
 * @author maoyl05
 *
 */
@Controller
public class DefaultErrController {
	/**
	 * 测试程序抛出AuthException的情况下程序处理方式：跳转到error/authExceptionView
	 * @param err_code
	 * @return
	 */
	@RequestMapping(value = "/dft/{err_code}", method = RequestMethod.GET)
	public ModelAndView errShow(@PathVariable int err_code) {
		Map<String, String> map = new HashMap<>();
		map.put("test", "json");
		map.put("test-html", "html");
		map.put("what", "what");
		try {
			int i = 1 / 0;
		} catch (Exception e) {
			throw new SysException(new Date(), "Something bad happened dude !! Run Away :-(");
		}
		ModelAndView modelAndView = new ModelAndView("error/404");
		modelAndView.addObject(map);
		return modelAndView;

	}

	/**
	 * 测试程序抛出NullPointerException的情况下程序处理方式：跳转到error/null
	 */
	@RequestMapping("/dft/null")
	public void testNullPointerException() {
		// 这里就会发生空指针异常，然后就会返回定义在SpringMVC配置文件中的null视图
		throw new NullPointerException("Error!");
	}

	/**
	 * 测试程序抛出NumberFormatException的情况下程序处理方式：跳转到error/number
	 */
	@RequestMapping("/number")
	public void testNumberFormatException() {
		// 这里就会发生NumberFormatException，然后就会返回定义在SpringMVC配置文件中的number视图
		Integer.parseInt("abc");
	}

	/**
	 * 测试程序抛出其他的异常情况下程序默认跳转到：error/500
	 */
	@RequestMapping("/default")
	public void testDefaultException() {
		// 由于该异常类型在SpringMVC的配置文件中没有指定，所以就会返回默认的exception视图
		throw new RuntimeException("Error!");
	}
}
