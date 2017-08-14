package com.whirlwind.iroid.fragssharingdatas;

import android.support.v4.app.Fragment;

public interface OnFragmentInteractionListener {

    void changeTitle(String userContent1);

    void replaceFragment(Fragment fragment);
}