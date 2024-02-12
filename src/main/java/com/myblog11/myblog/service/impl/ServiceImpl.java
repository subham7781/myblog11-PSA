package com.myblog11.myblog.service.impl;

import com.myblog11.myblog.entity.Post;
import com.myblog11.myblog.exception.ResourceNotFoundException;
import com.myblog11.myblog.payload.PostDto;
import com.myblog11.myblog.repository.PostRepository;
import com.myblog11.myblog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImpl implements PostService {

    private PostRepository postRepository;
    private ModelMapper modelMapper;

    public ServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto CreatePost(PostDto postDto) {
//        post p = new post();
//        p.setTitle(postDto.getTitle());
//        p.setContent(postDto.getContent());
//        p.setDescription(postDto.getDescription());
        Post p = mapToEntity(postDto);

        Post save = postRepository.save(p);

//        PostDto dto = new PostDto();
//        dto.setTitle(save.getTitle());
//        dto.setContent(save.getContent());
//        dto.setDescription(save.getDescription());1
        return mapToDto(save);
    }

    @Override
    public PostDto FindByID(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Data is not present")
        );
        return mapToDto(post);
    }

    @Override
    public List<PostDto> FindAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
      Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        Page<Post> PagePost = postRepository.findAll(pageable);
        List<Post> all = PagePost.getContent();
        List<PostDto> dto = all.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return dto;
    }

    PostDto mapToDto(Post post){
        PostDto dto = modelMapper.map(post, PostDto.class);
        return dto;
    }
    Post mapToEntity(PostDto postDto){
        Post Entity = modelMapper.map(postDto, Post.class);
        return Entity;
    }
}
