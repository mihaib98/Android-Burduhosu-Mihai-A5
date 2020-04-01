package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    TextView textView;
    String[] listItem = {"SmartCards","Android","Calcul Numeric","Grafica pe Calculator","Psihologie"};
    String bundleItem = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle","onCreate invoked");

        if (savedInstanceState != null) {
            bundleItem = savedInstanceState.getString("savedItems");
            Toast.makeText(getApplicationContext(), bundleItem, Toast.LENGTH_SHORT).show();
        }

        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.textView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String value = adapter.getItem(position);
                bundleItem += value;
                bundleItem += "\n";
                Toast.makeText(getApplicationContext(), bundleItem, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putString("savedItems", bundleItem);
        super.onSaveInstanceState(outState);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sample_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.cart:
                Intent intent = new Intent(this, Profile.class);
                startActivity(intent);
                break;
            case R.id.storage:
                intent = new Intent(this, Storage.class);
                startActivity(intent);
                break;
            case R.id.sensors:
                intent = new Intent(this, SensorActivity.class);
                startActivity(intent);
                break;
            case R.id.options:
                intent = new Intent(this, Options.class);
                startActivity(intent);
                break;
            case R.id.settings:
                intent = new Intent(this, Settings.class);
                startActivity(intent);
                break;
            case R.id.exit:
                new ExitDialog().show(getSupportFragmentManager(),"exit");
                break;
        }
        return super.onOptionsItemSelected(item);
    }


        protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked");
    }
}
