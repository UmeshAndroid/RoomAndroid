package com.roomdemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by umesh.dabhade on 15/01/18.
 */

@Database(entities = {User.class},version = 1)
public abstract class UserDatabase extends RoomDatabase{

    public abstract UserDao getUserDao();
}
