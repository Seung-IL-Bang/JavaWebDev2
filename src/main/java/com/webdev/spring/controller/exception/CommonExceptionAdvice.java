package com.webdev.spring.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice // 컨트롤러에서 발생하는 예외를 처리할 수 있는 Bean
@Log4j2
public class CommonExceptionAdvice {

    // 개별 예외 처리: 배포할 땐 종류 별로 예외 처리를 하는 것이 좋다.
    @ResponseBody // 문자열이나 JSON 데이터를 그대로 전송할 때 사용되는 REST 방식 어노테이션
    @ExceptionHandler(NumberFormatException.class) // 해당 종류의 예외 발생 시 아래 메소드로 진행
    public String exceptNumber(NumberFormatException numberFormatException) {

        log.error("-----------------------------");
        log.error(numberFormatException.getMessage());

        return "NUMBER FORMAT EXCEPTION";
    }

    // 범용 예외 처리: 예외 메시지가 자세히 출력되는 것이 개발할 때 도움이 되므로 개발 시 주로 사용
    @ResponseBody
    @ExceptionHandler(Exception.class) // 상위 클래스의 예외가 우선 순위가 높기 때문에 NumberFormatException 보다 먼저 핸들링 된다.
    public String exceptCommon(Exception exception) {
        log.error("-----------------------------");
        log.error(exception.getMessage());

        StringBuffer buffer = new StringBuffer("<ul>");

        buffer.append("<li>" + exception.getMessage() + "</li>");

        Arrays
                .stream(exception.getStackTrace())
                .forEach(stackTraceElement -> buffer.append("<li>" + stackTraceElement + "</li>"));

        buffer.append("</ul>");

        return buffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // 해당 status 코드의 예외 처리는 반드시 아래 메소드로 진행.
    public String notFound() {
        return "custom404";
    }
}
