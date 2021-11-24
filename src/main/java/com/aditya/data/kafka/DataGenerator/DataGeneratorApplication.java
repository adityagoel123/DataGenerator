package com.aditya.data.kafka.DataGenerator;

import com.aditya.data.kafka.DataGenerator.dtos.PosInvoice;
import com.aditya.data.kafka.DataGenerator.service.dataGenerator.InvoiceGenerator;
import com.aditya.data.kafka.DataGenerator.service.kafka.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataGeneratorApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(DataGeneratorApplication.class, args);
	}

	@Autowired
	private KafkaProducerService producerService;

	@Autowired
	private InvoiceGenerator invoiceGenerator;

	@Value("${application.configs.invoice.count}")
	private int INVOICE_COUNT;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		for (int i = 0; i < INVOICE_COUNT; i++) {
			PosInvoice invoice = invoiceGenerator.getNextInvoice();
			producerService.sendMessage(invoice);
			Thread.sleep(1000);
		}
	}



}
