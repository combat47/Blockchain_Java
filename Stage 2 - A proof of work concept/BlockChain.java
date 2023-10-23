package blockchain;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class BlockChain {
    private final HashMap<Integer, Block> blockHashMap = new HashMap<>();
    private int id = 1;
    private final int amountOfInteger;

    public BlockChain(int amountOfInteger) {
        this.amountOfInteger = amountOfInteger;
    }

    public void genBlockChain() {

        long timeStamp = new Date().getTime();

        Block block;
        if (blockHashMap.size() == 0) {
            block = new Block();
//            block = new Block(id, timeStamp, 0+"",utils,amountOfInteger);
            block.setId(id);
            block.setTimestamp(timeStamp);
            block.setPreviousHash(0 + "");

        } else {
            block = new Block(id, timeStamp, blockHashMap.get(id - 1).getHashBlock());
        }
        block = generateMagicNumber(block);
        blockHashMap.put(id, block);
        System.out.println(block.toString());
        addToId();
    }



    boolean looping;

    public Block generateMagicNumber(Block block) {
        long startTime = System.currentTimeMillis();
        looping = true;
        while (looping) {
            block.setMagicNumber(ThreadLocalRandom.current().nextLong(Long.MAX_VALUE));
            String s = Utils.applySha256(block.toString());
            if (s.startsWith("0".repeat(amountOfInteger))) {
                looping = false;

                block.setTimeToGen((System.currentTimeMillis() - startTime)/1000);
                block.setHashBlock(s);
                return block;
            }
        }
        return null;
    }

    public void addToId() {
        this.id++;
    }
}
