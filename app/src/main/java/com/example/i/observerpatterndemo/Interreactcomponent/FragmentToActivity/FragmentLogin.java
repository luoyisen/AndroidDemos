package com.example.i.observerpatterndemo.Interreactcomponent.FragmentToActivity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.i.observerpatterndemo.R;

/**
 * Created by I on 2017/8/24.
 */

public class FragmentLogin extends Fragment {
    EditText userName;
    EditText studentId;
    EditText password;
    RelativeLayout layout_parent;
    int heightDifference;
    LinearLayout sub_container;
    public static final String USER_NAME = "username";
    public static final String STUDENT_ID = "studentid";
    public static final String PASSWORD = "password";
    private MyListener mylistener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragmentopenactivity, container, false);
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
//        password.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//
//            @Override
//            public void onGlobalLayout() {
//                Rect r = new Rect();
//                layout_parent.getWindowVisibleDisplayFrame(r);
//                int screenHeight = layout_parent.getRootView().getHeight();
//                heightDifference = screenHeight - (r.bottom - r.top);
//
//                //boolean visible = heightDiff > screenHeight / 3;
//            }
//        });
//
//        sub_container.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400));
    }

    private void doLogin() {
        if ((userName.getText().toString().trim().equals("11"))
                && (studentId.getText().toString().trim().equals("22"))
                && (password.getText().toString().trim().equals("33"))) {
            mylistener.sendContent("有用户正在登陆！！！");
            Intent intent = new Intent(getActivity(), UserInfoActivity.class);
            intent.putExtra(USER_NAME, userName.getText().toString().trim());
            intent.putExtra(STUDENT_ID, studentId.getText().toString().trim());
            intent.putExtra(PASSWORD, password.getText().toString().trim());
//            startActivityForResult(intent, 110);
            startActivity(intent);
        }
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//    }

    public interface MyListener {
         void sendContent(String info);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /**
         * This makes sure that the container activity has implemented
         * the callback interface. If not, it throws an exception
         */
        //加入判断:
        if (context instanceof MyListener) {//如果该Fragment Attach的Activity实现了MyListener接口
            mylistener = (MyListener) context;
        }
        //或者捕获异常
//        try {
//            mylistener = (MyListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString() + "包含该Fragment的Activity必须实现MyListener接口");
//        }
    }

}
