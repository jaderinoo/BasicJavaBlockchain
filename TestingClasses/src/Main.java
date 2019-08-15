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
		Scanner scanner = new Scanner(System.in);
		//Resets the file
		if(blockNum == 0) {
			FileWriter fileWriter = new FileWriter("BlockLog.txt");
		}
		
		System.out.println("Please Select an Option:\n  1 - Add Item to Chain\n  2 - View Blockchain Contents");
		
		int selection = scanner.nextInt();
		switch(selection) {
			case 1:
				setString();
				break;
			case 2:
				System.out.println(Chain + "\n");
				break;
			default:
				System.out.println("Invalid option. Please try again.\n"); 
				break;
		}
		main(null);
	}
	
	public static void setString() throws IOException {
		String userTemp = "";

	    System.out.println("\nWhat would you like to Hash?:");
		Scanner scanner2 = new Scanner(System.in);
	    userTemp = scanner2.nextLine();
		if (userTemp.isEmpty() == true) {
			System.out.println("Input is empty, returning\n");
			main(null);
		}
		String[] genesisTransaction = userTemp.split("");
		if(blockNum == 0) {
			BlockChain genesisBlock = new BlockChain(0, previousTransaction, genesisTransaction);
			Chain.add(genesisBlock);
			WriteFile(Integer.toString(genesisBlock.getBlockHash()));
			System.out.println("\nGenesis Block");
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
	        Chain.add(Block);
			WriteFile(Integer.toString(Block.getBlockHash()));
			System.out.println("\nHash of block #" + blockNum);
	        System.out.println(Block.getBlockHash() + "\n" + Chain.get(blockNum)+ "\n");
	        blockNum++;
		}

		main(null);
	}

	public static void WriteFile(String hashedString) throws IOException {
		FileWriter fileWriter = new FileWriter("BlockLog.txt", true);
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    if(blockNum == 0) {
	    	printWriter.println("Genesis Block Hash: " + hashedString + "\n" + Chain.get(blockNum));
	    }else {
	    	printWriter.println("Block #" + blockNum + " Hash: " + hashedString + "\n" + Chain.get(blockNum));
	    }
	    printWriter.close();
	}
}
