package com.example.boilerplateproj.domain.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.boilerplateproj.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findBoardByContent(String content);
    // id > ? ORDER BY id DESC limit ?, ?
    //List<Board> findByBoardNoGreaterThanOrderByBoardNoDesc(Long boardNo, Pageable paging);
    // id > ? limit ?, ?
    //Page<Board> findByIdGreaterThan(Long id, Pageable paging);

    //@Query(value = "select * from board b where b.username like %?1%", nativeQuery = true)
    //List<Board> findBoardByUsername(String username);

    @Query("select b from Board b")
    List<Board> findWithPagination(Pageable pageable);
}