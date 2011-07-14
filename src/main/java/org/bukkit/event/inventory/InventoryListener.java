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

// transaction start/end, player joined/left transaction, and moving stuff around.
    public void onInventoryOpen(InventoryOpenEvent evt) {}
    
    public void onInventoryClose(InventoryCloseEvent evt) {}
    
    public void onInventoryClick(InventoryClickEvent evt) {}
    
    public void onInventoryCraft(InventoryCraftEvent evt) {}
}
