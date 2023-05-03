package com.webdev.spring.service;

import com.webdev.spring.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @Test
    @DisplayName("Register 동작")
    public void testRegister() {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("test...")
                .dueDate(LocalDate.of(2023, 5, 3))
                .writer("user01")
                .build();

        todoService.register(todoDTO);
    }
}
