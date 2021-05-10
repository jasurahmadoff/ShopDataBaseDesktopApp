package az.kontakt.shop.service.impl;

import az.kontakt.shop.dao.ProviderDao;
import az.kontakt.shop.model.Provider;
import az.kontakt.shop.service.ProviderService;
import java.util.List;

public class ProviderServiceImpl implements ProviderService {

    private ProviderDao providerDao = null;

    public ProviderServiceImpl(ProviderDao providerDao) {
        this.providerDao = providerDao;
    }

    @Override
    public List<Provider> getProviderList() throws Exception {
        return providerDao.getProviderList();
    }

    @Override
    public List<Provider> searchProviderData(String keyword) throws Exception {
        return providerDao.searchProviderData(keyword);
    }

    @Override
    public void deleteProvider(Long providerId) throws Exception {
        providerDao.deleteProvider(providerId);
    }

    @Override
    public void addProvider(Provider provider) throws Exception {
        providerDao.addProvider(provider);
    }

    @Override
    public Provider getProviderByID(Long selectedId) throws Exception {
        return providerDao.getProviderByID(selectedId);
    }

    @Override
    public void updateProvider(Provider provider) throws Exception {
        providerDao.updateProvider(provider);
    }
}
