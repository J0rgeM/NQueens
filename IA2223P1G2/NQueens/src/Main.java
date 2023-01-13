import java.util.Scanner;

public class Main {
    /**
     * The function takes in a board of size n, and returns a solution to the n-queens problem
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        LocalSearch a = new LocalSearch();

        int n = sc.nextInt();
        Ilayout solution = a.solve(new Board(n));
        System.out.println(solution.isGoal());

        sc.close();
    }
}
