package org.bukkit.types.block;

/**
 * A wrapper class for {@link BlockType}s to point towards any registered BlockType with a given ID
 */
public class BlockTypeWrapper extends BlockType {
    public BlockTypeWrapper(int id) {
        super(id);
    }

    public BlockType getHandle() {
        return BlockType.get(getId());
    }

    @Override
    public String getName() {
        return getHandle().getName();
    }
}
