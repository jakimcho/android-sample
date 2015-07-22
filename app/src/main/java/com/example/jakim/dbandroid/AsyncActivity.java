package com.example.jakim.dbandroid;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class AsyncActivity extends Activity implements View.OnClickListener {

    TextView t1;
    TextView t2;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);

        b1 = (Button) findViewById(R.id.go1);
        b2 = (Button) findViewById(R.id.go2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_async, menu);
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

        if(v.getId() == R.id.go1){
            new Counter().execute(t1);
        }else{
            new Counter().execute(t2);
        }

    }

    private class Counter extends AsyncTask<View, Integer, Void> {
        TextView text;
        @Override
        protected Void doInBackground(View... params) {
            TextView text = (TextView) params[0];
            this.text = text;
            try {
                for (int i = 0; i < 10; i ++){
                    publishProgress(i);
                    Thread.sleep(400);
                }
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            String updated = String.valueOf(values[0]);
            this.text.setText(updated);
        }

    }
}
