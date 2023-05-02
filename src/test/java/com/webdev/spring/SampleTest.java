package com.webdev.spring;

import com.webdev.spring.sample.SampleService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;


@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTest {

    @Autowired
    private SampleService sampleService;

    @Autowired // ApplicationContext 안에 해당 인터페이스의 구현체가 하나만 등록되어 있으면 자동으로 매칭된다. -> HikariDataSource
    private DataSource dataSource;

    @Test
    @DisplayName("SampleService 빈 생성")
    public void testService1() {
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }

    @Test
    @DisplayName("HikariDataSource 연결 상태")
    public void testConnection() throws Exception {
        Connection connection = dataSource.getConnection();
        log.info(connection);
        Assertions.assertNotNull(connection);
        connection.close();
    }
}

// @ExtendWith(SpringExtension.class)
// : JUnit5 버전에서 'spring-test' 를 이용하기 위한 설정이다. (JUnit4 버전에서는 -> @RunWith)

// @ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
// : 스프링의 설정 정보를 로딩하기 위해서 사용한다. 현재 프로젝트에선 스프링 설정을 XML 로 진행하기 때문에 'locations' 속성을 이용한다.
//   자바 설정을 이용하는 경우에는 'classes' 속성을 이용한다.
