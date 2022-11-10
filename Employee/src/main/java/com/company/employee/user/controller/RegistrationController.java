package com.company.employee.user.controller;

import com.company.employee.user.UserNotFoundException;
import com.company.employee.user.domain.Registration;
import com.company.employee.user.domain.User;
import com.company.employee.user.service.RegistrationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationServices registrationService;

    @GetMapping("/registration")
    public String showUserRegistrationList(Model model) {

        //model.addAttribute("listUsers", listUsers);
        return "login";
    }
// redirect to new page
    @GetMapping("/adhome")
    public String showadhome(Model model) {
        return "adhome";
    }

    //register form
    @PostMapping("/registration/save")
    public String saveUser(Registration register, RedirectAttributes ra) {
        registrationService.save(register);
        ra.addFlashAttribute("message", "The user registration has been saved successfully");
        return "redirect:/registration";
    }

    @GetMapping("/registration/new")
    public String showNewRegistrationForm(Model model) {
        model.addAttribute("user", new Registration());
        model.addAttribute("pageTitle", "Add New User Registration");
        return "register";
    }
    //// register end

    //use in the login screen to validate the user is exist and the password is matched with the given user email
    @GetMapping("registration/user/{email}/{password}")
    public String getRegisteredUser(@PathVariable("email") String email, @PathVariable("password") String password, RedirectAttributes ra) {
        try {
            Registration registration = registrationService.getRegistration(email, password);
            if(registration.getUserType().equals("admin")){
                return "redirect:/users";
            }else{
                return "redirect:/adhome";
            }
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", "username and password not matched");
            return "redirect:/registration";
        }
    }

    @PutMapping("registration/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            registrationService.delete(id);
            ra.addFlashAttribute("message", "The user ID" + id + "has been deleted.");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/users";
    }

    @GetMapping("/registration/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Registration user = registrationService.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit Registered User (ID: " + id + ")");

            return "user_form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/users";
        }
    }
}