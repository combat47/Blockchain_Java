package blockchain;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how many zeros the hash must start with: ");
        int amountOfInteger = scanner.nextInt();
        BlockChain blockchain = new BlockChain(amountOfInteger);
        for (int i = 0; i < 5; i++) {
            blockchain.genBlockChain();
        }

    }
}
