package org.bukkit.types;

import org.bukkit.types.block.BlockType;

/**
 * Represents an {@link ItemType} version of a {@link BlockType}.
 */
public class BlockItem extends ItemType {
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

    public static class BlockItemWrapper extends BlockItem {
        public BlockItemWrapper(int id) {
            super(id);
        }
    }
}
