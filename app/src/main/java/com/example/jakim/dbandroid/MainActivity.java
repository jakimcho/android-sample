package com.example.jakim.dbandroid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.jakim.dbandroid.util.DBUsers;
import com.example.jakim.dbandroid.util.User;


public class MainActivity extends Activity implements View.OnClickListener {

    private EditText userName;
    private EditText userSirName;
    private RadioGroup userGender;
    private Button saveButton;
    private Button usersDisplayButton;
    private Button asyncButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.userGender = (RadioGroup) findViewById(R.id.userGender);
        this.userName = (EditText) findViewById(R.id.userNameField);
        this.userSirName = (EditText) findViewById(R.id.userSirNameField);
        this.saveButton = (Button) findViewById(R.id.userSaveButton);
        this.usersDisplayButton = (Button) findViewById(R.id.usersDisplayButton);
        this.asyncButton = (Button) findViewById(R.id.asyncButton);
        this.saveButton.setOnClickListener(this);
        this.asyncButton.setOnClickListener(this);
        this.usersDisplayButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.userSaveButton){
            DBUsers dbUser = new DBUsers(getApplicationContext());
            int indexOfGenderSelection = this.userGender.getCheckedRadioButtonId();
            View selectedGender = this.userGender.findViewById(indexOfGenderSelection);
            int genderIndex = this.userGender.indexOfChild(selectedGender);
            String userName = this.userName.getText().toString();
            String userSirName = this.userSirName.getText().toString();

            User user = new User(userName, userSirName, genderIndex);
            dbUser.addUserRecord(user);
        }

        if(v.getId() == R.id.usersDisplayButton){
            Intent displayUsers = new Intent(getApplicationContext(), ListUsersActivity.class);
            startActivity(displayUsers);
        }

        if(v.getId() == R.id.asyncButton){
            Intent displayAsync = new Intent(getApplicationContext(), AsyncActivity.class);
            startActivity(displayAsync);
        }
    }
}
