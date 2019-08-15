import java.util.Arrays;

public class BlockChain {
    private int blockHash;
    private String[] previousTransaction;

    public BlockChain(int BlockNumber,String[] previousTransaction, String[] transactions) {

        Object[] contents = {Arrays.hashCode(transactions), previousTransaction, BlockNumber};
        
        this.blockHash = Arrays.hashCode(contents);
        this.previousTransaction = previousTransaction;

    }

    public int getBlockHash() {
        return blockHash;
    }
    
    public String getpreviousTransaction() {
        return Arrays.toString(previousTransaction);
    }
}
