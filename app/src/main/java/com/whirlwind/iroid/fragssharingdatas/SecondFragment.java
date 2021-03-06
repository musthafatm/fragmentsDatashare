package com.whirlwind.iroid.fragssharingdatas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




public class SecondFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   // private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String value1;
    private String mParam2;


    // private

    public static TextView mtv2;

    private EditText met2;


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
        // if (getArguments() != null) {

        //mParam2 = getArguments().getString(ARG_PARAM2);
        // }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
       // value1 = getArguments().getString("FIRST_PARAM", "Hello");
        value1 = getArguments().getString("FIRST_PARAM");

        met2 = (EditText) view.findViewById(R.id.et2);
        mtv2 = (TextView) view.findViewById(R.id.tv2);

        Toast.makeText(getActivity(), "Data:" + value1, Toast.LENGTH_LONG).show();
        mtv2.setText(value1);

        // mListener.replaceText(dataFromFrag1);
        mListener.changeTitle("Second Fragment");

        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragment firstFragment = FirstFragment.newInstance();
                Bundle bundle = new Bundle();
                //******here null is passed to Second_Param : if length =0 and then default value: 'Hai' is passed to second_Param
                // ******inside onCreateView of FirstFragment.java(This is another method)
                bundle.putString("SECOND_PARAM", met2.getText().toString().length() > 0 ? met2.getText().toString() : null);

                firstFragment.setArguments(bundle);
                mListener.replaceFragment(firstFragment);
            }
        });


        //Actually like this: updateTextField(userData1);    But '   userData1  '   needs to be accessed here.

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
