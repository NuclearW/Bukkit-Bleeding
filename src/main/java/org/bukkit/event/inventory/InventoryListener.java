package org.bukkit.event.inventory;

import org.bukkit.event.Listener;
/**
* Handles all events thrown in relation to Blocks
 */
public class InventoryListener implements Listener {
    public InventoryListener() {}

    /**
     * Called when an ItemStack is successfully smelted in a furnace.
     *
     * @param event Relevant event details
     */
    public void onFurnaceSmelt(FurnaceSmeltEvent event) {}

    /**
     * Called when an ItemStack is successfully burned as fuel in a furnace.
     *
     * @param event Relevant event details
     */
    public void onFurnaceBurn(FurnaceBurnEvent event) {}

    /**
     * Called when an inventory view is opened. Will <i>not</i> be called
     * when the player's internal crafting view is opened.
     * 
     * @param event Relevant event details
     */
    public void onInventoryOpen(InventoryOpenEvent event) {}
    
    /**
     * Called when an inventory view is closed. Unlike {@link #onInventoryOpen(InventoryOpenEvent)},
     * this is called for the player's internal crafting view.
     * 
     * @param event Relevant event details
     */
    public void onInventoryClose(InventoryCloseEvent event) {}
    
    /**
     * Called when a player clicks on an inventory slot, or outside the
     * inventory window.
     * 
     * @param event Relevant event details
     */
    public void onInventoryClick(InventoryClickEvent event) {}
    
    /**
     * Called when a player tries to craft an item, either in the
     * internal crafting view or on a workbench. Will not be called
     * if the click event was cancelled.
     * 
     * @param event Relevant event details
     */
    public void onInventoryCraft(InventoryCraftEvent event) {}
}
