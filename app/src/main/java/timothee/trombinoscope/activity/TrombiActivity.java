package timothee.trombinoscope.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import timothee.trombinoscope.DAO.IPersonData;
import timothee.trombinoscope.DAO.PersonDataDAO;
import timothee.trombinoscope.DAO.PersonSQLLiteDAO;
import timothee.trombinoscope.R;
import timothee.trombinoscope.adapter.PersonneAdapter;
import timothee.trombinoscope.dto.Person;
import timothee.trombinoscope.sqlite.PersonDBHelper;

public class TrombiActivity extends AppCompatActivity {
    private static final String TAG = "TrombiActivity";

    ListView mListView;
    PersonneAdapter pAdapter;

    public static List<Person> selectedPersons =new ArrayList<Person>();
    public static List<View> selectedChilds =new ArrayList<View>();

    IPersonData personDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //personDAO = new PersonDataDAO();
        personDAO = new PersonSQLLiteDAO(PersonDBHelper.getInstance(this));
        setContentView(R.layout.activity_trombi);

        //PersonDataDAO p = new PersonDataDAO();
        //Toast.makeText(getBaseContext(), p.afficher(), Toast.LENGTH_SHORT).show();

        mListView = (ListView)findViewById(R.id.listView);

        /*final List<Person> persons = DataPerson.persons;

        List<String> listStr = new ArrayList<>();
        for (int i=0; i<persons.size(); i++){
            listStr.add(persons.get(i).getPrenom()+" "+persons.get(i).getNom());
        }*/
        //tvList = (TextView) findViewById(R.id.textViewList);
        //tvList.setText(p.afficher());
        //tvList.setText(persons.toString());

        /*adapter=new ArrayAdapter<String>(this,
                R.layout.personne_item,   //android.R.layout.simple_list_item_1
                listStr){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                //View view = super.getView(position,convertView,parent);
                //view.setBackgroundColor(persons.get(position).getAvatarColor());



                return view;
            }
        };
        mlistView.setAdapter(adapter);  */         //setListAdapter(adapter);
        pAdapter = new PersonneAdapter(TrombiActivity.this, personDAO.getPersons());
        mListView.setAdapter(pAdapter);

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                Person person= (Person) arg0.getItemAtPosition(pos);
                Toast.makeText(getApplicationContext(), "POS : " + pos + ", ID : " + id +", PERSON :" + person, Toast.LENGTH_LONG).show();


                View    child   =arg0.getChildAt(pos);
                if (!selectedChilds.contains(child)) {
                    Log.i(TAG, "SELECT");
                    // CHANGE BACKGROUD
                    arg0.getChildAt(pos).setBackgroundColor(Color.GRAY);
                    Log.i(TAG, "SET MARKER");
                    // ADD in SELECTED LIST
                    selectedChilds.add(child);
                    selectedPersons.add(person);
                } else {
                    Log.i(TAG, "UNSELECT");
                    //arg0.getChildAt(pos).setBackgroundColor(Color.WHITE);
                    arg0.getChildAt(pos).setBackgroundColor(Color.TRANSPARENT);
                    Log.i(TAG, "UNSET MARKER");

                    if(selectedChilds.contains(child))
                        selectedChilds.remove(child);
                    if(selectedPersons.contains(person))
                        selectedPersons.remove(person);
                }

                return true;
            }
        });

        //persons.add(shareFact);
        //adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Use AppCompatActivity's method getMenuInflater to get a handle on the menu inflater */
        MenuInflater inflater = getMenuInflater();
        /* Use the inflater's inflate method to inflate our menu layout to this menu */
        inflater.inflate(R.menu.trombinoscope_menu, menu);
        /* Return true so that the menu is displayed in the Toolbar */
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_delete) {
            Toast.makeText(getApplicationContext(), "SUPPRIMER", Toast.LENGTH_LONG).show();
            // SUPPRIMER
            for (Person person: selectedPersons) {
                Log.i(TAG, "REMOVE :" + person);
                personDAO.removePerson(person);
            }
            reloadAllData();
            selectedChilds.clear();
            selectedPersons.clear();
        }

        return super.onOptionsItemSelected(item);
    }

    private void reloadAllData(){
        Log.i(TAG, "RELOAD NEW DATA :" + personDAO.getPersons());
        // CLEAR AND ADD ALL, NOT TO USE WHEN LISTDATA
        pAdapter.clear();
        pAdapter.addAll(personDAO.getPersons());
        // UPDATE
        pAdapter.notifyDataSetChanged();
        // Set Back White back ground
        for(View child : selectedChilds) {
            child.setBackgroundColor(Color.WHITE);
        }
    }

}
