package mxf.study.algorighm.sort;

/**
 * Created by maxiaofeng on 2016/12/19.
 */
public class SelectionSort<T extends Comparable<T>> implements Sort<T> {



    @Override
    public void sort(T[] data) {

        sort2(0, data);
//        sortByIndex(0, data);

    }

    /**
     * 选择排序，同时找到最大和最小，最多只需进行[n/2]趟循环
     * @param start
     * @param data
     */
    private void sort2(int start, T[] data) {
        for(int rstart = start, rend = data.length - 1 ; rstart < rend; rstart++, rend--) {
            MaxAndMin maxAndMin = maxAndMinInRange(rstart, rend, data);
            swap(data, maxAndMin.max, rend);
            swap(data, maxAndMin.min, rstart);
        }
    }

    private void sortByIndex(int start, T[] data) {
        int endIndex = data.length;

        for(; start < endIndex; start++) {
            int _min = minInRange(start, endIndex, data);
            swap(data, _min, start);
        }
    }

    private int minInRange(int start, int end, T[] data) {

        int _min = start;
        for(int n = start;n < end;n++) {

            if(data[_min].compareTo(data[n]) > 0) {
                _min = n;
            }
        }

        return _min;
    }

    private MaxAndMin maxAndMinInRange(int start, int end, T[] data) {

        int _min = start;
        int _max = start;
        for(int n = start;n <= end;n++) {

            if(data[_min].compareTo(data[n]) > 0) {
                _min = n;
            }
            if(data[_max].compareTo(data[n]) < 0) {
                _max = n;
            }
        }

        return new MaxAndMin(_min, _max);
    }

    class MaxAndMin {
        int min, max;

        public MaxAndMin(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
