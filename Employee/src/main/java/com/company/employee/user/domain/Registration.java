package com.company.employee.user.domain;

import javax.persistence.*;

@Entity
@Table(name = "registration")
public class Registration {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10, nullable = false)
    private String contactNo;


    @Column(nullable = false, unique = true, length = 50)
    private String email;


    @Column(length = 45, nullable = false, name = "first_name")
    private String firstName;

    @Column(length = 45, nullable = false, name = "last_name")
    private String lastName;

    @Column(length = 15, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String userType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
