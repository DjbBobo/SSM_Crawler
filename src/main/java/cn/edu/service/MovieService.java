package cn.edu.service;

import cn.edu.domain.Movie;

import java.util.List;


public interface MovieService {

    public void addMovie(Movie movie)throws Exception;


    public List<Movie> findAll(int page,int size)throws Exception;

    public Boolean check(Movie movie)throws Exception;

    public List<Movie> search(String movieName,int page,int size)throws Exception;

    public Movie findById(Integer id)throws Exception;

    public List<Movie> searchCrawler(String movieName);
}
