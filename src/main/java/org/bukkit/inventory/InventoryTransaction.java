package org.bukkit.inventory;

import java.util.ArrayList;
import java.util.HashSet;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public interface InventoryTransaction {
    /**
     * Get the people involved in this transaction.
     * @return list of people
     */
    ArrayList<Player> getMembers();
    
    /**
     * Get the inventory involved in this transaction.
     * @return the inventory
     */
    Inventory getInventory();
    
    /**
     * Determine the type of inventory involved in the transaction.
     * @return the inventory type
     */
    InventoryType getType();
}
