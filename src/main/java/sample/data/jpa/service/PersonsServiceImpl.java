package sample.data.jpa.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import sample.data.jpa.domain.Persons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Component("personsService")
@Transactional
class PersonsServiceImpl implements PersonsService {
	
	private final PersonsRepository personsRepository;	
	private final Logger log = LoggerFactory.getLogger(PersonsServiceImpl.class);
	
	public PersonsServiceImpl(PersonsRepository personsRepository) {
		this.personsRepository = personsRepository;
	}	
	
	@Override
	public Persons getPersons(Long personId) {
		log.info("Inside getPersons call");
		Assert.notNull(personId, "Person Id must not be null");
		return this.personsRepository.getOne(personId);
	}	
	
	@Override
	public List<Persons> getPersons() {
		log.info("Inside getPersons call");
		return this.personsRepository.findAll();
	}

	@Override
	public Persons add(Persons person) {
		log.info("Inside add person call:"+person.toString());
		Persons persons1 = this.personsRepository.save(person);
		return persons1;
	}
	
	@Override
	public Persons update(Persons person) {
		log.info("Update existing person call:"+person.toString());
		Persons person1 = this.personsRepository.save(person);
		return person1;
	}
	
	@Override
	public Persons delete(Persons person) {
		log.info("delete person call:"+person.toString());
		Persons person1 = this.personsRepository.delete(person);
		return person1;
	}	
}
