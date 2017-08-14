package com.whirlwind.iroid.fragssharingdatas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class SecondFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;



    private TextView mtv2;


    private OnFragmentInteractionListener mListener;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters



    public static SecondFragment newInstance() {
        SecondFragment fragment2 = new SecondFragment();
        Bundle args = new Bundle();

        fragment2.setArguments(args);
        return fragment2;

        /*
      Existing code:
      SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;*/
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        mtv2 = (TextView) view.findViewById(R.id.tv2);

      view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              mListener.replaceFragment(SecondFragment.this);
          }
      });

        mListener.changeTitle("Second Fragment");

        //Actually like this: updateTextField(userData1);             But '   userData1  '   needs to be accessed here.

        return view;
    }


//##################################################***********

    public void updateTextField(String newText){

        mtv2.setText(newText);
    }









    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }






    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }




}
