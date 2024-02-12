package com.myblog11.myblog.service;

import com.myblog11.myblog.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto CreatePost(PostDto postDto);

    PostDto FindByID(long id);

    List<PostDto> FindAll(int pageNo, int pageSize, String sortBy, String sortDir);
}
