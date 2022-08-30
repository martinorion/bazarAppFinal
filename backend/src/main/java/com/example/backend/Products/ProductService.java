package com.example.backend.Products;

import com.example.backend.User.User;

import java.util.List;

public interface ProductService {

    void addProduct(Product product);

    void deleteProduct(Product product);

    void updateProduct(Product product);

    void getByCategory(String category);

    List<Product> showOnlyUsersProducts();

    void editProduct(Product product);
}
