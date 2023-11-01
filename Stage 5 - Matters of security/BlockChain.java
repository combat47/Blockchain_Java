package blockchain;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class BlockChain {
    private int lengthOfPrefix = 0;
    private final Deque<Block> blockDeque = new ArrayDeque<>();

    public void addBlockToChain(Block block) { //synchronized because the method calling this is synchronized
        if (blockDeque.size() == 0) {
            block.setPreviousHash("0");
        } else {
            block.setPreviousHash(blockDeque.peek().getHash());//set it to the hash of the last element
        }
        blockDeque.push(block);
        System.out.println(block);
    }

    public void printBlocks() {
        Iterator<Block> blockIterator = blockDeque.descendingIterator();//iterate FIFO
        blockIterator.forEachRemaining(System.out::println);

    }


    public synchronized void createBlock(long miner) {
        Block block = new Block(lengthOfPrefix, miner);
        addBlockToChain(block);

        long creationTimeOfLastBlock = block.getCreationDuration();
        if (creationTimeOfLastBlock > 100) {
            lengthOfPrefix--;
        } else if (creationTimeOfLastBlock < 10) {
            lengthOfPrefix++;
        }

    }

}
