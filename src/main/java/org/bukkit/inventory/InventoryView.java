package org.bukkit.inventory;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;

/**
 * Represents a view linking two inventories and a single player
 * (whose inventory may or may not be one of the two)
 * 
 * Note: If you implement this interface but fail to satisfy the expected
 * contracts of certain methods, there's no guarantee that the game
 * will work as it should.
 */
public interface InventoryView {
    /**
     * Get the upper inventory involved in this transaction.
     * @return the inventory
     */
    Inventory getTopInventory();
    
    /**
     * Get the lower inventory involved in this transaction.
     * @return the inventory
     */
    Inventory getBottomInventory();
    
    /**
     * Get the player viewing.
     * @return the player
     */
    HumanEntity getPlayer();
    
    /**
     * Determine the type of inventory involved in the transaction. This indicates
     * the window style being shown. It will never return PLAYER, since that is
     * common to all windows.
     * @return the inventory type
     */
    InventoryType getType();
    
    /**
     * Sets one item in this inventory view by its raw slot ID.
     * @param slot The ID as returned by InventoryClickEvent.getRawSlot()
     * @param item The new item to put in the slot, or null to clear it.
     */
    void setItem(int slot, ItemStack item);
    
    /**
     * Sets one item in this inventory view by its raw slot ID.
     * @param slot The ID as returned by InventoryClickEvent.getRawSlot()
     * @return The item currently in the slot.
     */
    ItemStack getItem(int slot);
    
    /**
     * Sets the item on the cursor of one of the viewing players.
     * @param player The player whose cursor you want to change.
     * @param item The item to put on the cursor, or null to remove the item on their cursor.
     */
    void setCursor(ItemStack item);
    
    /**
     * Get the item on the cursor of one of the viewing players.
     * @param player The player whose cursor you want to check.
     * @return The item on the player's cursor, or null if they aren't holding one.
     */
    ItemStack getCursor();
    
    /**
     * Converts a raw slot ID into its local slot ID into whichever of the two inventories
     * the slot points to. If the raw slot refers to the upper inventory, it will be returned
     * unchanged and thus be suitable for getTopInventory().getItem(); if it refers to the
     * lower inventory, the output will differ from the input and be suitable for
     * getBottomInventory().getItem().
     * @param rawSlot The raw slot ID.
     * @return The converted slot ID.
     */
    int convertSlot(int rawSlot);
    
    /**
     * Closes the inventory view.
     */
    void close();
    
    /**
     * Check the total number of slots in this view, combining the upper and lower inventories.
     * Note though that it's possible for this to be greater than the sum of the two inventories
     * if for example some slots are not being used.
     * @return The total size
     */
    int countSlots();
}
