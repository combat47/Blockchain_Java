package blockchain;

public class Block {
    private int id;
    private long timestamp;
    private String previousHash;
    private String hashBlock;
    private Long timeToGen;
    private long magicNumber;

    public Block() {
    }

    public Block(int id, long timestamp, String previousHash) {
        this.id = id;
        this.timestamp = timestamp;
        this.previousHash = previousHash;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHashBlock() {
        return hashBlock;
    }

    public void setHashBlock(String hashBlock) {
        this.hashBlock = hashBlock;
    }


    public void setTimeToGen(Long timeToGen) {
        this.timeToGen = timeToGen;
    }

    public void setMagicNumber(long magicNumber) {
        this.magicNumber = magicNumber;
    }


    @Override
    public String toString() {
        if (timeToGen != null) {
            return "Block:" + "\n" +
                    "Id: " + id + "\n" +
                    "Timestamp: " + timestamp + "\n" +
                    "Magic number: " + magicNumber + "\n" +
                    "Hash of the previous block: \n" + previousHash + '\n' +
                    "Hash of the block: \n" + hashBlock + "\n"+
                    "Block was generating for " + timeToGen + " seconds"
                    + "\n"
                    ;
        } else {
            return "Block:" + "\n" +
                    "Id: " + id + "\n" +
                    "Timestamp: " + timestamp + "\n" +
                    "Magic number: " + magicNumber + "\n" +
                    "Hash of the previous block: \n" + previousHash + '\n' +
                    "Hash of the block: \n" + hashBlock + "\n"+ "\n"
                    ;
        }
    }
}
