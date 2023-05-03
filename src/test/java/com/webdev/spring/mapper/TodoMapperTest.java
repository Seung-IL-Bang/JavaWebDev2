package com.webdev.spring.mapper;

import com.webdev.spring.domain.TodoVO;
import jdk.vm.ci.meta.Local;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTest {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    @DisplayName("select now()")
    public void testGetTime() {
        log.info(todoMapper.getTime());
    }

    @Test
    @DisplayName("insert TodoVO")
    public void testInsert() {

        TodoVO todoVO = TodoVO.builder()
                .title("스프링 테스트")
                .dueDate(LocalDate.of(2022, 10, 10))
                .writer("user00")
                .build();

        todoMapper.insert(todoVO);
    }

    @Test
    @DisplayName("selectAll TodoVO")
    public void testSelectAll() {

        List<TodoVO> voList = todoMapper.selectAll();

        voList.forEach(vo -> log.info(vo));
    }

    @Test
    @DisplayName("selectOne TodoVO")
    public void testSelectOne() {
        TodoVO todoVO = todoMapper.selectOne(1L);

        log.info(todoVO);
    }

}

// @Autowired(required = false)
// : 'required' 속성으로 'false' 가 지정되면 해당 객체를 주입 받지 못하더라도 예외가 발생하지 않는다.
//   required = false; 직접 빈으로 등록된 mapper 가 없기 때문에 발생하는 경고를 방지하기 위해 적용