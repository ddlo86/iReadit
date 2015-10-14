package com.example.gmcl.Bo.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gmcl.Bo.R;
import com.example.gmcl.Bo.data.Job;
import com.parse.ParseUser;

/**
 * Created by GMCL on 06/10/2015.
 */




public class DetailsFragmentold1 extends Fragment{

    ParseUser user;
    TextView tvmeeseeks;
    final static String TAG = DetailsFragmentold1.class.getSimpleName();
    public DetailsFragmentold1() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        //TODO: check if null or object comparison fucksup
        Job job = (Job) bundle.getSerializable("currentJob");

        Log.d(TAG, job.getDropoffCity() + job.getJobId());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_details_old1, container, false);
        tvmeeseeks = (TextView) view.findViewById(R.id.meeseeks);

            return view;




    }
}

