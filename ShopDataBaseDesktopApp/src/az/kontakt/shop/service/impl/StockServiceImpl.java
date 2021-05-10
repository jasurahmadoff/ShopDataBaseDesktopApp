package az.kontakt.shop.service.impl;

import az.kontakt.shop.dao.StockDao;
import az.kontakt.shop.model.Stock;
import az.kontakt.shop.service.StockService;
import java.util.List;

public class StockServiceImpl implements StockService {

    private StockDao stockDao = null;

    public StockServiceImpl(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    @Override
    public List<Stock> getStockList() throws Exception {
        return stockDao.getStockList();
    }

    @Override
    public List<Stock> searchStockData(String keyword) throws Exception {
        return stockDao.searchStockData(keyword);
    }

    @Override
    public void deleteStock(Long stockId) throws Exception {
        stockDao.deleteStock(stockId);
    }

    @Override
    public void addStock(Stock stock) throws Exception {
        stockDao.addStock(stock);
    }

    @Override
    public Stock getStockById(Long selectedId) throws Exception {
        return stockDao.getStockById(selectedId);
    }

    @Override
    public void updateStock(Stock stock) throws Exception {
        stockDao.updateStock(stock);
    }
}