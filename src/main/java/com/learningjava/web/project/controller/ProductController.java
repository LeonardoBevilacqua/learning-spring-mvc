package com.learningjava.web.project.controller;

import com.learningjava.web.project.model.Product;
import com.learningjava.web.project.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// mapping the entire controler to '/', meaning 'http://localhost:8080' or
// 'http://mywebsite.com'
@RequestMapping("/")
public class ProductController {

  private final ProductService service;
  private static final String REDIRECT_TO_HOME = "redirect:/";
  private static final String CREATE_OR_EDIT_VIEW = "create-or-edit";

  public ProductController(ProductService productService) {
    this.service = productService;
  }

  @GetMapping
  public String home(Model model) {
    model.addAttribute("products", this.service.listByFilter());
    return "home";
  }

  @PostMapping("/delete")
  public String delete(@RequestParam Long id, @RequestParam(name = "_method") String method) {
    if ("DELETE".equals(method)) {
      this.service.delete(id);
    }

    return REDIRECT_TO_HOME;
  }

  @GetMapping("/create")
  public String create(Model model) {
    return CREATE_OR_EDIT_VIEW;
  }

  @PostMapping("/create")
  public String create(@RequestParam String name, @RequestParam String description, @RequestParam float price) {
    this.service.create(toProduct(name, description, price));

    return REDIRECT_TO_HOME;
  }

  @GetMapping("/update/{id}")
  public String update(@PathVariable("id") Long id, Model model) {
    Product foundProduct = this.service.getById(id);

    model.addAttribute("legend", "Editar Produto");
    model.addAttribute("product", foundProduct);
    return CREATE_OR_EDIT_VIEW;
  }

  @PostMapping("/update")
  public String update(@RequestParam Long id, @RequestParam String name, @RequestParam String description,
          @RequestParam float price) {
    this.service.update(id, toProduct(name, description, price));

    return REDIRECT_TO_HOME;
  }

  private Product toProduct(String name, String description, float price) {
    return new Product.Builder().setName(name).setDescription(description).setPrice(price).build();
  }
}
