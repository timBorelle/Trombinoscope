package timothee.trombinoscope;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import timothee.trombinoscope.DAO.PersonDataDAO;

public class TrombiActivity extends AppCompatActivity {

    //private ListView lv;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trombi);

        //PersonDataDAO p = new PersonDataDAO();
        //Toast.makeText(getBaseContext(), p.afficher(), Toast.LENGTH_SHORT).show();

        final ListView listView = (ListView)findViewById(R.id.listView);

        final List<Person> persons = DataPerson.persons;
        List<String> listStr = new ArrayList<>();
        for (int i=0; i<persons.size(); i++){
            listStr.add(persons.get(i).getPrenom()+" "+persons.get(i).getNom());
        }
        //tvList = (TextView) findViewById(R.id.textViewList);
        //tvList.setText(p.afficher());
        //tvList.setText(persons.toString());

        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listStr){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position,convertView,parent);
                view.setBackgroundColor(persons.get(position).getAvatarColor());
                return view;
            }
        };
        listView.setAdapter(adapter);           //setListAdapter(adapter);

        //persons.add(shareFact);
        adapter.notifyDataSetChanged();
    }
}
