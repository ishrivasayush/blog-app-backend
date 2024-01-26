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
    private String content;
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
    private Blog blog;

}
