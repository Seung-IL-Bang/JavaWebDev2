package com.webdev.spring.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

// @Primary // 한 인터페이스의 여러 개 구현체(beans)가 존재하는 경우 최우선으로 적용할 객체를 해당 구현체로 적용
@Repository
@Qualifier("event")
public class EventSampleDAOImpl implements SampleDAO {
}
