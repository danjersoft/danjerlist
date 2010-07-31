package com.danjersoft.sandbox.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.danjersoft.sandbox.model.Item;
import com.danjersoft.sandbox.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView get() {
      return new ModelAndView().addObject("items", new ItemService().getItems());
   }

   @RequestMapping(value = "/add", method = RequestMethod.GET)
   public void showForm() {}

   @RequestMapping(method = RequestMethod.POST)
   public String add(Item item) {
      new ItemService().addItem(item);
      return "redirect:items";
   }
}
