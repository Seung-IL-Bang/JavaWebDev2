package com.webdev.spring.mapper;

import com.webdev.spring.domain.TodoVO;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);
}
