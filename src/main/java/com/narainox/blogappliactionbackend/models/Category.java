package com.narainox.blogappliactionbackend.models;

import com.narainox.blogappliactionbackend.models.Blog;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String categoryName;

    @Column(name ="description")
    private String categoryDescription;

//    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
//    private List<Blog> blogs=new ArrayList<>();
}
