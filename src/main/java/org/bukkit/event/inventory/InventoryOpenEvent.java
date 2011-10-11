
package org.bukkit.event.inventory;

import org.bukkit.inventory.InventoryView;
import org.bukkit.event.Cancellable;

/**
 * Represents a player related inventory event
 */
public class InventoryOpenEvent extends InventoryEvent implements Cancellable {
    private boolean cancelled;
    
    public InventoryOpenEvent(InventoryView transaction) {
        super(Type.INVENTORY_OPEN, transaction);
        this.cancelled = false;
    }
    
    /**
     * Gets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * If an inventory open event is cancelled, the inventory screen will not show.
     *
     * @return true if this event is cancelled
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Sets the cancellation state of this event. A cancelled event will not
     * be executed in the server, but will still pass to other plugins
     *
     * If an inventory open event is cancelled, the inventory screen will not show.
     *
     * @param cancel true if you wish to cancel this event
     */
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}
