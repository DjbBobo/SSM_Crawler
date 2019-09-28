package cn.edu.service;

import cn.edu.domain.Tv;
import cn.edu.domain.Tvs;

import java.util.List;

public interface TvService {
    /**
     * 检查是否存在
     */
    public Boolean checkTv(Tv tv)throws Exception;

    public void addTv(Tv tv)throws Exception;

    public Integer findTvByUrl(String url)throws Exception;

    public void addTvs(Tvs tvs)throws Exception;

    public Boolean checkTvs(Tvs tvs)throws Exception;

    public List<Tv> findAll(int page,int size)throws Exception;

    public String findById(Integer id)throws Exception;

    public List<String> findTvsByTvId(Integer id)throws Exception;

    public Boolean isNew(Tv tv)throws Exception;

    public void updateTv(Tv tv)throws Exception;


    public List<Tv> search(String name, Integer page, Integer size)throws Exception;
}
