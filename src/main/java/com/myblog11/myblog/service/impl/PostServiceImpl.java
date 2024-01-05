package com.myblog11.myblog.service.impl;

import com.myblog11.myblog.entity.post;
import com.myblog11.myblog.payload.PostDto;
import com.myblog11.myblog.repository.PostRepository;
import com.myblog11.myblog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
       post p= new post();
       p.setTitle(postDto.getTitle());
       p.setDescription(postDto.getDescription());
       p.setContent(postDto.getContent());
        post save = postRepository.save(p);

        PostDto dto = new PostDto();
        dto.setTitle(save.getTitle());
        dto.setDescription(save.getDescription());
        dto.setContent(save.getContent());
        return dto;
    }



}
