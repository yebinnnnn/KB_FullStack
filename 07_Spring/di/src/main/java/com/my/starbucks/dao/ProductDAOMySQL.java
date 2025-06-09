package com.my.starbucks.dao;

import com.my.starbucks.vo.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("daoMysql")
public class ProductDAOMySQL implements ProductDAO {

    @Override
    public void insert(Product product) {

    }

    @Override
    public Product findByProdNo(String prodNo) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public List<Product> findAll(int offset, int count) {
        return List.of();
    }

    @Override
    public long findCount() {
        return 0;
    }

    @Override
    public List<Product> findByProdNoContainingOrProdNameContaining(String word) {
        return List.of();
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(String prodNo) {

    }
}
