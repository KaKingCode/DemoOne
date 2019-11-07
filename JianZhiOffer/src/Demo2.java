
/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @since JDK 1.8
 */
public class Demo2 {
    public static void main(String[] args){
        System.out.print(new Demo2().replaceSpace3(new StringBuffer("h el ")));
        //System.out.print(new Demo2().replaceSpace1(new StringBuffer("'hello world'")));
    }

    /**
     **方法1：新开辟一个字符数组做替换，这种写法先前不知道新字符数组空间问题。不推荐
    **/
    public String replaceSpace(StringBuffer str) {
        char[] strArray = str.toString().toCharArray();
        char[] targetArray = new char[10240];
        int i =0;
        int j =0;
        while(i<strArray.length){
            if(strArray[i]!=' '){
                targetArray[j]=strArray[i];
                j++;
                i++;
            }else{
                targetArray[j]='%';
                targetArray[j+1]='2';
                targetArray[j+2]='0';
                j=j+3;
                i++;
            }
        }
        return (String.valueOf(targetArray));
    }

    /**
     * 方法2：自带方法
     * @param str
     * @return
     */
    public String replaceSpace2(StringBuffer str){
       return str.toString().replaceAll(" ","%20");
    }

    /**
     * 方法3：
     从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
     从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
     * @param str
     * @return
     */
    public String replaceSpace3(StringBuffer str){
        //先计算需要多少空间
        int count=0;
        for(int i = 0 ; i<str.length();i++){
            if(str.charAt(i) == ' '){
                count++;
            }
        }
        int oldLength = str.length();
        int newLength = str.length()+2*count;
        str.setLength(newLength);
        for(int i = oldLength-1;i>=0;i--){
            if(str.charAt(i)==' '){
                str.setCharAt(--newLength,'%');
                str.setCharAt(--newLength,'2');
                str.setCharAt(--newLength,'0');
            }
            else str.setCharAt(--newLength,str.charAt(i));
        }
        return str.toString();
    }

    /**
     * 方法4：自开辟字符串，字符串追加。
     * @param str
     * @return
     */
    public String replaceSpace4(StringBuffer str) {
        StringBuffer sb =new StringBuffer();
        for(int i=0;i<str.toString().length();i++){
            char a = str.charAt(i);
            if(a == ' ') sb.append("%20");
            else sb.append(a);
        }
        return sb.toString();
    }

}
