package com.spring.mybatis.api;

import com.spring.mybatis.model.Product;

import java.util.List;

/**
 * Created by hdfs on 2016/8/1.
 */
public interface ProductApi {
    public Product getProductById(int id);

    public List<Product> selectProducts();
}
