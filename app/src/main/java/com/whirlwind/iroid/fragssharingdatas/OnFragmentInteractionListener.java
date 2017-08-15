package com.whirlwind.iroid.fragssharingdatas;

import android.support.v4.app.Fragment;
import android.widget.EditText;

public interface OnFragmentInteractionListener {

    void changeTitle(String userContent1);

    void replaceFragment(Fragment fragment);

    void readText();

    // void replaceText(Fragment fragment);
}