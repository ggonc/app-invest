package com.mobile.invest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText inputValorInicial, inputAplicacaoMensal, inputTempoAplicacao, inputTaxa;
    public TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputValorInicial = findViewById(R.id.inputValorInicial);
        inputAplicacaoMensal = findViewById(R.id.inputAplicacaoMensal);
        inputTempoAplicacao = findViewById(R.id.inputTempoAplicacao);
        inputTaxa = findViewById(R.id.inputTaxa);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularAplicacao(View view) {
        double valorInicial = Double.parseDouble(inputValorInicial.getText().toString());
        double aplicacaoMensal = Double.parseDouble(inputAplicacaoMensal.getText().toString());
        int tempoAplicacao = Integer.parseInt(inputTempoAplicacao.getText().toString());
        double taxa = Double.parseDouble(inputTaxa.getText().toString());
        double taxaAplicada = 0;

        for (int i = 0; i < tempoAplicacao; i++){
            taxaAplicada += aplicacaoMensal + (aplicacaoMensal * taxa);
        }

        double resultado = valorInicial + taxaAplicada;
        textResultado.setText("O valor final de sua aplicação será de R$ " + String.format("%.2f", resultado) + ".");
    }
}