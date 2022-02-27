package de.bail.classicmodels.model.graphql;

import java.io.Serializable;

public class Employee implements Contact, Serializable {

  private Integer id;

  private String lastName;

  private String firstName;

  private String extension;

  private String email;

  private Office office;

  private Employee reportsTo;

  private String jobTitle;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Office getOffice() {
    return office;
  }

  public void setOffice(Office office) {
    this.office = office;
  }

  public Employee getReportsTo() {
    return reportsTo;
  }

  public void setReportsTo(Employee reportsTo) {
    this.reportsTo = reportsTo;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }
}
