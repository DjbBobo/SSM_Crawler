package cn.edu.web;

import cn.edu.domain.Movie;
import cn.edu.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cn.edu.service.impl.MovieServiceImpl;
import utils.CrawlerMovie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @RequestMapping("/add.do")
    public void addMovie(@RequestBody String request) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Movie movie = mapper.readValue(request, Movie.class);
        System.out.println("Movie= " + movie);
        if (movieService.check(movie) == true) {
            movieService.addMovie(movie);
        }
    }

    //    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//        ModelAndView mv = new ModelAndView();
//        List<Movie> movies = movieService.findAll();
//        mv.addObject("movies",movies);
//        mv.setViewName("first");
//        return mv;
//    }
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page
                                ,@RequestParam(name = "size",required = true,defaultValue = "36")Integer size,HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        request.getSession().setAttribute("sort","movie");
        List<Movie> movies = movieService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(movies);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("main");
        return mv;
    }

    @RequestMapping("/search.do")
    public ModelAndView search(String name
                              ,@RequestParam(name = "page",required = true,defaultValue = "1")Integer page
                              ,@RequestParam(name = "size",required = true,defaultValue = "16")Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Movie> movies = movieService.search(name,page,size);
        PageInfo pageInfo = null;
        //判断数据库是否找到
        long total = ((Page)movies).getTotal();
        //若找到
        if (total != 0){
            pageInfo = new PageInfo(movies);
        }else{
            //若没找到，则到爱奇艺抓取
            movies = movieService.searchCrawler(name);
            pageInfo = new PageInfo(movies);
        }
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("main");
        return mv;
    }
    @RequestMapping("/searchCrawler.do")
    public ModelAndView searchCrawler(String movieName) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Movie> movies = movieService.searchCrawler(movieName);
        mv.addObject("movies",movies);
        mv.setViewName("searchCrawler");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)Integer id, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        Movie movie = movieService.findById(id);
        request.getSession().setAttribute("playUrl",movie.getPlayUrl());
        mv.addObject("movie",movie);
        mv.setViewName("moviePlay");
        return mv;
    }

    @RequestMapping("/setAttr.do")
    public ModelAndView setAttr(@Param("playUrl") String playUrl,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        session.setAttribute("playUrl",playUrl);
        mv.setViewName("play");
        return mv;
    }

    @RequestMapping("/addNewMovie.do")
    public ModelAndView addNewTv(){
        ModelAndView mv = new ModelAndView();
        CrawlerMovie.Crawler();
        mv.addObject("success","更新成功");
        mv.setViewName("Online");
        return mv;
    }

}
