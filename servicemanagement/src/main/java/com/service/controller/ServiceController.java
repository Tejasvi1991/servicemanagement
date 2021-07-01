package com.service.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.management.service.ManagementService;
import com.service.model.ServiceData;


/**
 * @author Tejasvi
 *
 */
@Controller
public class ServiceController {
	@Autowired
	private ManagementService managementService;
	
	@GetMapping("/view")
	public String showServiceDetails(ModelMap model) {
		List<ServiceData> serviceData = managementService.getAllServiceDetails(); 
		model.put("serviceDataList",serviceData); 
		return "servicedetails";
	}
	
	@GetMapping("/update")
    public String addBookView(@RequestParam int id,Model model,ModelMap modelmap) {
		modelmap.put("id", managementService.findServiceById(id).getId());
        model.addAttribute("service", managementService.findServiceById(id));
        return "updatepatient";
    }
	
	@PostMapping("/updateservice")
	public String updateServiceDetails(@RequestParam int id,@ModelAttribute("service") ServiceData serviceData) throws ParseException {
		managementService.updateServiceDetails(id,serviceData); 
		return "success";
	}
	
	@GetMapping("/delete")
	public String deleteServiceDetails(@RequestParam int id) {
		managementService.deleteServiceDetails(id); 
		return "success";
	}

}
