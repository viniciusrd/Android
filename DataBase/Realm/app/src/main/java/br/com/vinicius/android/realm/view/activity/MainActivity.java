package br.com.vinicius.android.realm.view.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.vinicius.android.realm.R;
import br.com.vinicius.android.realm.view.fragment.InsertFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    //Fragemnt
    private InsertFragment insertFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_insert:
                    mTextMessage.setText(R.string.title_insert);

                    setFragment(insertFragment);

                    return true;
                case R.id.navigation_update:
                    mTextMessage.setText(R.string.title_update);
                    return true;
                case R.id.navigation_list:
                    mTextMessage.setText(R.string.title_read);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);

        insertFragment = new InsertFragment();
        setFragment(insertFragment);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    private void setFragment(Fragment fragmentParam) {

        //Configurar o fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_main, fragmentParam);
        transaction.commit();

    }

}
