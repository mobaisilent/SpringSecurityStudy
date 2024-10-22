package com.mobai.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity   //开启WebSecurity相关功能
public class SecurityConfiguration {
  //这里将BCryptPasswordEncoder直接注册为Bean，Security会自动进行选择
  @Bean
  public PasswordEncoder passwordEncoder() {
    System.out.println(new BCryptPasswordEncoder().encode("password"));
    return new BCryptPasswordEncoder();
  }

//  @Bean
//  public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//    UserDetails user = User
//            .withUsername("user")
//            .password(encoder.encode("user"))   //这里将密码进行加密后存储
//            .roles("USER")
//            .build();
//    System.out.println(encoder.encode("user"));  //一会观察一下加密出来之后的密码长啥样
//    UserDetails admin = User
//            .withUsername("admin")
//            .password(encoder.encode("amdin"))   //这里将密码进行加密后存储
//            .roles("ADMIN", "USER")
//            .build();
//    System.out.println(encoder.encode("admin"));  //一会观察一下加密出来之后的密码长啥样
//    return new InMemoryUserDetailsManager(user, admin);
//  }


  // 下面是处理数据库信息
  @Bean
  public DataSource dataSource() {
    //数据源配置
    return new PooledDataSource("com.mysql.cj.jdbc.Driver",
            "jdbc:mysql://localhost:3306/SpringSecurityStudy", "root", "mobaisilent");
  }


//  //手动创建一个AuthenticationManager用于处理密码校验
//  private AuthenticationManager authenticationManager(UserDetailsManager manager,
//                                                      PasswordEncoder encoder){
//    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//    provider.setUserDetailsService(manager);
//    provider.setPasswordEncoder(encoder);
//    return new ProviderManager(provider);
//  }
//
//  @Bean
//  public UserDetailsManager userDetailsService(DataSource dataSource,
//                                               PasswordEncoder encoder) throws Exception {
//    JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
//    //为UserDetailsManager设置AuthenticationManager即可开启重置密码的时的校验
//    manager.setAuthenticationManager(authenticationManager(manager, encoder));
//    return manager;
//  }
  @Bean
  public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    return bean;
  }
}