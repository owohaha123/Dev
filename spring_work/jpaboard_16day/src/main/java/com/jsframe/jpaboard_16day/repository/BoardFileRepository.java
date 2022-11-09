package com.jsframe.jpaboard_16day.repository;

import com.jsframe.jpaboard_16day.entity.Board;
import com.jsframe.jpaboard_16day.entity.BoardFile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardFileRepository extends CrudRepository<BoardFile, Long> {
    // 게시글(board)에 해당하는 파일목록 가져오는 메소드
    List<BoardFile> findByBfbid(Board board);
    // 게시글에 해당하는 파일목록 삭제
    void deleteByBfbid(Board board);

}
