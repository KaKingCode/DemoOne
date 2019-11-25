/**
 *一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * @since JDK 1.8
 */
public class Demo8 {
    //同样斐波拉契

    public int JumpFloor(int target) {
        if(target<=3) return target;
        int temp=0;
        int tempPre=3;
        int tempPrePre=2;
        for(int i=4;i<=target;i++){
            temp=tempPre+tempPrePre;
            tempPrePre=tempPre;
            tempPre=temp;

        }
        return temp;
    }
}
