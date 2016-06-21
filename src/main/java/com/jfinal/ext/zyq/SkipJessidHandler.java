package com.jfinal.ext.zyq;

import com.jfinal.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SkipJessidHandler extends Handler {
    public static void main(String[] args) {
        System.out.println("http://127.0.0.1:8191/;jsessionid=DB4C38A60CD21AFC6CAAC1BDC23FF8EE".replaceAll(";jsessionid=[a-zA-Z0-9#]+", ""));
    }

    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        if (target.contains("jsessionid=")) {
            try {
                if (!response.isCommitted())
                response.sendRedirect(target.replaceAll(";jsessionid=[a-zA-Z0-9#]+", ""));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}