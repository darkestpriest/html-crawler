package com.test.html_crawler.model;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 30/06/18.
 */
public enum HtmlTag {
    DIV("div"),
    A("a");

    private String tag;

    HtmlTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return getTag();
    }
}
