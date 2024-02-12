package com.myblog11.myblog.service;

import com.myblog11.myblog.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto CreatePost(CommentDto commentDto, long postId);

    void deleteByid(long id);

    CommentDto updateComment(CommentDto commentDto, long id, long postId);

    List<?> findAll();
}
