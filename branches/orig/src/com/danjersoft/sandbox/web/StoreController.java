package com.danjersoft.sandbox.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.danjersoft.sandbox.model.Store;
import com.danjersoft.sandbox.service.StoreService;

@Controller
@RequestMapping("/stores")
public class StoreController {

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView get() {
      return new ModelAndView().addObject("items", new StoreService().getStores());
   }

   @RequestMapping(value = "/add", method = RequestMethod.GET)
   public void showForm() {}

   @RequestMapping(method = RequestMethod.POST)
   public String add(Store store) {
      new StoreService().addStore(store);
      return "redirect:stores";
   }
}
