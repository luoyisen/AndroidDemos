package com.example.i.observerpatterndemo.Interreactcomponent.FragmentToActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.i.observerpatterndemo.R;

import static com.example.i.observerpatterndemo.Interreactcomponent.FragmentToActivity.FragmentLogin.PASSWORD;
import static com.example.i.observerpatterndemo.Interreactcomponent.FragmentToActivity.FragmentLogin.STUDENT_ID;
import static com.example.i.observerpatterndemo.Interreactcomponent.FragmentToActivity.FragmentLogin.USER_NAME;

/**
 * Created by I on 2017/8/24.
 */

public class UserInfoActivity extends Activity {
    TextView text_username, text_studentid, text_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        text_username = (TextView) findViewById(R.id.username);
        text_studentid = (TextView) findViewById(R.id.studentid);
        text_password = (TextView) findViewById(R.id.password);
        text_username.setText(getIntent().getStringExtra(USER_NAME));
        text_studentid.setText(getIntent().getStringExtra(STUDENT_ID));
        text_password.setText(getIntent().getStringExtra(PASSWORD));
    }
}
