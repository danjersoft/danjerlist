/**
 * 
 */
package com.danjersoft.list;

import org.directwebremoting.util.Logger;

import com.danjersoft.list.model.Item;
import com.danjersoft.list.model.List;
import com.danjersoft.list.model.ListItem;
import com.danjersoft.list.service.ListService;

/**
 * @author $Author$
 * @version $Revision$, $Date$
 * 
 */
public class Lists {
   private static final Logger log = Logger.getLogger(Lists.class);

   public java.util.List<List> getAllLists() {
      log.debug("Retrieving all lists");
      return new ListService().getAllLists();
   }

   public java.util.List<Item> getAllItems() {
      log.debug("Retrieving all items");
      return new ListService().getAllItems();
   }

   public List addList(List list) {
      log.debug("Adding new list: " + list);
      return new ListService().addList(list);
   }

   public java.util.List<ListItem> getListItems(long listId) {
      ListService service = new ListService();
      List list = service.getListById(listId);
      log.debug("Getting items for list: " + list);
      return service.getListItems(list);
   }

   public ListItem addListItem(long listId, String itemName) {
      ListService listService = new ListService();
      // get list by id
      List list = listService.getListById(listId);
      log.debug("Adding new item to list: " + list);
      Item item = listService.getItemByName(itemName);
      log.debug("item: " + item);
      ListItem listItem = new ListItem(list, item);
      log.debug("before: " + listItem);
      listService.saveList(list);
      listService.addItemToList(listItem);
      log.debug("after: " + listItem);
      return listItem;
   }

   public void deleteList(long id) {
      log.debug("Deleting list with id: " + id);
      new ListService().deleteListById(id);
   }
}
