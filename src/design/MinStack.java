package design;

import java.util.LinkedList;
import java.util.Stack;

public class MinStack {
    private Stack nums;
    public MinStack(){
        nums = new Stack();
    }
    public void push(int val){
        nums.push(val);
    }
    public void pop() {
        nums.pop();
    }
    public int top() {
        return (int)nums.get(nums.size()-1);
    }
    public int getMin() {
        int min = (int) nums.get(0);
        for(Object i:nums){
            int val = (int) i;
            if(min > val) min = val;
        }
        return min;
    }


}
class Test {
    public static void main(String[] args) {
        MinStack m = new MinStack();
        System.out.println();
        m.push(2);
        m.push(0);
        m.push(3);
        m.push(0);
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
    }
}