package com.example.i.AndroidDemos.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.i.AndroidDemos.base.listener.MyListener;
import com.example.i.AndroidDemos.ui.activity.UserInfoActivity;
import com.example.i.AndroidDemos.R;

/**
 * Created by I on 2017/8/24.
 */

public class FragmentLogin extends Fragment {
    EditText userName;
    EditText studentId;
    EditText password;
    RelativeLayout layout_parent;
    LinearLayout sub_container;
    public static final String USER_NAME = "username";
    public static final String STUDENT_ID = "studentid";
    public static final String PASSWORD = "password";
    public MyListener mylistener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userName = (EditText) view.findViewById(R.id.text_username);
        studentId = (EditText) view.findViewById(R.id.text_student_id);
        password = (EditText) view.findViewById(R.id.text_passwd);
        layout_parent = (RelativeLayout) view.findViewById(R.id.layout_parent);
        sub_container = (LinearLayout) view.findViewById(R.id.sub_container);
        view.findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
    }

    private void doLogin() {
        if ((userName.getText().toString().trim().equals("11"))
                && (studentId.getText().toString().trim().equals("22"))
                && (password.getText().toString().trim().equals("33"))) {

            Intent intent = new Intent(getActivity(), UserInfoActivity.class);
            intent.putExtra(USER_NAME, userName.getText().toString().trim());
            intent.putExtra(STUDENT_ID, studentId.getText().toString().trim());
            intent.putExtra(PASSWORD, password.getText().toString().trim());
            startActivityForResult(intent, 110);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onAttach(Context context) {//onAttach方法有两个重载，一个传递的参数是Activity，一个是Context，传递参数为context的在一些Android版本上面由bug，(如果是使用的Fragment包，而不是v4.support.fragment包就会有);
        super.onAttach(context);
        //This makes sure that the container activity has implemented the callback interface. If not, it throws an exception

        //加入判断:
        if (context instanceof MyListener) {//如果该Fragment Attach的Activity实现了MyListener接口
            mylistener = (MyListener) context;//实例化该接口
        }
        //或者捕获异常
//        try {
//            mylistener = (MyListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString() + "包含该Fragment的Activity必须实现MyListener接口");
//        }
    }

    /**
     *
     * 如果使用的是 android.app.Fragment;而不是android.support.v4.app.Fragment;
     * 则需要传递参数为Activity
     * @Override
     * public void onAttach(Activity activity) {
     *    super.onAttach(activity);
     *    if (activity instanceof MyListener) {
     *       mylistener = (MyListener) activity;
     *    }
     * }
     */
}
