package board.test;

import org.dom4j.rule.Mode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {

    @GetMapping("test")
    public ModelAndView test() throws Exception {
        ModelAndView mv = new ModelAndView("/board/test");
        mv.addObject("data", "babo");
        return mv;
    }
}
