package edu.mum.cs544.productmanagement.service;

import edu.mum.cs544.productmanagement.domain.Cart;
import edu.mum.cs544.productmanagement.domain.Product;
import edu.mum.cs544.productmanagement.repository.CartDao;
import edu.mum.cs544.productmanagement.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartDao cartDao;


    @Override
    public List<Cart> getAll(long userId) {
        return cartDao.findAll();
    }

    @Override
    public long add(Cart p) {
        cartDao.save(p);
        return p.getId();
    }



    @Override
    public void delete(long id) {

        cartDao.deleteById(id);
    }

}
