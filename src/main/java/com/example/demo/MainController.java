package com.example.demo;
 
import java.util.*;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.lang.String;
@Controller 
public class MainController {
  @Autowired 
  private MemberRepository memberRepository;
  
  @Autowired
  private ProductRepository productRepository;
  
  @GetMapping("/")
  public String index() {
	  return "index";
  }
  
@RequestMapping("/add_product")
  public String addpro(Model model) {
   
	  List<Product> product = (List<Product>) productRepository.findAll();
	  model.addAttribute("product",product);
    return "add_product";
  }
  @GetMapping("/delete/product/{id}")
  public String deleteproduct(@PathVariable("id") long id, Model model) {
      Product product = productRepository.findById((int) id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
      productRepository.delete(product);
      return "redirect:/add_product";
  }
  @PostMapping("/update/product/{pid}")
  public String updateUser(@PathVariable("pid") Integer id, @Validated  Product product, 
    BindingResult result, Model model) {
     System.out.println(id); 
	 System.out.println(product.getPid()+ product.getPname());
	if (result.hasErrors()) {
          product.setPid(id);
          return "edit_product";
      }
          
      productRepository.save(product);
      return "redirect:/add_product";
  }
  @GetMapping("/edit/product/{pid}")
  public String editform(@PathVariable("pid") int id, Model model) {
      Product product = productRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
      
      model.addAttribute("product", product);
      return "edit_product";
  }
   
  @GetMapping(path="/allproduct")
  public @ResponseBody Iterable<Product> getAllProducts() {
    
	  
    return productRepository.findAll();
  }
  
  @PostMapping("/createproduct")
  public String addproduct(@Validated Product product, BindingResult result, Model model) {
      if (result.hasErrors()) {
          return "create_newproduct";
      }
      
      productRepository.save(product);
      return "redirect:/add_product";
  }
  @GetMapping("/createproduct")
  public String showProduct(Model model) {
      Product product = new Product();
      model.addAttribute("product", product);
      
      return "create_newproduct";
  }

 
  
  @RequestMapping("/addmember")
  public String userForm(Model model) {
   
	  List<Member> users = (List<Member>) memberRepository.findAll();
	  model.addAttribute("users",users);
    return "add_member";
  }
  @GetMapping("/delete/member/{id}")
  public String deleteUser(@PathVariable("id") long id, Model model) {
      Member user = memberRepository.findById((int) id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
      memberRepository.delete(user);
      return "redirect:/addmember";
  }
  @PostMapping("/update/member/{id}")
  public String updateUser(@PathVariable("id") Integer id, @Validated  Member user, 
    BindingResult result, Model model) {
     System.out.println(id); 
	 System.out.println(user.getId()+ user.getFname());
	if (result.hasErrors()) {
          user.setId(id);
          return "edit_member";
      }
          
      memberRepository.save(user);
      return "redirect:/addmember";
  }
  @GetMapping("/edit/member/{id}")
  public String showUpdateForm(@PathVariable("id") int id, Model model) {
      Member user = memberRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
      
      model.addAttribute("user", user);
      return "edit_member";
  }
   
  @GetMapping(path="/allmember")
  public @ResponseBody Iterable<Member> getAllUsers() {
    // This returns a JSON or XML with the users
    return memberRepository.findAll();
  }
  
  @PostMapping("/register")
  public String addUser(@Validated Member user, BindingResult result, Model model) {
      if (result.hasErrors()) {
          return "register_member";
      }
      
      memberRepository.save(user);
      return "redirect:/addmember";
  }
  @GetMapping("/register")
  public String showForm(Model model) {
      Member user = new Member();
      model.addAttribute("user", user);
      
      return "register_member";
  }
}