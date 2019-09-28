package cn.edu.dao;

import cn.edu.domain.Tv;
import cn.edu.domain.Tvs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TvDao {

    @Select("select * from tv where playUrl=#{playUrl}")
    public Tv checkTv(Tv tv)throws Exception;

    @Insert("insert into tv(name,playUrl,imageUrl,score,mainActor,latestOrder,videoCount) values(#{name},#{playUrl},#{imageUrl},#{score},#{mainActor},#{latestOrder},#{videoCount})")
    public void addTv(Tv tv)throws Exception;

    @Select("select id from tv where playUrl=#{url}")
    public Integer findTvByUrl(String url);

    @Insert("insert into tvs(tv_id,playUrl) values(#{tv_id},#{playUrl})")
    public void addTvs(Tvs tvs)throws Exception;

    @Select("select * from tvs where playUrl=#{playUrl} and tv_id=#{tv_id}")
    public Boolean checkTvs(Tvs tvs)throws Exception;

    @Select("select * from tv")
    public List<Tv> findAll()throws Exception;

    @Select("select name from tv where id=#{id}")
    public String findById(Integer id)throws Exception;

    @Select("select playUrl from tvs where tv_id=#{id}")
    public List<String> findTvsByTvId(Integer id)throws Exception;

    @Select("select * from tv where playUrl=#{playUrl} and latestOrder=#{latestOrder}")
    public Boolean isNew(Tv tv)throws Exception;

    @Update("update tv set lathere plaestOrder=#{latestOrder} wyUrl=#{playUrl}")
    public void updateTv(Tv tv)throws Exception;

    @Select("select * from tv where name like CONCAT('%',#{name},'%')")
    public List<Tv> search(String name)throws Exception;
}
