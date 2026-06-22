package org.example.productmanagerthymeleaf.service;

import org.example.productmanagerthymeleaf.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iPhone 15 Pro", 1000.0, "Điện thoại Apple"));
        products.put(2, new Product(2, "Laptop ThinkPad", 1500.0, "Laptop doanh nhân"));
        products.put(3, new Product(3, "Bàn phím cơ Cơ", 100.0, "Gõ cực sướng"));
    }

    // 1. Lấy toàn bộ danh sách (Read All)
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    // 2. Thêm mới hoặc Cập nhật (Create / Update)
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    // 3. Tìm sản phẩm theo ID (Read One)
    public Product findById(int id) {
        return products.get(id);
    }

    // 4. Xóa sản phẩm (Delete)
    public void remove(int id) {
        products.remove(id);
    }
}
