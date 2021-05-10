package az.kontakt.shop.service.impl;

import az.kontakt.shop.dao.ShopDao;
import az.kontakt.shop.model.*;
import az.kontakt.shop.service.ShopService;
import java.util.List;

public class ShopServiceImpl implements ShopService {

    private ShopDao shopDao = null;

    public ShopServiceImpl(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    @Override
    public List<Shop> getShopList() throws Exception {
        return shopDao.getShopList();
    }

    @Override
    public List<Shop> searchShopData(String keyword) throws Exception {
        return shopDao.searchShopData(keyword);
    }

    @Override
    public void deleteShop(Long shopId) throws Exception {
        shopDao.deleteShop(shopId);
    }

    @Override
    public void addShop(Shop shop) throws Exception {
        shopDao.addShop(shop);
    }

    @Override
    public List<Product> getProductListByShopId(Shop tempShop) throws Exception {
        return shopDao.getProductListByShopId(tempShop);
    }

    @Override
    public Shop getShopById(Long selectedId) throws Exception {
        return shopDao.getShopById(selectedId);
    }

    @Override
    public void updateShop(Shop shop) throws Exception {
        shopDao.updateShop(shop);
    }
}