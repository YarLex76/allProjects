package ru.suhar.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.suhar.springcourse.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PIOPLE_COUNT;
    private List<Person> people = new ArrayList<>();
    {
        people.add(new Person(++PIOPLE_COUNT, "Alex"));
        people.add(new Person(++PIOPLE_COUNT, "Sergey"));
        people.add(new Person(++PIOPLE_COUNT, "Maxim"));
    }
    public List<Person> index(){
        return people;
    }

    public Person show (int id){
        return people.stream().filter(person ->person.getId() == id).findAny().orElse(null);
    }

    public void save (Person person){
        person.setId(++PIOPLE_COUNT);
        people.add(person);
    }



}
