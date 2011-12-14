package org.bukkit.types.item;

/**
 * Represents a sword item, that may be used to harm other entities
 */
public abstract class ItemSword extends ItemType {
    public ItemSword(int id) {
        super(id);
    }

    /**
     * Gets the damage that this item will inflict upon an entity.
     *
     * @return Damage that this sword will create.
     */
    public abstract int getDamage();

    /**
     * Sets the damage that this sword will inflict upon an entity.
     *
     * @param damage New damage that this will cause.
     * @throws IllegalArgumentException Thrown if damage < 0
     */
    public abstract void setDamage(int damage);

    public static class Wrapper extends ItemSword {
        public Wrapper(int id) {
            super(id);
        }

        public ItemSword getHandle() {
            return (ItemSword)ItemType.get(getId());
        }

        @Override
        public int getDamage() {
            return getHandle().getDamage();
        }

        @Override
        public void setDamage(int damage) {
            getHandle().setDamage(damage);
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
}
