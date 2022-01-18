package com.miiti.shoppingcart.parser;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
public abstract class AbstractDataParser<T> {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    protected List<String> lines;

    public AbstractDataParser(List<String> lines) {
        Assert.notEmpty(lines, "File should contain valid data and must be not-null");
        this.lines = lines;
    }

    public List<T> parseData() {
        logger.info("Parsing "+lines.size() +" lines");
        return parse();
    }

    protected abstract List<T> parse();
}
