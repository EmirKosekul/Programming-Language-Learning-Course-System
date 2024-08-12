package com.example.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import com.example.Kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import com.example.Kodlama.io.Devs.business.responds.GetAllSubTechnologiesRespond;
import com.example.Kodlama.io.Devs.business.responds.GetByIdSubTechnologyRespond;
import com.example.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import com.example.Kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import com.example.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import com.example.Kodlama.io.Devs.entities.concretes.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService{
	private SubTechnologyRepository subTechnologyRepository;
	private LanguageRepository languageRepository;
	List<SubTechnology> subTechnologies;
	List<ProgrammingLanguage> programmingLanguages;
	@Autowired
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository,LanguageRepository languageRepository) {
		
		this.subTechnologyRepository = subTechnologyRepository;
		this.languageRepository=languageRepository;
		subTechnologies= new ArrayList<SubTechnology>();
	}

	@Override
	public void addSubTechnology(CreateSubTechnologyRequest createSubTechnologyRequest) {
		if (createSubTechnologyRequest.getName() == null || createSubTechnologyRequest.getName().isEmpty()) {
	        System.out.println("Language name can not be empty!");
	        return;
	    }
	    
		subTechnologies = subTechnologyRepository.findAll();
	    
	    for (SubTechnology sT : subTechnologies) {
	        if (sT.getName().equalsIgnoreCase(createSubTechnologyRequest.getName())) {
	            System.out.println("This language has already been added.");
	            return;
	        }
	    }
	    
	    programmingLanguages= languageRepository.findAll();
	    ProgrammingLanguage newProgrammingLanguage= new ProgrammingLanguage();
	    for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if(programmingLanguage.getId()==createSubTechnologyRequest.getProgrammingLanguageId()) {
				newProgrammingLanguage = programmingLanguage;
			}
		}
	    SubTechnology subTechnology=new SubTechnology();
	    subTechnology.setName(createSubTechnologyRequest.getName());
	    subTechnology.setProgrammingLanguage(newProgrammingLanguage);
	    subTechnologyRepository.save(subTechnology);
		
	}

	@Override
	public List<GetAllSubTechnologiesRespond> getAllSubTechnology() {
		List<SubTechnology> subTechnologies= subTechnologyRepository.findAll();
		List<GetAllSubTechnologiesRespond> respondSubTechnologies = new ArrayList<GetAllSubTechnologiesRespond>();
		for (SubTechnology subTechnology : subTechnologies) {
			GetAllSubTechnologiesRespond getAllSubTechnologiesRespond = new GetAllSubTechnologiesRespond();
			getAllSubTechnologiesRespond.setId(subTechnology.getId());
			getAllSubTechnologiesRespond.setName(subTechnology.getName());
			getAllSubTechnologiesRespond.setProgrammingLanguageName(subTechnology.getProgrammingLanguage().getName());
			respondSubTechnologies.add(getAllSubTechnologiesRespond);
		}
		
		return respondSubTechnologies;
		
	}

	@Override
	public GetByIdSubTechnologyRespond getSubTechnologyById(int id) {
		SubTechnology subTechnology =subTechnologyRepository.getReferenceById(id);
		GetByIdSubTechnologyRespond getByIdSubTechnologyRespond= new GetByIdSubTechnologyRespond();
		getByIdSubTechnologyRespond.setId(subTechnology.getId());
		getByIdSubTechnologyRespond.setName(subTechnology.getName());
		getByIdSubTechnologyRespond.setProgrammingLanguageName(subTechnology.getProgrammingLanguage().getName());
	
		return getByIdSubTechnologyRespond;
	}

	@Override
	public void deleteSubTechnologyByName(String name) {
		subTechnologyRepository.deleteByName(name);
		
	}

	@Override
	public void updateSubTechnologyByName(String oldName,String newName) {
		subTechnologyRepository.updateLanguageByName(oldName, newName);
		
	}

}
