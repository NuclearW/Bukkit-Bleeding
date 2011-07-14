package org.bukkit.event.inventory;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Event.Type;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryTransaction;
import org.bukkit.inventory.ItemStack;

public class InventoryCraftEvent extends InventoryClickEvent {

    public InventoryCraftEvent(InventoryTransaction what, Player whosePack, InventorySlotType type, ItemStack inSlot, ItemStack onCursor, boolean isRightClick, List<Player> members) {
        super(/*Type.INVENTORY_CRAFT, */what, whosePack, type, inSlot, onCursor, isRightClick, 0);
    }

}
