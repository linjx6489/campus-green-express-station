package com.campus.express.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Getter @Setter @NoArgsConstructor
public class Notice {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String title;
 @Column(length=2000) private String content;
 private LocalDateTime createdAt=LocalDateTime.now();
 public Notice(String title,String content){this.title=title;this.content=content;}
}
