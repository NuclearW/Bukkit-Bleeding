package org.bukkit.types.item;

import org.bukkit.types.block.BlockType;

/**
 * Represents an {@link ItemType} version of a {@link BlockType}.
 */
public abstract class BlockItem extends ItemType {
    public BlockItem(BlockType block) {
        super(block.getId());
    }

    public BlockItem(int id) {
        super(id);
    }

    @Override
    public String getName() {
        return getBlockType().getName();
    }

    /**
     * Gets the {@link BlockType} that this item represents.
     *
     * @return Represented BlockType.
     */
    public BlockType getBlockType() {
        return BlockType.get(getId());
    }

    public static class Wrapper extends BlockItem {
        public Wrapper(int id) {
            super(id);
        }
        
        public BlockItem getHandle() {
            return (BlockItem)ItemType.get(getId());
        }

        @Override
        public int getMaxUses() {
            return getHandle().getMaxUses();
        }

        @Override
        public void setMaxUses(int uses) {
            getHandle().setMaxUses(uses);
        }
    }
}
