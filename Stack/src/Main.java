public class Main {
    public static void main(String[] args) {
        Stack<Integer>  si = new Stack<Integer>(5);
        System.out.println(si.push(1000));
        System.out.println(si.push(2000));
        System.out.println(si.push(3000));
        System.out.println(si.push(4000));
        System.out.println(si.pop());
    }
}
