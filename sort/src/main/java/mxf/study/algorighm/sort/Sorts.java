package mxf.study.algorighm.sort;

/**
 * Created by maxiaofeng on 2016/12/19.
 */
public class Sorts {

    /**
     * 是否排好序
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] array) {
        if(array == null) {
            return false;
        }
        if(array.length == 1) {
            return true;
        }

        for(int i = 1 ; i < array.length; i++) {

            if(array[i].compareTo(array[i-1]) < 0) {
                return false;
            }
        }
        return true;
    }


    public static <T extends Comparable<T>> String printArray(T[] data, int ... markIndex) {

        StringBuilder sb = new StringBuilder("{");
        for(int i = 0 ; i < data.length ; i++) {
            if(isMark(markIndex, i)) {
                sb.append("['" + data[i] + "'], ");
            } else {
                sb.append(data[i] + ", ");
            }
        }
        return (sb.subSequence(0, sb.length() -2) + "}");
    }

    private static <T extends Comparable<T>> boolean isMark(int[] markIndex, int i) {
        for(int n : markIndex) {
            if(n == i) {
                return true;
            }
        }
        return false;
    }
}
