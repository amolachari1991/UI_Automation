package com.utility;

import com.github.javafaker.Faker;
import com.pojo.AddressPojo;

import java.util.Locale;

public class FakeTestDataUtility {
    public static AddressPojo addressPojo;
    public static Faker faker = new Faker(Locale.US);
//        addressPojo = new AddressPojo("abc","def","xyz","airport Road","next to indigo park area","Indiana","Indiana","12345",
//        "United States","9999999999","9999999999","EMPTY","Indiana");
    public static AddressPojo addressFakeData() {
        addressPojo = new AddressPojo(faker.name().firstName(),
                faker.name().lastName(),
                faker.company().name(),
                faker.address().buildingNumber(),
                faker.address().fullAddress(),
                faker.address().cityName(),
                faker.address().state(),
                faker.numerify("#####"),
                "United States",
                faker.phoneNumber().cellPhone(),
                faker.phoneNumber().cellPhone(),
                faker.lorem().word(),
                faker.lorem().word());
        return addressPojo;
    }

    public static void fakeTestData() {
        System.out.println(faker.name().firstName());
    }

    public static void main(String[] args) {
        fakeTestData();
    }

}