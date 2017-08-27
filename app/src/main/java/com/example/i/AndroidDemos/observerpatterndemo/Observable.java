package com.example.i.AndroidDemos.observerpatterndemo;

import java.util.ArrayList;


/**
 * Created by I on 2017/8/21.
 */

public class Observable {
    private boolean changed = false;
    private final ArrayList<Observer> observers;

    public Observable() {
        observers = new ArrayList<>();
    }


    public synchronized void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }


    public synchronized void deleteObserver(Observer o) {
        observers.remove(o);
    }


    public void notifyObservers() {
        notifyObservers(null);
    }

    public void notifyObservers(Object arg) {

        Observer[] arrLocal;

        synchronized (this) {
            if (!hasChanged())
                return;

            arrLocal = observers.toArray(new Observer[observers.size()]);
            clearChanged();
        }

        for (int i = arrLocal.length - 1; i >= 0; i--)
            arrLocal[i].update(this, arg);//通知observer就是调用接口observer中的具体方法
    }

    public synchronized void deleteObservers() {
        observers.clear();
    }

    protected synchronized void setChanged() {
        changed = true;
    }

    protected synchronized void clearChanged() {
        changed = false;
    }


    public synchronized boolean hasChanged() {
        return changed;
    }

    public synchronized int countObservers() {
        return observers.size();
    }
}

