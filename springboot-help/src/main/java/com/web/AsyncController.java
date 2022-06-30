package com.web;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/async")
public class AsyncController {

    public void index(HttpServletRequest request, HttpServletResponse response) {
        AsyncContext asyncContext = request.getAsyncContext();

        asyncContext.setTimeout(1000L);

        asyncContext.start(new Runnable() {
            @Override
            public void run() {

            }
        });

        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {

            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {

            }

            @Override
            public void onError(AsyncEvent event) throws IOException {

            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {

            }
        });
    }
}
