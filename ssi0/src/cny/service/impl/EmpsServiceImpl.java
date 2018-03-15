package cny.service.impl;

import cny.dao.EmpsDao;
import cny.model.Emps;
import cny.service.EmpsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("empsService")
public class EmpsServiceImpl implements EmpsService {
    @Resource
    private EmpsDao empsDao;

    public void setEmpsDao(EmpsDao empsDao) {
        this.empsDao = empsDao;
    }

    @Override
    public void register(Emps emps) throws Exception {
        empsDao.add(emps);
    }
}
