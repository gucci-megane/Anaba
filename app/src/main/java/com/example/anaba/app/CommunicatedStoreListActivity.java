package com.example.anaba.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by gucci on 2014/12/20.
 */
public class CommunicatedStoreListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.communication_layout);

        //Listの初期設定
        ListView listView = (ListView)findViewById(R.id.common_listView);
        // Androidフレームワーク標準のレイアウト
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getApplicationContext(),R.layout.list_item);
        adapter.add("test1");
        listView.setAdapter(adapter);
        // ListViewのitemをおした時の処理
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                ListView listView = (ListView) parent;
                // クリックされたアイテムを取得します
                String item = (String) listView.getItemAtPosition(position);
                Toast.makeText(CommunicatedStoreListActivity.this, item, Toast.LENGTH_LONG).show();
            }
        });

        //Listの初期設定
        listView = (ListView)findViewById(R.id.non_common_listView);
        // Androidフレームワーク標準のレイアウト
        adapter = new ArrayAdapter<String>(this.getApplicationContext(),R.layout.list_item);
        adapter.add("test2");
        listView.setAdapter(adapter);
        // ListViewのitemをおした時の処理
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                ListView listView = (ListView) parent;
                // クリックされたアイテムを取得します
                String item = (String) listView.getItemAtPosition(position);
                Toast.makeText(CommunicatedStoreListActivity.this, item, Toast.LENGTH_LONG).show();
            }
        });

    }

}
