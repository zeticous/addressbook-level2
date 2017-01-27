package seedu.addressbook.data.person;

public class Block {
    private int blockNumber;
    
    public Block(String blockNumber){
        setBlockNumber(blockNumber);
    }
    
    public int getBlockNumber(){
        return blockNumber;
    }
    
    public void setBlockNumber(String blockNumber){
        this.blockNumber = Integer.parseInt(blockNumber);
    }
}
