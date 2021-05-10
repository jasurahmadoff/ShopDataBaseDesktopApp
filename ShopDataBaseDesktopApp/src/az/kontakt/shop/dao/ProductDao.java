package az.kontakt.shop.dao;

import az.kontakt.shop.model.Product;
import az.kontakt.shop.model.Stock;
import java.util.List;

public interface ProductDao {

    void addProduct(Product product) throws Exception;

    List<Product> getProductList() throws Exception;

    List<Product> searchProductData(String keyword) throws Exception;

    void deleteProduct(Long productId) throws Exception;

    Integer findTotalCountOfSelectedProductInProductTable(Stock stock) throws Exception;

    Product getProductByID(Long selectedId) throws Exception;

    void updateProduct(Product product) throws Exception;
}