package com.example.demo.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Member {

    @Id
    String id;
    String password;
    String name;
    String gender;
    String year;
    String month;
    String day;
    String birth;
    String mail1;
    String mail2;
    String mail;
    String phone;
    String address;

}
