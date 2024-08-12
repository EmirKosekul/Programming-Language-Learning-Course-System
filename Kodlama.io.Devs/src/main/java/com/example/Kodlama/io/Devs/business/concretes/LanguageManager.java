package com.example.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Kodlama.io.Devs.business.abstracts.LanguageService;
import com.example.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import com.example.Kodlama.io.Devs.business.responds.GetAllProgrammingLanguagesRespond;
import com.example.Kodlama.io.Devs.business.responds.GetByIdProgrammingLanguageRespond;
import com.example.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import com.example.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class LanguageManager implements LanguageService{
	
	LanguageRepository languageRepository;
	List<ProgrammingLanguage> programmingLanguages;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
	}

	@Override
	public void addLanguage(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		
	    if (createProgrammingLanguageRequest.getName() == null || createProgrammingLanguageRequest.getName().isEmpty()) {
	        System.out.println("Language name can not be empty!");
	        return;
	    }
	    
	    programmingLanguages = languageRepository.findAll();
	    
	    for (ProgrammingLanguage pL : programmingLanguages) {
	        if (pL.getName().equalsIgnoreCase(createProgrammingLanguageRequest.getName())) {
	            System.out.println("This language has already been added.");
	            return;
	        }
	    }
	    
	    ProgrammingLanguage programmingLanguage= new ProgrammingLanguage();
	    programmingLanguage.setName(createProgrammingLanguageRequest.getName());
	    languageRepository.save(programmingLanguage);
	}

	@Override
	public List<GetAllProgrammingLanguagesRespond> getAll() {
		List<ProgrammingLanguage> languages= languageRepository.findAll();
		List<GetAllProgrammingLanguagesRespond> respondLanguages = new ArrayList<GetAllProgrammingLanguagesRespond>();
		for (ProgrammingLanguage programmingLanguage : languages) {
			GetAllProgrammingLanguagesRespond getAllProgrammingLanguagesRespond = new GetAllProgrammingLanguagesRespond();
			getAllProgrammingLanguagesRespond.setId(programmingLanguage.getId());
			getAllProgrammingLanguagesRespond.setName(programmingLanguage.getName());
			respondLanguages.add(getAllProgrammingLanguagesRespond);
		}
		
		return respondLanguages; 
	}

	@Override
	public GetByIdProgrammingLanguageRespond getById(int id) {
		GetByIdProgrammingLanguageRespond getByIdProgrammingLanguageRespond = new GetByIdProgrammingLanguageRespond();
	    getByIdProgrammingLanguageRespond.setId(languageRepository.getReferenceById(id).getId());
		getByIdProgrammingLanguageRespond.setName(languageRepository.getReferenceById(id).getName());
		
		return getByIdProgrammingLanguageRespond;
	}

	@Override
	public void updateLanguage(String oldLanguageName, String newLanguageName) {
		languageRepository.updateLanguageByName(oldLanguageName,newLanguageName);
		
	}

	@Override
	public void deleteLanguage(String languageName) {
		languageRepository.deleteByName(languageName);
		
	}

}
