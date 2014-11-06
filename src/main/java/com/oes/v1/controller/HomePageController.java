/**
 * 
 */
package com.oes.v1.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.oes.v1.vo.OrganizationRequest;


/**
 * @author Babita Kaushik
 *
 */
@Controller
public class HomePageController extends MultiActionController{
	/** Logger */
	//private static final Logger LOG = LoggerFactory.getLogger(HomePageController.class);
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getOfferImage(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws IOException {
		return "home/home";
	}
	
	@RequestMapping(value = "/MyOrganization",method = RequestMethod.GET)
	public String createNewOrganization(@ModelAttribute("OrganizationRequestForm") OrganizationRequest organizationRequest, Map<String, Object> model, 
			HttpServletRequest request, HttpServletResponse httpServletResponse) {
		//LOG.debug("BasicSearchController.submitBasicSearchForm(): Enter");
		return "organization/organizationHome";
	}
}
