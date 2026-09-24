package com.campus.express.controller;

import com.campus.express.model.*; import com.campus.express.repo.*; import com.campus.express.service.AuthService; import lombok.RequiredArgsConstructor; import org.springframework.web.bind.annotation.*; import java.time.LocalDateTime; import java.util.*;
@RestController @RequestMapping("/api/express/packages") @RequiredArgsConstructor
public class PackageController { private final PackageRepository packages; private final UserRepository users; private final AuthService auth;
 private Long uid(String h){return auth.userId(h);}
 @GetMapping public List<PackageItem> mine(@RequestHeader("Authorization") String h){return packages.findByOwnerIdOrderByStoredAtDesc(uid(h));}
 @PostMapping public PackageItem create(@RequestHeader("Authorization") String h,@RequestBody PackageItem item){item.setId(null);item.setOwner(users.findById(uid(h)).orElseThrow());item.setStatus(PackageItem.Status.STORED);item.setStoredAt(LocalDateTime.now());return packages.save(item);}
 @PostMapping("/{id}/pickup") public PackageItem pickup(@RequestHeader("Authorization") String h,@PathVariable Long id){PackageItem p=packages.findById(id).orElseThrow();if(!p.getOwner().getId().equals(uid(h)))throw new IllegalArgumentException("无权操作");p.setStatus(PackageItem.Status.PICKED_UP);p.setPickedAt(LocalDateTime.now());return packages.save(p);}
}
