package com.example.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import com.example.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import com.example.Kodlama.io.Devs.business.responds.GetAllProgrammingLanguagesRespond;
import com.example.Kodlama.io.Devs.business.responds.GetByIdProgrammingLanguageRespond;

public interface LanguageService {

	void addLanguage(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
	List<GetAllProgrammingLanguagesRespond> getAll();
	GetByIdProgrammingLanguageRespond getById(int id);
    void updateLanguage(String oldLanguageName, String newLanguageName);
    void deleteLanguage(String languageName);
	
	
}
