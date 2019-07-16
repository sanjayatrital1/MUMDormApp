package edu.mum.cs544.productmanagement.service;

import edu.mum.cs544.productmanagement.domain.Product;
import edu.mum.cs544.productmanagement.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public Product get(Long id) {
        return productDao.getOne(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }

    @Override
    public Long add(Product p) {
        productDao.save(p);
        return p.getId();
    }

    @Override
    public void update(Product p) {

    productDao.save(p);
    }

    @Override
    public void delete(Long id) {

        productDao.deleteById(id);
    }

    @Override
    public List<Product> findByUser(long id) {
        return productDao.findByUser(id);
    }

    @Override
    public List<Product> searchByCategory(String category) {
       return productDao.searchByCategory(category);
    }
}
