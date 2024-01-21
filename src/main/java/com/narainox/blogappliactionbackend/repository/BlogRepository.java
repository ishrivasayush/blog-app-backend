package com.narainox.blogappliactionbackend.repository;

import com.narainox.blogappliactionbackend.models.Blog;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findByUser(Integer userId, Pageable pageable);
}
