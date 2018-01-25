package com.roomdemo;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etFirstName)
    EditText etFirstName;

    @BindView(R.id.etLastName)
    EditText etLastName;

    @BindView(R.id.btnSave)
    Button btnSave;

    @BindView(R.id.rvUser)
    RecyclerView rvUser;

    private UserDatabase userDatabase;
    private UsersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new UsersAdapter();
        userDatabase = Room.databaseBuilder(getApplicationContext(),UserDatabase.class,"user_db").build();
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        rvUser.setAdapter(adapter);
    }

    @OnClick(R.id.btnSave)
    public void onSave(){

        new DatabaseAsync().execute();
        //Umay Dukra
    }

    private class DatabaseAsync extends AsyncTask<Void, Void, Void>{

        private ArrayList<User> arlstUser;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            arlstUser = new ArrayList<User>();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            adapter.setUsers(arlstUser);

            etFirstName.setText("");
            etLastName.setText("");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            User user = new User();
            user.setFirstName(etFirstName.getText().toString());
            user.setLastName(etLastName.getText().toString());

            userDatabase.getUserDao().insertUser(user);

            arlstUser = (ArrayList<User>) userDatabase.getUserDao().getAllUsers();

            return null;
        }
    }
}
