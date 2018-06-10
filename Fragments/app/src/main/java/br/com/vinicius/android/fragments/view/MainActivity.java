package br.com.vinicius.android.fragments.view;

import android.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.vinicius.android.fragments.R;
import br.com.vinicius.android.fragments.fragment.ContatosFragment;
import br.com.vinicius.android.fragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button btnContatos, btnConversas;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnContatos = findViewById(R.id.btnContatos);
        btnConversas = findViewById(R.id.btnConversas);

        //Remover sombra actionBar
        getSupportActionBar().setElevation(0);

        //Carregar fragmento
        conversasFragment = new ConversasFragment();

        //Configurar o fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameConteudo, conversasFragment);
        transaction.commit();

        btnContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contatosFragment = new ContatosFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, contatosFragment);
                transaction.commit();

            }
        });

        btnConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Carregar fragmento
                conversasFragment = new ConversasFragment();

                //Configurar o fragmento
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, conversasFragment);
                transaction.commit();
            }
        });

    }
}
