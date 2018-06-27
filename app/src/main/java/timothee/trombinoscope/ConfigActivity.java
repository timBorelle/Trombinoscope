package timothee.trombinoscope;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import timothee.trombinoscope.DAO.PersonDataDAO;

public class ConfigActivity extends AppCompatActivity {

    EditText prenom, nom, couleur;
    Button ajouterP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        prenom = findViewById(R.id.editTextPrenom);
        nom = findViewById(R.id.editTextNom);
        couleur = findViewById(R.id.editTextColor);
        ajouterP = (Button) findViewById(R.id.ajouterP);

        ajouterP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersonDataDAO personDAO = new PersonDataDAO();
                Person p1 = new Person(prenom.getText().toString(), nom.getText().toString(), Integer.parseInt(couleur.getText().toString()));
                //personDAO.addPerson(p1);
                Toast.makeText(getBaseContext(), prenom.getText().toString()+" a été ajouté(e)",Toast.LENGTH_SHORT).show();
                finish();
                startActivity(getIntent());
            }
        });

    }
}
