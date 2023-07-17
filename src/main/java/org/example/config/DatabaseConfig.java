package org.example.config;

import com.querydsl.sql.PostgreSQLTemplates;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.postgresql.PostgreSQLQueryFactory;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.querydsl.sql.spring.SpringExceptionTranslator;
import com.zaxxer.hikari.HikariConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@RequiredArgsConstructor
@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@EntityScan("org.example.domain.entity")
@EnableJpaRepositories("org.example.repository")
public class DatabaseConfig {

    private final DataSource dataSource;

    private final HikariConfig config;

    @PostConstruct
    public void init() {
        config.addHealthCheckProperty("connectivityCheckTimeoutMs", "60000");
    }

    @Primary
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Primary
    @Bean
    public SQLTemplates sqlTemplates() {
        return PostgreSQLTemplates.builder().build();
    }

    @Bean
    public com.querydsl.sql.Configuration querydslConfiguration() {
        com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(sqlTemplates());
        configuration.setExceptionTranslator(new SpringExceptionTranslator());
        return configuration;
    }

    @Bean
    public PostgreSQLQueryFactory sqlQueryFactory() {
        return new PostgreSQLQueryFactory(querydslConfiguration(), new SpringConnectionProvider(dataSource));
    }

}
