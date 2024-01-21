package com.narainox.blogappliactionbackend.repository;

import com.narainox.blogappliactionbackend.models.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment> findByBlog(Integer blogId, Pageable pageable);
}
