package denardev.test.repository;

import denardev.test.data.Person;

public interface PersonRepository {
    Person selectByID(String id);
    void insert(Person person);
}
