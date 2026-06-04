package com.learningjava.web.project.service;

import java.util.List;

import com.learningjava.web.project.model.Product;
import com.learningjava.web.project.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository repository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.repository = productRepository;
  }

  @Override
  public void create(Product product) {
    this.repository.save(product);
  }

  @Override
  public Product getById(Long id) {
    return this.repository.getReferenceById(id);
  }

  @Override
  public List<Product> listByFilter() {
    return this.repository.findAll();
  }

  @Override
  public void update(Long id, Product product) {
    Product savedProduct = this.repository.getReferenceById(id);

    savedProduct.setName(product.getName());
    savedProduct.setDescription(product.getDescription());
    savedProduct.setPrice(product.getPrice());

    this.repository.save(savedProduct);
  }

  @Override
  public void delete(Long id) {
    this.repository.deleteById(id);
  }

}
