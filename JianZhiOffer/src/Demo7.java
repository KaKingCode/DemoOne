/**
 *大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 *n<=39
 * @since JDK 1.8
 */
public class Demo7 {
    int[][] matrix1 = {
            {1,2},
            {3,4},
            {5,6}
    };
    int[][] matrix2 = {
            {1},
            {2}
    };
    //方法1：纯递归，容易死掉
    public int Fibonacci(int n) {
        if(n<=1) {
            return n;
        }
        else{
            return Fibonacci(n-1) +  Fibonacci(n-2);
        }
    }
    //方法2：改成循环
    public int Fibonacci1(int n){
        int preNum=1;
        int prePreNum=0;
        int result=1;
        if(n<=1){
            return n;
        }
        for(int i =2;i<=n;i++){
            result=preNum+prePreNum;
            prePreNum=preNum;
            preNum=result;
        }
        return result;
    }


    //方阵矩阵乘法 行*列
    public int[][] matrixMult(int[][] matrix1,int[][] matrix2){
        int col1 = matrix1[0].length;//列数
        int row1 = matrix1.length;//行数
        int col2 = matrix2[0].length;//列数
        int[][] temp = new int[row1][col2];
        for(int i=0;i<row1;i++){
            for(int j=0;j<col2;j++){
                for(int k=0;k<col1;k++){
                    temp[i][j]+=matrix1[i][k]*matrix2[k][j];
                }
            }
        }
        return temp;
    }
    //求取{{1,1},{1,0}} 的N阶方阵
    public int[][] pow(int N){
        int[][] temp = {{1,0},{0,1}};//单位矩阵作为初始矩阵,任何一个矩阵A*单位矩阵=A
        int[][] base = {{1,1},{1,0}};//斐波那契初始矩阵
        while(N>0){
            if((N&1)==1){
                temp=matrixMult(temp,base);
            }
            base=matrixMult(base,base);
            N=N>>1;
        }
        return temp;
    }
    //方法3：快速幂
    public int Fibonacci2(int n){
        if(n<=1)return n;
        int [][] f01 = {{1},{0}};
        int [][] v = pow(n-1);
        int [][] result = matrixMult(v,f01);
        return result[0][0];
    }

    public static void main(String[] args) {
        Demo7 demo7 = new Demo7();
        int[][] a  = demo7.matrixMult(demo7.matrix1,demo7.matrix2);
        int[][] temp3 = demo7.pow(3);
        int[][] temp4 = demo7.pow(4);
        System.out.print(a[0]);
    }
}
