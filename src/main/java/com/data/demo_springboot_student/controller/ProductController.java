package com.data.demo_springboot_student.controller;


import com.data.demo_springboot_student.entity.Product;
import com.data.demo_springboot_student.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // GET /products/add: Hiển thị form thêm mới sản phẩm
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/add";
    }

    // POST /products/add: Thêm sản phẩm mới
    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }

    // GET /products: Lấy danh sách sản phẩm
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product/list";
    }

    // GET /products/update/{id}: Hiển thị form cập nhật sản phẩm
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Product product = productRepository.findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Id khong hop le: " + id));
        model.addAttribute("product", product);
        return "product/update";
    }

    // POST /products/update/{id}: Cập nhật thông tin sản phẩm
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        product.setId(id);
        productRepository.update(product);
        return "redirect:/products";
    }

    // GET /products/delete/{id}: Xóa sản phẩm theo ID
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Id khong hop le: " + id));
        productRepository.delete(product);
        return "redirect:/products";
    }
}