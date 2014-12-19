package com.example.anaba.app;

import com.squareup.otto.Bus;

/**
 * Created by gucci on 2014/12/19.
 */
public class BusHolder {

    private static Bus sBus = new Bus();

    public static Bus get() {
        return sBus;
    }
}
