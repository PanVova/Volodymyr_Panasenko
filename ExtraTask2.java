import java.util.Stack;

public class ExtraTask2 {
    public static String longToIP(long ip) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        while (ip > 0){
            stack.push((int) (ip % 2));
            ip /= 2;
        }

        while (stack.size() < 32) stack.push(0);

        int flag = 0;
        int temp = 0;

        while (!stack.empty()){
            temp = temp * 2 + stack.pop();
            flag++;
            if (flag % 8 == 0){
                stringBuilder.append(temp);
                if (flag < 32){
                    stringBuilder.append('.');
                }
                temp = 0;
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        long input = 2149583361L;
        System.out.println(longToIP(input));
    }
}