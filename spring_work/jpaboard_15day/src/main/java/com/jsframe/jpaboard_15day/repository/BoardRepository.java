package com.jsframe.jpaboard_15day.repository;

import com.jsframe.jpaboard_15day.entity.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
