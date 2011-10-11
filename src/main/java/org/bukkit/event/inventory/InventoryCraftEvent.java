package org.bukkit.event.inventory;

import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.Recipe;

public class InventoryCraftEvent extends InventoryEvent {
    Recipe matrix;

    public InventoryCraftEvent(InventoryView what, Recipe recipe) {
        super(Type.INVENTORY_CRAFT, what);
        matrix = recipe;
    }
    
    public Recipe getRecipe() {
        return matrix;
    }
}
