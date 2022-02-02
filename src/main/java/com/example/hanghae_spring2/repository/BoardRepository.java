package com.example.hanghae_spring2.repository;

import com.example.hanghae_spring2.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAll();
}
