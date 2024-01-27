package com.narainox.blogappliactionbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_Sequence"
    )
    @SequenceGenerator(
            name = "category_Sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    private int id;
    @Column(name="title",length = 100,nullable = false)
    private String categoryTitle;

    @Column(name="description")
    private String categoryDescription;

    @Column(
            name = "created_at",
            updatable = false
    )
    private LocalDateTime createdAt;
    @Column(
            name = "updated_at",
            updatable = false
    )
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Blog> blogs=new ArrayList<>();


}
