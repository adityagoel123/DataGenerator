package com.aditya.data.kafka.DataGenerator.service.dataGenerator;

import com.aditya.data.kafka.DataGenerator.dtos.DeliveryAddress;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Random;

@Service
class AddressGenerator {

    private final Random random;
    private final DeliveryAddress[] addresses;

    public AddressGenerator() {
        final String DATAFILE = "src/main/resources/data/address.json";
        final ObjectMapper mapper;
        random = new Random();
        // We would be needing this Jackson's ObjectMapper in order to read the json file.
        mapper = new ObjectMapper();
        try {
            addresses = mapper.readValue(new File(DATAFILE), DeliveryAddress[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // We are generating any random-number from range of : [1 to 100].
    private int getIndex() {
        return random.nextInt(100);
    }

    // Used whenever someone wants to generate the Next-Address randomly.
    // We have 100 addresses in the "address.json" data-file.
    public DeliveryAddress getNextAddress() {
        return addresses[getIndex()];
    }

}
