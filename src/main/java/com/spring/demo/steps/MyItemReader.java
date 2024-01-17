package com.spring.demo.steps;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;

import java.util.Arrays;
import java.util.List;

public class MyItemReader implements ItemReader<String> {

    private final ItemReader<String> delegate;

    public MyItemReader() {
        List<String> items = Arrays.asList("item1", "item2", "item3");
        this.delegate = new ListItemReader<>(items);
    }

    @Override
    public String read() throws Exception {
        return delegate.read();
    }
}
