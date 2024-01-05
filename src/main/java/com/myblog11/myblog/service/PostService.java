package com.myblog11.myblog.service;

import com.myblog11.myblog.entity.post;
import com.myblog11.myblog.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<post> listpost();

    void Delete(long id);

    post updae(long id,PostDto postDto);

}
