package com.example.trabalhoandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView_resultadoIMC;
    private EditText editText_peso, editText_altura;
    private Button bt_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView_resultadoIMC= findViewById(R.id.textView_resultadoIMC);
        bt_ok = findViewById(R.id.button);
        editText_peso = findViewById(R.id.editText_peso);
        editText_altura = findViewById(R.id.editText_altura);

        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!editText_peso.getText().toString().isEmpty() && !editText_altura.getText().toString().isEmpty()) {

                    double peso = Double.parseDouble(editText_peso.getText().toString());
                    double altura = Double.parseDouble(editText_altura.getText().toString());
                    double IMC = peso / (altura * altura);

                    if (IMC < 18.5) {
                        textView_resultadoIMC.setText(IMC + "\n Magreza");
                    } else if (IMC >= 18.5 && IMC < 24.9) {
                        textView_resultadoIMC.setText(IMC + "\n Normal");
                    } else if (IMC >= 25 && IMC < 29.9) {
                        textView_resultadoIMC.setText(IMC + "\n Sobrepeso");
                    } else if (IMC >= 30 && IMC < 39.9) {
                        textView_resultadoIMC.setText(IMC + "\n Obesidade");
                    } else if (IMC > 40) {
                        textView_resultadoIMC.setText(IMC + "\n Sobrepeso");
                    }


                }
                else {
                    AlertDialog.Builder a = new AlertDialog.Builder(view.getContext());
                    a.setTitle("Informação!");
                    a.setMessage("Os campos \"Peso\" e \"Altura\" não podem estar vazios. Por favor digite os valores e tente novamente!");
                    a.setPositiveButton("Ok", null);
                    a.create();
                    a.show();
                }

            }
        });


    }

    public  void abrir_tela_sobre(View view){
        Intent it_telaSobre = new Intent(this,telaDoisTrabalhoIMC.class);
        startActivity(it_telaSobre);

    }


}