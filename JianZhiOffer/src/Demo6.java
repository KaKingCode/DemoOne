/**
 *把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @since JDK 1.8
 */
public class Demo6 {

    public static void main(String[] args) {
        System.out.println(new Demo6().minNumberInRotateArray2(new int[]{1,2,3}));
        System.out.println(new Demo6().minNumberInRotateArray2(new int[]{1,1,1}));
        System.out.println(new Demo6().minNumberInRotateArray2(new int[]{0,1,1}));
        System.out.println(new Demo6().minNumberInRotateArray2(new int[]{1}));
        System.out.println(new Demo6().minNumberInRotateArray2(new int[]{3,4,5,1,2,3}));
        System.out.println(new Demo6().minNumberInRotateArray2(new int[]{0,1,2,8,9,10}));
    }

    //顺序查找
    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length==0){
            return 0;
        }
        if(array.length==1){
            return array[0];
        }
        for(int i =0;i<array.length-1; i++){
            if(array[i]>array[i+1]) return array[i+1];
        }
        return 0;
    }
    //二分查找
    public int minNumberInRotateArray2(int [] array){
        if(array == null || array.length==0){
            return 0;
        }
        int left = 0 ; int right = array.length -1;
        while(left<right){
            int mid = (left+right)/2;
            if(array[mid] < array[right]) right=mid;
            if(array[mid] > array[right]) left =mid+1;
            if(array[mid] == array[right]) right--;
        }
        return array[left];
    }
}
