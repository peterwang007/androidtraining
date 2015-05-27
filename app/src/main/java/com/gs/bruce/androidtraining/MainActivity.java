package com.gs.bruce.androidtraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {

    public final static   String EDIT_MESSAGE="com.gs.bruce.main.sendmessage";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Liferecycle","---Application created------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Liferecycle", "---Application stop------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Liferecycle", "---Application destory------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Liferecycle", "---Application pause------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Liferecycle", "---Application resume------");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("Liferecycle", "---Application save instance state------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Liferecycle", "---Application start------");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Liferecycle", "---Application restart------");
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
            Toast toast = Toast.makeText(this, "You have clicked the Setting button", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }
        if(id == R.id.action_search){
            Toast toast = Toast.makeText(this,"You have clicked the search button",Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void  sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessage.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EDIT_MESSAGE, message);
        startActivity(intent);
    }

}
