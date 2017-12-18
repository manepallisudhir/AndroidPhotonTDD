package com.example.manep.androidphotontdd;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.manep.androidphotontdd.businesslogic.Matrix_creation;


public class MainActivity extends AppCompatActivity {

    TableLayout tl;
    TextView result_t;
    EditText row_e, col_e;
    Button btn, get_result;
    String[][] matrix;
    int row_val, col_val;
    Matrix_creation object = new Matrix_creation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matrix_creation);

        tl = (TableLayout) findViewById(R.id.matrix);
        row_e = (EditText) findViewById(R.id.row);
        col_e = (EditText) findViewById(R.id.col);
        btn = (Button) findViewById(R.id.gen);
        get_result = (Button) findViewById(R.id.get_result);
        get_result.setVisibility(View.GONE);
        result_t = (TextView) findViewById(R.id.results);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tl.removeAllViewsInLayout();

                if (!row_e.getText().toString().equals("") && !col_e.getText().toString().equals("")) {
                    if (!row_e.getText().toString().equals("0") && !col_e.getText().toString().equals("0")) {

                        row_val = Integer.parseInt(row_e.getText().toString());
                        col_val = Integer.parseInt(col_e.getText().toString());
                        object.sizeOfMatrix(row_val, col_val);

                        matrix = new String[row_val][col_val];

                        get_result.setVisibility(View.VISIBLE);


                        for (int i = 0; i < row_val; i++) {
                            TableRow tableRow = new TableRow(MainActivity.this);

                            for (int j = 0; j < col_val; j++) {

                                final TextView t = new TextView(MainActivity.this);
                                t.setMinWidth(100);
                                t.setMinHeight(100);
                                t.setGravity(Gravity.CENTER);
                                t.setBackgroundResource(R.drawable.matrix_bg);
                                final int x = i;
                                final int y = j;
                                t.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        // dialog here

                                        // custom dialog
                                        final Dialog dialog = new Dialog(MainActivity.this);
                                        dialog.setContentView(R.layout.input_matrix);
                                        // set the custom dialog components - text, image and button
                                        TextView text = (TextView) dialog.findViewById(R.id.value_heading);
                                        text.setText("Enetr Value at : " + x + " , " + y);

                                        final EditText val_e = (EditText) dialog.findViewById(R.id.input_e);
                                        Button dialogButton = (Button) dialog.findViewById(R.id.set_node);

                                        Button cancel = (Button)dialog.findViewById(R.id.set_cancel);
                                        cancel.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                dialog.dismiss();
                                            }
                                        });
                                        // if button is clicked, close the custom dialog
                                        dialogButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                if (!val_e.getText().toString().equals("")) {
                                                    t.setText(val_e.getText().toString());
                                                    matrix[x][y] = val_e.getText().toString();
                                                    dialog.dismiss();
                                                }

                                            }
                                        });

                                        dialog.show();
                                    }
                                });
                                tableRow.addView(t, j);

                            }

                            tl.addView(tableRow);
                        }


                    }
                }


            }
        });

        get_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = 0;
                String[] elemnts = new String[row_val * col_val];


                for (int row = 0; row < row_val; row++) {
                    for (int col = 0; col < col_val; col++) {
                        if (matrix[row][col] != null) {

                            elemnts[count] = matrix[row][col];
                            ++count;
                        }
                    }
                }

                if (row_val * col_val == count) {
                    if (!object.setEelementsInMatrix(elemnts).equals("Invalid Matrix")) {

                        result_t.setText( object.path_weight());

                        // result_t.setText("Full path: " + object.havingFullpath() + "\n Total Cost " + object.getCost() + "\n Path" + object.getpath());
                    } else
                        result_t.setText("Invalid Matrix");


                } else
                    result_t.setText("Matrix is not well formatted");


            }
        });

    }
}
