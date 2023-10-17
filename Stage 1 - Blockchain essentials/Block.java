package blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Date;

public class Block {
    private final int id;
    private final long timestamp;
    String previousBlockHash;
    String hash;

    public Block(int id, String input, String previousBlockHash) {
        timestamp = new Date().getTime();
        this.id = id;
        this.previousBlockHash = previousBlockHash;
        hash = applySha256(input);
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    public String getHash() {
        return hash;
    }

    private static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte elem : hash) {
                String hex = Integer.toHexString(0xff & elem);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
