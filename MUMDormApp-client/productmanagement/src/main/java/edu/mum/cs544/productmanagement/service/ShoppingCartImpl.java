package edu.mum.cs544.productmanagement.service;

import edu.mum.cs544.productmanagement.domain.ShoppingCart;
//import edu.mum.cs544.productmanagement.repository.ShoppingCartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
//@Transactional
//public class ShoppingCartImpl implements IShoppingCartService {
//    @Autowired
//    private ShoppingCartDao shoppingCartDao;
//    @Override
//    public List<ShoppingCart> getAll() {
//        return shoppingCartDao.findAll();
//    }
//
//    @Override
//    public ShoppingCart get(Long id) {
//        return shoppingCartDao.getOne(id);
//    }
//
//    @Override
//    public Long add(ShoppingCart cart) {
//        shoppingCartDao.save(cart);
//        return cart.getId();
//    }
//
//    @Override
//    public void update(ShoppingCart cart) {
//        shoppingCartDao.save(cart);
//    }
//
//    @Override
//    public void delete(Long id) {
//
//        shoppingCartDao.deleteById(id);
//    }
//}
