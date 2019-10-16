package cn.edu.service.impl;

import cn.edu.dao.TvDao;
import cn.edu.domain.Tv;
import cn.edu.domain.Tvs;
import cn.edu.service.TvService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TvServiceImpl implements TvService {
    @Autowired
    TvDao tvDao;

    public String findById(Integer id) throws Exception {
        return tvDao.findById(id);
    }

    public List<Tv> search(String name, Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return tvDao.search(name);
    }

    public List<String> findTvsByTvId(Integer id) throws Exception {
        return tvDao.findTvsByTvId(id);
    }

    public Boolean checkTv(Tv tv)throws Exception {
        return tvDao.checkTv(tv) == null?true:false;
    }

    public Boolean isNew(Tv tv) throws Exception {
        return tvDao.isNew(tv) == null?false:true;
    }

    public void updateTv(Tv tv) throws Exception {
        tvDao.updateTv(tv);
    }

    public void addTv(Tv tv) throws Exception {
        tvDao.addTv(tv);
    }

    public Integer findTvByUrl(String url) throws Exception {
        return tvDao.findTvByUrl(url);
    }

    public void addTvs(Tvs tvs) throws Exception {
        tvDao.addTvs(tvs);
    }

    public Boolean checkTvs(Tvs tvs) throws Exception{
        return tvDao.checkTvs(tvs) == null?true:false;
    }

    public List<Tv> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return tvDao.findAll();
    }
}
