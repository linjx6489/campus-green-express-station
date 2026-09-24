package com.campus.express.controller;

import com.campus.express.model.User; import com.campus.express.repo.UserRepository; import com.campus.express.service.AuthService; import jakarta.validation.constraints.NotBlank; import lombok.RequiredArgsConstructor; import org.springframework.web.bind.annotation.*; import java.util.Map;
@RestController @RequestMapping("/api/auth") @RequiredArgsConstructor
public class AuthController { private final UserRepository users; private final AuthService auth;
 @PostMapping("/login") public Map<String,Object> login(@RequestBody LoginRequest r){String token=auth.login(r.username(),r.password()); User u=users.findByUsername(r.username()).orElseThrow(); return Map.of("token",token,"user",u);}
 public record LoginRequest(@NotBlank String username,@NotBlank String password){}
}
