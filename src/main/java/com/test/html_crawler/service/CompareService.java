package com.test.html_crawler.service;

import com.test.html_crawler.exception.CannotFindValueException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 30/06/18.
 */
public class CompareService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompareService.class);

    private final String needle;

    public CompareService(final String needle) {
        this.needle = needle;
    }

    public List<String> getDocumentDiff(final Elements original, final Elements toCompare)
            throws CannotFindValueException {
        List<String> result = new ArrayList<>();
        List<Element> filteredOriginalElements = filterElements(original);
        List<Element> filteredToCompareElements = new ArrayList<>(toCompare);
        if(filteredOriginalElements.isEmpty()) {
            throw new CannotFindValueException(String.format("Original document does not contain %s", needle));
        }
        if(!areListsEquals(filteredOriginalElements, filteredToCompareElements)) {
            result = getDocumentDiff(filteredOriginalElements, filteredToCompareElements);
        }
        return result;
    }

    private boolean areListsEquals(List<Element> original, List<Element> toCompare) {
        Set<Element> expectedElements = new HashSet<>(original);
        return toCompare.stream().map(Element::toString)
                .collect(Collectors.toList()).containsAll(expectedElements);
    }

    private List<String> getDocumentDiff(final List<Element> original, final List<Element> toCompare) {
        List<String> originalStringList = original
                .stream()
                .map(Element::text)
                .collect(Collectors.toList());
        return toCompare
                .stream()
                .filter(element->originalStringList.contains(element.text()))
                .map(element -> element.parentNode().toString())
                .collect(Collectors.toList());
    }

    private List<Element> filterElements(final Elements elements) {
        return elements
                .stream()
                .filter(element->element.id().toLowerCase().contains(needle.toLowerCase()))
                .collect(Collectors.toList());
    }
}
