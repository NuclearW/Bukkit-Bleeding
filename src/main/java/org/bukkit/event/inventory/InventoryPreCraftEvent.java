package org.bukkit.event.inventory;

import org.bukkit.event.Event;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.Recipe;

public class InventoryPreCraftEvent extends Event {
    CraftingInventory matrix;

    public InventoryPreCraftEvent(CraftingInventory what) {
        super(Type.INVENTORY_PRE_CRAFT);
        this.matrix = what;
    }
    
    /**
     * @return The recipe being crafted.
     */
    public Recipe getRecipe() {
        return matrix.getRecipe();
    }
    
    /**
     * @return The crafting inventory on which the recipe was formed.
     */
    public CraftingInventory getInventory() {
        return matrix;
    }
}
