package com.example.Kodlama.io.Devs.entities.concretes;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguage {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	
//	@JsonIgnore
	@OneToMany(mappedBy="programmingLanguage")
	private List<SubTechnology> subTechnology= new ArrayList<SubTechnology>();
		
	
}
