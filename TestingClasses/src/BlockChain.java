import java.lang.reflect.Array;
import java.util.Arrays;

public class BlockChain {
    private int blockHash;
    private int previousTransaction;

    public BlockChain(int BlockNumber,String[] previousTransaction, String[] transactions) {

        Object[] contents = {Arrays.hashCode(transactions), previousTransaction, BlockNumber};
        this.blockHash = Arrays.hashCode(contents);
    }

    public int getBlockHash() {
        return blockHash;
    }
    
    public int getpreviousTransaction() {
        return previousTransaction;
    }
}
