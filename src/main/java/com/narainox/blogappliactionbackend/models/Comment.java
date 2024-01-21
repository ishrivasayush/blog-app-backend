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
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment_sequence"
    )
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    private Integer commentId;
    private String title;
    @ManyToOne
    @JoinColumn
            (
                    name="user_id"
            )
    private User user;
    @ManyToOne
    @JoinColumn
            (
                    name = "blog_id"
            )
    private Blog blog;
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
