package com.example.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import com.example.Kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import com.example.Kodlama.io.Devs.business.responds.GetAllSubTechnologiesRespond;

@RestController
@RequestMapping("/api/subtechnologies")
public class SubTechnologyControllers {

	private SubTechnologyService subTechnologyService;

	@Autowired
	public SubTechnologyControllers(SubTechnologyService subTechnologyService) {
		this.subTechnologyService = subTechnologyService;
	}
	
	@GetMapping("/getall")
	List<GetAllSubTechnologiesRespond> getAll() {
		return subTechnologyService.getAllSubTechnology();
	}
	
	@PostMapping("/addsubtechnology")
	void addSubTechnology(@RequestBody CreateSubTechnologyRequest createSubTechnologyRequest) {
		subTechnologyService.addSubTechnology(createSubTechnologyRequest);
	}
	
	@DeleteMapping("deletesubtechnology")
	void deleteSubTecnology(String name) {
		subTechnologyService.deleteSubTechnologyByName(name);
	}
	
	
}
