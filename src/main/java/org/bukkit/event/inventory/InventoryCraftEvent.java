package org.bukkit.event.inventory;

import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.Recipe;

public class InventoryCraftEvent extends InventoryClickEvent {
    private Recipe recipe;

    public InventoryCraftEvent(Recipe recipe, InventoryView what, SlotType type, int slot, boolean right, boolean shift) {
        super(what, type, slot, right, shift);
        this.recipe = recipe;
    }

    /**
     * @return A copy of the current recipe on the crafting matrix.
     */
    public Recipe getRecipe() {
        return recipe;
    }
}
