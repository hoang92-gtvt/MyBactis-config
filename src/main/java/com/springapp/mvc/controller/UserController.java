package com.springapp.mvc.controller;

import com.springapp.mvc.model.UsersDemo;
import com.springapp.mvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Tian Wang on 2015/3/24.
 */

@Controller
public class UserController {
    @Autowired
    @Qualifier("userService") //this is to specify implementation class
    private IUserService userService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView  home() {
        ModelAndView mav = new ModelAndView("home");
         return mav;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView  listUsers1() {
        ModelAndView mav = new ModelAndView("list");
        List<UsersDemo> userList = userService.getAllUsers();
        mav.addObject("list", userList);

        return mav;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView  findone(@PathVariable("id") int userId) {
        ModelAndView mav = new ModelAndView("detail");
        UsersDemo user = userService.getUser(userId);
        mav.addObject("user", user);

        return mav;
    }

    /**
     *
     * @return users in json
     */
    @ResponseBody
    @RequestMapping(value = "/json",
            method = RequestMethod.GET,
            produces="application/json;charset=UTF-8")
    public  List<UsersDemo> listUsers() {
        List<UsersDemo> users = userService.getAllUsers();
        return users;
    }

//    @ResponseBody
//    @RequestMapping(value="/{userId}",
//            method = RequestMethod.GET,
//            produces="application/json;charset=UTF-8")
//    public Users findUser(@PathVariable("userId") int userId) {
//        Users users = userService.getUser(userId);
//        return users;
//    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") UsersDemo usersDemo, BindingResult result) {
        userService.addUser(usersDemo);
        return "redirect:/";
    }
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.PUT)
    public String deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
        return "redirect:/";
    }
}
