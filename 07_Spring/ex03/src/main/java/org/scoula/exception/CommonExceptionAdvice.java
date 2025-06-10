package org.scoula.exception;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.config.Order;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@ControllerAdvice
public class CommonExceptionAdvice {

    // 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public String except(Exception ex, Model model) {
        log.error("Exception ......." + ex.getMessage());
        model.addAttribute("exception", ex);
        log.error(model);
        return "error_page"; // error_page.html or error_page.jsp 등
    }
    // 404 Not Found 처리
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex, Model model, HttpServletRequest request) {
        log.error("404 Error: ", ex);
        model.addAttribute("uri", request.getRequestURI());
        return "custom404"; // custom404.html or custom404.jsp 등
    }
}
