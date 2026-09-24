package com.campus.express.config;
import com.campus.express.model.*; import com.campus.express.repo.*; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.Bean; import org.springframework.context.annotation.Configuration;
@Configuration public class SeedConfig { @Bean CommandLineRunner seed(UserRepository u,NoticeRepository n){return args->{if(u.count()==0)u.save(new User("demo","123456","演示用户"));if(n.count()==0)n.save(new Notice("绿色寄递倡议","请使用可循环快递袋，取件后及时完成取件确认，共建绿色校园。"));};}}
