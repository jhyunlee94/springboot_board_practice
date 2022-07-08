package board.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoggerInterceptor implements HandlerInterceptor {
/*
* preHandle 컨트롤러 실행 전에 수행
* postHandle 컨트롤러 수행 후 결과를 뷰로 보내주기 전에 수행
* afterCompletion 뷰의 작업까지 완료된 후 수행
* */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("=============== START =================");
        log.debug(" Request URI \t : " + request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("==================== END ====================");
    }
}
