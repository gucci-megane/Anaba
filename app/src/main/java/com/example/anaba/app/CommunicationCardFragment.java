package com.example.anaba.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by gucci on 2014/11/26.
 */
public class CommunicationCardFragment extends Fragment{
    private static final String ARG_POSITION = "position";

    private int position;

    public static CommunicationCardFragment newInstance(int position) {
        CommunicationCardFragment f = new CommunicationCardFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //CARD内の編集はここで

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        FrameLayout fl = new FrameLayout(getActivity());
        fl.setLayoutParams(params);
        final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
                .getDisplayMetrics());
        params.setMargins(margin, margin, margin, margin);

        LinearLayout ll = new LinearLayout(getActivity());
        ll.setLayoutParams(params);
        ll.setBackgroundResource(R.drawable.background_card);
        ll.setOrientation(LinearLayout.VERTICAL);

        TextView v = new TextView(getActivity());
        v.setGravity(Gravity.CENTER);
        v.setText("Communication");
        ll.addView(v);

        fl.addView(ll);
        return fl;
    }
}