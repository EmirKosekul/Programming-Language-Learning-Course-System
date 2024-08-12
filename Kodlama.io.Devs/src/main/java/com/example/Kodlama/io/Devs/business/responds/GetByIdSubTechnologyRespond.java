package com.example.Kodlama.io.Devs.business.responds;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdSubTechnologyRespond {
	int id;
	String name;
	String programmingLanguageName;
}
