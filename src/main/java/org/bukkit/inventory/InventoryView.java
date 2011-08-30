package org.bukkit.inventory;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

/**
 * Represents a view linking two inventories and a single player
 * (whose inventory may or may not be one of the two)
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
    Player getPlayer();
    
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
     * Updates the view the viewing player.
     */
    void update();
    
    /**
     * Converts a raw slot ID into its local slot ID into whichever of the two inventories
     * the slot points to. The resulting integer is suitable for either getTopInventory().getItem()
     * or for getBottomInventory.getItem(); use isInTop() to determine which one.
     * @param rawSlot The raw slot ID.
     * @return The converted slot ID.
     */
    int convertSlot(int rawSlot);
    
    /**
     * Check whether the given raw slot ID refers to a slot in the upper inventory.
     * @param rawSlot The raw slot ID.
     * @return True if it refers to the upper inventory, false if it refers to the lower.
     */
    boolean isInTop(int rawSlot);
}
