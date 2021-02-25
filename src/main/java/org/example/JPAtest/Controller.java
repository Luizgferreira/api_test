package org.example.JPAtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/city")
    public City createCity(@RequestBody City city){
        return cityRepository.save(city);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/city")
    public Iterable<City> getCities(){
        return cityRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/person")
    public Iterable<Person> getPeople(){
        return personRepository.findAll();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/person")
    public Person createPerson(@RequestBody PersonView personView){
        City city = cityRepository.findById(personView.getCity()).orElse(null);
        Person person = new Person(personView.getName(),
                personView.getAge(), city);
        return personRepository.save(person);
    }



}
