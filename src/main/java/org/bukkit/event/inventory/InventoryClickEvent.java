package org.bukkit.event.inventory;

import java.util.List;

import org.bukkit.inventory.InventoryView;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event.Result;
import org.bukkit.event.Event.Type;
import org.bukkit.inventory.Inventory;
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
    
    public Player getWhoClicked() {
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

    private int convertSlot(int slot) {
        Inventory cInv = getInventory();
        Inventory pInv = getWhoClicked().getInventory();
        rawSlot = slot;
        if(slot < cInv.getSize()) { // It's in the container inventory
            return slot;
        } else { // It's in the player inventory
            int size = cInv.getSize();
            if(getView().getType() == InventoryType.CRAFTING) {
                // Armour slot?
                switch(slot) {
                case 5: return 39;
                case 6: return 38;
                case 7: return 37;
                case 8: return 36;
                }
                size += 4;
            }
            slot -= size;
            if(slot >= 27) // Quickbar
                slot -= 27;
            else slot += 9;
            return slot;
        }
    }
}
