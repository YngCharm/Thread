import java.util.ArrayList;

public class Fibonacci {

    final Object lock = new Object();
    ArrayList<Double> numbers = new ArrayList<>();

    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34
    public void addingInList() {
        numbers.add(0.0);
        numbers.add(1.0);
        numbers.add(1.0);
        numbers.add(2.0);
        numbers.add(3.0);
        numbers.add(5.0);
        numbers.add(8.0);
        numbers.add(13.0);
        numbers.add(21.0);
        numbers.add(34.0);
    }

    Runnable sum = () -> {

        synchronized (lock) {
            lock.notify();
        }

        addingInList();
        for (int i = 0; i < 9; i++) {

            double multiply = numbers.get(i) * numbers.get(i + 1);
            System.out.println(multiply);
        }
    };

    Runnable dividing = () -> {
        synchronized (lock) {
            lock.notify();
        }

        addingInList();
        for (int i = 0; i < 9; i++) {

            double divide = (numbers.get(i) + numbers.get(i + 1)) / 2;
            System.out.println(divide);
        }
    };

    Runnable output = () -> {
        synchronized (lock){
            lock.notify();
            System.out.println("Результат двух потоков - X");
        }
    };

    Runnable result = () -> {
        sum.run();
        dividing.run();
        output.run();
    };
}
