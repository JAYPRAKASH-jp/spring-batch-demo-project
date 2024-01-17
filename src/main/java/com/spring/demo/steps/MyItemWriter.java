package com.spring.demo.steps;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class MyItemWriter implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> items) throws Exception {
        for (String item : items) {
            System.out.println("Writing item: " + item);
        }
    }
}
