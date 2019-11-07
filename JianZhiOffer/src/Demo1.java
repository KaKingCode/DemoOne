/**
 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Demo1 {

    public boolean Find(int target, int [][] array) {
        int lenX = array[0].length;//列
        int lenY = array.length;//行
        for(int i = 0,j = lenY -1;i<lenX && j>=0;){
            if(array[j][i] == target) return true;
            if(array[j][i] < target){
                i++;
                continue;
            }
            if(array[j][i] > target){
                j--;
                continue;
            }
        }
        return false;
    }
}
