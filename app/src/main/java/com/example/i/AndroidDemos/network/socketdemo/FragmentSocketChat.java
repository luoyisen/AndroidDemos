package com.example.i.AndroidDemos.network.socketdemo;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.i.AndroidDemos.main.MainActivity;
import com.example.i.AndroidDemos.R;
import com.example.i.AndroidDemos.base.BaseFragment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by I on 2017/8/26.
 */

public class FragmentSocketChat extends BaseFragment {
    private static final String TAG = "DEBUG-WCL: " + MainActivity.class.getSimpleName();

    private TextView mTvContent; // 显示聊天内容
    private EditText mEtMessage; // 输入发送数据
    private Button mBSend; // 发送数据

    private PrintWriter mPrintWriter; // 向服务端发送消息
    private Socket mClientSocket; // 客户端的Socket

    private static final int MESSAGE_RECEIVE_NEW_MSG = 0;
    private static final int MESSAGE_SOCKET_CONNECTED = 1;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_socketdemo;
    }

    // 处理
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_RECEIVE_NEW_MSG:
                    mTvContent.setText(
                            String.valueOf(mTvContent.getText().toString() + msg.obj));
                    break;
                case MESSAGE_SOCKET_CONNECTED:
                    mBSend.setEnabled(true);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(getActivity(), ServerService.class);
        getActivity().startService(intent);

        new Thread(new Runnable() {
            @Override
            public void run() {
                connectTCPServer();
            }
        }).start();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvContent = (TextView) view.findViewById(R.id.main_tv_content);
        mEtMessage = (EditText) view.findViewById(R.id.main_et_edit_text);
        mBSend = (Button) view.findViewById(R.id.main_b_send);
        mBSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = mEtMessage.getText().toString();
                if (!TextUtils.isEmpty(msg) && mPrintWriter != null) {
                    mPrintWriter.println(msg);
                    mEtMessage.setText("");
                    String time = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(System.currentTimeMillis());
                    String showedMsg = "self " + time + ":" + msg + "\n";
                    mTvContent.setText(String.valueOf(mTvContent.getText() + showedMsg));
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        if (mClientSocket != null) {
            try {
                mClientSocket.shutdownInput();
                mClientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onDestroy();
    }

    private void connectTCPServer() {
        Socket socket = null;
        while (socket == null) {
            try {
                socket = new Socket("localhost", ServerService.PORT);
                mClientSocket = socket;
                mPrintWriter = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())), true);
                mHandler.sendEmptyMessage(MESSAGE_SOCKET_CONNECTED);
                Log.e(TAG, "服务器连接成功");
            } catch (IOException e) {
                SystemClock.sleep(1000);
                Log.e(TAG, "连接TCP服务失败, 重试...");
            }
        }

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            while (!FragmentSocketChat.this.getActivity().isFinishing()) {
                String msg = br.readLine();
                Log.e(TAG, "收到信息: " + msg);
                if (msg != null) {
                    String time = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(System.currentTimeMillis());
                    String showedMsg = "server " + time + ":" + msg + "\n";
                    mHandler.obtainMessage(MESSAGE_RECEIVE_NEW_MSG, showedMsg)
                            .sendToTarget();
                }
            }
            Log.e(TAG, "退出");
            ServerService.close(mPrintWriter);
            ServerService.close(br);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
