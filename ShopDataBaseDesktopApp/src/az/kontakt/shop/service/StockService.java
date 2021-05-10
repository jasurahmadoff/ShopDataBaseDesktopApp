package az.kontakt.shop.service;

import az.kontakt.shop.model.Stock;
import java.util.List;

public interface StockService {

    List<Stock> getStockList() throws Exception;

    List<Stock> searchStockData(String keyword) throws Exception;

    void deleteStock(Long stockId) throws Exception;

    void addStock(Stock stock) throws Exception;

    Stock getStockById(Long selectedId) throws Exception;

    void updateStock(Stock stock) throws Exception;
}
