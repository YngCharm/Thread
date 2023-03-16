public class Main {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        Thread threadMultiply = new Thread(fibonacci.sum);
        Thread threadDivide = new Thread(fibonacci.dividing);
        Thread threadOutput = new Thread(fibonacci.output);

        threadOutput.start();
        threadMultiply.start();
        threadDivide.start();
    }
}