package az.kontakt.shop.service;

import az.kontakt.shop.model.Product;
import az.kontakt.shop.model.Stock;
import java.util.List;

public interface ProductService {

    void addProduct(Product product) throws Exception;

    List<Product> getProductList() throws Exception;

    List<Product> searchProductData(String keyword) throws Exception;

    void deleteProduct(Long productId) throws Exception;

    Integer findTotalCountOfSelectedProductInProductTable(Stock stock) throws Exception;

    Product getProductByID(Long selectedId) throws Exception;

    void updateProduct(Product product) throws Exception;
}
