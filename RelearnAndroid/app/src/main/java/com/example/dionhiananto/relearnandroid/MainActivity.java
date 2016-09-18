package com.example.dionhiananto.relearnandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import adapters.DoubleString;
import adapters.MyRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView myRecyclerView;
    MyRecyclerViewAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_playground);
        Log.d("test release activity", "create");




        try {
            //set layout to activity_main.xml to enable this
            ImageView imageView = (ImageView) findViewById(R.id.testImage);
            //imageView.setImageResource(R.drawable.food_image_1);
            imageView.setOnClickListener(new customListener());
        }
        catch(Exception E){

        }


        //set layout to recycler_view_playground to enable this
        myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        myAdapter= new MyRecyclerViewAdapter(this);
        ArrayList<DoubleString> model = new ArrayList<DoubleString>();
        for(int i = 0 ; i < 1000 ; i++){
            DoubleString temp = new DoubleString();
            temp.text1 = "text1:" + i;
            temp.text2 = "text2:" + i;
            model.add(temp);
        }
        myAdapter.setModel(model);
        myRecyclerView.setAdapter(myAdapter);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.d("test release activity", "start");
    }


    @Override
    protected void onResume(){
        super.onResume();
        Log.d("test release activity", "resume");

    }


    @Override
    public void onPause() {
        super.onPause();
        Log.d("test release activity", "pause");

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("test release activity", "stop");

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("test release activity", "restart");

    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("test release activity", "destroy");

    }





    private class customListener implements View.OnClickListener{
        public void onClick(View var1){
            Log.d("test release activity","image view clicked");
        }
    }
}
