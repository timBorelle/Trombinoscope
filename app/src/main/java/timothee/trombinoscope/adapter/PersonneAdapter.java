package timothee.trombinoscope.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import timothee.trombinoscope.DAO.IPersonData;
import timothee.trombinoscope.DAO.PersonSQLLiteDAO;
import timothee.trombinoscope.R;
import timothee.trombinoscope.activity.ConfigActivity;
import timothee.trombinoscope.activity.MainActivity;
import timothee.trombinoscope.dto.Person;
import timothee.trombinoscope.holder.PersonneItemHolder;
import timothee.trombinoscope.sqlite.PersonDBHelper;


public class PersonneAdapter extends ArrayAdapter<Person> {

    IPersonData personDAO;

    public PersonneAdapter(Context context, List<Person> persons) {
        super(context, 0, persons);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.personne_item, parent, false);
        }

        PersonneItemHolder viewHolder = (PersonneItemHolder) convertView.getTag();
        personDAO = new PersonSQLLiteDAO(PersonDBHelper.getInstance(getContext()));
        if (viewHolder == null) {
            viewHolder = new PersonneItemHolder();
            viewHolder.firstName = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.lastName = (TextView) convertView.findViewById(R.id.prenom);
            viewHolder.couleur = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.imgCancel = (ImageView) convertView.findViewById(R.id.imgCancel);
            viewHolder.imgCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "Suppression...", Toast.LENGTH_SHORT).show();
                    //personDAO.removePerson(view.getParent().);
                }
            });
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Person personne = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.firstName.setText(personne.getPrenom());
        viewHolder.lastName.setText(personne.getNom());
        viewHolder.couleur.setImageDrawable(new ColorDrawable(personne.getAvatarColor()));
        //viewHolder.couleur.setBackgroundColor(personne.getAvatarColor());

        return convertView;
    }
}