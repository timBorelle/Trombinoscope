package timothee.trombinoscope.DAO;

import java.util.ArrayList;
import java.util.List;

import timothee.trombinoscope.data.DataPerson;
import timothee.trombinoscope.dto.Person;

public class PersonDataDAO implements IPersonData{

    public static ArrayList<Person> persons;

    /*public PersonDataDAO(){
        DataPerson dp = new DataPerson();
    }*/

    @Override
    public List<Person> getPersons() {
        return DataPerson.persons;
    }

    @Override
    public void addPerson(Person p) {
        DataPerson.persons.add(p);
    }

    @Override
    public void removePerson(Person p) {
        DataPerson.persons.remove(p);
    }

    /*public String afficher(){
        StringBuilder sb = new StringBuilder();
        for(Person p : this.getPersons()){
            sb.append(p.toString() + System.lineSeparator());
        }
        return sb.toString();
        //Toast.makeText(DataPerson.this, toastStr, Toast.LENGTH_SHORT).show();
    }*/
}
