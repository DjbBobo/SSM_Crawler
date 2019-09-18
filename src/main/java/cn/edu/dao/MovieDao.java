package cn.edu.dao;

import cn.edu.domain.Movie;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MovieDao {
    /**
     * 插入一部电影
     * @param movie
     * @throws Exception
     */
    @Insert("insert into movie(name,playUrl,imageUrl,score) values(#{name},#{playUrl},#{imageUrl},#{score})")
    public void addMovie(Movie movie)throws Exception;

    /**
     * 查询所有电影
     * @return
     * @throws Exception
     */
    @Select("select * from movie")
    public List<Movie> findAll()throws Exception;

    @Select("select * from movie where playUrl=#{playUrl}")
    public Movie check(Movie movie)throws Exception;

    @Select("select * from movie where name like CONCAT('%',#{name},'%')")
    public List<Movie> search(String movieName)throws Exception;

    @Select("select * from movie where id=#{id}")
    public Movie findById(Integer id)throws Exception;

}

