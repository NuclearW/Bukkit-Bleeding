package org.bukkit.event.inventory;

public enum InventorySlotType {
    RESULT(false), CRAFTING(false), ARMOR(true), CONTAINER(false), PACK(true), QUICKBAR(true), OUTSIDE(false), FUEL(true);
    private final boolean isPlayer;
    public boolean isPlayerSlot() {
        return isPlayer;
    }
    private InventorySlotType(boolean playerInv) {
        isPlayer = playerInv;
    }
}
