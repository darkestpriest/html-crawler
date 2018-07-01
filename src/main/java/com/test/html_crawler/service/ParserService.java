package com.test.html_crawler.service;

import com.test.html_crawler.exception.PathParsingException;
import com.test.html_crawler.model.HtmlTag;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 30/06/18.
 */
public class ParserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParserService.class);

    public Document parsePath(final String path) throws PathParsingException {
        LOGGER.info(String.format("Parsing %s", path));
        try {
            return Jsoup.connect(path).get();
        } catch (IOException e) {
            LOGGER.warn("Error parsing path", e);
            throw new PathParsingException(String.format("Cannot parse %s", path), e);
        }
    }

    public Elements getPathElements(final String path, final HtmlTag[] tags) throws PathParsingException {
        StringBuilder tagsString = new StringBuilder();
        Arrays.stream(tags).forEach(tag->tagsString.append(tag).append(" "));
        String tagCriteria = tagsString.toString().trim();
        LOGGER.info(String.format("Getting %s tag from %s", tagCriteria, path));
        return parsePath(path).select(tagCriteria);
    }
}
