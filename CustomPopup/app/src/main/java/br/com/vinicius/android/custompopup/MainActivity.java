package br.com.vinicius.android.custompopup;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Dialog mDialog;
    Button mBtnShowPopup;
    Button mBtnShowPopup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDialog = new Dialog(this);
        mBtnShowPopup = findViewById(R.id.showPopup);
        mBtnShowPopup2 = findViewById(R.id.showPopup2);
        mBtnShowPopup.setOnClickListener(this);
        mBtnShowPopup2.setOnClickListener(this);

    }

    private void showPopup(){

        ImageView imgClose;
        Button    buttonContact;
        mDialog.setContentView(R.layout.custompopup);

        imgClose = mDialog.findViewById(R.id.close);
        buttonContact = mDialog.findViewById(R.id.btnContato);

        imgClose.setOnClickListener(this);

        mDialog.show();

    }

    private void showPopup2(){

        mDialog.setContentView(R.layout.customprogressdialog);
        mDialog.show();

    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.close){
            mDialog.dismiss();
        }
        if (v.getId() == R.id.showPopup){
            showPopup();
        }

        if (v.getId() == R.id.showPopup2){
            showPopup2();
        }
    }
}
