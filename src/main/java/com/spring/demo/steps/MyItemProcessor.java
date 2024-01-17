package com.spring.demo.steps;

import org.springframework.batch.item.ItemProcessor;

public class MyItemProcessor implements ItemProcessor<String, String> {

    @Override
    public String process(String item) throws Exception {
        return item.toUpperCase();
    }
}
