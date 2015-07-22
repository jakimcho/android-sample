package com.example.jakim.dbandroid;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jakim.dbandroid.util.User;

import java.util.List;

/**
 * Created by Jakim on 12.7.2015 ã..
 */
public class UserListAdaptor extends ArrayAdapter {

    private List<User> users;
    private Context context;
    private int resourceLayout;

    public UserListAdaptor(Context context, int resource,  List<User> objects) {
        super(context, resource, objects);
        this.users = objects;
        this.context = context;
        this.resourceLayout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((Activity)this.context).getLayoutInflater();
        View row = inflater.inflate(this.resourceLayout, parent, false);

        TextView userName = (TextView) row.findViewById(R.id.userName);
        TextView userSirName = (TextView) row.findViewById(R.id.userSirName);
        ImageView avatar = (ImageView) row.findViewById(R.id.avatar);
        avatar.setImageResource(R.drawable.tiger);

        userName.setText(this.users.get(position).getUserName());
        userSirName.setText(this.users.get(position).getUserSirName());

        return row;
    }
}
