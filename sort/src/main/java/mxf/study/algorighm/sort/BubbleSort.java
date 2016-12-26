package mxf.study.algorighm.sort;

/**
 * Created by maxiaofeng on 2016/12/17.
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    
    @Override
    public void sort(T[] data) {

//        sortBySingleMaxDirection(data);
//        sortBySingleMinDirection(data);

        sortByDoubleDirection(data);
    }

    public T[] bubbleSort(T[] A, int n) {
        //冒泡排序：从后往前（从下往上）就像冒泡一样
        //用flag作为标记，标记数组是否已经排序完成
        boolean flag = true;
        //固定左边的数字
        for(int i=0; i<n-1&flag; i++){
            flag = false;
            //从后面（下面）往前（上）遍历
            for(int j=n-2;j>=i;j--){

                if(A[j].compareTo(A[j+1]) > 0){
                    swap(A,j,j+1);
                    flag = true;
                }
            }
            if(!flag) { //排序结束
                break;
            }
        }

        return A;

    }

    /**
     * 传统冒泡
     * @param data
     */
    public void sortBySingleMaxDirection(T[] data) {

        for(int j = data.length; j > 0; j --) {
            int exchanged = bubbleOneMaxInRange(data, 0, j);

            if(exchanged == 0) {
                // exchange，用于标志某一趟排序过程中是否有数据交换，
                // 如果进行某一趟排序时并没有进行数据交换，则说明数据已经按要求排列好，可立即结束排序，避免不必要的比较过程。
                break;
            }
        }
    }

    /**
     * 传统冒泡
     * @param data
     */
    public void sortBySingleMinDirection(T[] data) {

        for(int j = 0; j < data.length; j++) {
            int exchanged = bubbleOneMinInRange(data, j, data.length);

            if(exchanged == 0) {
                // exchange，用于标志某一趟排序过程中是否有数据交换，
                // 如果进行某一趟排序时并没有进行数据交换，则说明数据已经按要求排列好，可立即结束排序，避免不必要的比较过程。
                break;
            }
        }
    }

    private int bubbleOneMaxInRange(T[] data, int start, int end) {
        int exchanged = 0;
        for (int _this = start; _this < end - 1; _this++) {
            int next = _this + 1;
            if (data[next].compareTo(data[_this]) < 0) {
                exchanged += swapIfNeed(data, next, _this);
            }
        }
        return exchanged;
    }

    /**
     * 传统冒泡排序中每一趟排序操作只能找到一个最大值或最小值,
     * 我们考虑利用在每趟排序中进行正向和反向两遍冒泡的方法一次可以得到两个最终值(最大者和最小者) ,
     * 从而使排序趟数几乎减少了一半。
     *
     * @param data
     */
    public void sortByDoubleDirection(T[] data) {

        for(int start = 0 , end = data.length; start < end; start ++, end --) {
            int exchanged = bubbleOneMaxInRange(data, 0, end);

            exchanged += bubbleOneMinInRange(data, start, end);

            if(exchanged == 0) {
                // exchange，用于标志某一趟排序过程中是否有数据交换，
                // 如果进行某一趟排序时并没有进行数据交换，则说明数据已经按要求排列好，可立即结束排序，避免不必要的比较过程。
                break;
            }
        }
    }

    private int bubbleOneMinInRange(T[] data, int start, int end) {
        int exchanged = 0;
        for (int _this = end - 1; _this > start; _this--) {
            int _before = _this - 1;
            if (data[_this].compareTo(data[_before]) < 0) {
                exchanged += swapIfNeed(data, _this, _before);
            }
        }
        return exchanged;
    }
}
