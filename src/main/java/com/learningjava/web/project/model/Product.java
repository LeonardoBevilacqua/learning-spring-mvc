package com.learningjava.web.project.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "products")
public class Product {

  public Product() {
    // default constructor
  }

  // Builder constructor
  private Product(Builder builder) {
    this.name = builder.name;
    this.description = builder.description;
    this.price = builder.price;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "price", nullable = false)
  private float price;

  @Column(name = "created_at", nullable = false)
  @CreationTimestamp
  private Date createdAt;

  @Column(name = "modified_at", nullable = false)
  @UpdateTimestamp
  private Date modifiedAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getModifiedAt() {
    return modifiedAt;
  }

  public void setModifiedAt(Date modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public static class Builder {
    private String name;
    private String description;
    private float price;

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public Builder setPrice(float price) {
      this.price = price;
      return this;
    }

    public Product build() {
      return new Product(this);
    }
  }
}
