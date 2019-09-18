package cn.edu.service.impl;

import cn.edu.dao.ParseUrlDao;
import cn.edu.domain.ParseUrl;
import cn.edu.service.ParseUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParseUrlServiceImpl implements ParseUrlService {
    @Autowired
    ParseUrlDao parseUrlDao;
    public ParseUrl findById(Integer id) throws Exception {
        return parseUrlDao.findById(id);
    }
}
