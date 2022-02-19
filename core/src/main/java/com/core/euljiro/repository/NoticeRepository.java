package com.core.euljiro.repository;

import com.core.euljiro.domain.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer>, JpaSpecificationExecutor<Notice> {

    Page<Notice> findByTitleContains(String title, Pageable pageable);

    List<Notice> findAll();

    @Query(value = "select * from notice where title = :title ", nativeQuery = true)
    List<Notice> findByQuery(String title);
}
