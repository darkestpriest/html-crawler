package com.test.html_crawler;

import com.test.html_crawler.exception.CannotFindValueException;
import com.test.html_crawler.exception.InvalidInputException;
import com.test.html_crawler.exception.PathParsingException;
import com.test.html_crawler.model.PathContainer;
import com.test.html_crawler.service.ProcessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 30/06/18.
 */
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.info("Init application...");
        try {
            PathContainer pathContainer = new PathContainer(Optional.ofNullable(args));
            List<String> diff = new ProcessorService()
                    .compare(pathContainer);
            diff.forEach(System.out::println);
        } catch (InvalidInputException e) {
            LOGGER.warn("Error initiating the app", e);
            System.exit(0);
        } catch (PathParsingException e) {
            LOGGER.warn("Cannot process paths", e);
            System.exit(0);
        } catch (CannotFindValueException e) {
            LOGGER.warn("Original path does not contain key value", e);
            System.exit(0);
        }
    }
}
