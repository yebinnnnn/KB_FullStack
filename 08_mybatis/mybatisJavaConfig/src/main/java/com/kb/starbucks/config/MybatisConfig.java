package com.kb.starbucks.config;
import com.kb.starbucks.mapper.ProductMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.session.Configuration;
import javax.sql.DataSource;
public class MybatisConfig {
    private static DataSource getDataSource() {
        return new PooledDataSource(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/starbucks", // 데이터베이스 URL
                "root",  // 사용자명
                "kb2025" // 비밀번호
        );
    }
    private static DataSource getHikariDataSource(){
        HikariConfig hikariConfig = new HikariConfig();

        // HikariCP의 기본 설정을 적용
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/starbucks");  // 데이터베이스 URL
        hikariConfig.setUsername("root");  // 사용자명
        hikariConfig.setPassword("kb2025"); // 비밀번호

        // 추가적인 HikariCP 설정 가능 (예: 최대 커넥션 풀 크기, 커넥션 타임아웃 등)
        hikariConfig.setMaximumPoolSize(10); // 최대 10개의 커넥션
        hikariConfig.setConnectionTimeout(30000); // 30초 동안 커넥션이 없으면 타임아웃

        // HikariCP 데이터소스 생성
        return new HikariDataSource(hikariConfig);
    }

    public static SqlSessionFactory getSqlSessionFactory() {

        //  1. 데이터 소스 설정 (PooledDataSource 사용)
//        DataSource dataSource = getDataSource();
        //  1. 데이터 소스 설정 (HikariDataSource 사용)
        DataSource dataSource = getHikariDataSource();

        // 2. 트랜잭션 팩토리 설정 (JDBC 기반 트랜잭션 사용)
        TransactionFactory transactionFactory = new JdbcTransactionFactory();

        // 3. Environment 객체 설정 (트랜잭션 팩토리와 데이터 소스를 설정)
        Environment environment = new Environment(
                "development",  // 환경 이름
                transactionFactory, // 트랜잭션 팩토리
                dataSource // 데이터 소스
        );

        // 4. Configuration 객체 생성
        Configuration configuration = new Configuration(environment);

        // 5.mapUnderscoreToCamelCase 설정 (Java 코드에서 설정)
        configuration.setMapUnderscoreToCamelCase(true);

        // 6. 매퍼 클래스 추가
//        configuration.addMapper(ProductMapper.class);
        configuration.addMapper(com.kb.starbucks.mapper.ProductMapper.class);

        // 7. SqlSessionFactory 객체 생성
        return new SqlSessionFactoryBuilder().build(configuration);
    }
}