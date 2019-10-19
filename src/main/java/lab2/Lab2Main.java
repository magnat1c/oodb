package lab2;

import lab1.Person;

import java.io.IOException;
import java.util.List;

public class Lab2Main {

    public static void main(String[] args) {
        try {

            List<Person> persons = serviceDB.loadPersonList();

            persons.forEach(System.out::println);

            Person prs = PersonService.findPersonByName(persons, "Фаиль");

            if (prs != null) {
                prs.setPhoneNumber("+773456783535");
                prs.setEmail("");
            }

            serviceDB.savePersonList(persons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
