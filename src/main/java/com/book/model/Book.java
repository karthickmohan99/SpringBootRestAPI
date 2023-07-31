package com.book.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //Specifies that this class is a entity and mapped to a database Tabe
@Table(name = "bookinfo")//name of the table to be used for mapping

public class Book {
     @Id
     @Column(name = "bookid")
     private int bid;
     
     @Column(name ="bookname")
     private String bname;
     
     @Column(name = "bookPrice")
     private float bprice;
}
