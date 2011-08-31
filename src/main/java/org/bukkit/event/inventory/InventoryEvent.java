
package org.bukkit.event.inventory;

import java.util.List;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Event;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

/**
 * Represents a player related inventory event
 */
public class InventoryEvent extends Event {
    protected InventoryView transaction;
    
    public InventoryEvent(Type type, InventoryView transaction) {
        super(type);
        this.transaction = transaction;
    }

    /**
     * Gets the primary Inventory involved in this transaction
     *
     * @return The upper inventory.
     */
    public Inventory getInventory() {
        return transaction.getTopInventory();
    }

    /**
     * Gets the list of players viewing the primary (upper) inventory involved in this event
     *
     * @return A list of people viewing.
     */
    public List<HumanEntity> getViewers() {
        return transaction.getTopInventory().getViewers();
    }

    /**
     * Gets the view object itself
     *
     * @return InventoryView
     */
    public InventoryView getView() {
        return transaction;
    }
}
