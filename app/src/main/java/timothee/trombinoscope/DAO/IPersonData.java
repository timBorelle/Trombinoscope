package timothee.trombinoscope.DAO;

import java.util.List;

import timothee.trombinoscope.dto.Person;

public interface IPersonData {

    public List<Person> getPersons();
    public void addPerson(Person p);
    public void removePerson(Person p);
}
