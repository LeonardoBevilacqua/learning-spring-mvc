package com.learningjava.web.project.service;

import java.util.List;

import com.learningjava.web.project.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
  void create(Product product);

  Product getById(Long id);

  List<Product> listByFilter();

  void update(Long id, Product product);

  void delete(Long id);
}
