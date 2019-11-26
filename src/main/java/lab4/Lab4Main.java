package lab4;

import lab1.Person;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Lab4Main {
    public static void main(String[] args) throws SQLException, IOException {
        List<Person> persons = ServiceWithDB.loadJson();

        if (persons != null) {
            for (Person person : persons) {
                System.out.println(person);
            }
        }

        System.out.println("-------------------");

        persons = ServiceWithDB.loadJsonb();

        if (persons != null) {
            for (Person person : persons) {
                System.out.println(person);
            }
        }

        List<Person> personList = ServiceWithJSON.loadPersonList();
        ServiceWithDB.savePersonList(personList);

    }
}
