package com.campus.express.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name="sys_user") @Getter @Setter @NoArgsConstructor
public class User {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(nullable=false, unique=true) private String username;
  @Column(nullable=false) private String password;
  private String nickname;
  private String phone;
  @Enumerated(EnumType.STRING) private Role role=Role.STUDENT;
  private LocalDateTime createdAt=LocalDateTime.now();
  public User(String username,String password,String nickname){this.username=username;this.password=password;this.nickname=nickname;}
  public enum Role { STUDENT, COURIER, ADMIN }
}
