package com.example.i.AndroidDemos;

import android.app.Application;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

/**
 * Created by I on 2017/8/24.
 */

public class MyApplication extends Application {
    private Socket mSocket;

    /**
     * 注意导入的包
     */ {
        try {
            mSocket = IO.socket("https://socketio-chat.now.sh/");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return mSocket;
    }
}
