package com.example.i.AndroidDemos.noteandtools.note;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.i.AndroidDemos.R;

/***
 * Created by I on 2017/8/22.
 */

public class ActivityEventDispatch extends AppCompatActivity {
    RadioGroup radioGroup0, radioGroup1, radioGroup2, radioGroup3, radioGroup4;
    MyViewGroup myviewgroup;
    MyButton myButton;
    NormalButton normalbutton;
    NormalLinearLayout normallinearlayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdiapatch);
        myviewgroup = (MyViewGroup) findViewById(R.id.myviewgroup);
        myButton = (MyButton) findViewById(R.id.mybutton);
        normalbutton = (NormalButton) findViewById(R.id.normal_button);
        normallinearlayout = (NormalLinearLayout) findViewById(R.id.normal_container);
        radioGroup0 = (RadioGroup) findViewById(R.id.radiogroup_0);
        radioGroup0.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.viewgroup_dispatch_super) {
                    myviewgroup.setDispatchMode(0);
                } else if (checkedId == R.id.viewgroup_dispatch_false) {
                    myviewgroup.setDispatchMode(1);
                } else {
                    myviewgroup.setDispatchMode(2);
                }
            }
        });
        radioGroup1 = (RadioGroup) findViewById(R.id.radiogroup_1);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.viewgroup_intercept_super) {
                    myviewgroup.setInterceptMode(0);
                } else if (checkedId == R.id.viewgroup_intercept_false) {
                    myviewgroup.setInterceptMode(1);
                } else {
                    myviewgroup.setInterceptMode(2);
                }
            }
        });
        radioGroup2 = (RadioGroup) findViewById(R.id.radiogroup_2);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.viewgroup_touch_super) {
                    myviewgroup.setTouchMode(0);
                } else if (checkedId == R.id.viewgroup_touch_false) {
                    myviewgroup.setTouchMode(1);
                } else {
                    myviewgroup.setTouchMode(2);
                }
            }
        });
        radioGroup3 = (RadioGroup) findViewById(R.id.radiogroup_3);
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.child_dispatch_super) {
                    myButton.setDispatchMode(0);
                } else if (checkedId == R.id.child_dispatch_false) {
                    myButton.setDispatchMode(1);
                } else {
                    myButton.setDispatchMode(2);
                }
            }
        });
        radioGroup4 = (RadioGroup) findViewById(R.id.radiogroup_4);
        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.child_touch_super) {
                    myButton.setTouchMode(0);
                } else if (checkedId == R.id.child_touch_false) {
                    myButton.setTouchMode(1);
                } else {
                    myButton.setTouchMode(2);
                }
            }
        });

    }
}
