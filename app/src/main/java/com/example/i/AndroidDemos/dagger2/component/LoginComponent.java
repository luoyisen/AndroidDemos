package com.example.i.AndroidDemos.dagger2.component;

import com.example.i.AndroidDemos.main.DiView;
import com.example.i.AndroidDemos.dagger2.module.PresenterModule;
import com.example.i.AndroidDemos.ui.dialogfragment.DialogFragmentLogin;

import dagger.Component;

/***
 * Created by I on 2017/9/24.
 */

@DiView
@Component(modules = {PresenterModule.class}, dependencies = {AppComponent.class})
public interface LoginComponent {
    void inject(DialogFragmentLogin dialogFragmentLogin);
}