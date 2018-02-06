package com.example.lieberson.preferenciascorusuario;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    private RelativeLayout layout;
    private RadioGroup radioGroup;
    private RadioButton radioButtonSelecionado;
    private Button botaoSalvar;

    private static final String ARQUIVO_PREFERENCIAL = "ArqPreferencial";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layoutId);
        radioGroup = findViewById(R.id.radioGroupId);
        botaoSalvar = findViewById(R.id.botaoSalvarId);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();


                    if (idRadioButtonEscolhido > 0){

                        radioButtonSelecionado = findViewById(idRadioButtonEscolhido);

                        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIAL, 0);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String corEscolhida = radioButtonSelecionado.getText().toString();
                        editor.putString("corEscolhida", corEscolhida);
                        editor.commit();

                        setBackground(corEscolhida);

                    }

            }
        });

    }

    private void setBackground(String cor){

        if (cor.equals("Azul")){

            layout.setBackgroundColor(Color.parseColor("#495B7C"));

        }else if (cor.equals("Laranja")){

            layout.setBackgroundColor(Color.parseColor("#FFA500"));

        }else if (cor.equals("Verde")){

            layout.setBackgroundColor(Color.parseColor("#009670"));

        }

    }
}
