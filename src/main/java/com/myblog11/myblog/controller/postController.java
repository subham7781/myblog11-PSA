package com.myblog11.myblog.controller;

import com.myblog11.myblog.entity.post;
import com.myblog11.myblog.payload.PostDto;
import com.myblog11.myblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class postController {

private PostService postService;

    public postController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto post = postService.createPost(postDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<post>> listpost(){
       List<post> list= postService.listpost();
       return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> Delete(@PathVariable long id){
        postService.Delete(id);
        return new ResponseEntity<>("Record is deleted",HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestParam long id,@RequestBody PostDto postDto){
        post updae = postService.updae(id, postDto);
        return new ResponseEntity<>(updae,HttpStatus.OK);
    }
}
