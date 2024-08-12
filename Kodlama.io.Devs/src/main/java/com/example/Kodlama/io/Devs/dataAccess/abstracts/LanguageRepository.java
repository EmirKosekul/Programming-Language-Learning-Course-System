package com.example.Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

import jakarta.transaction.Transactional;

public interface LanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {

	@Transactional
	void deleteByName(String name);
	
	@Modifying
    @Transactional
    @Query("UPDATE ProgrammingLanguage p SET p.name = :newName WHERE p.name = :oldName")
    void updateLanguageByName(@Param("oldName") String oldName, @Param("newName") String newName);
	
}
