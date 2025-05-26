package org.grocery.service.impl;

import lombok.RequiredArgsConstructor;
import org.grocery.exception.ResourceNotFoundException;
import org.grocery.model.GroceryItem;
import org.grocery.repository.GroceryItemRepository;
import org.grocery.service.GroceryItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroceryItemServiceImpl implements GroceryItemService {

    private final GroceryItemRepository groceryItemRepository;

    @Override
    public GroceryItem createGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    @Override
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    @Override
    public GroceryItem getGroceryItemById(Long id) {
        return groceryItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grocery Item", "id", id));
    }

    @Override
    public List<GroceryItem> getGroceryItemsByCategory(String category) {
        return groceryItemRepository.findByCategory(category);
    }

    @Override
    public GroceryItem updateGroceryItem(Long id, GroceryItem groceryItemDetails) {
        GroceryItem groceryItem = getGroceryItemById(id);
        
        groceryItem.setName(groceryItemDetails.getName());
        groceryItem.setCategory(groceryItemDetails.getCategory());
        groceryItem.setPrice(groceryItemDetails.getPrice());
        groceryItem.setQuantity(groceryItemDetails.getQuantity());
        
        return groceryItemRepository.save(groceryItem);
    }

    @Override
    public void deleteGroceryItem(Long id) {
        GroceryItem groceryItem = getGroceryItemById(id);
        groceryItemRepository.delete(groceryItem);
    }
}
