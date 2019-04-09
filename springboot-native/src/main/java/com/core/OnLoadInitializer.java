package com.core;

public class OnLoadInitializer implements BaseInitializer {
    @Override
    public void onStartUp() {
        System.out.println(this.getClass().getName());
    }
}
