package org.bukkit.event.inventory;

import org.bukkit.event.Event;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.Recipe;

public class InventoryPreCraftEvent extends Event {
    Recipe recipe;
    CraftingInventory matrix;

    public InventoryPreCraftEvent(CraftingInventory what, Recipe recipe) {
        super(Type.INVENTORY_PRE_CRAFT);
        this.recipe = recipe;
        this.matrix = what;
    }
    
    /**
     * @return The recipe being crafted.
     */
    public Recipe getRecipe() {
        return recipe;
    }
    
    /**
     * @return The crafting inventory on which the recipe was formed.
     */
    public CraftingInventory getInventory() {
        return matrix;
    }
}
