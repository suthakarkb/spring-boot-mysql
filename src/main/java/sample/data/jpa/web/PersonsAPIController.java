/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.data.jpa.service.PersonsService;
import sample.data.jpa.domain.Persons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;

@RestController
public class PersonsAPIController {
	
	private final Logger log = LoggerFactory.getLogger(PersonsAPIController.class);
	
	@Autowired
	private PersonsService personsService;	
	
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<String> getProducts() {
      List<String> productsList = new ArrayList<>();
      productsList.add("Honey");
      productsList.add("Almond");
      return productsList;
   }
   
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String createProduct() {
      return "Product is saved successfully";
   }
   
    @RequestMapping(path="/welcome", method=RequestMethod.GET)
    public String helloWorld() {
		return "Welcome to springboot mysql demo services";
	} 

    // @RequestMapping(value="/persons/{id}", method=RequestMethod.GET)
	// @ResponseBody
	// @Transactional(readOnly = true)
	// public Persons getPersonByPersonId(@PathVariable("id") String id) throws Exception{
		// log.info("Fetching Person1 with id {}",id);
		// Persons person = personsService.getPersons(id);
		// if(person != null) {
			// return person; }
		// else {
			// return null;
		// }
	// }	
	
	@RequestMapping(value="/person/{id}", method=RequestMethod.GET)
	@ResponseBody
	@Transactional(readOnly = true)
	public Persons getPersonById(@PathVariable("id") String id) throws Exception{
		log.info("Fetching Person2 with id {}",id);
		try {
			Long personId = new Long(id);
			Persons person = personsService.getPersons(personId);
			if(person != null) {
				return person; }
		} catch (Exception exception) {
			log.error("Error while Fetching a person : " + exception.getLocalizedMessage());
		}
		return null;	
	}	

	@RequestMapping(value="/persons", method=RequestMethod.GET)
	@ResponseBody
	@Transactional(readOnly = true)
	public List<Persons> getPersons() throws Exception{
		log.info("Fetching List of Persons");
		List<Persons> persons = personsService.getPersons();
		if(persons != null) {
			return persons; }
		else {
			return null;
		}
	}

	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
	public Persons addPerson(@RequestBody Persons person) {
		log.info("Add a new person : ");
		log.info(person.toString());
		try {
			person = personsService.add(person);
			log.info("person added successfully");
		} catch (Exception exception) {
			log.error("Error while Inserting a person : " + exception.getLocalizedMessage());
		}
		return person;
	}

	@RequestMapping(value = "/person/update", method = RequestMethod.PUT)
	public Persons updatePerson(@RequestBody Persons person) {
		log.info("Update existing person : ");
		log.info(person.toString());
		try {
			person = personsService.update(person);
			log.info("person updated successfully");
		} catch (Exception exception) {
			log.error("Error while Update : " + exception.getLocalizedMessage());
		}
		return person;
	}
	
	@RequestMapping(value = "/person/delete", method = RequestMethod.DELETE)
	public Persons deleteUser(@RequestBody Persons person) {
		log.info("Deleting person : "+person);
		try {
			Persons person1 = personsService.delete(person);
			log.info("person deleted successfully");
			return person1;
		} catch (Exception exception) {
			//exception.printStackTrace();
			log.error("Error while Deletion : " + exception.getLocalizedMessage());
		}
		return person;
	}	
   
}
