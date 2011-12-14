package org.bukkit.types.item;

import java.util.HashMap;
import java.util.Map;

/**
 * Represent the default {@link ItemType}s that may be found in the server
 */
public final class Items {
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
