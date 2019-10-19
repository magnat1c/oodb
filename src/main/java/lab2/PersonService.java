package lab2;

import lab1.Person;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class PersonService {


    public static Person findPersonByName(List<Person> persons, String searchName) {
        Person result = null;

        for (Person person : persons) {
            if (person.getFirstName().equals(searchName)) {
                result = person;
            }
        }

        return result;
    }

    public static Person findPersonByLastName(List<Person> persons, String searchLastName) {
        Person result = null;

        for (Person person : persons) {
            if (person.getLastName().equals(searchLastName)) {
                result = person;
            }
        }

        return result;
    }

    public static List<Person> sortByName(List<Person> persons) {
        return persons.stream().sorted(Comparator.comparing(Person::getFirstName)).collect(Collectors.toList());
    }

}
