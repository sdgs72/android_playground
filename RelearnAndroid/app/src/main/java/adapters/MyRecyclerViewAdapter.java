package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dionhiananto.relearnandroid.R;

import java.util.ArrayList;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{
    private final String debug_tag = "RecyclerViewTest";
    private ArrayList<DoubleString> model;
    private LayoutInflater myInflater;



    public MyRecyclerViewAdapter(Context e){

        myInflater = (LayoutInflater) e.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        model = new ArrayList<DoubleString>();

    }

    public void setModel(ArrayList<DoubleString> model){
        this.model = model;
    }



    /*
    this function will inflate the given ViewGroup whenever the scrollView needs a new ViewHolder
    what is a ViewHolder?(a viewholder represents a ViewGroup and its metadata for a single row in the recyclerview)
    if a screen can only fit 6 rows, only 6 viewholder will be created and if the user scrolls down or up
    it will repopulate the existing viewholder with the correct data
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(debug_tag,"onCreateViewHolder");
        View v = myInflater.inflate(R.layout.single_row_text,parent,false);
        return new MyViewHolder(v);
    }


    /*
    this function will refill the content for the given ViewHolder
    the holder is the viewholder whose data is about to be changed/reused
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DoubleString elem = model.get(position);
        holder.text1.setText(elem.text1);
        holder.text2.setText(elem.text2);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView text1;
        public TextView text2;

        /*
        it is important to cache the findViewByID
        so that you don't need to call findViewByID multiple times, findViewByID is expensive
         */
        public MyViewHolder(View itemView) {
            super(itemView);
            text1 = (TextView)itemView.findViewById(R.id.single_row_text1);
            text2 = (TextView)itemView.findViewById(R.id.single_row_text2);
        }
    }



}

