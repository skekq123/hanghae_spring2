package com.example.hanghae_spring2.controller;

import com.example.hanghae_spring2.dto.CommentRequestDto;
import com.example.hanghae_spring2.model.Comment;
import com.example.hanghae_spring2.security.UserDetailsImpl;
import com.example.hanghae_spring2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 댓글 등록
    @PostMapping("/api/comments")
    public Comment createBoard(@RequestBody CommentRequestDto requestDto,
                             @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 로그인 되어 있는 회원 테이블의 ID
        Long userId = userDetails.getUser().getId();
        String username = userDetails.getUser().getUsername();
        Comment comment = commentService.createComment(requestDto, userId, username);

        // 응답 보내기
        return comment;
    }

    //댓글 가져오기
    @GetMapping("/api/comments/{id}")
    public List<Comment> getComment(@PathVariable Long id) {
        return commentService.getComment(id);
    }

    //댓글 삭제
    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return id;
    }

    //댓글 수정
    @PostMapping("/api/comments/edit/{id}")
    public int updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(requestDto, id);
    }
}
