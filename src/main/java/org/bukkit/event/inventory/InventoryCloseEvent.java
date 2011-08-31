
package org.bukkit.event.inventory;

import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;

/**
 * Represents a player related inventory event
 */
public class InventoryCloseEvent extends InventoryEvent {
    protected Player who;
    public InventoryCloseEvent(Player player, InventoryView transaction) {
        super(Type.INVENTORY_CLOSE, transaction);
        this.who = player;
    }

    /**
     * Returns the player involved in this event
     * @return Player who is involved in this event
     */
    public final Player getPlayer() {
        return who;
    }
}
