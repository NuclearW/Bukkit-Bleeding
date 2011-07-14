package org.bukkit.inventory;

/**
 * Interface to the crafting inventories
 */
 
public interface InventoryCrafting extends Inventory {
    ItemStack getResult();
    ItemStack[] getMatrix();
    void setResult(ItemStack newResult);
    void setMatrix(ItemStack[] contents);
}