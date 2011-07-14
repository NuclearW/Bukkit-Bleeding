package org.bukkit.event.inventory;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Event.Type;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryTransaction;
import org.bukkit.inventory.ItemStack;

public class InventoryCraftEvent extends InventoryChangeEvent {
    ItemStack[][] matrix = new ItemStack[3][3];
    int width, height;

    public InventoryCraftEvent(InventoryTransaction what, ItemStack[][] recipe, ItemStack proposedResult) {
        super(Type.INVENTORY_CRAFT, what, proposedResult, null, 0, InventorySlotType.RESULT);
        for(int row = 0; row < recipe.length; row++)
            for(int item = 0; item < recipe.length; item++)
                if(row < 3 && item < 3)
                    matrix[row][item] = recipe[row][item];
        //pruneMatrix();
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public ItemStack[][] getRecipe() {
        return matrix;
    }
    
    private void pruneMatrix() {
        // check rows
        boolean[] takeRow = new boolean[] {true,true,true};
        int numRows = 0;
        for(int i = 0; i < 3; i++) {
            if(matrix[i][0] == null && matrix[i][1] == null && matrix [i][2] == null) {
                takeRow[i] = false;
                numRows++;
            }
        }
        ItemStack[][] rows = new ItemStack[numRows][];
        int n = 0;
        for(int i = 0; i < 3; i++) {
            if(takeRow[i]) {
                rows[n] = matrix[i];
                n++;
            }
        }
        // check columns
        boolean[] takeColumn = new boolean[] {true,true,true};
        int numColumns = 0;
        for(int i = 0; i < 3; i++) {
            if(matrix[0][i] == null && matrix[1][i] == null && matrix [2][i] == null) {
                takeColumn[i] = false;
                numColumns++;
            }
        }
        n = 0;
        for(int i = 0; i < 3; i++) {
            ItemStack[] thisRow = new ItemStack[numColumns];
            if(takeColumn[i]) {
                for(int j = 0; j < numRows; j++) {
                    thisRow[n] = rows[j][n];
                }
                n++;
            }
        }
        matrix = rows;
    }
}
