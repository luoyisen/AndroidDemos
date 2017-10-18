package com.example.i.AndroidDemos.main.dagger2;

import com.example.i.AndroidDemos.main.DiView;
import com.example.i.AndroidDemos.main.login.ui.LoginFragment;

import dagger.Component;

/***
 * Created by I on 2017/9/24.
 */

@DiView
@Component(modules = {PresenterModule.class}, dependencies = {AppComponent.class})
public interface LoginComponent {
    void inject(LoginFragment loginFragment);
}