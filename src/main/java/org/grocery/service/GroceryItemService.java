package org.grocery.service;

import org.grocery.model.GroceryItem;

import java.util.List;

public interface GroceryItemService {
    GroceryItem createGroceryItem(GroceryItem groceryItem);
    List<GroceryItem> getAllGroceryItems();
    GroceryItem getGroceryItemById(Long id);
    List<GroceryItem> getGroceryItemsByCategory(String category);
    GroceryItem updateGroceryItem(Long id, GroceryItem groceryItemDetails);
    void deleteGroceryItem(Long id);
}
