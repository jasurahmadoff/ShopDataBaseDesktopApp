package az.kontakt.shop.service.impl;

import az.kontakt.shop.dao.CatagoryDao;
import az.kontakt.shop.model.Catagory;
import az.kontakt.shop.service.CatagoryService;
import java.util.List;

public class CatagoryServiceImpl implements CatagoryService {

    private CatagoryDao catagoryDao = null;

    public CatagoryServiceImpl(CatagoryDao catagoryDao) {
        this.catagoryDao = catagoryDao;
    }

    @Override
    public List<Catagory> getCatagoryList() throws Exception {
        return catagoryDao.getCatagoryList();
    }
}