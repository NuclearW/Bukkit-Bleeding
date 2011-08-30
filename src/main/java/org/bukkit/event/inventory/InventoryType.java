package org.bukkit.event.inventory;

public enum InventoryType {
    /**
     * A chest inventory, with 0, 9, 18, 27, 36, 45, or 54 slots of type CONTAINER.
     */
    CHEST(27),
    /**
     * A dispenser inventory, with 9 slots of type CONTAINER.
     */
    DISPENSER(9),
    /**
     * A furnace inventory, with a RESULT slot, a CRAFTING slot, and a FUEL slot.
     */
    FURNACE(3),
    /**
     * A workbench inventory, with 9 CRAFTING slots and a RESULT slot.
     */
    WORKBENCH(10),
    /**
     * A player's crafting inventory, with 4 CRAFTING slots and a RESULT slot. Also implies that the
     * 4 ARMOR slots are accessible.
     */
    CRAFTING(5),
    /**
     * A player's inventory, with 9 QUICKBAR slots, 27 CONTAINER slots, and 4 ARMOR slots. The
     * ARMOUR slots may not be accessible, though.
     */
    PLAYER(36);
    private int size;
    
    private InventoryType(int defaultSize) {
        size = defaultSize;
    }
    
    public int getDefaultSize() {
        return size;
    }
}
