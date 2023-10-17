package blockchain;

public class Main {
    private static final BlockChain blockChain = new BlockChain();
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            blockChain.addBlock(String.valueOf(i));
        }
        System.out.println(blockChain);
    }
}
