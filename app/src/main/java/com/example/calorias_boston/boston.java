package com.example.calorias_boston;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class boston extends AppCompatActivity implements View.OnClickListener{

    Button volver, calcular;
    TextView txt_nombre,txt_edad,txt_sexo,txt_tiempo;
    String nombre,edad,sexo;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boston);

        txt_tiempo = (TextView)findViewById(R.id.tiempo);
        txt_nombre = (TextView)findViewById(R.id.nombre);
        txt_edad = (TextView)findViewById(R.id.edad);
        txt_sexo = (TextView)findViewById(R.id.sexo);
        volver = (Button)findViewById(R.id.voler);
        calcular = (Button)findViewById(R.id.calcular);

        volver.setOnClickListener(this);
        calcular.setOnClickListener(this);

        nombre = getIntent().getStringExtra("nombre");
        edad = getIntent().getStringExtra("edad");
        sexo = getIntent().getStringExtra("sexo");
        txt_nombre.setText(nombre);
        txt_edad.setText(edad);
        txt_sexo.setText(sexo);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.voler:
                i = new Intent(boston.this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.calcular:
                int numedad = Integer.parseInt(edad);
                if(sexo.equals("Masculino")) {
                    if(numedad >=18 && numedad<=34) {
                        txt_tiempo.setText("3:00 hrs");
                    }
                    if(numedad >=35 && numedad<=39) {
                        txt_tiempo.setText("3:05 hrs");
                    }
                    if(numedad >=40 && numedad<=44) {
                        txt_tiempo.setText("3:10 hrs");
                    }
                    if(numedad >=45 && numedad<=49) {
                        txt_tiempo.setText("3:20 hrs");
                    }
                    if(numedad >=50 && numedad<=54) {
                        txt_tiempo.setText("3:25 hrs");
                    }
                    if(numedad >=55 && numedad<=59) {
                        txt_tiempo.setText("3:35 hrs");
                    }
                    if(numedad >=60 && numedad<=64) {
                        txt_tiempo.setText("3:50 hrs");
                    }
                    if(numedad >=65 && numedad<=69) {
                        txt_tiempo.setText("4:05 hrs");
                    }
                    if(numedad >=70 && numedad<=74) {
                        txt_tiempo.setText("4:20 hrs");
                    }
                    if(numedad >=75 && numedad<=79) {
                        txt_tiempo.setText("4:35 hrs");
                    }
                    if(numedad > 80) {
                        txt_tiempo.setText("4:50 hrs");
                    }

                }else if(sexo.equals("Femenino")) {
                    if(numedad >=18 && numedad<=34) {
                        txt_tiempo.setText("3:30 hrs");
                    }
                    if(numedad >=35 && numedad<=39) {
                        txt_tiempo.setText("3:35 hrs");
                    }
                    if(numedad >=40 && numedad<=44) {
                        txt_tiempo.setText("3:40 hrs");
                    }
                    if(numedad >=45 && numedad<=49) {
                        txt_tiempo.setText("3:50 hrs");
                    }
                    if(numedad >=50 && numedad<=54) {
                        txt_tiempo.setText("3:55 hrs");
                    }
                    if(numedad >=55 && numedad<=59) {
                        txt_tiempo.setText("4:05 hrs");
                    }
                    if(numedad >=60 && numedad<=64) {
                        txt_tiempo.setText("4:20 hrs");
                    }
                    if(numedad >=65 && numedad<=69) {
                        txt_tiempo.setText("4:35 hrs");
                    }
                    if(numedad >=70 && numedad<=74) {
                        txt_tiempo.setText("4:50 hrs");
                    }
                    if(numedad >=75 && numedad<=79) {
                        txt_tiempo.setText("5:05 hrs");
                    }
                    if(numedad > 80) {
                        txt_tiempo.setText("5:20 hrs");
                    }
                }
        }
    }
}