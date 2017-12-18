package com.example.manep.androidphotontdd.businesslogic;

/**
 * Created by manep on 12/17/2017.
 */

public class Node_info {
    private int row_node;
    private int col_node;
    private int val_node;

    public Node_info(int ro,int co,int val) {

        this.row_node=ro;
        this.col_node=co;
        this.val_node=val;

    }

    public int getRow_node() {
        return (row_node);
    }

    public int getCol_node() {
        return col_node;
    }

    public int getVal_node() {
        return val_node;
    }

}