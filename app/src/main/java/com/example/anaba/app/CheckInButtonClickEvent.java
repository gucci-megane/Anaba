package com.example.anaba.app;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by gucci on 2014/12/19.
 */
public class CheckInButtonClickEvent {

    public String message;

    public CheckInButtonClickEvent(String message, ListView listView, ArrayAdapter<String> adapter) {
        super();
        Log.e("status", "CheckInButtonClick");

        this.message = message;
        adapter.add(message);
        listView.setAdapter(adapter);
    }
}
