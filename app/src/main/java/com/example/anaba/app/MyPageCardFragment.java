package com.example.anaba.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by gucci on 2014/11/26.
 */
public class MyPageCardFragment extends Fragment{
    private static final String ARG_POSITION = "position";

    private int position;

    ListView listView;

    public static MyPageCardFragment newInstance(int position) {
        MyPageCardFragment f = new MyPageCardFragment();
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
        v.setText("MyPage");
        ll.addView(v);

        ImageView iv  = new ImageView(getActivity());
        iv.setImageResource(R.drawable.juice);
        ll.addView(iv);


        v = new TextView(getActivity());
        v.setGravity(Gravity.CENTER);
        v.setText("Check-In List");
        ll.addView(v);

        //Listの初期設定
        listView = new ListView(getActivity());
        // Androidフレームワーク標準のレイアウト
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                R.layout.list_item);

        adapter.add("自宅");
        adapter.add("吉野家");
        adapter.add("研究室");
        adapter.add("ひまわり");

        listView.setAdapter(adapter);
        ll.addView(listView);

        fl.addView(ll);
        return fl;
    }
}