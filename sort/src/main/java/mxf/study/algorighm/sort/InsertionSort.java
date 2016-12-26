package mxf.study.algorighm.sort;

/**
 * 插入排序
 * 时间复杂度 平均  O（N的平方）
 *
 * 倒叙输入，则时间复杂度刚好为最差，O（N的平方）
 * 正序输入，时间复杂度为最优，O（N）
 *
 * 适合几乎排好序的输入
 *
 * 如果碰见一个和插入元素相等的，那么插入元素把想插入的元素放在相等元素的后面。所以，相等元素的前后顺序没有改变，从原无序序列出去的顺序就是排好序后的顺序，所以插入排序是稳定的
 *
 * Created by maxiaofeng on 2016/12/16.
 */
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] data) {

        sortByLoop1(data);
//        sortInternal(data, 1);
//        sortByLoop(data);
    }

    public int[] insertionSort(int[] A, int n) {
        //用模拟插入扑克牌的思想
        //插入的扑克牌
        int i,j,temp;
        //已经插入一张，继续插入
        for(i=1;i<n;i++){

            temp = A[i];
            //把i前面所有大于要插入的牌的牌往后移一位，空出一位给新的牌
            for(j=i;j>0&&A[j-1]>temp;j--){
                A[j] = A[j-1];
            }
            //把空出来的一位填满插入的牌
            A[j] = temp;

        }
        return A;


    }

    /**
     * 不用每次都从最前面开始找，而是从后面开始找。各有利弊吧，
     * 因为不知道姚插入的数字是更靠近前部还是后部
     * @param data
     */
    private void sortByLoop1(T[] data) {


        int j;
        for(int p = 1; p < data.length; p ++) {
            T tmp = data[p];
            for(j = p; j > 0 && data[j -1].compareTo(tmp) > 0 ; j--) {
                data [j] = data[j - 1];
            }
            data[j] = tmp;

        }

    }
    private void sortByLoop(T[] data) {


        for(int i = 1; i < data.length; i ++) {

            for(int j = 0; j < i ; j++) {

                if(data[j].compareTo(data[i]) > 0) {
                    T tmp = data[i];
                    moveNext(data, j, i);
                    data[j] = tmp;
                    break;
                }

            }

        }

    }

    private void sortInternal(T[] data, int current) {

        int i = 0;
        T currentT = data[current];
        T prev = null;
        for(T t : data) {
            if(prev == null) {
                prev = t;
                continue;
            }

            if(i > current) {
                i++;
                sortInternal(data, i);
            }
            if(t.compareTo(currentT) > 0) {
                moveNext(data, i, current);
                data[current] = currentT;
                break;
            }

        }
    }

    private void moveNext(T[] data, int from, int to) {


        for(int i = to; i >from ; i--) {

            data[i] = data[i-1];
        }

    }
}
