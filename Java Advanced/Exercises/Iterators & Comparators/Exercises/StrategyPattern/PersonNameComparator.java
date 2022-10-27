package IteratorsAndComparatorsEXERCISES.StrategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {

        if (firstPerson.getName().length() == secondPerson.getName().length()){
            char letterOfFirst = firstPerson.getName().toLowerCase().charAt(0);
            char letterOfSecond = secondPerson.getName().toLowerCase().charAt(0);
             return Character.compare(letterOfFirst, letterOfSecond);
        }
        return firstPerson.getName().length() - secondPerson.getName().length();

    }
}
