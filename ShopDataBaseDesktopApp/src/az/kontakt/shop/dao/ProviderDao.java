package az.kontakt.shop.dao;

import az.kontakt.shop.model.Provider;
import java.util.List;

public interface ProviderDao {

    List<Provider> getProviderList() throws Exception;

    List<Provider> searchProviderData(String keyword) throws Exception;

    void deleteProvider(Long providerId) throws Exception;

    void addProvider(Provider provider) throws Exception;

    Provider getProviderByID(Long selectedId) throws Exception;

    void updateProvider(Provider provider) throws Exception;
}