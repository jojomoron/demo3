package com.example.demo.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Book {
	@Id
//	@GeneratedValue
	@GeneratedValue(strategy = GenerationType.IDENTITY)//重要!!不然測試資料ID會一直重複
    private Integer bookid;
    private String name;
    private String author;
    
	@Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', author='%s']",
                bookid, name, author);
    }
}
