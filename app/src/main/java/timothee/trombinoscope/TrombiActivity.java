package timothee.trombinoscope;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import timothee.trombinoscope.DAO.PersonDataDAO;

public class TrombiActivity extends AppCompatActivity {

    private TextView tvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trombi);

        //PersonDataDAO p = new PersonDataDAO();
        //Toast.makeText(getBaseContext(), p.afficher(), Toast.LENGTH_SHORT).show();

        List<Person> persons = DataPerson.persons;

        tvList = (TextView) findViewById(R.id.textViewList);
        //tvList.setText(p.afficher());
        tvList.setText(persons.toString());
    }
}
