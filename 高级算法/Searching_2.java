import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caseNum = in.nextInt();
        while (caseNum-- > 0) {
            if (caseNum != 0)
                System.out.println(countNumbers(in.nextLong()));
            else
                System.out.print(countNumbers(in.nextLong()));
        }
    }

    static int countNumbers(long n) {
        int c = 0;

        int limit = (int) Math.sqrt(n);

        // Sieve array
        int prime[] = new int[limit + 1];

        // initially prime[i] = i
        for (int i = 1; i <= limit; i++) {
            prime[i] = i;
        }

        // use seive concept to store the
        // first prime factor of every number
        for (int i = 2; i * i <= limit; i++) {
            if (prime[i] == i) {
                // mark all factors of i
                for (int j = i * i; j <= limit; j += i) {
                    if (prime[j] == j) {
                        prime[j] = i;
                    }
                }
            }
        }

        // check for all numbers if they can be
        // expressed in form p*q
        for (int i = 2; i <= limit; i++) {
            // p prime factor
            int p = prime[i];

            // q prime factor
            int q = prime[i / prime[i]];

            // if both prime factors are different
            // if p*q<=n and q!=
            if (p * q == i && q != 1 && p != q) {
                c += 1;
            } else if (prime[i] == i) {

                // Check if it can be expressed as p^8
                if (Math.pow(i, 8) <= n) {

                    c += 1;
                }
            }
        }

        return c;
    }
}