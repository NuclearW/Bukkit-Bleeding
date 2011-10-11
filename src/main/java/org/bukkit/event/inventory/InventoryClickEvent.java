package org.bukkit.event.inventory;

import org.bukkit.inventory.InventoryView;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.ItemStack;

public class InventoryClickEvent extends InventoryEvent implements Cancellable {
    private InventorySlotType slot_type;
    private boolean rightClick, shiftClick;
    private Result result;
    private int whichSlot;
    private int rawSlot;

    public InventoryClickEvent(InventoryView what, InventorySlotType type, int slot, boolean right, boolean shift) {
        super(Type.INVENTORY_CLICK, what);
        this.slot_type = type;
        this.rightClick = right;
        this.shiftClick = shift;
        this.result = Result.DEFAULT;
        this.rawSlot = slot;
        this.whichSlot = what.convertSlot(slot);
    }

    public InventorySlotType getSlotType() {
        return slot_type;
    }
    
    public ItemStack getCursor() {
        return getView().getCursor();
    }
    
    public ItemStack getCurrentItem() {
        return getView().getItem(rawSlot);
    }
    
    public boolean isRightClick() {
        return rightClick;
    }
    
    public boolean isLeftClick() {
        return !rightClick;
    }
    
    public boolean isShiftClick() {
        return shiftClick;
    }
    
    public void setResult(Result newResult) {
        result = newResult;
    }
    
    public Result getResult() {
        return result;
    }
    
    public HumanEntity getWhoClicked() {
        return getView().getPlayer();
    }
    
    public void setCursor(ItemStack what) {
        getView().setCursor(what);
    }
    
    public void setCurrentItem(ItemStack what) {
        getView().setItem(rawSlot, what);
    }

    public boolean isCancelled() {
        return result == Result.DENY;
    }

    public void setCancelled(boolean toCancel) {
        result = toCancel ? Result.DENY : Result.ALLOW;
    }
    
    public int getSlot() {
        return whichSlot;
    }
    
    public int getRawSlot() {
        return rawSlot;
    }
}
