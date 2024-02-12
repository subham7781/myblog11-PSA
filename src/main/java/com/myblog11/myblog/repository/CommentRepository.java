package com.myblog11.myblog.repository;

import com.myblog11.myblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
