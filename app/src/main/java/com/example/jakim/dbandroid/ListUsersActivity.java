package com.example.jakim.dbandroid;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.jakim.dbandroid.util.DBUsers;
import com.example.jakim.dbandroid.util.User;

import java.util.ArrayList;
import java.util.List;


public class ListUsersActivity extends Activity {

    private ListView usersListView;
    private DBUsers dbUsers;
    private List<User> users;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        dbUsers = new DBUsers(getApplicationContext());

        this.usersListView = (ListView) findViewById(R.id.usersListView);
        Cursor cursor = dbUsers.getValues();
        users = new ArrayList<User>();

        if(cursor.moveToFirst()){
            do{
                user = new User();
                user.setUserName(cursor.getString(cursor.getColumnIndex("user_name")));
                user.setUserSirName(cursor.getString(cursor.getColumnIndex("user_sir_name")));
                users.add(user);
            }while(cursor.moveToNext());
        }

        cursor.close();
        dbUsers.close();

        UserListAdaptor usersListAdaptor = new UserListAdaptor(this, R.layout.users_list_view, users);
        this.usersListView.setAdapter(usersListAdaptor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_users, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
