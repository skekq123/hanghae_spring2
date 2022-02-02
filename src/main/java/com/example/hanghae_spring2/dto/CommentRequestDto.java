package com.example.hanghae_spring2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommentRequestDto {
    private String contents;
    private Long boardId;
}
