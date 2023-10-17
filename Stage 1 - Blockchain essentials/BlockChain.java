package blockchain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlockChain {
    List<Block> blocks = new ArrayList<>();

    public void addBlock(String data) {
        blocks.add(new Block(blocks.size() + 1, data, getLastHash()));
    }

    public String getLastHash() {
        if (blocks.size() == 0) {
            return String.valueOf(0);
        }
        return blocks.get(blocks.size() - 1).hash;
    }

    public boolean isValid() {
        if (blocks.isEmpty()) {
            return true;
        }

        for (Block b: blocks){
            if (b.getId() == 1) {
                if (!b.previousBlockHash.equals("0")) {
                    return false;
                }
            } else {
                String prevBlockHash = blocks.get(b.getId() - 2).hash; // -1 due to index offset, another -1 to get previous
                if (!b.previousBlockHash.equals(prevBlockHash)) {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Block b: blocks) {
            sb.append("Block:\n");
            for (String s : Arrays.asList("Id: " + b.getId() + "\n", "Timestamp: " + b.getTimestamp() + "\n", "Hash of the previous block:\n" + b.previousBlockHash + "\n", "Hash of the block:\n" + b.getHash() + "\n", "\n")) {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}
