package com.myblog11.myblog.controller;

import com.myblog11.myblog.payload.CommentDto;
import com.myblog11.myblog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDto> CreatePost(@RequestBody CommentDto commentDto, @RequestParam long postId){
        CommentDto dto=  commentService.CreatePost(commentDto,postId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>DeleteById(@PathVariable long id){
        commentService.deleteByid(id);
        return new ResponseEntity<>("Comment is Deleted!!",HttpStatus.OK);
    }
    @PutMapping("/{id}/post/{postId}")
    public ResponseEntity<?> UpdateComment(@RequestBody CommentDto commentDto,@PathVariable long id,@PathVariable long postId){
        CommentDto dto = commentService.updateComment(commentDto, id, postId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> FindAll(){
       List<?> all =commentService.findAll();
       return new ResponseEntity<>(all,HttpStatus.OK);
    }
}
