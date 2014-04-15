public class WordFind 
{
	
	public String[] findWords(String[] grid, String[] wordList)
	{
		String buffer[] = new String[wordList.length];
		boolean got = false;
		for (int i = 0; i < wordList.length; i++) 
		{
			got = false;
			System.out.println("looking for " + wordList[i]);
			for(int j=0;j<grid.length;j++)
			{
				for(int k=0;k<grid[j].length();k++)
				{
					
					if(found(grid,wordList[i],j,k))
					{
						got = true;
						buffer[i]= j + " " + k;
						System.out.println(buffer[i]);
						k= grid[j].length()-1;
						j=grid.length-1;
					}
					else
					{
						buffer[i]= "";
					}
				}
			}
			if(!got)
				System.out.println("not found");
		}
		return buffer;
	}
	
	boolean found(String[] puzzle,String word,int row,int column)
	{
		if(checkvertically(puzzle, word, row, column))
			return true;
		else if(checkhorizontally(puzzle, word, row, column))
			return true;
		else if(checkdiagonnally(puzzle, word, row, column))
			return true;
		else
			return false;	
	}
	boolean checkhorizontally(String[] puzzle,String word,int row,int column)
	{
		if(word.length()>puzzle[row].length()-column)//no need to check if the length of word to be searched is greater than row
		{
			return false;
		}
		else
		{
			
			for(int i=0;i<word.length();i++)
			{
				if(puzzle[row].charAt(column+i)!=word.charAt(i))
					return false;
			}
			return true;
			
		}
	}
	boolean checkvertically(String[] puzzle,String word,int row,int column)
	{
		if(word.length()>puzzle.length-row)//no need to check if the length of word to be searched is greater than row
		{
			return false;
		}
		else
		{
			
			for(int i=0;i<word.length();i++)
			{
				if(puzzle[row+i].charAt(column)!=word.charAt(i))
					return false;
			}
			return true;
			
		}
	}
	boolean checkdiagonnally(String[] puzzle,String word,int row,int column)
	{
		if(word.length()>puzzle[row].length()-column || word.length()>puzzle.length-row)//no need to check if the length of word to be searched is greater than row
		{
			return false;
		}
		else
		{
			
			for(int i=0;i<word.length();i++)
			{
				if(puzzle[row+i].charAt(column+i)!=word.charAt(i))
					return false;
			}
			return true;
			
		}
	}
	public static void main(String[] args) 
	{
		
		String grid[] = {"EASYTOFINDEAGSRVHOTCJYG",
				 "FLVENKDHCESOXXXXFAGJKEO",
				 "YHEDYNAIRQGIZECGXQLKDBI",
				 "DEIJFKABAQSIHSNDLOMYJIN",
				 "CKXINIMMNGRNSNRGIWQLWOG",
				 "VOFQDROQGCWDKOUYRAFUCDO",
				 "PFLXWTYKOITSURQJGEGSPGG"};
		String wordList[] = {"EASYTOFIND", "DIAG", "GOING", "THISISTOOLONGTOFITINTHISPUZZLE"};
		WordFind find =  new WordFind();
		String returned[] = find.findWords(grid, wordList);
		System.out.println("the length is "+ returned.length);
		for(int i=0;i<returned.length;i++)
		{
			System.out.println(returned[i]);
		}
	}

}
