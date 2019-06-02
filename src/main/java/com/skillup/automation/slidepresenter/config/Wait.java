package com.skillup.automation.slidepresenter.config;

public class Wait {
    public static final int TEN_SECONDS = 10000;
    public static final int FIVE_SECONDS = 5000;
    public static final int TWO_SECONDS = 2000;
    public static final int ONE_SECOND = 1000;

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
