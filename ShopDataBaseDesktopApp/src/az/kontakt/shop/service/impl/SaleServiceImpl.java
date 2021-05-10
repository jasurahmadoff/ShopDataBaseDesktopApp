package az.kontakt.shop.service.impl;

import az.kontakt.shop.dao.SaleDao;
import az.kontakt.shop.model.Sale;
import az.kontakt.shop.service.SaleService;
import java.util.List;

public class SaleServiceImpl implements SaleService {

    private SaleDao saleDao = null;

    public SaleServiceImpl(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    @Override
    public List<Sale> getSaleList() throws Exception {
        return saleDao.getSaleList();
    }

    @Override
    public List<Sale> searchSaleData(String keyword) throws Exception {
        return saleDao.searchSaleData(keyword);
    }

    @Override
    public void deleteSale(Long saleId) throws Exception {
        saleDao.deleteSale(saleId);
    }

    @Override
    public void addSale(Sale sale) throws Exception {
        saleDao.addSale(sale);
    }

    @Override
    public Long findMaxChequeNumSale() throws Exception {
        return saleDao.findMaxChequeNumSale();
    }

    @Override
    public Double findUnitPriceById(Long productID) throws Exception {
        return saleDao.findUnitPriceById(productID);
    }

    @Override
    public Sale getSaleById(Long selectedId) throws Exception {
        return saleDao.getSaleById(selectedId);
    }

    @Override
    public void updateSale(Sale sale) throws Exception {
        saleDao.updateSale(sale);
    }
}
