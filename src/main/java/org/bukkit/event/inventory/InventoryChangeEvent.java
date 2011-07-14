package org.bukkit.event.inventory;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event.Type;
import org.bukkit.inventory.InventoryTransaction;
import org.bukkit.inventory.ItemStack;

public class InventoryChangeEvent extends InventoryEvent implements Cancellable {
    private ItemStack before, after;
    private InventorySlotType slotType;
    private int slotNum;
    private boolean cancelled;

    public InventoryChangeEvent(InventoryTransaction what, ItemStack newStack, ItemStack oldStack, int slot, InventorySlotType type) {
        this(Type.INVENTORY_CHANGE, what, newStack, oldStack, slot, type);
    }

    public InventoryChangeEvent(Type evttype, InventoryTransaction what, ItemStack newStack, ItemStack oldStack, int slot, InventorySlotType type) {
        super(evttype, what);
        before = oldStack;
        after = newStack;
        slotNum = slot;
        slotType = type;
    }
    
    public ItemStack getOldItem() {
        return before;
    }
    
    public ItemStack getNewItem() {
        return after;
    }
    
    public void setNewItem(ItemStack newItem) {
        after = newItem;
    }
    
    public int getSlot() {
        return slotNum;
    }
    
    public InventorySlotType getSlotType() {
        return slotType;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}
