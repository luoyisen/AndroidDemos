package com.example.i.AndroidDemos.main.dagger2;

/***
 * Created by I on 2017/9/24.
 */

public class ComponentHolder {
    private static LoginComponent loginComponent;

    public static LoginComponent getLoginComponent() {
        return loginComponent;
    }

    public static void setLoginComponent(LoginComponent loginComponent) {
        ComponentHolder.loginComponent = loginComponent;
    }
}
