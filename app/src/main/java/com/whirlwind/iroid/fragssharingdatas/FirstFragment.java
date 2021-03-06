package com.whirlwind.iroid.fragssharingdatas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FirstFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
 /*   private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";*/


    public static EditText met1;

    private TextView mtv1;


    // TODO: Rename and change types of parameters
    public static String mParam1;
    private String mParam2;

    private static OnFragmentInteractionListener mListener;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance() {

        return new FirstFragment();


        /*
       Existing code:
       FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;*/
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  if (getArguments() != null) {
            // mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        met1 = (EditText) view.findViewById(R.id.et1);
        mtv1 = (TextView) view.findViewById(R.id.tv1);


       String value2 = getArguments() != null ? getArguments().getString("SECOND_PARAM", "Hai") : "Hai";

        mtv1.setText(value2);
        //mParam1 = met1.getText().toString();

        mListener.changeTitle("First Fragment");

        Button mbutton1 = (Button) view.findViewById(R.id.button1);
        mbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SecondFragment secondFragment = SecondFragment.newInstance();
                Bundle bundle = new Bundle();
                bundle.putString("FIRST_PARAM", met1.getText().toString().length() > 0 ? met1.getText().toString() : "Hello");
                secondFragment.setArguments(bundle);


                mListener.replaceFragment(secondFragment);

//                if(met1.getText().toString().equals("")){
//                    Toast.makeText(getActivity(), "User input value must be filled", Toast.LENGTH_LONG).show();
//                    return;
//                }
//                userData1 = met1.getText().toString();
//                onButtonPressed(userData1);
            }
        });


        return view;
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

