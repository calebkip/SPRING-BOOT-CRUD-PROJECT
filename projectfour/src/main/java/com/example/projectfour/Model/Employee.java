package com.example.projectfour.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name="employees")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
 @Column (name  ="firstname",nullable = false)
      private  String firstname;
 @Column(name="lastname")
      private  String lastname;
 @Column(name="email")
      private String email;
 @Column(name="department")
      private  String department;
}

