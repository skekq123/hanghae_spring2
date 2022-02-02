package com.example.hanghae_spring2.repository;

import com.example.hanghae_spring2.model.Board;
import com.example.hanghae_spring2.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBoardId(Long boardId);
}
