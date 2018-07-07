package br.com.vinicius.android.sharedpreferences;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textWelcome;
    private Button buttonSalvar;
    private TextInputEditText inputNome;

    private static final String PREFERENCE_FILE = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFindViewsById();
        getPreferencesUser();

    }

    private void getPreferencesUser() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_FILE,0);
        if(sharedPreferences.contains("nome")){
            String nome = sharedPreferences.getString("nome","Não encontrado");
            textWelcome.setText("Olá,"+nome);
        }else
            textWelcome.setText("Usário não encontrado");

    }

    private void getFindViewsById() {
        buttonSalvar = findViewById(R.id.btnSalvar);
        buttonSalvar.setOnClickListener(this);
        textWelcome = findViewById(R.id.txtWelcome);
        inputNome = findViewById(R.id.txtInputNome);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnSalvar:
                //Ele cria um arquivo xml no aparelho
                SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_FILE,0);
                SharedPreferences.Editor editor =  sharedPreferences.edit();

                if(inputNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Nome não informado !",Toast.LENGTH_LONG).show();
                }else {
                    String nome = inputNome.getText().toString();
                    editor.putString("nome",nome);
                    editor.commit();
                    textWelcome.setText("Olá,"+nome);
                }
        }
    }


}
