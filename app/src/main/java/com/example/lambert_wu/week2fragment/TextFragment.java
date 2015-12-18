package com.example.lambert_wu.week2fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment {
    final static String ARG_IDX = "index";
    int mCurrentIdx = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        if (savedInstanceState != null) {
            mCurrentIdx = savedInstanceState.getInt(ARG_IDX);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.article_view, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateArticleView(args.getInt(ARG_IDX));
        } else if (mCurrentIdx != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateArticleView(mCurrentIdx);
        }
    }

    public void updateArticleView(int index) {
        TextView article = (TextView) getActivity().findViewById(R.id.article);
        article.setText("This is Article "+index+".");
        mCurrentIdx = index;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_IDX, mCurrentIdx);
    }
}
