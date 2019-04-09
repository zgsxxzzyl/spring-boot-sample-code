package com.util;

import java.util.ArrayList;
import java.util.List;

public class ClassScaner {
    private static final String packages = "com.core";

    public static <T> List<T> scan(String packages, Class<T> t) {
        List<T> list = new ArrayList();

        return list;
    }


    public static void main(String[] args) {
        List<String> scan = ClassScaner.scan(packages, String.class);
    }
}
