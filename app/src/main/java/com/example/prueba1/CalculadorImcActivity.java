package com.example.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CalculadorImcActivity extends AppCompatActivity {

    private EditText edtPeso;
    private EditText edtAltura;
    private TextView txtResultado;
    private Button btnCalcular;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculador_imc); // Asegúrate de que este es el nombre correcto de tu archivo XML

        // Inicializa los componentes de la vista
        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        txtResultado = findViewById(R.id.txtResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnVolver = findViewById(R.id.btnVolver);

        // Configura el listener para el botón de calcular
        btnCalcular.setOnClickListener(v -> calcularIMC());

        // Configura el listener para el botón de volver
        btnVolver.setOnClickListener(v -> {
            // Regresa a la MainActivity
            Intent intent = new Intent(CalculadorImcActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Opcional: Finaliza la actividad actual para que no regrese al presionar "Atrás"
        });
    }

    private void calcularIMC() {
        // Obtiene los valores de los campos
        String pesoStr = edtPeso.getText().toString();
        String alturaStr = edtAltura.getText().toString();

        // Verifica si los campos no están vacíos
        if (!pesoStr.isEmpty() && !alturaStr.isEmpty()) {
            try {
                // Convierte los valores a números
                double peso = Double.parseDouble(pesoStr);
                double altura = Double.parseDouble(alturaStr);

                // Verifica que la altura no sea cero para evitar división por cero
                if (altura == 0) {
                    txtResultado.setText("La altura no puede ser cero.");
                    return;
                }

                // Calcula el IMC
                double imc = peso / (altura * altura);

                // Determina la clasificación del IMC
                String clasificacion;
                if (imc < 18.5) {
                    clasificacion = "Bajo peso";
                } else if (imc < 24.9) {
                    clasificacion = "Normal";
                } else if (imc < 29.9) {
                    clasificacion = "Sobrepeso";
                } else {
                    clasificacion = "Obeso";
                }

                // Muestra el resultado en el TextView
                txtResultado.setText(String.format("IMC: %.2f\nClasificación: %s", imc, clasificacion));
            } catch (NumberFormatException e) {
                // Muestra un mensaje de error si la conversión falla
                txtResultado.setText("Ingrese valores válidos.");
            }
        } else {
            // Muestra un mensaje de error si algún campo está vacío
            txtResultado.setText("Complete todos los campos.");
        }
    }
}




