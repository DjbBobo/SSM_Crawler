package cn.edu.web;

import cn.edu.domain.Tv;
import cn.edu.domain.Tvs;
import cn.edu.service.TvService;
import cn.edu.service.impl.TvServiceImpl;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import utils.CrawlerTv;
import utils.CrawlerTvs;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tv")
public class TvController {
    @Autowired
    TvService tvService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page
            , @RequestParam(name = "size",required = true,defaultValue = "36")Integer size, HttpServletRequest request)throws Exception{
        ModelAndView mv = new ModelAndView();
        request.getSession().setAttribute("sort","tv");
        List<Tv> list =  tvService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("main");
        return mv;
    }

    @RequestMapping("/search.do")
    public ModelAndView search(String name
            ,@RequestParam(name = "page",required = true,defaultValue = "1")Integer page
            ,@RequestParam(name = "size",required = true,defaultValue = "16")Integer size)throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Tv> list = tvService.search(name,page,size);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("main");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)Integer id,HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        //电视剧名字
        String name = tvService.findById(id);

        //查找所有剧集
        List<String> urlList =  tvService.findTvsByTvId(id);
        request.getSession().setAttribute("name",name);
        request.getSession().setAttribute("urlList",urlList);
        mv.setViewName("tvPlay");

        return mv;
    }

    @RequestMapping("/addToSession.do")
    public ModelAndView addToSession(@RequestParam String url,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        request.getSession().setAttribute("playUrl",url);
        mv.setViewName("tvPlay");
        return mv;
    }

    @RequestMapping("/addTv.do")
    public void addTv(@RequestBody String req)throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Tv tv = mapper.readValue(req, Tv.class);
        System.out.println(tv);
        if (tvService.checkTv(tv)){
            tvService.addTv(tv);
        }else if (!tvService.isNew(tv)){
            //更新
            tvService.updateTv(tv);
            CrawlerTvs.Crawler(tv.getPlayUrl());
        }
    }
    @RequestMapping("/updateTv.do")
    public void updateTv(Tv tv)throws Exception{
        tvService.updateTv(tv);
    }



    @RequestMapping("/isNew.do")
    public void isNew(Tv tv)throws Exception{
        tvService.isNew(tv);
    }

    @RequestMapping("/addTvs.do")
    public void addTvs(@RequestBody String req)throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Map map = mapper.readValue(req, Map.class);
        String url = (String) map.get("url");
        String playUrl = (String) map.get("playUrl");
        Integer tvId = tvService.findTvByUrl(url);
        Tvs tvs = new Tvs();
        tvs.setTv_id(tvId);
        tvs.setPlayUrl(playUrl);
        if (tvService.checkTvs(tvs)) {
            tvService.addTvs(tvs);
        }

    }

    @RequestMapping("/checkTv.do")
    public Boolean checkTv(Tv tv)throws Exception{
        return tvService.checkTv(tv);
    }

    @RequestMapping("/checkTvs.do")
    public Boolean checkTvs(Tvs tvs)throws Exception{
        return tvService.checkTvs(tvs);
    }

    @RequestMapping("/findTvByUrl.do")
    public Integer findTvByUrl(String url)throws Exception{
        return tvService.findTvByUrl(url);
    }

    @RequestMapping("/addNewTv.do")
    public ModelAndView addNewTv(){
        ModelAndView mv = new ModelAndView();
        CrawlerTv.Crawler();
        mv.addObject("success","更新成功");
        mv.setViewName("Online");
        return mv;
    }

}
