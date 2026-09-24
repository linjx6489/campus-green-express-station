package com.campus.express.service;

import com.campus.express.model.User; import com.campus.express.repo.UserRepository; import io.jsonwebtoken.Jwts; import io.jsonwebtoken.security.Keys; import org.springframework.beans.factory.annotation.Value; import org.springframework.stereotype.Service; import java.nio.charset.StandardCharsets; import java.util.Date;
@Service public class AuthService {
 private final UserRepository users; private final byte[] key;
 public AuthService(UserRepository users,@Value("${app.jwt-secret}") String secret){this.users=users;key=secret.getBytes(StandardCharsets.UTF_8);}
 public String login(String username,String password){ User u=users.findByUsername(username).orElseThrow(()->new IllegalArgumentException("账号不存在")); if(!u.getPassword().equals(password)) throw new IllegalArgumentException("密码错误"); return Jwts.builder().subject(u.getId().toString()).claim("nickname",u.getNickname()).expiration(new Date(System.currentTimeMillis()+86400000)).signWith(Keys.hmacShaKeyFor(key)).compact(); }
 public Long userId(String token){return Long.valueOf(Jwts.parser().verifyWith(Keys.hmacShaKeyFor(key)).build().parseSignedClaims(token.replace("Bearer ","")).getPayload().getSubject());}
}
