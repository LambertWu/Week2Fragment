package com.example.lambert_wu.week2fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentSelector extends Fragment {

    private static final int ARTICLE1 = 1;
    private static final int ARTICLE2 = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View fragmentView = inflater.inflate(R.layout.article_select, container, false);
        setArticleSelector((Button) fragmentView.findViewById(R.id.button1), ARTICLE1);
        setArticleSelector((Button) fragmentView.findViewById(R.id.button2), ARTICLE2);
        return fragmentView;
    }

    public void setArticleSelector(Button btn, final int article){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onArticleSelected(article);
            }
        });
    }

    public void onArticleSelected(int fragmentIdx){
        TextFragment frag = (TextFragment)
                getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment2);

        if (frag != null) {
            frag.updateArticleView(fragmentIdx);
        } else {
            TextFragment newFragment = new TextFragment();
            Bundle args = new Bundle();
            args.putInt(TextFragment.ARG_IDX, fragmentIdx);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
