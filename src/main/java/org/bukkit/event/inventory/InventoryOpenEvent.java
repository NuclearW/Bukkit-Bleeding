
package org.bukkit.event.inventory;

import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.block.Block;
import org.bukkit.inventory.InventoryView;
import org.bukkit.event.Cancellable;

/**
 * Represents a player related inventory event
 */
public class InventoryOpenEvent extends InventoryEvent implements Cancellable {
    protected Block block;
    protected Entity entity;
    protected HumanEntity who;
    private boolean cancelled;
    
    public InventoryOpenEvent(HumanEntity player, InventoryView transaction) {
        super(Type.INVENTORY_OPEN, transaction);
        this.cancelled = false;
        this.who = player;
    }
    
    public InventoryOpenEvent(HumanEntity player, InventoryView transaction, Block block) {
        this(player, transaction);
        this.block = block;
    }
    
    public InventoryOpenEvent(HumanEntity player, InventoryView transaction, Entity entity) {
        this(player, transaction);
        this.entity = entity;
    }
    
    /**
     * Gets the block belonging to the open inventory
     * @return A Block object that contains the inventory. Null if the inventory isn't block based.
     */
    public Block getBlock() {
        return this.block;
    }
    
    /**
     * Gets the entity belonging to the open inventory
     * @return An Entity object that contains the inventory. Null if the inventory isn't entity based.
     */
    public Entity getEntity() {
        return this.entity;
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
