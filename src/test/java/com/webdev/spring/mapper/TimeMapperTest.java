package com.webdev.spring.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTest {

    @Autowired(required = false) // required = false; 직접 빈으로 등록된 TimeMapper 가 없기 때문에 발생하는 경고를 방지하기 위해 적용
    private TimeMapper2 timeMapper2;

    @Test
    @DisplayName("MyBatis: select now()")
    public void testGetTime() {
        log.info(timeMapper2.getNow());
    }
}

// @Autowired(required = false)
// : 'required' 속성으로 'false' 가 지정되면 해당 객체를 주입 받지 못하더라도 예외가 발생하지 않는다.
