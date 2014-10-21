/**
 * 
 */
package com.oes.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


/**
 * @author Babita Kaushik
 *
 */
@Controller
public class HomePageController extends MultiActionController{
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getOfferImage(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws IOException {
		return "home/home";
	}
}
