package board.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice // 해당 클래스가 예외처리 클래스임을 알림
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception exception) {
        ModelAndView mv = new ModelAndView("/error/error_default");
        mv.addObject("exception", exception);

        log.error("exception", exception);
        return mv;
    }
}
