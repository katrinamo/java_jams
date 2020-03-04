import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	/**
	 * GuessingGame - A simple GUI based HiLo guessing game.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtGuess;
	private JLabel lblOutput;
	private JButton btnRestart;
	private int theNumber;
	
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		
		try {
			// convert the string to a number
			int guess = Integer.parseInt(guessText);

			if (guess < theNumber)
				message = guess + " is too low. Try again!";
			else if (guess > theNumber)
				message = guess + " is too high. Try again!";
			else {
				message = guess + " is correct! You win!!! :D";
				btnRestart.setVisible(true);
			}
		} catch (Exception e ) {
			message = "Enter an integer between 1 and 100.";
		} finally {
			// Make the label reflect the result, make it so you automatically write over numbers
			lblOutput.setText(message);			
			txtGuess.requestFocusInWindow();
			txtGuess.selectAll();
			
		}
	}
	
	// A new game simply means to generate a new number, make play again button 
	// invisible, reset text
	public void newGame() {
		lblOutput.setText("Enter a number in the text box and hit the button to submit!");
		btnRestart.setVisible(false);
		theNumber = (int) (Math.random()*100 + 1);
	}
	
	public GuessingGame() {
		setTitle("Katie's HiLo Guessing Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Katie's HiLo Guessing Game");
		lblNewLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 39, 414, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(45, 92, 230, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setBounds(285, 89, 44, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(163, 145, 89, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number in the text box and hit the button to submit!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(45, 207, 330, 14);
		getContentPane().add(lblOutput);
		
		btnRestart = new JButton("Play Again?");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		btnRestart.setBounds(151, 179, 113, 23);
		getContentPane().add(btnRestart);
		btnRestart.setVisible(false);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(500, 300));
		theGame.setVisible(true);
	}
}
