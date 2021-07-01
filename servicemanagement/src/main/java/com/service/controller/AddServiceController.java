package com.service.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.service.management.service.ManagementService;
import com.service.model.ServiceData;

@Controller
public class AddServiceController {
	
	@Autowired
	private ManagementService managementService;
	
	 @GetMapping("/add")
	    public String addServiceView(Model model) {
	        model.addAttribute("service", new ServiceData());
	        return "addservice";
	    }

	    @PostMapping("/addservice")
	    public String addService(@ModelAttribute("service") ServiceData serviceData) throws ParseException {
	        ServiceData savedServie = managementService.addNewService(serviceData);
	        return "success";
	    } 

}
