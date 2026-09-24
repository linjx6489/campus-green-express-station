package com.campus.express.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Getter @Setter @NoArgsConstructor
public class PackageItem {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(nullable=false) private String trackingNo;
  private String company;
  private String receiverName;
  private String receiverPhone;
  private String shelfCode;
  @Enumerated(EnumType.STRING) private Status status=Status.STORED;
  private LocalDateTime storedAt=LocalDateTime.now();
  private LocalDateTime pickedAt;
  @ManyToOne(optional=false) private User owner;
  public enum Status { STORED, PICKED_UP }
}
