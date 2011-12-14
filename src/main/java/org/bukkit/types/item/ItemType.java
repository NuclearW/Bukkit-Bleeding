package org.bukkit.types.item;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the various type of Items in the game, that may be held by players
 */
public abstract class ItemType {
    public static final BlockItem STONE = new BlockItem.Wrapper(1);
    public static final BlockItem GRASS = new BlockItem.Wrapper(2);
    // ....

    public static final ItemType IRON_SHOVEL = new ItemWrapper(256);
    public static final ItemType IRON_PICKAXE = new ItemWrapper(257);
    public static final ItemType IRON_AXE = new ItemWrapper(258);
    public static final ItemSword IRON_SWORD = new ItemSword.Wrapper(267);
    // ....

    private static final int MAX_ITEM_TYPES = 32000;
    private static final ItemType[] types = new ItemType[MAX_ITEM_TYPES];
    private static final Map<String, ItemType> aliases = new HashMap<String, ItemType>(MAX_ITEM_TYPES);
    private static boolean acceptingRegs = true;
    private final int id;

    public ItemType(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of this ItemType.
     *
     * @return ID of this ItemType.
     */
    public final int getId() {
        return id;
    }

    /**
     * Gets a human readable name of this block.
     *
     * @return Human readable block name.
     */
    public abstract String getName();

    /**
     * Gets the maximum amount of times this item may be used before breaking.
     * <p>
     * This may be 0, in which case the item will never break.
     *
     * @return Maximum amount of times this item can be used, or 0 for infinite
     */
    public abstract int getMaxUses();

    /**
     * Sets the maximum amount of times this item may be used before breaking.
     * <p>
     * This may be 0, in which case the item will never break.
     *
     * @param uses Maximum amount of times this item can be used, or 0 for infinite
     * @throws IllegalArgumentException Thrown if uses < 0
     */
    public abstract void setMaxUses(int uses);

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof ItemType) {
            ItemType other = (ItemType)obj;
            if (this.getId() == other.getId()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        return hash;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + id + ", " + getName() + "]";
    }


    // Statics after yonder!


    /**
     * Attempts to register a given ItemType.
     *
     * @param type Type to register.
     * @throws IllegalArgumentException Thrown if type is null.
     * @throws IllegalArgumentException Thrown is a ItemType is already registered with the same ID as the passed type.
     */
    public static void registerItem(ItemType type) {
        if (type == null) {
            throw new IllegalArgumentException("Cannot register a null type");
        } else if (types[type.getId()] != null) {
            throw new IllegalArgumentException("An ItemType with the id " + type.getId() + " already exists!");
        } else if (!acceptingRegs) {
            throw new IllegalStateException("Item type registrations are not being accepted at this time");
        }

        types[type.getId()] = type;
    }

    /**
     * Stops this class from accepting any further ItemType registrations.
     */
    public static void stopAcceptingRegistrations() {
        acceptingRegs = false;
    }

    /**
     * Checks if this class is accepting new ItemType registrations.
     *
     * @return True if you can call {@link #registerBlock(org.bukkit.types.item.ItemType)}.
     */
    public static boolean isAcceptingRegistrations() {
        return acceptingRegs;
    }

    /**
     * Gets an ItemType with the given ID.
     * <p>
     * This may return null if no ItemType is registered with the given ID.
     *
     * @param id ID to retrieve.
     * @return ItemType with the given ID, or null.
     */
    public static ItemType get(int id) {
        return (id < 0 || id >= MAX_ITEM_TYPES) ? null : types[id];
    }

    /**
     * Gets a ItemType with the given name or alias.
     * <p>
     * This may return null if no ItemType is registered with the given name.
     *
     * @param name Name of the item to retrieve.
     * @return ItemType with the given ID, or null.
     */
    public static ItemType get(String name) {
        return aliases.get(name);
    }
}
