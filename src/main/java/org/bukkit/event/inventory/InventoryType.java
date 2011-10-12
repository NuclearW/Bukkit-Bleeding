package org.bukkit.event.inventory;

public enum InventoryType {
    /**
     * A chest inventory, with 0, 9, 18, 27, 36, 45, or 54 slots of type CONTAINER.
     */
    CHEST(27,"Chest"),
    /**
     * A dispenser inventory, with 9 slots of type CONTAINER.
     */
    DISPENSER(9,"Dispenser"),
    /**
     * A furnace inventory, with a RESULT slot, a CRAFTING slot, and a FUEL slot.
     */
    FURNACE(3,"Furnace"),
    /**
     * A workbench inventory, with 9 CRAFTING slots and a RESULT slot.
     */
    WORKBENCH(10,"Crafting"),
    /**
     * A player's crafting inventory, with 4 CRAFTING slots and a RESULT slot. Also implies that the
     * 4 ARMOR slots are accessible.
     */
    CRAFTING(5,"Crafting"),
    /**
     * A player's inventory, with 9 QUICKBAR slots, 27 CONTAINER slots, and 4 ARMOR slots. The
     * ARMOUR slots may not be accessible, though.
     */
    PLAYER(36,"Player"),
    /**
     * The creative mode inventory, with only 9 QUICKBAR slots and nothing else. (The actual
     * creative interface with the items is client-side and cannot be altered by the server.)
     */
    CREATIVE(9,"Creative");
    private final int size;
    private final String title;
    
    private InventoryType(int defaultSize, String defaultTitle) {
        size = defaultSize;
        title = defaultTitle;
    }
    
    public int getDefaultSize() {
        return size;
    }

    public String getDefaultTitle() {
        return title;
    }
    
    public enum SlotType {
        /**
         * A result slot in a furnace or crafting inventory.
         */
        RESULT,
        /**
         * A slot in the crafting matrix, or the input slot in a furnace inventory.
         */
        CRAFTING,
        /**
         * An armour slot in the player's inventory.
         */
        ARMOR,
        /**
         * A regular slot in the container or the player's inventory; anything not covered
         * by the other enum values.
         */
        CONTAINER,
        /**
         * A slot in the bottom row or quickbar.
         */
        QUICKBAR,
        /**
         * A slot in the bottom row or quickbar in the creative mode item selection screen.
         */
        CREATIVE,
        /**
         * A pseudo-slot representing the area outside the inventory window.
         */
        OUTSIDE,
        /**
         * The fuel slot in a furnace inventory.
         */
        FUEL;
    }
}
