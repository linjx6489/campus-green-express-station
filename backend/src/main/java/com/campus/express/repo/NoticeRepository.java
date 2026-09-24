package com.campus.express.repo;
import com.campus.express.model.Notice; import org.springframework.data.jpa.repository.JpaRepository;
public interface NoticeRepository extends JpaRepository<Notice,Long>{}
