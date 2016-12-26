package mxf.study.algorighm.sort;

/**
 * Created by maxiaofeng on 2016/12/16.
 */
public interface Sort<T extends Comparable<T>> {

    void sort(T[] data);

    default void swap(T[] data, int i, int j) {
        T tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;

//        System.out.println(String.format("swapIfNeed %s", printArray(data, i, j)));
    }

    default int swapIfNeed(T[] data, int i, int j) {
        if(i == j) {
            return 0;
        }
//        if(i > j != data[i].compareTo(data[j]) > 0) {
//            return 0;
//        }

        swap(data, i, j);
        return 1;
    }


}
