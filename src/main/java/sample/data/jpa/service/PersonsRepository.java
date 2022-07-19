package sample.data.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import sample.data.jpa.domain.Persons;

import java.util.List;

interface PersonsRepository extends Repository<Persons, Long> {
	
	Page<Persons> findAll(Pageable pageable);
	Page<Persons> findByNameAllIgnoringCase(Long firstName, Pageable pageable);
	Persons getOne(Long personId);
	List<Persons> findAll();
	Persons save(Persons person);
	Persons delete(Persons person);

}
