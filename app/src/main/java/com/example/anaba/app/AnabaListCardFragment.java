package com.example.anaba.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by gucci on 2014/11/26.
 */
public class AnabaListCardFragment extends Fragment{
    private static final String ARG_POSITION = "position";

    private int position;

    ListView listView;

    ArrayAdapter<String> listAdapter;

    public static AnabaListCardFragment newInstance(int position) {
        AnabaListCardFragment f = new AnabaListCardFragment();
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
        v.setText("AnabaList");
        ll.addView(v);


        //Listの初期設定
        listView = new ListView(getActivity());
        // Androidフレームワーク標準のレイアウト
        listAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                R.layout.list_item);
        // ListViewのitemをおした時の処理
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                ListView listView = (ListView) parent;
                // クリックされたアイテムを取得します
                String item = (String) listView.getItemAtPosition(position);
                Toast.makeText(getActivity(), item, Toast.LENGTH_LONG).show();
            }
        });


        Spinner spinner = new Spinner(getActivity());
        spinner.setFocusable(false);
        ll.addView(spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.anabalist_spinner_item);
        adapter.add("test");
        adapter.add("check");
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent,View view, int position, long id){
                Spinner spinner = (Spinner) parent;
                // 初回起動時の動作
                if (spinner.isFocusable() == false) {
                    spinner.setFocusable(true);
                    return;
                }
                String item = (String) spinner.getSelectedItem();
                Toast.makeText(getActivity(), String.format("%sが選択されました。", item),Toast.LENGTH_SHORT).show();
                listAdapter.add(item);
                listView.setAdapter(listAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){
                Toast.makeText(getActivity(),
                        "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });

        ll.addView(listView);
        fl.addView(ll);
        return fl;
    }
}