package az.kontakt.shop.service;

import az.kontakt.shop.model.Catagory;
import java.util.List;

public interface CatagoryService {

    List<Catagory> getCatagoryList() throws Exception;
}