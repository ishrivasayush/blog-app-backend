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
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_Sequence"
    )
    @SequenceGenerator(
            name = "user_Sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    private Integer userId;
    @Column(name="full_name")
    private String fullName;
    @Column(name = "user_name",nullable = false)
    private String userName;
    private Byte role;
    @Column(name = "password",nullable = false, length = 10)
    private String password;
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

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Blog> blogs=new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
}
