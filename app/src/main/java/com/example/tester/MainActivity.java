package com.example.tester;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Puxando um representante para cada função.
    private TextView editResult;
    private EditText editPeso;
    private EditText editAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Puxando dados dos representantes.
        editResult = findViewById(R.id.editResult);
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);

    }

    public void calcularImc(View view){

        // Irá calcular usando os valores informados lá nos espaços (Peso & Altura)
        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double resultado = peso / (altura * altura);

        if( resultado < 19 ) {

            editResult.setText("Abaixo do peso.");

        } else if( resultado <= 19 || resultado < 25 ){

            editResult.setText("Peso normal.");

        } else if( resultado <= 25 || resultado < 30 ){

            editResult.setText("Sobrepeso");

        } else if( resultado <= 30 || resultado < 40 ){

            editResult.setText("Obesidade tipo 1");

        } else if( resultado >= 40 ){

            editResult.setText("Obesidade tipo 2");

        }

    }
}