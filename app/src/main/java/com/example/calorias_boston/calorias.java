package com.example.calorias_boston;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyCallback;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class calorias extends AppCompatActivity implements View.OnClickListener{

    Button volver, calcular;
    TextView txt_peso,txt_altura,txt_nombre,txt_edad,txt_sexo, resultado;
    EditText et_peso,et_altura;
    String nombre,edad,sexo,peso,altura;
    Double dato, numpeso, numaltura ,numedad;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorias);

        et_peso = (EditText)findViewById(R.id.et_peso);
        et_altura = (EditText)findViewById(R.id.et_altura);
        txt_nombre = (TextView)findViewById(R.id.nombre);
        txt_edad = (TextView)findViewById(R.id.edad);
        txt_sexo = (TextView)findViewById(R.id.sexo);
        txt_altura = (TextView)findViewById(R.id.altura);
        txt_peso = (TextView)findViewById(R.id.peso);
        resultado = (TextView)findViewById(R.id.tasa_basal);
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
        numedad = Double.parseDouble(edad);

    }

    @Override
    public void onClick(View view) {
        txt_peso.setText(et_peso.getText().toString());
        txt_altura.setText(et_altura.getText().toString());
        peso = et_peso.getText().toString();
        altura = et_altura.getText().toString();
        switch(view.getId()) {
            case R.id.voler:
                i = new Intent(calorias.this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.calcular:
                if(peso.equals("") || altura.equals("")){
                    Toast.makeText(this, "Rellene Todos los Campos", Toast.LENGTH_SHORT).show();
                }else {
                    numpeso = Double.parseDouble(peso);
                    numaltura = Double.parseDouble(altura);
                    if (sexo.equals("Masculino")) {
                        dato = (10 * numpeso) + (6.25 * numaltura) - (5 * numedad) + 5;
                    } else if (sexo.equals("Femenino")) {
                        dato = (10 * numpeso) + (6.25 * numaltura) - (5 * numedad) - 161;
                    }
                    resultado.setText("Tu Tasa Metabolica Basal es de: " + dato);
                    et_peso.setText("");
                    et_altura.setText("");
                    break;
                }
        }
    }
}