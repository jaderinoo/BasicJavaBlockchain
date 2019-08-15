import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int blockNum = 0;
	static String[] previousTransaction = {};
	static String[] Transaction = {};
	static ArrayList<Object> Chain = new ArrayList<Object>();
	
	public static void main(String[] args) throws IOException {
		
		//Resets the file
		if(blockNum == 0) {
			FileWriter fileWriter = new FileWriter("BlockLog.txt");
		}
		setString();
		System.out.println("I'm back!");
	}
	
	public static void setString() throws IOException {
		String userTemp = "";
		
		Scanner scanner = new Scanner(System.in);
	    System.out.println("What would you like to Hash?:");
	    userTemp = scanner.nextLine();
		if (userTemp.isEmpty() == true) {
			System.out.println("Input is empty, returning");
			setString();
		}
		String[] genesisTransaction = userTemp.split("");
		if(blockNum == 0) {
			BlockChain genesisBlock = new BlockChain(0, previousTransaction, genesisTransaction);
	        WriteFile(Integer.toString(genesisBlock.getBlockHash()));
			System.out.println("Hash of block #" + blockNum);
			Chain.add(genesisBlock);
	        System.out.println(genesisBlock.getBlockHash() + "\n" + Chain.get(blockNum)+ "\n");
	        blockNum++;
		}else {
			if(Transaction.length == 0) {
				previousTransaction = genesisTransaction;
			}else {
				previousTransaction = Transaction;
			}
			String[] Transaction = userTemp.split("");
			BlockChain Block = new BlockChain(blockNum, previousTransaction, Transaction);
	        WriteFile(Integer.toString(Block.getBlockHash()));
	        Chain.add(Block);
			System.out.println("Hash of block #" + blockNum);
	        System.out.println(Block.getBlockHash() + "\n" + Chain.get(blockNum)+ "\n");
	        blockNum++;
		}

		main(null);
	}

	public static void WriteFile(String hashedString) throws IOException {
		FileWriter fileWriter = new FileWriter("BlockLog.txt", true);
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.println("Block #" + blockNum + " Hash: " + hashedString);
	    printWriter.close();
	}
}
