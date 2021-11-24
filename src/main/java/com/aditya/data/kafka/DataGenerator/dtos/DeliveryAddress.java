package com.aditya.data.kafka.DataGenerator.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryAddress {

    // This property maps the properties from the fields in address.json file to this class.
    @JsonProperty("AddressLine")
    private String addressLine;

    @JsonProperty("City")
    private String city;

    @JsonProperty("State")
    private String state;

    @JsonProperty("PinCode")
    private String pinCode;

    @JsonProperty("ContactNumber")
    private String contactNumber;


}
