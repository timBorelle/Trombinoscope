package timothee.trombinoscope;

import android.graphics.Color;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DataPerson {

    /*public static ArrayList<Person> persons;
    Person p1 = new Person("Timothée", "Borelle", Color.RED);
    Person p2 = new Person("Yann", "Toqué", Color.parseColor("#00ff00"));
    Person p3 = new Person("Val", "Lecouple", Color.parseColor("#00ff88"));*/

    public static List<Person> persons = new ArrayList<Person>(){{
        add(new Person("Timothée", "Borelle", Color.RED));
        add(new Person("Yann", "Toqué", Color.parseColor("#00ff00")));
        add(new Person("Val", "Lecouple", Color.parseColor("#00ff88")));
    }};

    /*public DataPerson(){
        this.persons = new ArrayList<>();
        this.persons.add(p1);
        this.persons.add(p2);
        this.persons.add(p3);
    }*/

}
