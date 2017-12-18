package com.example.manep.androidphotontdd;

import com.example.manep.androidphotontdd.businesslogic.Matrix_creation;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    Matrix_creation object =new Matrix_creation();
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test()  {

        object.sizeOfMatrix(5, 6);
        String[] x={
                "3","4","1","2","8","6",
                "6","1","8","2","7","4",
                "5","9","3","9","9","5",
                "8","4","1","3","2","6",
                "3","7","2","8","6","4"
        };

        try {

            assertEquals("good",object.setEelementsInMatrix(x));
            object.setEelementsInMatrix(x);
            // fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {


        }

        object.path_weight();
        // having full path
        assertEquals("yes",object.havingFullpath());
        // cost
        assertEquals("17",object.getCost());
        // path
        assertEquals("1,2,1,1,5,5,",object.getpath());



    }

    @Test
    public void test2()  {

        object.sizeOfMatrix(5,6);
        String[] x={"3", "4", "1", "2", "8", "6",
                "6","1", "8", "2", "7", "4",
                "5", "9", "3", "9", "9", "5",
                "8", "4", "1", "3", "2","6",
                "3", "7","2", "1", "2", "3" };

        try {

            assertEquals("good",object.setEelementsInMatrix(x));

            // fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {


        }

        object.path_weight();
        // having full path
        assertEquals("yes",object.havingFullpath());
        // cost
        assertEquals("11",object.getCost());
        // path
        assertEquals("1,1,1,1,1,1,",object.getpath());

    }

    @Test
    public void test3()  {

        object.sizeOfMatrix(3,5);
        String[] x={"19", "10", "19", "10", "19",
                "21", "23", "20", "19", "12",
                "20", "12", "20", "11", "10"};

        try {
            assertEquals("good",object.setEelementsInMatrix(x));
            // fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {


        }
        object.path_weight();
        // having full path
        assertEquals("yes",object.havingFullpath());
        // cost
        assertEquals("68",object.getCost());
        // path
        assertEquals("1,1,1,1,3,",object.getpath());
    }


    @Test
    public void test4()  {

        object.sizeOfMatrix(1,5);
        String[] x={"5","8","5","3","5"};

        try {
            assertEquals("good",object.setEelementsInMatrix(x));
            // fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {


        }

        object.path_weight();

        // having full path
        assertEquals("yes",object.havingFullpath());
        // cost
        assertEquals("26",object.getCost());
        // path
        assertEquals("1,1,1,1,1,",object.getpath());
    }

    @Test
    public void test5()  {

        object.sizeOfMatrix(5,1);
        String[] x={"5",
                "8",
                "5",
                "3",
                "5"};

        try {
            assertEquals("good",object.setEelementsInMatrix(x));
            // fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {


        }

        object.path_weight();

        // having full path
        assertEquals("yes",object.havingFullpath());
        // cost
        assertEquals("3",object.getCost());
        // path
        assertEquals("4,",object.getpath());
    }

    @Test
    public void test6()  {

        object.sizeOfMatrix(3,3);
        String[] x={"5","4","H" ,
                "8", "M","7" ,
                "5","7","5"};

        try {
            assertEquals("Invalid Matrix",object.setEelementsInMatrix(x));
            // fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {


        }
    }


    @Test
    public void test11()  {

        object.sizeOfMatrix(4,2);
        String[] x={"51", "51",
                "10", "51",
                "51", "51",
                "5", "5"};

        try {
            assertEquals("good",object.setEelementsInMatrix(x));
            // fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {


        }

        object.path_weight();
        // having full path
        assertEquals("yes",object.havingFullpath());
        // cost
        assertEquals("10",object.getCost());
        // path
        assertEquals("4,4,",object.getpath());
    }

    @Test
    public void test13()  {

        object.sizeOfMatrix(2,20);
        String[] x={"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
                "2", "2", "2", "2", "2", "2","2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2",
        };

        try {
            assertEquals("good",object.setEelementsInMatrix(x));
            // fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {


        }
        object.path_weight();
        // having full path
        assertEquals("yes",object.havingFullpath());
        // cost
        assertEquals("20",object.getCost());
        // path
        assertEquals("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,",object.getpath());
    }



}