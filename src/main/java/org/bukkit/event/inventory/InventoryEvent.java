
package org.bukkit.event.inventory;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryTransaction;

/**
 * Represents a player related inventory event
 */
public class InventoryEvent extends Event {
    protected InventoryTransaction transaction;
    
    public InventoryEvent(Type type, InventoryTransaction transaction) {
        super(type);
        this.transaction = transaction;
    }

    /**
     * Gets the primary Inventory involved in this transaction
     *
     * @return Inventory
     */
    public Inventory getInventory() {
        return transaction == null ? null : transaction.getInventory();
    }

    /**
     * Gets the list of players involved in this transaction
     *
     * @return List<Player>
     */
    public ArrayList<Player> getMembers() {
        return transaction == null ? new ArrayList<Player>() : transaction.getMembers();
    }

    /**
     * Gets the transaction object itself
     *
     * @return InventoryTransaction; null if there are no players left.
     */
    public InventoryTransaction getTransaction() {
        return transaction;
    }
}
