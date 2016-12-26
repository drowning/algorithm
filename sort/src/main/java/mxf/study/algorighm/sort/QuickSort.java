package mxf.study.algorighm.sort;

import java.util.Optional;

import static com.sun.org.apache.bcel.internal.classfile.Utility.printArray;

/**
 * Created by maxiaofeng on 2016/12/17.
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    
    @Override
    public void sort(T[] data) {

        quickSort(data, 0, data.length - 1);
    }

    private int partition(T[] a, int low, int high) {

        T base = a[low];                             //基准元素
        while(low < high){                                   //从表的两端交替地向中间扫描
            while(low < high  && a[high].compareTo(base) >=0) {
                //从high 所指位置向前搜索，至多到low+1 位置。将比基准元素小的交换到低端
                --high;
            }
            swapIfNeed(a, low, high);
            while(low < high  && a[low].compareTo(base) <= 0) {
                ++low;
            }
            swapIfNeed(a, low, high);
        }
        return low;
    }

    void quickSort(T a[], int low, int high){
        if(low < high){
            int privotLoc = partition(a,  low,  high);  //将表一分为二
            quickSort(a,  low,  privotLoc -1);          //递归对低子表递归排序
            quickSort(a,   privotLoc + 1, high);        //递归对高子表递归排序
        }
    }
}
