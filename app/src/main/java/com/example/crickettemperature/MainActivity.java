package com.example.crickettemperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
    EditText e1 ;
    Button b1;
    TextView t2;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        b1 = findViewById(R.id.b1);
        t2 = findViewById(R.id.t2);

        t2.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                formatter = new DecimalFormat("#0.0");

                if (e1.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all fields!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int chirps = Integer.parseInt(e1.getText().toString().trim());
                    double temp = (chirps/3.0)+4.0;
                    String results = "The approximate temperature outside is "+formatter.format(temp)+" degrees celsius";
                    t2.setText(results);
                    t2.setVisibility(View.VISIBLE);
                }
            }
        });

    }

}
