package com.example.springbatch.xmlconfig;

import org.springframework.batch.item.*;

public class MyItemReader implements ItemStreamReader<String> {

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {

    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {

    }

    @Override
    public void close() throws ItemStreamException {

    }

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return "data";
    }
}
