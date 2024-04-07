import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        // menu of tasks that can choose one by one
        while (!exit) {
            System.out.println("Task 1");
            System.out.println("Task 2");
            System.out.println("Task 3");
            System.out.println("Task 4");
            System.out.println("Task 5");
            System.out.println("Task 6");
            System.out.println("Task 7");
            System.out.println("Task 8");
            System.out.println("Task 9");
            System.out.println("Task 10");
            System.out.println("0. Exit");
            System.out.println("Enter task number: ");
            int choice = sc.nextInt();

            // cases to choose task and run it,otherwise it will exit
            if (choice == 0){
                System.out.println("exit");
                break;
            }

            long startTime = System.currentTimeMillis(); // to calculate execution time
            switch (choice){
                case 1:
                    Task1();
                    break;
                case 2:
                    Task2();
                    break;
                case 3:
                    Task3();
                    break;
                case 4:
                    Task4();
                    break;
                case 5:
                    Task5();
                    break;
                case 6:
                    Task6();
                    break;
                case 7:
                    Task7();
                    break;
                case 8:
                    Task8();
                    break;
                case 9:
                    Task9();
                    break;
                case 10:
                    Task10();
                    break;
                default://if no choices executed
                    System.out.println("choose one of the task to print result");
                    break;

            }

            double endTime = System.currentTimeMillis();
            double duration = (endTime - startTime) / 1000000;
            System.out.println("duration time " + duration + " ms");
        }
    }

    private static void Task1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter numbers of array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findMin(arr);
    }

    private static void Task2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter numbers for array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        averageOfArr(n, arr);
    }

    private static void Task3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number for task:");
        int n = sc.nextInt();

        isPrime(n);
    }

    private static void Task4(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a factorial number!");
        int n = sc.nextInt();

        System.out.println("Result: " + factorial(n));
    }

    private static void Task5(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n-th fibonacci number:");
        int n = sc.nextInt();
        System.out.println("Result: " + fibonacci(n));
    }

    private static void Task6(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int a = sc.nextInt();
        System.out.println("Enter power:");
        int n = sc.nextInt();
        System.out.println("Result: " + toPower(a,n));
    }

    private static void Task7(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter digits for array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        reverseOrder(arr, 0, arr.length - 1);

        System.out.println("Result: ");
        for(int num : arr){
            System.out.println(num + " ");
        }
    }

    private static void Task8(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string:");
        String s = sc.nextLine();
        System.out.println("Result: " + isDigit(s));
    }

    private static void Task9(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number:");
        int n = sc.nextInt();
        System.out.println("Enter  the second number:");
        int k = sc.nextInt();
        System.out.println("Result: " + binomialCoef(n, k));
    }

    private static void Task10(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  the fist number:");
        int a = sc.nextInt();
        System.out.println("Enter the second number:");
        int b = sc.nextInt();

        System.out.println("Result: " + GCD(a,b));
    }

    /**
     * This one calculate GCD of two numbers and return the result,a is the 1st int, b is 2nd
     */
    private static int GCD(int a, int b){
        if (b == 0)
            return a;

        return GCD(b, a % b);
    }

    /**
     * This one calculate binomial coefficient by his formula, here n is total number, k is number of items .
     * in first base case return 1 due to factorial of 0! =1
     */
    private static int binomialCoef(int n, int k){
        if (k == 0 || n == k)
            return 1;

        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    /**
     * This one check is the string type conatains of digit or not
     * yes if contains, otherwise no
     */
    private static String isDigit(String str){
        if(str.length() == 0)
            return "Yes";

        if (Character.isDigit(str.charAt(0)))
            return isDigit(str.substring(1));
        else
            return "No";
    }

    /**
     * This one  reverse the given array by swapping elements
     * from the start and end positions iteratively
     * 2 pointers include end and start
     */
    private static void reverseOrder(int[] arr, int start, int end){
        if (start >= end)
            return;

        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        reverseOrder(arr, start + 1, end - 1);
    }

    /**
     * This one calculates the power of a given number using recursion
     * a is a base , n is the power of a
     */
    private static int toPower(int a, int n){
        if(n == 0)
            return 1;
        else
            return a * toPower(a, n - 1);
    }

    /**
     * This one obtain  the nth Fibonacci number using recursion.
     * parameter n is an index of the Fibonacci number
     * As a result it returns the value of the nth Fibonacci number.
     */
    private static int fibonacci(int n){
        if (n <= 1 )
            return n; // F0 = 0 and F1 = 1 base case
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**This one represent the factorial of a non-negative integer using recursion.
     * n is the number for which the factorial is to be calculated.
     *It returns the factorial of the given non-negative number.
     */
    private static int factorial(int n){
        if (n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    /**
     * This code checks if a number is a prime.
     * n is the number integer .
     */
    private static void isPrime(int n){
        if(n % 2 == 0){
            System.out.println(n + " Composite");
        }
        else {
            System.out.println(n + " Prime");
        }
    }

    /**
     * This one calculates the average of elements in the array.
     *  n is the number of elements in the array.
     */
    private static void averageOfArr(int n, int[] arr){
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        double average = sum / n;
        System.out.println("Result: " + average);
    }

    /**
     * This one will find and search the minimum number of
     * an array by step by step
     **/
    private static void findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]){
                min = arr[i];
            }
        }
        System.out.println("Result: " + min);
    }
}