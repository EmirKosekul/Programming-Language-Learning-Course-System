package com.example.Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Kodlama.io.Devs.entities.concretes.SubTechnology;

import jakarta.transaction.Transactional;

public interface SubTechnologyRepository extends JpaRepository<SubTechnology, Integer>{

	@Transactional
	void deleteByName(String name);
	
	@Modifying
    @Transactional
    @Query("UPDATE SubTechnology s SET s.name = :newName WHERE s.name = :oldName")
    void updateLanguageByName(@Param("oldName") String oldName, @Param("newName") String newName);
}
