package com.sathya.mvc.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.sathya.mvc.Entites.ProductEntity;
import com.sathya.mvc.model.ProductModel;
import com.sathya.mvc.repository.ProductRepository;
import com.sathya.mvc.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@GetMapping("/productform")
	public String getProductForm(Model model) {
		ProductModel productModel = new ProductModel();
	    //productModel.setProBrand("sathya");
		model.addAttribute("productModel",productModel);
		model.addAttribute("page","productform");
		return "index";
		
	}
	@PostMapping("/productssave")
    public String saveProduct(@Valid ProductModel productModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        
        // Check if there are validation errors
        if (bindingResult.hasErrors()) {
            // If validation fails, return the user to the form with error messages
            return "get-product"; // The name of the form view where validation errors will be shown
        }

        // If validation passes, save the product and redirect to a success page or another route
        // For example, you could save the product to the database using a service layer

        // Add a success message as a flash attribute (shown once after redirection)
        productService.saveProductData(productModel);

        return "sucess."; // Redirect to the products listing or another success page
        }
	
	@GetMapping("/getproducts")
	public String showProducts(Model model) {
		List<ProductEntity>products = productService.getAllProducts();
		model.addAttribute("products",products);
		model.addAttribute("page","getproducts");
		return "index";
	}
	@GetMapping("/delete")
	public String deleteProduct(Long id) {
		productService.deleteProductById(id);
		return "redirect:/getproducts";
	}
	/* @GetMapping("/update")                                                                    
	 public String editProductForm(Long id, Model model) {                         
	     Optional<ProductEntity> product = Optional.of(productService.findProductById(id));   

	                                                                                             
	     if (product.isPresent()) {                                                              
	         model.addAttribute("productModel", product.get());                                  
	         return "updateProduct";                                   
	     } else {                                                                                
	         model.addAttribute("errorMessage", "Product not found");                            
	         return "error";                         
	     }                                                                                       
	 }
    @PostMapping("/update")
    public String updateProduct(Long id, ProductModel productModel) {
        productService.updateProduct(id, productModel);
        return "redirect:/getproducts"; 
    } */
	 @GetMapping("/update")
	    public String showEditForm(@RequestParam Long id, Model model) {
	        // Fetch the product by ID and add it to the model
	        ProductModel productModel = productService.getProductById(id);
	        model.addAttribute("productModel", productModel);
	        model.addAttribute("categories", Arrays.asList("Mobile", "Camera", "Printer", "Laptop", "Accessories"));
	        model.addAttribute("id", id);
	        return "updateProduct";  
	    }
	 @PostMapping("/update")
	    public String updateProduct(Long id, ProductModel productModel) {
	        productService.updateProduct(id, productModel);
	        return "redirect:/getproducts"; 
	    }
	 @GetMapping("/Aboutus")
	 public String aboutUs(Model model) {
		 model.addAttribute("page","Aboutus");
			return "index";
		
		 
	 }
	 @GetMapping("/Contactus")
	 public String contactUs(Model model) {
		 model.addAttribute("page","Contactus");
			return "index";
		
		 
	 }
	 @GetMapping("/search")
	    public String searchProductById(@RequestParam("id") long id, Model model) {
	        ProductEntity product = productService.getProductById(id);
	        model.addAttribute("product", product);
	        //model.addAttribute("page","Search");
			return "Search";
	    
	    }
     
}