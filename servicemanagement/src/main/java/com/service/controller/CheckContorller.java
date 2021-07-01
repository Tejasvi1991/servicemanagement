package com.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.management.service.ManagementService;
import com.service.model.ServiceData;

@Controller
public class CheckContorller {
	
	@Autowired
	private ManagementService managementService;
	
	@GetMapping("/check")
	public String checkServiceURL(@RequestParam int id, ModelMap modelmap) {
		String message = "";
		String name = "";
		ServiceData serviceData  =  managementService.findServiceById(id);
		int val = managementService.checkURL(null != serviceData.getUrl() ? serviceData.getUrl() : ""); 
		if(null != serviceData.getServiceName()) {
			name = serviceData.getServiceName();
		}else if(null != serviceData.getUrl()){
			name = serviceData.getUrl();
		}
		if(val == 200) {
			message = name + " is working";
		}else {
			message = name + " is not working";
		}
		modelmap.put("msg", message);
		return "checkstatus";
	}

}
