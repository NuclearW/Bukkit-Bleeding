package org.bukkit.types.item;

import org.bukkit.types.block.BlockType;

/**
 * Represents an {@link ItemType} version of a {@link BlockType}.
 */
public interface BlockItem extends ItemType {
    /**
     * Gets the {@link BlockType} that this item represents.
     *
     * @return Represented BlockType.
     */
    public BlockType getBlockType();

    public static class Wrapper extends ItemWrapper implements BlockItem {
        public Wrapper(int id) {
            super(id);
        }

        @Override
        public BlockItem getHandle() {
            return (BlockItem)super.getHandle();
        }

        public BlockType getBlockType() {
            return getHandle().getBlockType();
        }
    }
}
