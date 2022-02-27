package de.bail.classicmodels.model.graphql;

import java.io.Serializable;


public class Customer implements Contact,  Serializable {

  private Integer id;

  private String customerName;

  private String lastName;

  private String firstName;

  private String phone;

  private String addressLine1;

  private String addressLine2;

  private String city;

  private String state;

  private String postalCode;

  private String country;

  private Employee salesRepEmployee;

  private Double creditLimit;

  public Integer getId() {
    return id;
  }

  public void setId(Integer customerNumber) {
    this.id = customerNumber;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String contactLastName) {
    this.lastName = contactLastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String contactFirstName) {
    this.firstName = contactFirstName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Employee getSalesRepEmployee() {
    return salesRepEmployee;
  }

  public void setSalesRepEmployee(Employee salesRepEmployeeNumber) {
    this.salesRepEmployee = salesRepEmployeeNumber;
  }

  public Double getCreditLimit() {
    return creditLimit;
  }

  public void setCreditLimit(Double creditLimit) {
    this.creditLimit = creditLimit;
  }

}
