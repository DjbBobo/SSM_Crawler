package cn.edu.web;

import cn.edu.domain.ParseUrl;
import cn.edu.service.ParseUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/parse")
public class ParseUrlController {
    @Autowired
    ParseUrlService parseUrlService;
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        ParseUrl parseUrl = parseUrlService.findById(id);
        mv.addObject("parseUrl",parseUrl);
        mv.setViewName("play");
        return mv;
    }
}
