package com.google.application.dao;

import com.google.application.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FakePersonDataAccessServiceTest {

    private static List<Person> mDatabase;
    private static PersonDao mDao;

    @BeforeEach
    void setUp() {
        mDao = new FakePersonDataAccessService();
        mDatabase = new ArrayList();
    }


    @Test
    void personInsertedSuccessfully(){
        Person person = new Person(UUID.randomUUID(), "mohamed");
        int result = mDao.insertPerson(person.getId(), person);
        mDatabase.add(person);
        assertTrue(mDatabase.contains(person));
        assertEquals(1, result);
    }

    @Test
    void select_All_People_return_Successfully(){
        Person person = new Person(UUID.randomUUID(), "mohamed");
        Person person2 = new Person(UUID.randomUUID(), "adam");
        int result1 = mDao.insertPerson(person.getId(), person);
        int result2 = mDao.insertPerson(person2.getId(), person2);
        mDatabase.add(person);
        mDatabase.add(person2);
        assertEquals(1, result1);
        assertEquals(1, result2);
        assertTrue(mDatabase.contains(person));
        assertTrue(mDatabase.contains(person2));
    }

    @Test
    void getPersonById_return_Successfully(){
        Person person = new Person(UUID.randomUUID(), "mohamed");
        int result = mDao.insertPerson(person.getId(), person);
        mDatabase.add(person);

        Optional mPerson = mDatabase.stream().
                filter(person1 -> person1.getId()
                        .equals(person.getId())).findFirst();

        assertTrue(mDatabase.contains(mPerson.get()));
        assertEquals(1, result);
    }



}