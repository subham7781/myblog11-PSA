package com.myblog11.myblog.repository;

import com.myblog11.myblog.entity.post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<post,Long> {

}
