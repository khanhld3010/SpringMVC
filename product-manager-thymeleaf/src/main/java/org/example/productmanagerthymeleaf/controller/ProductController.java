package org.example.productmanagerthymeleaf.controller;

import org.example.productmanagerthymeleaf.model.Product;
import org.example.productmanagerthymeleaf.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product, RedirectAttributes flash) {
        productService.save(product);
        flash.addFlashAttribute("success", "Thêm mới sản phẩm thành công!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product, RedirectAttributes flash) {
        productService.save(product);
        flash.addFlashAttribute("success", "Cập nhật sản phẩm thành công!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id, RedirectAttributes flash) {
        productService.remove(id);
        flash.addFlashAttribute("success", "Xóa sản phẩm thành công!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "view"; // Gọi file WEB-INF/views/view.html
    }
}
