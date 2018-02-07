package com.example.i.AndroidDemos.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

/**
 * Created by HHX on 2018/2/6.
 */

public class SharedPreferencesUtil {

    private static SharedPreferencesUtil preferencesUtil;
    public Context context;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;

    public static synchronized SharedPreferencesUtil getInstance() {
        return preferencesUtil;
    }

    public static void initSP(Context context, String prefsName, int mode) {
        preferencesUtil = new SharedPreferencesUtil();
        preferencesUtil.context = context;
        preferencesUtil.sharedPreferences = preferencesUtil.context.getSharedPreferences(prefsName, mode);
        preferencesUtil.editor = preferencesUtil.sharedPreferences.edit();
    }

    public <T> T getObject(String key, Class<T> clazz) {
        if (sharedPreferences.contains(key)) {
            String stringStored = sharedPreferences.getString(key, null);
            byte[] buffer = Base64.decode(stringStored, Base64.DEFAULT);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer);
            ObjectInputStream objectInputStream = null;
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                T t = (T) objectInputStream.readObject();
                return t;
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void putObject(String key, Object object) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            String objectVal = new String(Base64.encode(byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
            editor.putString(key, objectVal);
            editor.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }

                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
