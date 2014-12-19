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
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by gucci on 2014/11/26.
 */
public class CheckInCardFragment extends Fragment{
    private static final String ARG_POSITION = "position";

    private int position;

    private static final String[] textViews = null;

    EditText et;

    ListView listView;

    private ArrayAdapter<String> adapter = null;

    public static CheckInCardFragment newInstance(int position) {
        CheckInCardFragment f = new CheckInCardFragment();
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

        TextView tv = new TextView(getActivity());
        tv.setGravity(Gravity.CENTER);
        tv.setText("Check-In");
        ll.addView(tv);

        //Listの初期設定
        listView = new ListView(getActivity());
        // Androidフレームワーク標準のレイアウト
        adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                R.layout.checkin_list_item);
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

        //検索とボタン
        LinearLayout tll = new LinearLayout(getActivity());
        params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        tll.setLayoutParams(params);
        tll.setOrientation(LinearLayout.HORIZONTAL);
        tll.setGravity(Gravity.CENTER);

        //検索
        et = new EditText(getActivity());
        et.setGravity(Gravity.CENTER);
        et.setHint("店舗を検索");
        tll.addView(et);

        //ボタン
        Button bt = new Button(getActivity());
        bt.setText("検索");
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BusHolder.get().post(new CheckInButtonClickEvent(et.getText().toString(),listView,adapter));
            }
        });

        tll.addView(bt);
        ll.addView(tll);
        ll.addView(listView);
        fl.addView(ll);

        return fl;
    }
}