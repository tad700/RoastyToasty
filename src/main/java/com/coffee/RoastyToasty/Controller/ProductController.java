package com.coffee.RoastyToasty.Controller;


import com.coffee.RoastyToasty.Entity.Product;
import com.coffee.RoastyToasty.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);

        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productId,@RequestBody Product updatedProduct){
        Product product = productService.updateProduct(productId,updatedProduct);
        return ResponseEntity.ok(product);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product with id"+id+" deleted successfully");
    }


}
