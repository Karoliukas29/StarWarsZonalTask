package com.zonal.starwars;

import android.app.Application;
import android.content.Context;


import org.greenrobot.greendao.database.Database;

public class StarWarsApp extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initDb();
    }

    public void initDb(){
        DaoMaster.OpenHelper helper = new StarWarsOpenHelperDB(this, "planets-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static class StarWarsOpenHelperDB extends DaoMaster.OpenHelper {

        public StarWarsOpenHelperDB(Context context, String name) {
            super(context, name);
        }

        @Override
        public void onCreate(Database db) {
            super.onCreate(db);
        }
    }
}