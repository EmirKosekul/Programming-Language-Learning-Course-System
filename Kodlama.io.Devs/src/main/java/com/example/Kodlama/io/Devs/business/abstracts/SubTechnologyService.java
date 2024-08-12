package com.example.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import com.example.Kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import com.example.Kodlama.io.Devs.business.responds.GetAllSubTechnologiesRespond;
import com.example.Kodlama.io.Devs.business.responds.GetByIdSubTechnologyRespond;

public interface SubTechnologyService {
	void addSubTechnology(CreateSubTechnologyRequest createSubTechnologyRequest);
	List<GetAllSubTechnologiesRespond> getAllSubTechnology();
	GetByIdSubTechnologyRespond getSubTechnologyById(int id);
	void deleteSubTechnologyByName(String name);
	void updateSubTechnologyByName(String oldname, String newName);
	
		
	
}
