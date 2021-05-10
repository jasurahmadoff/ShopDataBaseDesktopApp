package az.kontakt.shop.dao;

import az.kontakt.shop.model.Sale;
import java.util.List;

public interface SaleDao {

    List<Sale> getSaleList() throws Exception;

    List<Sale> searchSaleData(String keyword) throws Exception;

    void deleteSale(Long saleId) throws Exception;

    void addSale(Sale sale) throws Exception;

    Long findMaxChequeNumSale() throws Exception;

    Double findUnitPriceById(Long productID) throws Exception;

    Sale getSaleById(Long selectedId) throws Exception;

    void updateSale(Sale sale) throws Exception;
}