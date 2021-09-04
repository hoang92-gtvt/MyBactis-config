package com.springapp.mvc.controller;

import com.springapp.mvc.model.User;
import com.springapp.mvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Tian Wang on 2015/3/24.
 */

@Controller
@RequestMapping("/user")
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
        List<User> userList = userService.getAllUsers();
        mav.addObject("list", userList);

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
    public  List<User> listUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @ResponseBody
    @RequestMapping(value="/{userId}",
            method = RequestMethod.GET,
            produces="application/json;charset=UTF-8")
    public User findUser(@PathVariable("userId") int userId) {
        User user = userService.getUser(userId);
        return user;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, BindingResult result) {
        userService.addUser(user);
        return "redirect:/";
    }
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.PUT)
    public String deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
        return "redirect:/";
    }
}
