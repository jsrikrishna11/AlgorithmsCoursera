
class Sta<T>{
    T[] values;
    int top;
    public Sta(){
        this.values = (T[]) new Object[10];
        this.top = 0;
    }
    void push(T d){
        values[top++] = d;
    }
    T pop(){
        return values[--top];
    }
}

public class Stack{
    
 public static void main(String[] args) {
    Sta<Integer> s = new Sta<Integer>();
    s.push(4);
    System.out.println(s.pop());
    System.out.println("DOne");
 }
}