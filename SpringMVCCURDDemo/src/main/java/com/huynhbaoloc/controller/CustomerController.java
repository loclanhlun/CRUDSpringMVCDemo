package com.huynhbaoloc.controller;

import com.huynhbaoloc.entity.Customer;
import com.huynhbaoloc.service.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private ICustomerService icustomerService;

   @GetMapping("/list")
    public ModelAndView home(){
        List<Customer> listCustomer = icustomerService.getCustomers();
        ModelAndView mav = new ModelAndView("customer-form");
        mav.addObject("listCustomer", listCustomer);
        return mav;
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel){
       LOG.debug("inside show customer-form handler method");
       Customer theCustomer = new Customer();
       theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
       icustomerService.saveCustomer(theCustomer);
       return "redirect:/customer/list";
    }

    @GetMapping("/updateForm")
    public String showFormUpdate(@RequestParam("customerId") int theId){
       icustomerService.deleteCustomer(theId);
       return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId)  {
        icustomerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
}
