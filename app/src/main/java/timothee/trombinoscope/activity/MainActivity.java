package timothee.trombinoscope.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import timothee.trombinoscope.R;

public class MainActivity extends AppCompatActivity {

    Button b_trombi, b_config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_trombi = findViewById(R.id.buttonTrombi);
        b_config = findViewById(R.id.buttonConfig);

        b_trombi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Button b = (Button)view;
                //Toast.makeText(getBaseContext(), b.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, TrombiActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        b_config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Button b = (Button)view;
                Toast.makeText(getBaseContext(), b.getText().toString(), Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(MainActivity.this, ConfigActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        //mDbHelper.close();
        super.onDestroy();
    }
}
