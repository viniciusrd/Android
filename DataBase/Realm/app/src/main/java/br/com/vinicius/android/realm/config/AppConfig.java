package br.com.vinicius.android.realm.config;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AppConfig extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .name("vinicius.realm")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }

}
