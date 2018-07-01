package com.test.html_crawler.model;

import com.test.html_crawler.exception.HTMLCrawlerRuntimeException;
import com.test.html_crawler.exception.InvalidInputException;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 30/06/18.
 */
public class PathContainer {

    private final String originalPath;
    private final String toComparePath;

    public PathContainer(final Optional<String[]> args) throws InvalidInputException {
        checkInputs(args);
        String[] inputs = args.get();
        originalPath = inputs[0];
        toComparePath = inputs[1];
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public String getToComparePath() {
        return toComparePath;
    }

    private void checkInputs(Optional<String[]> args) throws InvalidInputException {
        String[] inputs = args.orElseThrow(
                () -> new InvalidInputException("Inputs cannot be null"));
        if(inputs.length < 2) {
            throw new InvalidInputException("Input array must contains, at least, two elements");
        }
        Arrays.stream(inputs)
                .forEach(argument -> {
                    try {
                        checkInput(argument);
                    } catch (InvalidInputException e) {
                        throw new HTMLCrawlerRuntimeException(e);
                    }
                });
    }

    private void checkInput(String input) throws InvalidInputException {
        Optional
                .ofNullable(input)
                .orElseThrow(
                        ()-> new InvalidInputException("You must provide not null inputs"));
    }
}
