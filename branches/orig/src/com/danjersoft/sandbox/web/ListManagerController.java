package com.danjersoft.sandbox.web;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.danjersoft.sandbox.model.List;
import com.danjersoft.sandbox.service.ListService;

@Controller
@RequestMapping("/listManager")
public class ListManagerController {
   private ListService listService;

   private static final Logger log = Logger.getLogger(ListManagerController.class.getName());

   public ListManagerController() {
      listService = new ListService();
   }

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView get() {
      return new ModelAndView().addObject("lists", listService.getLists());
   }

   @RequestMapping(value = "/view/{listId}")
   public String view(@PathVariable Long listId, Model model) {
      List list = listService.getListById(listId);
      model.addAttribute("list", list);
      model.addAttribute("listItems", listService.getItemsForList(list));
      model.addAttribute("availableItems", listService.getAvailableItems());
      return "listManager/view";
   }

   @RequestMapping(value = "/addItem/{listId}", method = RequestMethod.GET)
   public String addItemToList(@PathVariable Long listId, Model model) {
      model.addAttribute("list", listService.getListById(listId));
      model.addAttribute("items", listService.getAllItems());
      return "listManager/addItem";
   }

   /**
    * Add new List
    */
   @RequestMapping(value = "/add", method = RequestMethod.GET)
   public void showForm() {}

   @RequestMapping(method = RequestMethod.POST)
   public String add(List list) {
      listService.addList(list);
      return "redirect:/listManager.htm";
   }

   @RequestMapping(value = "/delete/{listId}", method = RequestMethod.GET)
   public String delete(@PathVariable Long listId) {
      log.fine("ListManagerController.delete(): " + listId);
      listService.deleteListById(listId);
      return "redirect:/listManager.htm";
   }
}
