package az.kontakt.shop.service.impl;

import az.kontakt.shop.dao.ProductDao;
import az.kontakt.shop.model.Product;
import az.kontakt.shop.model.Stock;
import az.kontakt.shop.service.ProductService;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = null;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getProductList() throws Exception {
        return productDao.getProductList();
    }

    @Override
    public List<Product> searchProductData(String keyword) throws Exception {
        return productDao.searchProductData(keyword);
    }

    @Override
    public void deleteProduct(Long productId) throws Exception {
        productDao.deleteProduct(productId);
    }

    @Override
    public void addProduct(Product product) throws Exception {
        productDao.addProduct(product);
    }

    @Override
    public Integer findTotalCountOfSelectedProductInProductTable(Stock stock) throws Exception {
        return productDao.findTotalCountOfSelectedProductInProductTable(stock);
    }

    @Override
    public Product getProductByID(Long selectedId) throws Exception {
        return productDao.getProductByID(selectedId);
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        productDao.updateProduct(product);
    }
}