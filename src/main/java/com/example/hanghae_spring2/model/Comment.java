package com.example.hanghae_spring2.model;

import com.example.hanghae_spring2.dto.BoardRequestDto;
import com.example.hanghae_spring2.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Comment extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long boardId;

    // 댓글 등록시
    public Comment(CommentRequestDto requestDto, Long userId, String username) {
        this.userId = userId;
        this.username = username;
        this.contents = requestDto.getContents();
        this.boardId = requestDto.getBoardId();
    }
}
