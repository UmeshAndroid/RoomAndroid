package com.roomdemo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umesh.dabhade on 15/01/18.
 */

@Dao
public interface UserDao {

    @Query("Select * from  User")
    List<User> getAllUsers();

    @Insert
    void insertUser(User user);

}
