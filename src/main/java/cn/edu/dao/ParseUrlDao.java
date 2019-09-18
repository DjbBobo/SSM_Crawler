package cn.edu.dao;

import cn.edu.domain.ParseUrl;
import org.apache.ibatis.annotations.Select;

public interface ParseUrlDao {
    @Select("select * from parseurl where id=#{id}")
    public ParseUrl findById(Integer id)throws Exception;
}
