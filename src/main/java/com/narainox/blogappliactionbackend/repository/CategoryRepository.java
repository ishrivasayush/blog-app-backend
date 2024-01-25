package com.narainox.blogappliactionbackend.repository;

import com.narainox.blogappliactionbackend.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
