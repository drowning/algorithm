package mxf.study.algorighm.sort;

/**
 *
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
 *
 *
 * Created by maxiaofeng on 2016/12/17.
 */
public class ShellSort<T extends Comparable<T>> implements Sort<T> {


    @Override
    public void sort(T[] data) {
        for(int dk = data.length/2; dk >= 1;dk = dk/2){
            shellInsertSort(data, data.length, dk);
        }
    }


    /**
     * 直接插入排序的一般形式
     *
     * @param dk 缩小增量，如果是直接插入排序，dk=1
     *
     */

    void shellInsertSort(T a[], int n, int dk)
    {
        for(int i= dk; i<n; ++i){
            int j;
            T tmp = a[i];
            for(j = i;j >= dk && tmp.compareTo(a[j-dk]) < 0; j-= dk) {
                a[j] = a[j -dk];
            }
            a[j] = tmp;
        }

    }
}
