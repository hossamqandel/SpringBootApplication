package com.google.application.dao;

import com.google.application.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> mDatabase = new ArrayList();

    @Override
    public int insertPerson(UUID id, Person person) {
        mDatabase.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return mDatabase;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return mDatabase
                .stream()
                .filter( person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if (!personMaybe.isPresent()) return 0;
        mDatabase.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id).map( p -> {
            int idxOfPersonToDelete = mDatabase.indexOf(person.getId());
            if (idxOfPersonToDelete >= 0){
                mDatabase.set(idxOfPersonToDelete, person);
                return 1;
            }
            return 0;

        }).orElse(0);
    }
}
