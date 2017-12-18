package com.example.manep.androidphotontdd.businesslogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by manep on 12/17/2017.
 */

public class Matrix_creation {

    static int  size_row,size_column;
    int[][] matrix;
    ArrayList<Node_info> rwo_travelsal;
    ArrayList<Result_info> final_list;

    public String[] reult=new String[3];



    public void sizeOfMatrix(int m,int n)
    {
        size_row=m;
        size_column=n;
        matrix=new int[m][n];
        final_list=new ArrayList<Result_info>();
    }

    public String setEelementsInMatrix(String[] x)
    {if(size_column*size_row==x.length)
    {
        int in_posi=0;
        for(int i=0;i<size_row;i++)
        {
            for (int j=0;j<size_column;j++)
            {
                try
                {

                    matrix[i][j]=Integer.parseInt(x[in_posi]);

                }catch (NumberFormatException e)
                {

                    return "Invalid Matrix";
                }

                ++in_posi;

            }
        }

    }else
    {
        return "Not well matrix";

    }

        return "good";
    }

    public void display_matrix()
    {
        for (int i=0; i<size_row; i++){
            for (int j =0; j<size_column; j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println("\n");
        }
    }

    public String path_weight() {


        findSmallestOneColumn(0);

        // find the finest path


        ArrayList<Result_info> final_list_t=new  ArrayList<>();
        for (int i=0;i<final_list.size();i++)
        {
            boolean flag_test=false;
            Result_info r_info=final_list.get(i);

            ArrayList<Result_info> test_path=new ArrayList<>();
            Result_info total_paths =new Result_info();



            ArrayList<Node_info> patha_list=new ArrayList<>();

            for(int j=0;j<r_info.getAll_nodes().size();j++)
            {
                flag_test=true;

                Node_info nod=new Node_info(
                        r_info.getAll_nodes().get(j).getRow_node(),
                        r_info.getAll_nodes().get(j).getCol_node(),
                        r_info.getAll_nodes().get(j).getVal_node());
                patha_list.add(nod);

                if(size_column-1!=0)
                {
                    if(r_info.getAll_nodes().get(j).getCol_node()/(size_column-1)==1)
                    {
                        total_paths.setAll_nodes(patha_list);
                        final_list_t.add(total_paths);
                        test_path.add(total_paths);
                        patha_list=new ArrayList<>();
                        total_paths =new Result_info();

                    }
                }else
                {

                    total_paths.setAll_nodes(patha_list);
                    final_list_t.add(total_paths);
                    test_path.add(total_paths);
                    patha_list=new ArrayList<>();
                    total_paths =new Result_info();


                }


               				/*do
               				{

               					System.out.println(""+r_info.getAll_nodes().get(j).getCol_node());
               				}while(r_info.getAll_nodes().get(j).getCol_node()/(size_column-1)==1);*/





            }

            if(flag_test)
            {
                for(int w=1;w<test_path.size();w++)
                {
                    Result_info r=test_path.get(w);

                    if(test_path.get(0).getAll_nodes().size()-r.getAll_nodes().size()!=0)
                    {

                        r.getAll_nodes().addAll(test_path.get(0).getAll_nodes().subList(0, test_path.get(0).getAll_nodes().size()-r.getAll_nodes().size()));

                    }



                }


            }






        }

        int[] all_cost=new int[final_list_t.size()];
        String[] cors_index=new String[final_list_t.size()];
        Collections.sort(final_list_t,new Result_info());
        // shortest path and it path
        reult[0]="yes";
        reult[1]=final_list_t.get(0).Total_cost()+"";
        reult[2]=final_list_t.get(0).row_path();


        return "Full path: Yes"+"\n Total Cost: "+final_list_t.get(0).Total_cost()+"\n Travel Path: "+final_list_t.get(0).row_path();







    }



    private int findSmallestOneColumn(int colum)
    {
        int small_val=matrix[0][colum];
        int smallest_row=0;
        int smallest_column=colum;


        for(int i=0;i<size_row;i++)
        {
            if(small_val>matrix[i][colum])
            {
                small_val=matrix[i][colum];
                smallest_row=i;
                smallest_column=colum;
            }

        }


        for(int i=0;i<size_row;i++)
        {
            if(small_val==matrix[i][colum])
            {

                Result_info result=new Result_info();
                rwo_travelsal=new ArrayList<Node_info> ();





                System.out.print("\n");
                System.out.print("Values are "+i+"\t"+colum+"\t"+ small_val);
                System.out.print("\n");


                addElementToResult(i,colum,small_val);
                findShortPath(i, colum,small_val);

                result.setAll_nodes(rwo_travelsal);

                final_list.add(result);












            }


        }




        return small_val;



    }

    int value=0;
    private void findShortPath(int row,int colu,int prev)
    {

        value=+prev;

        int x,y,z;
        if(colu<size_column-1)
        {
            colu=colu+1;
            int row_top =row-1;
            int row_dow=row+1;




            x=matrix[row][colu]+prev; // middle_element

            if(row_top<0)
                row_top=size_row-1;
            y=matrix[row_top][colu]+prev;// top element

            if(row_dow>size_row-1)
                row_dow=0;


            z=matrix[row_dow][colu]+prev;// bottom element


            String[] test=ChooseSmallestElement(row ,row_top,row_dow,colu);









        }




    }

    // increment column..
    // find three elements..
    // find the smallest element..


    private String[] ChooseSmallestElement(int row , int rowtop, int row_dow,int colu)
    {

        Stack<String> find_small_stack=new Stack<String>();

        int small_value = 0;

        String[] row_colu=new String[size_row];

        System.out.println("X---->"+matrix[row][colu]);
        System.out.println("Y---->"+matrix[rowtop][colu]);
        System.out.println("Z---->"+matrix[row_dow][colu]);



        if(matrix[row][colu]<matrix[rowtop][colu]&&matrix[row][colu]<matrix[row_dow][colu])
        {
            // smallest x
            small_value=matrix[row][colu];

            // but y,z same
            if(matrix[rowtop][colu]==matrix[row_dow][colu])
            {
                //y=z
                row_colu[0]=row+","+colu;
                find_small_stack.push(row_colu[0]);

            }else
            {
                row_colu[0]=row+","+colu;
                find_small_stack.push(row_colu[0]);
            }



        }else if(matrix[rowtop][colu]<matrix[row_dow][colu])
        {
            // small y
            small_value=matrix[rowtop][colu];

            if(matrix[row][colu]==matrix[row_dow][colu])
            {
                // x=z
                row_colu[0]=row+","+colu;
                row_colu[1]=row_dow+","+colu;
                find_small_stack.push(row_colu[0]);
                find_small_stack.push(row_colu[1]);
            }else if(matrix[row][colu]==matrix[rowtop][colu])
            {
                //y=x
                row_colu[0]=row+","+colu;
                row_colu[1]=rowtop+","+colu;
                find_small_stack.push(row_colu[0]);
                find_small_stack.push(row_colu[1]);
            }else
            {

                row_colu[0]=rowtop+","+colu;
                find_small_stack.push(row_colu[0]);
            }

        }else if(matrix[row_dow][colu]<matrix[rowtop][colu])
        {
            //small z

            small_value=matrix[row_dow][colu];
            if(matrix[rowtop][colu]==matrix[row][colu])
            {
                //y=z
                row_colu[0]=rowtop+","+colu;
                row_colu[1]=row+","+colu;
                find_small_stack.push(row_colu[0]);
                find_small_stack.push(row_colu[1]);
            }
            else if(matrix[row_dow][colu]==matrix[row][colu])
            {
                row_colu[0]=row_dow+","+colu;
                row_colu[1]=row+","+colu;
                find_small_stack.push(row_colu[0]);
                find_small_stack.push(row_colu[1]);
            }
            else
            {
                row_colu[0]=row_dow+","+colu;
                find_small_stack.push(row_colu[0]);

            }




        }else if(matrix[row_dow][colu]==matrix[rowtop][colu])
        {

            small_value=matrix[row_dow][colu];
            row_colu[0]=rowtop+","+colu;
            if(row_colu.length>1)
                row_colu[1]=row_dow+","+colu;


            find_small_stack.push(row_colu[0]);
            if(row_colu.length>1)
                find_small_stack.push(row_colu[1]);

        }else if(matrix[row_dow][colu]==matrix[rowtop][colu]&&matrix[rowtop][colu]==matrix[row][colu])

        {
            // x=y=z;

            small_value=matrix[row_dow][colu];
            row_colu[0]=row+","+colu;
            row_colu[1]=rowtop+","+colu;
            row_colu[2]=row_dow+","+colu;

            find_small_stack.push(row_colu[0]);
            find_small_stack.push(row_colu[1]);
            find_small_stack.push(row_colu[2]);


        }else
        {

        }


        System.out.println("Small value---->"+small_value);

        if(find_small_stack.size()>0)
        {


            for(int i=0;i<3;i++)
            {
                if(find_small_stack.size()>0)
                {
                    System.out.println("Before Statck POP"+find_small_stack);
                    String s=find_small_stack.pop();
                    System.out.println(Integer.parseInt(s.split(",")[0])+" Stack pop"+Integer.parseInt(s.split(",")[1]));
                    addElementToResult(Integer.parseInt(s.split(",")[0]),Integer.parseInt(s.split(",")[1]),small_value);
                    findShortPath(Integer.parseInt(s.split(",")[0]), Integer.parseInt(s.split(",")[1]), small_value);

                    if(Integer.parseInt(s.split(",")[1])==(size_column-1))

                        System.out.println("\n\n");


                }

            }





        }
        else
        {
            for(String s:row_colu)
            {

                if(s!=null)
                {
                    findShortPath(Integer.parseInt(s.split(",")[0]), Integer.parseInt(s.split(",")[1]), small_value);



                }

            }
        }
        return row_colu;

        // find equal values ....





    }


    private void addElementToResult(int row,int col,int result)
    {
        // shortest element to result set

        Node_info n=new Node_info(row, col, result);

        rwo_travelsal.add(n);


    }


    public String havingFullpath()
    {
        return reult[0];
    }
    public String getCost()
    {
        System.out.print("------->"+reult[1]);
        return reult[1];
    }
    public String getpath()
    {
        System.out.print("kznknzvkvzkk.s"+reult[2]);
        return reult[2];
    }

}