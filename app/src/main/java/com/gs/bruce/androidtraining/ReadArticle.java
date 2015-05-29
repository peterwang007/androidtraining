package com.gs.bruce.androidtraining;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ReadArticle extends Fragment {

    private View view;
    public ReadArticle() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("FegmentLiferecycle", "---Fegment created------");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("FegmentLiferecycle", "---Fegment start------");
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
