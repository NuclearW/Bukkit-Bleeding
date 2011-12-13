package org.bukkit.entity;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.Permissible;

/**
 * Represents a human entity, such as an NPC or a player
 */
public interface HumanEntity extends LivingEntity, AnimalTamer, Permissible {

    /**
     * Returns the name of this player
     *
     * @return Player name
     */
    public String getName();

    /**
     * Get the player's inventory.
     *
     * @return The inventory of the player, this also contains the armor slots.
     */
    public PlayerInventory getInventory();
    
    /**
     * Gets the inventory view the player is currently viewing. If they do not have
     * an inventory window open, it returns their internal crafting view.
     * @return The inventory view.
     */
    public InventoryView getOpenInventory();
    
    /**
     * Opens an inventory window with the specified inventory on the top and the player's inventory
     * on the bottom.
     * @param inventory The inventory to open
     * @return The newly opened inventory view
     */
    public InventoryView openInventory(Inventory inventory);
    
    /**
     * Opens an empty workbench inventory window with the player's inventory on the bottom.
     * @param location The location to attach it to. If null, the player's location is used.
     * @param force If false, and there is no workbench block at the location, no inventory will be
     * opened and null will be returned.
     * @return The newly opened inventory view, or null if it could not be opened.
     */
    public InventoryView openWorkbench(Location location, boolean force);
    
    /**
     * Opens an inventory window to the specified inventory view
     * @param inventory The view to open
     */
    public void openInventory(InventoryView inventory);
    
    /**
     * Force-closes the currently open inventory view for this player, if any.
     */
    public void closeInventory();

    /**
     * Returns the ItemStack currently in your hand, can be empty.
     *
     * @return The ItemStack of the item you are currently holding.
     */
    public ItemStack getItemInHand();

    /**
     * Sets the item to the given ItemStack, this will replace whatever the
     * user was holding.
     *
     * @param item The ItemStack which will end up in the hand
     */
    public void setItemInHand(ItemStack item);

    /**
     * Changes the item in hand to another of your 'action slots'.
     *
     * @param index The new index to use, only valid ones are 0-8.
     *
     public void selectItemInHand(int index);
     */

    /**
     * Returns whether this player is slumbering.
     *
     * @return slumber state
     */
    public boolean isSleeping();

    /**
     * Get the sleep ticks of the player. This value may be capped.
     *
     * @return slumber ticks
     */
    public int getSleepTicks();

    /**
     * Gets this humans current {@link GameMode}
     *
     * @return Current game mode
     */
    public GameMode getGameMode();

    /**
     * Sets this humans current {@link GameMode}
     *
     * @param mode New game mode
     */
    public void setGameMode(GameMode mode);
}
