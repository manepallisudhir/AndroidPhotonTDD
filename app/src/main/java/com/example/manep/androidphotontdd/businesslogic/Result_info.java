package com.example.manep.androidphotontdd.businesslogic;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by manep on 12/17/2017.
 */

public class Result_info implements Comparator<Result_info> {

    private ArrayList<Node_info> all_nodes;

    public ArrayList<Node_info> getAll_nodes() {
        return all_nodes;
    }

    public void setAll_nodes(ArrayList<Node_info> all_nodes) {
        this.all_nodes = all_nodes;
    }


    public Integer Total_cost()
    {

        Integer cost_val=0;
        for (int i=0;i<this.all_nodes.size();i++)
            cost_val=cost_val+all_nodes.get(i).getVal_node();

        return cost_val;

    }

    public String row_path()
    {

        int[] row_path=new int[Matrix_creation.size_column];
        for (int i=0;i<this.all_nodes.size();i++)
            if(all_nodes.get(i).getCol_node()==i)
                row_path[i]=(all_nodes.get(i).getRow_node());

        StringBuilder s=new StringBuilder();
        for(int c:row_path)
            s.append(c+1).append(",");


        return s.toString();

    }


    public boolean path_travel()
    {
        return (this.all_nodes.size()==Matrix_creation.size_column);
    }

    @Override
    public int compare(Result_info o1, Result_info o2) {
        // TODO Auto-generated method stub
        return o1.Total_cost().compareTo(o2.Total_cost());
    }





}