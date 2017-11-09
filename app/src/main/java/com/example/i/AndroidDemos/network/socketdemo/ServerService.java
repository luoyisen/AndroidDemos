package com.example.i.AndroidDemos.network.socketdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/***
 * Created by I on 2017/8/26.
 */

public class ServerService extends Service {
    private static final String TAG = "DEBUG-WCL: " + ServerService.class.getSimpleName();

    private boolean mIsServiceDestroyed = false;
    private String[] mDefinedMessages = new String[]{
            "what is broken can be reforged",
            "Trust Nothing but your Strength!",
            "Time for a true display of skill",
            "I decide what tide to bring",
            "Your will,my hands.",
            "always trust your spirit"
    };

    public static final int PORT = 8644;

    @Override
    public void onCreate() {
        new Thread(new TcpServer()).start();
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        mIsServiceDestroyed = true;
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class TcpServer implements Runnable {
        @Override
        public void run() {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(PORT);
            } catch (IOException e) {
                e.printStackTrace();
                return; // 链接建立失败直接返回
            }

            while (!mIsServiceDestroyed) {
                try {
                    final Socket client = serverSocket.accept();
                    Log.e(TAG, "接收数据");
                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                responseClient(client);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void responseClient(Socket client) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(client.getInputStream()));

        PrintWriter out = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(client.getOutputStream())), true);

        out.println("I decide what tide to bring");
        while (!mIsServiceDestroyed) {
            String str = in.readLine();
            if (str == null) {
                break;
            }

            int i = new Random().nextInt(mDefinedMessages.length);
            String msg = mDefinedMessages[i];
            out.println(msg);
        }
        close(out);
        close(in);
        client.close();
    }

    public static void close(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

