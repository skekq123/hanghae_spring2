package com.example.hanghae_spring2.model;

import com.example.hanghae_spring2.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Board {
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private Long userId;

    // 게시글 등록시
    public Board(BoardRequestDto requestDto, Long userId) {
        // 게시글을 등록한
        this.userId = userId;
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
