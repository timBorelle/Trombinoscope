package timothee.trombinoscope.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import timothee.trombinoscope.DAO.IPersonData;
import timothee.trombinoscope.DAO.PersonDataDAO;
import timothee.trombinoscope.R;
import timothee.trombinoscope.adapter.PersonneAdapter;

public class TrombiActivity extends AppCompatActivity {

    ListView mListView;
    //private ArrayAdapter<String> adapter;
    PersonneAdapter pAdapter;

    IPersonData personDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        personDAO = new PersonDataDAO();
        //personDAO = new PersonSQLLiteDAO(PersonDBHelper.getInstance(this));
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

        //persons.add(shareFact);
        //adapter.notifyDataSetChanged();
    }
}
