package com.polis.polisgmail;

import android.app.Application;

import com.polis.polisgmail.di.CompositionRoot;

public class App extends Application {

    private CompositionRoot compositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();

        compositionRoot = new CompositionRoot(this);
    }

    public CompositionRoot getCompositionRoot() {
        return compositionRoot;
    }
}
