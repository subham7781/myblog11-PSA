package com.myblog11.myblog.service.impl;

import com.myblog11.myblog.entity.Comment;
import com.myblog11.myblog.entity.Post;
import com.myblog11.myblog.exception.ResourceNotFoundException;
import com.myblog11.myblog.payload.CommentDto;
import com.myblog11.myblog.repository.CommentRepository;
import com.myblog11.myblog.repository.PostRepository;
import com.myblog11.myblog.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDto CreatePost(CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("post not found with id " + postId)
        );
        Comment comment = mapToEntity(commentDto);
        comment.setPost(post);
        Comment save = commentRepository.save(comment);
        CommentDto dto = mapToDto(save);

        return dto;
    }

    @Override
    public void deleteByid(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto, long id, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("id is not found " + postId)
        );
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("id is not found" + id)
        );
        Comment c = mapToEntity(commentDto);
        c.setId(comment.getId());
        c.setPost(post);
        Comment save = commentRepository.save(c);
        CommentDto dto = mapToDto(save);
        return dto;


    }

    @Override
    public List<?> findAll() {
        List<Comment> all = commentRepository.findAll();
        return all;
    }

    CommentDto mapToDto(Comment comment){
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
        return dto;
    }
    Comment mapToEntity(CommentDto commentDto){
        Comment entity = modelMapper.map(commentDto, Comment.class);
        return entity;
    }
}
