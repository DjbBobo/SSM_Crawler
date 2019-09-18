package cn.edu.service.impl;

import cn.edu.dao.MovieDao;
import cn.edu.domain.Movie;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.edu.service.MovieService;
import utils.CrawlerMovie;

import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieDao movieDao;

    public void addMovie(Movie movie) throws Exception {
        movieDao.addMovie(movie);
    }

    public List<Movie> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return movieDao.findAll();
    }

    public Boolean check(Movie movie) throws Exception {
        return movieDao.check(movie) == null ? true : false;
    }

    public List<Movie> search(String movieName, int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return movieDao.search(movieName);
    }

    public Movie findById(Integer id) throws Exception {
        return movieDao.findById(id);
    }

    public List<Movie> searchCrawler(String movieName) {
        return CrawlerMovie.Crawler(movieName);
    }


}
