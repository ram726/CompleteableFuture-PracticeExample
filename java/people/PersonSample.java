package people;

import java.util.Arrays;
import java.util.List;

public class PersonSample
{
    public static void main(String[] args) {
        System.out.println(
                createPeople().parallelStream()
                        .filter(person -> person.getAge()>30)
                        .filter(person -> person.getGender()=="female")
                        .map(Person::getName)
                        .findFirst()
                        .orElse("no one found")
        );
    }

    private static List<Person> createPeople() {
        return Arrays.asList(
                new Person("sara",20,"female"),
                new Person("sara",22,"female"),
                new Person("bob",20,"male"),
                new Person("paula",32,"female"),
                new Person("paul",32,"male"),
                new Person("jack",20,"male"),
                new Person("jill",42,"female")

                );
    }
}
