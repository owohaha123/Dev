package com.jsframe.jpaboard_16day.repository;

import com.jsframe.jpaboard_16day.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
    // 페이지 처리된 목록을 가져오는 메소드
    Page<Board> findByBnumGreaterThan(long bnum, Pageable pageable);
}
