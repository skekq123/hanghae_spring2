package com.example.hanghae_spring2.service;

import com.example.hanghae_spring2.dto.CommentRequestDto;
import com.example.hanghae_spring2.model.Comment;
import com.example.hanghae_spring2.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment createComment(CommentRequestDto requestDto, Long userId, String username) {
        Comment comment = new Comment(requestDto, userId, username);
        commentRepository.save(comment);
        return comment;
    }

    public List<Comment> getComment(Long boardId) {
        return commentRepository.findAllByBoardId(boardId);
    }
}