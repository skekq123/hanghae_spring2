package com.example.hanghae_spring2.repository;

import com.example.hanghae_spring2.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBoardIdOrderByModifiedAtDesc(Long boardId);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Comment a SET a.contents =?2 WHERE a.id=?1")
    int updateComment(Long id, String contents);
}
