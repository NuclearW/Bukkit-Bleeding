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

    @Override
    public void setLightEmission(int amount) {
        getHandle().setLightEmission(amount);
    }

    @Override
    public int getLightEmission() {
        return getHandle().getLightEmission();
    }

    @Override
    public void setLightBlock(int amount) {
        getHandle().setLightBlock(amount);
    }

    @Override
    public int getLightBlock() {
        return getHandle().getLightBlock();
    }
}
