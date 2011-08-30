package org.bukkit.event.inventory;

import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.Recipe;

public class InventoryCraftEvent extends InventoryEvent {
    Recipe matrix;
    int width, height;

    public InventoryCraftEvent(InventoryView what, Recipe recipe) {
        super(Type.INVENTORY_CRAFT, what);
        matrix = recipe;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public Recipe getRecipe() {
        return matrix;
    }
}
