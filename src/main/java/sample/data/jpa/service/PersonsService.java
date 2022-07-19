package sample.data.jpa.service;

import sample.data.jpa.domain.Persons;

import java.util.List;

public interface PersonsService {
	
	Persons getPersons(Long personId);
	List<Persons> getPersons();
	Persons add(Persons person);
	Persons update(Persons person);
	Persons delete(Persons id);
	
}