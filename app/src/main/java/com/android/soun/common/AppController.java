package com.android.soun.common;

import android.app.Application;

public class AppController extends Application {
    private Boolean language;

    public Boolean getLanguage() {
        return language;
    }

    public void setLanguage(Boolean language) {
        this.language = language;
    }
}
