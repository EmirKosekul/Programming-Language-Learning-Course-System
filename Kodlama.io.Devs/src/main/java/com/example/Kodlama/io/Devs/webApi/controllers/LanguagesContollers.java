package com.example.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Kodlama.io.Devs.business.abstracts.LanguageService;
import com.example.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import com.example.Kodlama.io.Devs.business.responds.GetAllProgrammingLanguagesRespond;
import com.example.Kodlama.io.Devs.business.responds.GetByIdProgrammingLanguageRespond;

@RestController
@RequestMapping("/api/languages")
public class LanguagesContollers {

	private LanguageService languageService;
	
	@Autowired
	public LanguagesContollers(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	List<GetAllProgrammingLanguagesRespond> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getbyid")
	GetByIdProgrammingLanguageRespond getById(int id) {
		return languageService.getById(id);
	}
	
	@PostMapping("/addlanguage")
	void addLanguage(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		languageService.addLanguage(createProgrammingLanguageRequest);
	}
	
	@PutMapping("/updatelanguage")
	void updateLanguage(String oldName, String newName) {
		languageService.updateLanguage(oldName, newName);
	}
	
	@DeleteMapping("/deletelanguage")
	void deleteLanguage(String name) {
		languageService.deleteLanguage(name);
	}
}








