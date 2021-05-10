package az.kontakt.shop.dao;

import az.kontakt.shop.model.Catagory;
import java.util.List;

public interface CatagoryDao {

    List<Catagory> getCatagoryList() throws Exception;
}