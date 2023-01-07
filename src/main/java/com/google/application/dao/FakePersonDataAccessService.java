package com.google.application.dao;

import com.google.application.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> mDatabase = new ArrayList();

    @Override
    public int insertPerson(UUID id, Person person) {
        mDatabase.add(new Person(id, person.getName()));
        return 1;
    }
}
