package com.example.calorias_boston;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Nombre, Edad;
    RadioButton rb1,rb2;
    Button calcular, boston;
    String nombre,edad,sexo;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = (EditText)findViewById(R.id.nombre);
        Edad = (EditText)findViewById(R.id.edad);
        rb1 = (RadioButton)findViewById(R.id.radioButton);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
        calcular = (Button)findViewById(R.id.calcularcaloiras);
        boston = (Button)findViewById(R.id.tiempoboston);

        calcular.setOnClickListener(this);
        boston.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        nombre = Nombre.getText().toString();
        edad = Edad.getText().toString();
        if(rb1.isChecked() == true) {
            sexo = "Masculino";
        }else if(rb2.isChecked() == true) {
            sexo = "Femenino";
        }else{
            sexo = "";
        }

        switch (view.getId()) {
            case R.id.calcularcaloiras:
                if(nombre.equals("") || edad.equals("") || sexo.equals("")){
                    Toast.makeText(this, "Rellene Todos los Campos", Toast.LENGTH_SHORT).show();
                }else {
                    i = new Intent(MainActivity.this, calorias.class);
                    i.putExtra("nombre",nombre);   //Paso de datos entre activities
                    i.putExtra("edad",edad);
                    i.putExtra("sexo",sexo);
                    startActivity(i);
                }
                break;

            case R.id.tiempoboston:
                if(nombre.equals("") || edad.equals("") || sexo.equals("")) {
                    Toast.makeText(this, "Rellena Todos los campos", Toast.LENGTH_LONG).show();
                }else {
                    i = new Intent(MainActivity.this, boston.class);
                    i.putExtra("nombre",nombre);   //Paso de datos entre activities
                    i.putExtra("edad",edad);
                    i.putExtra("sexo",sexo);
                    startActivity(i);
                }
                break;
        }
    }
}