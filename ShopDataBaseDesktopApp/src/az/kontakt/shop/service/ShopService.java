package az.kontakt.shop.service;

import az.kontakt.shop.model.Product;
import az.kontakt.shop.model.Shop;
import java.util.List;

public interface ShopService {

    List<Shop> getShopList() throws Exception;

    List<Shop> searchShopData(String keyword) throws Exception;

    void deleteShop(Long shopId) throws Exception;

    void addShop(Shop shop) throws Exception;

    List<Product> getProductListByShopId(Shop tempShop) throws Exception;

    Shop getShopById(Long selectedId) throws Exception;

    void updateShop(Shop shop) throws Exception;
}
