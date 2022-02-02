package com.example.hanghae_spring2.service;

import com.example.hanghae_spring2.dto.BoardRequestDto;
import com.example.hanghae_spring2.model.Board;
import com.example.hanghae_spring2.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board createBoard(BoardRequestDto requestDto, Long userId ) {
        Board board = new Board(requestDto, userId);
        boardRepository.save(board);
        return board;
    }

    public List<Board> getBoard() {
        return boardRepository.findAll();
    }
}
