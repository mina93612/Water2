package com.fju.water2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edMonth;
    private EditText edNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edMonth = findViewById((R.id.month));
        edNext = findViewById((R.id.next));
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void calculation(View view) {
        if (!TextUtils.isEmpty(edMonth.getText().toString())) {
            float degree = Float.parseFloat(edMonth.getText().toString());
            float money = 0;
            if (degree < 11) {
                money = 7.35f * degree;
            } else if (degree < 31) {
                money = 9.45f * degree - 21.0f;
            } else if (degree < 50) {
                money = 11.55f * degree - 84.0f;
            } else if (degree > 51) {
                money = 12.075f * degree - 110.25f;
            }
            new AlertDialog.Builder(this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用: " + money)
                    .setPositiveButton("ok", null)
                    .show();
        }
        if (!TextUtils.isEmpty(edNext.getText().toString())) {
            float degree = Float.parseFloat(edNext.getText().toString());
            float money = 0;
            if (degree < 21) {
                money = 7.35f * degree;
            } else if (degree < 61) {
                money = 9.45f * degree - 42.0f;
            } else if (degree < 100) {
                money = 11.55f * degree - 168.0f;
            } else if (degree > 101) {
                money = 12.075f * degree - 220.5f;
            }
            new AlertDialog.Builder(this)
                    .setTitle("隔月抄表費用")
                    .setMessage("費用: " + money)
                    .setPositiveButton("ok", null)
                    .show();
        }
    }
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
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
