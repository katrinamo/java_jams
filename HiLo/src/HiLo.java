import java.util.Scanner;

public class HiLo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String playAgain = "";
		
		do {
			
			//Generate a random number
			int theNumber = (int) (Math.random() * 100 + 1);
			//System.out.println(theNumber);

			int tries = 0;
			int guess = 0;

			while(guess != theNumber) {
				System.out.println("Guess a number between 1 and 100:");
				
				//Automatically takes input as an integer
				guess = scan.nextInt();
				System.out.println("You guessed " + guess + ".");
				tries++;

				if (guess > theNumber) 
					System.out.println("Your guess " + guess + " is high. Try again!");
				else if (guess < theNumber)
					System.out.println("Your guess " + guess + " is low. Try again!");
				else {
					System.out.println("Your guess of " + guess + " is correct! Congrats!");
					System.out.println("It only took you " + tries + " tries!");
				}
				
			}
			
			//Prompt for continuation
			System.out.println("Would you like to play again? (y/n)");
			playAgain = scan.next();
			
		} while (playAgain.equalsIgnoreCase("y"));
		
		System.out.println("Thanks for playing!");
		scan.close();
	}

}
