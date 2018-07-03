package timothee.trombinoscope.DAO;

import android.content.Context;

import java.util.List;

import timothee.trombinoscope.dto.Person;

public class PersonSQLLiteDAO implements IPersonData{

    public static PersonSQLLiteDAO mInstance = null;

    public PersonSQLLiteDAO(Context context){

    }

    @Override
    public List<Person> getPersons() {
        return null;
    }

    @Override
    public void addPerson(Person p) {

    }

    @Override
    public void removePerson(Person p) {

    }
}
