package com.campus.express.controller;
import com.campus.express.model.Notice; import com.campus.express.repo.NoticeRepository; import lombok.RequiredArgsConstructor; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/notices") @RequiredArgsConstructor public class NoticeController {private final NoticeRepository repo; @GetMapping public List<Notice> all(){return repo.findAll();}}
