package cny.service;

import cny.dao.EmpsDao;
import cny.model.Emps;

import javax.annotation.Resource;

public class EmpsService {
    @Resource
    private EmpsDao empsDao;
    public void setEmpsDao(EmpsDao empsDao) {
        this.empsDao = empsDao;
    }

    public void register(Emps emps) throws Exception {
        empsDao.add(emps);
    }
}
