package timothee.trombinoscope.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import timothee.trombinoscope.DAO.PersonDataDAO;
import timothee.trombinoscope.R;
import timothee.trombinoscope.dto.Person;

public class ConfigActivity extends AppCompatActivity {

    EditText prenom, nom, red, green, blue;
    Button ajouterP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final PersonDataDAO personDAO = new PersonDataDAO();
        //personDAO = new PersonDataDAO(PersonDBHelper.getInstance(this));
        setContentView(R.layout.activity_config);

        prenom = findViewById(R.id.editTextPrenom);
        nom = findViewById(R.id.editTextNom);
        red = findViewById(R.id.editTextColorR);
        green = findViewById(R.id.editTextColorG);
        blue = findViewById(R.id.editTextColorB);
        ajouterP = (Button) findViewById(R.id.ajouterP);

        ajouterP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int r = Integer.parseInt(red.getText().toString());
                int g = Integer.parseInt(green.getText().toString());
                int b = Integer.parseInt(blue.getText().toString());;
                Person p1 = new Person(prenom.getText().toString(), nom.getText().toString(), Color.rgb(r, g, b));
                personDAO.addPerson(p1);
                Toast.makeText(getBaseContext(), prenom.getText().toString()+" a été ajouté(e)",Toast.LENGTH_SHORT).show();
                finish();
                startActivity(getIntent());
            }
        });

    }
}
