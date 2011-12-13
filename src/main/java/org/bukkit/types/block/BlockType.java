package org.bukkit.types.block;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the various types of blocks in a world.
 */
public abstract class BlockType {
    public static final BlockType AIR = new BlockTypeWrapper(0);
    public static final BlockType STONE = new BlockTypeWrapper(1);
    // ....

    private static final int MAX_BLOCK_TYPES = 256;
    private static final BlockType[] types = new BlockType[MAX_BLOCK_TYPES];
    private static final Map<String, BlockType> aliases = new HashMap<String, BlockType>(MAX_BLOCK_TYPES);
    private static boolean acceptingRegs = true;
    private final int id;

    public BlockType(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of this BlockType.
     *
     * @return ID of this BlockType.
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof BlockType) {
            BlockType other = (BlockType)obj;
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
     * Attempts to register a given BlockType.
     *
     * @param type Type to register.
     * @throws IllegalArgumentException Thrown if type is null.
     * @throws IllegalArgumentException Thrown is a BlockType is already registered with the same ID as the passed type.
     */
    public static void registerBlock(BlockType type) {
        if (type == null) {
            throw new IllegalArgumentException("Cannot register a null type");
        } else if (types[type.getId()] != null) {
            throw new IllegalArgumentException("A BlockType with the id " + type.getId() + " already exists!");
        } else if (!acceptingRegs) {
            throw new IllegalStateException("Block type registrations are not being accepted at this time");
        }

        types[type.getId()] = type;
    }

    /**
     * Stops this class from accepting any further BlockType registrations.
     */
    public static void stopAcceptingRegistrations() {
        acceptingRegs = false;
    }

    /**
     * Checks if this class is accepting new BlockType registrations.
     *
     * @return True if you can call {@link #registerBlock(org.bukkit.types.block.BlockType)}.
     */
    public static boolean isAcceptingRegistrations() {
        return acceptingRegs;
    }

    /**
     * Gets a BlockType with the given ID.
     * <p>
     * This may return null if no BlockType is registered with the given ID.
     *
     * @param id ID to retrieve.
     * @return BlockType with the given ID, or null.
     */
    public static BlockType get(int id) {
        return (id < 0 || id >= MAX_BLOCK_TYPES) ? null : types[id];
    }

    /**
     * Gets a BlockType with the given name or alias.
     * <p>
     * This may return null if no BlockType is registered with the given name.
     *
     * @param name Name of the block to retrieve.
     * @return BlockType with the given ID, or null.
     */
    public static BlockType get(String name) {
        return aliases.get(name);
    }
}
