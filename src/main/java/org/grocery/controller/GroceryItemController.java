package org.grocery.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.grocery.model.GroceryItem;
import org.grocery.service.GroceryItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grocery-items")
@RequiredArgsConstructor
public class GroceryItemController {

    private final GroceryItemService groceryItemService;

    @PostMapping
    public ResponseEntity<GroceryItem> createGroceryItem(@Valid @RequestBody GroceryItem groceryItem) {
        return new ResponseEntity<>(groceryItemService.createGroceryItem(groceryItem), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {
        return ResponseEntity.ok(groceryItemService.getAllGroceryItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getGroceryItemById(@PathVariable Long id) {
        return ResponseEntity.ok(groceryItemService.getGroceryItemById(id));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<GroceryItem>> getGroceryItemsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(groceryItemService.getGroceryItemsByCategory(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(
            @PathVariable Long id, @Valid @RequestBody GroceryItem groceryItemDetails) {
        return ResponseEntity.ok(groceryItemService.updateGroceryItem(id, groceryItemDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceryItem(@PathVariable Long id) {
        groceryItemService.deleteGroceryItem(id);
        return ResponseEntity.noContent().build();
    }
}
