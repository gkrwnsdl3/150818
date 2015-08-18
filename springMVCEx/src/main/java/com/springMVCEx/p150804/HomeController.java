package com.springMVCEx.p150804;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("home");
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/board/view")
	/*public String func(Model model) {
		model.addAttribute("id", "1234");
		return "board/view";
	}*/
	/*public ModelAndView func(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", "1234");
		mv.setViewName("board/view");
		return mv;
	}*/
	/*public String func(HttpServletRequest request, Model model){
		model.addAttribute("id", request.getParameter("id"));
		model.addAttribute("pw", request.getParameter("pw"));
		return "board/view";
	}*/
	public String func(Member mbr){
		System.out.println("func");
		return "board/view";
	}
	
	@RequestMapping("/form")
	public String func2(){
		System.out.println("func2");
		return "form1";
	}
	
	@RequestMapping(value="/formret", method = RequestMethod.POST)
	public String func3(HttpServletRequest request, Model model){
		System.out.println("func3");
		model.addAttribute("id", request.getParameter("id"));
		model.addAttribute("pw", request.getParameter("pw"));
		return "board/view";
	}
}
