package com.test.html_crawler.exception;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 30/06/18.
 */
public class HTMLCrawlerRuntimeException extends RuntimeException {

    public HTMLCrawlerRuntimeException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public HTMLCrawlerRuntimeException(Throwable throwable) {
        super(throwable);
    }
}
