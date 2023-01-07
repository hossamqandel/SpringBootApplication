package com.google.application.service;

import com.google.application.dao.PersonDao;
import com.google.application.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
}
