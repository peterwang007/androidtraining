package com.gs.bruce.androidtraining;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;


public class FileProcess extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_process);

        Button btnCreateFile =(Button) findViewById(R.id.btn_create_file);
        Button btnCreateExternalFile =(Button) findViewById(R.id.btn_create_file2);
        btnCreateFile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String fileName = "myFile.txt";
                String content = "Hello world";
                FileOutputStream outputStream;

                File file = new File(getFilesDir(), fileName);
                try{
                    outputStream = openFileOutput(fileName,MODE_PRIVATE);
                    outputStream.write(content.getBytes());
                    outputStream.close();
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        btnCreateExternalFile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               getAlbumStorageDir(v.getContext(),"TestAlbum");
            }
        });
    }

    public File getAlbumStorageDir(Context context, String albumName) {
        if (isExternalStorageWritable()) {
            // Get the directory for the app's private pictures directory.
            File file = new File(context.getExternalFilesDir(
                    Environment.DIRECTORY_PICTURES), albumName);
            if (!file.mkdirs()) {
                Log.e("CreateDirError", "Directory not created");
            }
            return file;
        } else {
            Log.e("StorageIsNotAvaiable", "The external storage is not available");
            return null;
        }
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_file_process, menu);
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
