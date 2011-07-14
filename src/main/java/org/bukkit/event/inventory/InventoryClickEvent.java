package org.bukkit.event.inventory;

import java.util.List;

import org.bukkit.inventory.InventoryTransaction;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event.Result;
import org.bukkit.event.Event.Type;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClickEvent extends InventoryEvent implements Cancellable {
    private InventorySlotType slot_type;
    private ItemStack cursor, slot;
    private boolean right;
    private Player who;
    private Result result;
    private boolean cancel;
    private int whichSlot;

    public InventoryClickEvent(InventoryTransaction what, Player whosePack, InventorySlotType type, ItemStack inSlot, ItemStack onCursor, boolean isRightClick, int slot) {
        super(Type.INVENTORY_CLICK, what);
        this.slot_type = type;
        this.cursor = onCursor;
        this.slot = inSlot;
        this.right = isRightClick;
        this.who = whosePack;
        this.result = Result.DEFAULT;
        this.cancel = false;
        this.whichSlot = convertSlot(slot);
    }

    public InventorySlotType getSlotType() {
        return slot_type;
    }
    
    public ItemStack getCursor() {
        return cursor;
    }
    
    public ItemStack getCurrentItem() {
        return slot;
    }
    
    public boolean isRightClick() {
        return right;
    }
    
    public void setResult(Result newResult) {
        result = newResult;
    }
    
    public Result getResult() {
        return result;
    }
    
    public Player getWhoClicked() {
        return this.who;
    }
    
    public void setCursor(ItemStack what) {
        this.cursor = what;
    }
    
    public void setCurrentItem(ItemStack what) {
        this.slot = what;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean toCancel) {
        cancel = toCancel;
    }
    
    public int getSlot() {
        return whichSlot;
    }

    private int convertSlot(int slot) {
        Inventory cInv = getInventory();
        Inventory pInv = getWhoClicked().getInventory();
        if(slot < cInv.getSize()) { // It's in the container inventory
            return slot;
        } else { // It's in the player inventory
            int size = cInv.getSize();
            if(getTransaction().getType() == InventoryType.CRAFTING) {
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
