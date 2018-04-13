package com.example.tharu.gr5ex;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * Created by tharu on 4/7/2018.
 */

public class SecondFragment extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.second_layout, container, false);
        TextView tv = (TextView) myView.findViewById(R.id.textView2);


        try{
            int value1=0;
            String value2=" ";
            String[] StringArray = {};

            Bundle bundle = this.getArguments();
            if (bundle != null) {
                value1 = bundle.getInt("VALUE1", -1);
                value2 = bundle.getString("VALUE2", "h");
                StringArray = bundle.getStringArray("VALUE3");
                tv.setText("Q: " + value1 + " " + value2);
                //ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.second_layout, StringArray);
                ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, StringArray);
                ListView answer_list_view = (ListView) myView.findViewById(R.id.answer_list_view);
                answer_list_view.setAdapter(adapter);
            }else{
                tv.setText("Click next to start");
            }
        }catch (Exception ex){
            tv.setText("Click next to start");
        }
        return  myView;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
