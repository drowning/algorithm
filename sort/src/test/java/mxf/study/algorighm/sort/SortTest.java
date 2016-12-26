package mxf.study.algorighm.sort;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static mxf.study.algorighm.sort.Sorts.*;

/**
 * Created by maxiaofeng on 2016/12/17.
 */
public class SortTest {


    private static Integer[] data = {70, 87, 9, 94, 11, 9, 1, 61, 93, 9};

    @BeforeClass
    public static void beforeClass() {

        fillRandom(100);
        System.out.println("origin array: " + printArray(data));
    }

    @AfterClass
    public static void afterClass() {

        System.out.println("sorted array: " + printArray(data));
    }

    private static void fillRandom(int size) {
        data = new Integer[size];
        for(int i = 0 ; i < size; i++) {

            data[i] = (int)(Math.random() * size * 10);
        }
    }



    @Test
    public void insertSort() {

        InsertionSort<Integer> sort = new InsertionSort<>();
        sort.sort(data);
        Assert.assertTrue(isSorted(data));
    }

    @Test
    public void shellSort() {

        ShellSort<Integer> sort = new ShellSort<>();
        sort.sort(data);
        Assert.assertTrue(isSorted(data));
    }

    @Test
    public void quickSort() {

        QuickSort<Integer> sort = new QuickSort<>();
        sort.sort(data);
        Assert.assertTrue(isSorted(data));
    }

    @Test
    public void selectionSort() {

        SelectionSort<Integer> sort = new SelectionSort<>();
        sort.sort(data);
        Assert.assertTrue(isSorted(data));
    }


    @Test
    public void bubbleSort() {

        BubbleSort<Integer> sort = new BubbleSort<>();
        sort.sort(data);
        Assert.assertTrue(isSorted(data));
    }

}
