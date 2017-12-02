package com.au.arvin.spaceshuttle.repository;

import com.au.arvin.spaceshuttle.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

