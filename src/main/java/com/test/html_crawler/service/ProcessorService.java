package com.test.html_crawler.service;

import com.test.html_crawler.exception.CannotFindValueException;
import com.test.html_crawler.exception.PathParsingException;
import com.test.html_crawler.model.HtmlTag;
import com.test.html_crawler.model.PathContainer;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 30/06/18.
 */
public class ProcessorService {

    public List<String> compare(PathContainer pathContainer) throws PathParsingException, CannotFindValueException {
        Elements originalElements = new ParserService()
                .getPathElements(pathContainer.getOriginalPath(), HtmlTag.values());
        Elements toCompareElements = new ParserService()
                .getPathElements(pathContainer.getToComparePath(), HtmlTag.values());
        return new CompareService("make-everything-ok-button")
                .getDocumentDiff(originalElements, toCompareElements);
    }
}
