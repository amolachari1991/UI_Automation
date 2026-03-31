package com.pojo;

import org.omg.CORBA.WStringSeqHelper;

public class AddressPojo {
    private String firstname;
    private String lastname;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postcode;
    private String country;
    private String phone;
    private String mobile;
    private String other;
    private String alias;

    public AddressPojo(String firstname, String lastname, String company, String address1, String address2, String city, String state, String postcode, String country, String phone, String mobile, String other, String alias) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
        this.phone = phone;
        this.mobile = mobile;
        this.other = other;
        this.alias = alias;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getOther() {
        return other;
    }

    public String getAlias() {
        return alias;
    }




    @Override
    public String toString() {
        return "AddressPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", company='" + company + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", other='" + other + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }

}
