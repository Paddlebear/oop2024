package jtm.extra11;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import jtm.activity03.RandomPerson;

public class PersonMatcherImpl implements PersonMatcher{

    List<RandomPerson> randomPersons;

    public PersonMatcherImpl() {
        randomPersons = new LinkedList<>();
    }

    @Override
    public void addPerson(RandomPerson person) {
        // TODO Auto-generated method stub
        randomPersons.add(person);
    }

    @Override
    public List<RandomPerson> getPersonList() {
        // TODO Auto-generated method stub
        return randomPersons;
    }

    @Override
    public Stream<RandomPerson> getPersonStream() {
        // TODO Auto-generated method stub
        return randomPersons.stream();
    }
    
}
