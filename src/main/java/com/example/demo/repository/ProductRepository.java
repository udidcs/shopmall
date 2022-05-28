package com.example.demo.repository;

import com.example.demo.dto.Member;
import com.example.demo.dto.Product;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class ProductRepository {
    @PersistenceContext
    EntityManager em;

    public void save(Product pdt) {
        em.persist(pdt);
    }
    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll() {
        return em.createQuery("select p from Product p", Product.class)
                .getResultList();
    }
}
