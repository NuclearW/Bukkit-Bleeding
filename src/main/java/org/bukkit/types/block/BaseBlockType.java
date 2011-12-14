package org.bukkit.types.block;

/**
 * Base {@link ItemType} class
 */
public abstract class BaseBlockType implements BlockType {
    private final int id;

    public BaseBlockType(int id) {
        this.id = id;
    }

    public final int getId() {
        return id;
    }

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
}
