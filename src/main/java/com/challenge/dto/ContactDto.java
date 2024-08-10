package com.challenge.dto;

import lombok.Data;

@Data
public class ContactDto {
    public String firstName;
    public String lastName;
    public String birthdate;
    public String email;
    public String phone;
    public String street1;
    public String street2;
    public String city;
    public String stateProvince;
    public String postalCode;
    public String country;
}