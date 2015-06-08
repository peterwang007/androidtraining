package com.gs.bruce.androidtraining;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class ReadArticle extends Fragment {

    private View view;
    OnHeadlineSelectedListener mCallback;
    public ReadArticle() {
        // Required empty public constructor
    }
    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(int position);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("FegmentLiferecycle", "---Fegment created------");
    }

    @Override
    public void onAttach(final Activity activity) {
        super.onAttach(activity);
        try{
            mCallback= (OnHeadlineSelectedListener)activity;
            Button btnSave = (Button)activity.findViewById(R.id.btnSaveData);
            btnSave.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Context context = activity;
                    SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharedPref.edit();
                    editor.putString(getString(R.string.saved_high_score),"Haaaaaaaaaaaaa");
                    editor.commit();
                }
            });
        }
        catch (ClassCastException ex){
            throw new ClassCastException(activity.toString() +" must implement the OnHeadlineSelectedListener interface.");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("FegmentLiferecycle", "---Fegment start------");
        Context context = getActivity();
        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String highScore = sharedPref.getString(getString(R.string.saved_high_score), "You");
        Toast toast = Toast.makeText(context,highScore,Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("FegmentLiferecycle", "---Fegment resume------");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("FegmentLiferecycle", "---Fegment pause------");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("FegmentLiferecycle", "---Fegment stop------");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("FegmentLiferecycle", "---Fegment destory------");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        if (view == null) {
//            view =inflater.inflate(R.layout.fragment_read_article, container, false);
//        }
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_read_article, container, false);
    }

}
