package com.sts.Ecommerce.ECommerceApplicationBackend.controller;

import com.sts.Ecommerce.ECommerceApplicationBackend.entity.ImageModel;
import com.sts.Ecommerce.ECommerceApplicationBackend.entity.Product;
import com.sts.Ecommerce.ECommerceApplicationBackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

//    @PostMapping("/addNewProduct")
//    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
//        return new ResponseEntity<>(productService.addNewProduct(product), HttpStatus.CREATED);
//    }

   // @PreAuthorize("hasRole('Admin')")
   //@RequestMapping(path = "/addNewProduct", method = POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
   @PostMapping(value = "/addNewProduct")//, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})

    public Product addNewProduct(@ModelAttribute("product") Product product,
                                 @RequestParam("file") MultipartFile[] files){
        try{
            Set<ImageModel> images = uploadImage(files);
            product.setProductImages(images);
            return productService.addNewProduct(product);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public  Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();
        for(MultipartFile file : multipartFiles){
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }


    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(){
       return productService.getAllProduct();
    }


    @DeleteMapping("/deleteProduct/{productId}")
    public void deleteProductDetails(@PathVariable("productId") Integer productId){
        productService.deleteProductDetails(productId);
    }

    @GetMapping("/getProductDetail/{isSingleProductCheckout}/{productId}")
    public List<Product> getProductDetail(@PathVariable(name ="isSingleProductCheckout") boolean isSingleProductCheckout,
                                 @PathVariable(name = "productId")Integer productId){

       return productService.getProductDetail(isSingleProductCheckout, productId);

    }
}
