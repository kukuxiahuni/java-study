/**
 * 文件名：BinarySearch.java
 * 所在包：SearchLearning
 * 日期：2014-2-24 上午11:35:45
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有:
 */

package SearchLearning;

import java.util.Arrays;

/**
 * 项目名称：data_structure
 * 类名称：BinarySearch
 * 类描述：二分查找是有序表查找的一种，其中有序表是说明表中的内容是按照的降序/升序排序的。
 * 创建人：黄传聪
 * 创建时间：2014-2-24 上午11:35:45
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class BinarySearch {

    private int[] dataSources;
    private int size;
    private int low;
    private int high;
    private int mid;


    public BinarySearch(int size) {
        this.size = size;
        dataSources = new int[size];

        low = 0;
        high = size - 1;
    }

    /**
     * 方法名称：main()
     * 方法描述：
     *
     * @param
     * @return String
     * @Exception
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        BinarySearch bs = new BinarySearch(8);
        int[] data = {1, 2, 4, 4, 5, 6, 7, 8};
        bs.setDataSources(data);
        System.out.println(bs.binarySearch(8));
        System.out.println(bs.binarySearch(8, 0, 8));
    }

    /**
     * 方法名称：binarySearch()
     * 方法描述：二分查找,迭代方式
     *
     * @param
     * @return String
     * @Exception
     */
    private int binarySearch(int search) {
        int retVal = -1;
        while (low <= high) {
//			mid = (low + high) / 2;
            mid = low + (high - low) >> 1;

            if (dataSources[mid] < search) {
                low = mid + 1;

            } else if (dataSources[mid] > search) {
                high = mid - 1;
            } else {
                retVal = mid;
                break;
            }
        }

        return retVal;

    }

    /**
     * 方法名称：binarySearch()
     * 方法描述：递归方式
     *
     * @param
     * @return String
     * @Exception
     */
    private int binarySearch(int search, int low, int high) {

        int mid = (low + high) / 2;
        if (search == dataSources[mid]) {
            return mid;
        } else if (search < dataSources[mid]) {
            return binarySearch(search, low, mid - 1);
        } else {
            return binarySearch(search, mid + 1, high);
        }
    }

    public int[] getDataSources() {
        return dataSources;
    }

    public void setDataSources(int[] dataSources) {
        this.dataSources = dataSources;
        Arrays.sort(dataSources);
    }


    private int biS(int search, int low, int high) {

        if (low < 0 || high > dataSources.length || low > high) {
            throw new IllegalArgumentException();
        }

        int mid = low + (high - low) >> 1;

        if (search == dataSources[mid]) {
            return mid;
        }

        if (search < dataSources[mid]) {
            return biS(search, low, mid);
        } else {
            return biS(search, mid + 1, high);
        }

    }

    private int bisInterator(int search, int low, int high) {


        if (low < 0 || high > dataSources.length || low > high) {
            throw new IllegalArgumentException();
        }

        while (low <= high) {

            int mid = low + (high - low) >> 1;

            if (search == dataSources[mid]) {
                return mid;
            }

            if (search < dataSources[mid]) {
                high = mid;
            } else {

                low = mid + 1;
            }

        }

        return -1;
    }

}
