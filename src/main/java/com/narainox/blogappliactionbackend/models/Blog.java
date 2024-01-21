package com.narainox.blogappliactionbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="blogs")
public class Blog {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "blog_sequence"
    )
    @SequenceGenerator(
            name = "blog_sequence",
            sequenceName = "blog_sequence",
            allocationSize = 1
    )
    private Integer blogId;
    @Column(name = "title",nullable = false)
    private String title;
    private String description;
    private Integer user;
    private boolean publish;
    @Column(
            name = "created_at",
            updatable = false
    )
    private LocalDateTime createdAt;
    @Column
            (
                    name = "updated_at",
                    insertable = false
            )
    private LocalDateTime updatedAt;
}