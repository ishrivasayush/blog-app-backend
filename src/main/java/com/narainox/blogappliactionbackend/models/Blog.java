package com.narainox.blogappliactionbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "blog_title", length = 100, nullable = false)
    private String title;

    @Column(length = 1000000000)
    private String content;

    private String imageName;
    private Boolean publish;

    @Column(
            name = "created_at",
            insertable = false
    )
    private LocalDateTime createdAt;
    @Column(
            name = "updated_at",
            updatable = false
    )
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    private User user;
    @ManyToOne
    @JoinColumn(
            name = "category_id"
    )
    private Category category;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private Set<Comment> comments=new HashSet<>();
}
