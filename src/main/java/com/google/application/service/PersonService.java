package com.google.application.service;

import com.google.application.dao.PersonDao;
import com.google.application.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao mPersonDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao mPersonDao) {
        this.mPersonDao = mPersonDao;
    }

    public int addPerson(Person person) {
        return mPersonDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return mPersonDao.selectAllPeople();
    }

    public Optional<Person> selectPersonById(UUID id){
        return mPersonDao.selectPersonById(id);
    }

    public int deletePersonById(UUID id){
        return mPersonDao.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person newPerson){
        return mPersonDao.updatePersonById(id, newPerson);
    }
}
