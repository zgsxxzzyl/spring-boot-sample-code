package com.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;

public class ExceptionUtil {

    public static String printStack(Throwable throwable) {
        String[] stackFrames = ExceptionUtils.getStackFrames(throwable);
        System.out.println(stackFrames[0]);
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        return stackTrace[0].toString();
    }
}
