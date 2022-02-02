package com.example.hanghae_spring2.controller;

import com.example.hanghae_spring2.dto.BoardRequestDto;
import com.example.hanghae_spring2.model.Board;
import com.example.hanghae_spring2.security.UserDetailsImpl;
import com.example.hanghae_spring2.service.BoardService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 신규 상품 등록
    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto,
                                 @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 로그인 되어 있는 회원 테이블의 ID
        Long userId = userDetails.getUser().getId();

        Board board = boardService.createBoard(requestDto, userId);

        // 응답 보내기
        return board;
    }
    //게시글 보여주기
    @GetMapping("/api/boards")
    public List<Board> getBoards() {
        return boardService.getBoard();
    }
}
