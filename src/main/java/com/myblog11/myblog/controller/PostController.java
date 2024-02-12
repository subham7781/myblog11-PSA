package com.myblog11.myblog.controller;

import com.myblog11.myblog.payload.PostDto;
import com.myblog11.myblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> CreatePost(@RequestBody PostDto postDto){
        PostDto postDto1 = postService.CreatePost(postDto);
        return new ResponseEntity<>(postDto1, HttpStatus.CREATED);
    }
    @GetMapping("particular")
    public ResponseEntity<?> FindById(@RequestParam long id){
        PostDto postDto = postService.FindByID(id);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }
    //http:localhost:8080/api/posts?pageNo=0?pageSize=2
    @GetMapping
    public ResponseEntity<?> FindAll(
            @RequestParam(name = "pageNo",required = false,defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize",required = false,defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy",required = false,defaultValue = "id") String sortBy,
            @RequestParam(name = "sortDir",required = false,defaultValue = "id") String sortDir

    ){
       List<PostDto> posts = postService.FindAll(pageNo,pageSize,sortBy,sortDir);
       return new ResponseEntity<>(posts,HttpStatus.OK);
    }

}
