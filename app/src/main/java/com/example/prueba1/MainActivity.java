package com.example.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ajusta el padding para los Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configura el listener para el botón "CALCULADORA DE IMC"
        Button btnImc = findViewById(R.id.btnImc);
        btnImc.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CalculadorImcActivity.class);
            startActivity(intent);
        });

        // Configura el listener para el botón "CONVERSOR DE MONEDA"
        Button btnConversor = findViewById(R.id.btnConversor);
        btnConversor.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConversorActivity.class);
            startActivity(intent);
        });
    }
}


