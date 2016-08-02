package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mybatis.api.ProductApi;
import com.spring.mybatis.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by hdfs on 2016/8/2.
 */
@RestController
public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Product> index() {
        InputStream is = MainController.class.getClassLoader().getResourceAsStream("/com/spring/mybatis/conf.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        ProductApi productApi = session.getMapper(ProductApi.class);

        List<Product> products = productApi.selectProducts();
        return products;
    }
}
