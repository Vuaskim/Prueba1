package com.example.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConversorActivity extends AppCompatActivity {

    private EditText edtValor;
    private Button btnConvertir;
    private Button btnVolver;
    private TextView txtResultado;

    // Tasas de conversión desde pesos chilenos (CLP) a otras monedas
    private static final double CLP_TO_USD = 0.0012;
    private static final double CLP_TO_EUR = 0.0011;
    private static final double CLP_TO_GBP = 0.0009;
    private static final double CLP_TO_JPY = 0.16;
    private static final double CLP_TO_CAD = 0.0016;
    private static final double CLP_TO_AUD = 0.0019;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversor_view); // Asegúrate de que este es el nombre correcto de tu archivo XML

        // Inicializa los componentes de la vista
        edtValor = findViewById(R.id.edtValor);
        btnConvertir = findViewById(R.id.btnConvertir);
        btnVolver = findViewById(R.id.btnVolver);
        txtResultado = findViewById(R.id.txtResultado);

        // Configura los listeners para los botones de conversión
        findViewById(R.id.btnUSD).setOnClickListener(v -> convertirDivisa(CLP_TO_USD, "Dólar Estadounidense"));
        findViewById(R.id.btnEUR).setOnClickListener(v -> convertirDivisa(CLP_TO_EUR, "Euro"));
        findViewById(R.id.btnGBP).setOnClickListener(v -> convertirDivisa(CLP_TO_GBP, "Libra Esterlina"));
        findViewById(R.id.btnJPY).setOnClickListener(v -> convertirDivisa(CLP_TO_JPY, "Yen Japonés"));
        findViewById(R.id.btnCAD).setOnClickListener(v -> convertirDivisa(CLP_TO_CAD, "Dólar Canadiense"));
        findViewById(R.id.btnAUD).setOnClickListener(v -> convertirDivisa(CLP_TO_AUD, "Dólar Australiano"));

        // Configura el listener para el botón de volver
        btnVolver.setOnClickListener(v -> {
            // Crea un intent para iniciar MainActivity
            Intent intent = new Intent(ConversorActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Opcional, cierra la actividad actual
        });
    }

    private void convertirDivisa(double tasaConversion, String nombreMoneda) {
        // Obtiene el valor ingresado
        String valorStr = edtValor.getText().toString();

        // Verifica si el campo no está vacío
        if (!valorStr.isEmpty()) {
            try {
                double valor = Double.parseDouble(valorStr);
                double resultado = valor * tasaConversion;

                // Muestra el resultado en el TextView
                txtResultado.setText(String.format("Resultado: %.2f %s", resultado, nombreMoneda));
            } catch (NumberFormatException e) {
                txtResultado.setText("Ingrese un valor válido.");
            }
        } else {
            txtResultado.setText("Ingrese un valor en CLP.");
        }
    }
}


