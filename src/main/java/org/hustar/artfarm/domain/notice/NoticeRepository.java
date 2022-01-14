package org.hustar.artfarm.domain.notice;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long>{
	
	Page<Notice> findAllByOrderByNoticeIdxDesc(Pageable pageable);
	
//	@Modifying
//    @Query("update Notice n set n.views = n.views + 1 where n.notice_idx = :noticeIdx")
//    Long updateViews(@Param("noticeIdx") Long noticeIdx);
}
