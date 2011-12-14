package org.bukkit.types.item;

/**
 * A wrapper class for {@link Item}s to point towards any registered Item with a given ID
 */
public class ItemWrapper extends ItemType {
    public ItemWrapper(int id) {
        super(id);
    }

    public ItemType getHandle() {
        return ItemType.get(getId());
    }

    @Override
    public String getName() {
        return getHandle().getName();
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
