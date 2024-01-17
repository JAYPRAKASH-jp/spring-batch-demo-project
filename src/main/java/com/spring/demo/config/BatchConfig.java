package com.spring.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.demo.steps.MyItemProcessor;
import com.spring.demo.steps.MyItemReader;
import com.spring.demo.steps.MyItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Bean
	public ItemReader<String> reader() {
		return new MyItemReader();
	}

	@Bean
	public ItemProcessor<String, String> processor() {
		return new MyItemProcessor();
	}

	@Bean
	public ItemWriter<String> writer() {
		return new MyItemWriter();
	}

	@Bean
	public Step myStep(StepBuilderFactory stepBuilderFactory, ItemReader<String> reader,
			ItemProcessor<String, String> processor, ItemWriter<String> writer) {
		return stepBuilderFactory.get("myStep").<String, String>chunk(10).reader(reader).processor(processor)
				.writer(writer).build();
	}

	@Bean
	public Job myJob(JobBuilderFactory jobBuilderFactory, Step myStep) {
		return jobBuilderFactory.get("myJob").incrementer(new RunIdIncrementer()).start(myStep).build();
	}
	
}
