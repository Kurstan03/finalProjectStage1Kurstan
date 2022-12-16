package model;

import enums.Gender;
import exceptions.BadRequestException;
import exceptions.UniqueConstraintException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class User {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private Gender gender;
    private BigDecimal money;
    private List<Book> books = new ArrayList<>();

    public User(Long id, String name, String surname, String email, String phoneNumber, Gender gender, BigDecimal money, List<Book> books) {
        try {
            this.id = id;
            this.name = name;
            this.surname = surname;
            if (email.contains("@")) {
                this.email = email;
            } else {
                throw new BadRequestException();
            }
            if (phoneNumber.startsWith("+996") && phoneNumber.length() == 13) {
                this.phoneNumber = phoneNumber;
            } else {
                throw new BadRequestException();
            }
            this.gender = gender;
            this.money = money;
            this.books = books;
        } catch (BadRequestException e){
            System.err.println("BadRequestException");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", money=" + money +
                ", books=" + books +
                '}';
    }
}
