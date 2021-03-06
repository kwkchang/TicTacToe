import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TicTacToe_V1 {

	private JFrame frame;

	int turn = 1; //will be incremented after each turn.
	boolean clicked1 = false, clicked2 = false, clicked3 = false, clicked4 = false, clicked5 = false, clicked6 = false,
			clicked7 = false, clicked8 = false, clicked9 = false; //will be set to true once the player or computer has selected a button.

	int b1, b2, b3, b4, b5, b6, b7, b8, b9 = 0;		
	//will later be changed to reflect value in the box (ie 'X' will be represented by 1, 'O' will be represented by 2)
	
	int winCount1 = 0;
	int winCount2 = 0;

	boolean computerwins = false; //Only used for "tie" code for 1 player, "Go Second" mode.
	
	private JTextField name1; //The textbox where player1 will insert his name.
	private JTextField name2; //The textbox where player2 will insert his name.

	/**
	 * 
	 * Launch the application.
	 * 
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe_V1 window = new TicTacToe_V1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Create the application.
	 * 
	 */

	public TicTacToe_V1() {
		initialize();

	}

	/**
	 * 
	 * Initialize the contents of the frame.
	 * 
	 */

	private void initialize() {
		frame = new JFrame();
		//setting the title of the frame.
		frame.setTitle("Tic Tac Toe"); 
		//the boundaries for the window.
		frame.setBounds(100, 100, 600, 800); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//creating a label called lblWelcome.
		JLabel lblWelcome = new JLabel("Welcome to Kyle and Andre's Tic Tac Toe!");
		//setting the font and size of the label.
		lblWelcome.setFont(new Font("Lucida Bright", Font.BOLD, 26));
		//location of the label.
		lblWelcome.setBounds(10, 11, 555, 88);
		//adds lblWelcome to the homepage.
		frame.getContentPane().add(lblWelcome);

		//creating a button called btn1Player.
		JButton btn1Player = new JButton("1 player");
		//setting the font and size of the button.
		btn1Player.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		//location of the button.
		btn1Player.setBounds(88, 110, 117, 23);
		//adds btn1Player to the homepage.
		frame.getContentPane().add(btn1Player);

		//creating a button called btn2Players.
		JButton btn2Players = new JButton("2 players");
		//setting the font and size of the button.
		btn2Players.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		//location of the button.
		btn2Players.setBounds(385, 110, 117, 23);
		//adds btn2Players to the homepage.
		frame.getContentPane().add(btn2Players);
		
		
		//what happens to the screen when btn1Player is clicked.
		btn1Player.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				//btn1Player, btn2Players, and lblWelcome are removed from view.
				frame.getContentPane().remove(btn1Player);
				frame.getContentPane().remove(btn2Players);
				frame.getContentPane().remove(lblWelcome);

				//a new button called btnGoFirst is created, and added to the screen.
				JButton btnGoFirst = new JButton("Go First");
				btnGoFirst.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
				btnGoFirst.setBounds(88, 110, 117, 23);
				frame.getContentPane().add(btnGoFirst);

				//a new button called btnGoSecond is created, and added to the screen.
				JButton btnGoSecond = new JButton("Go Second");
				btnGoSecond.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
				btnGoSecond.setBounds(385, 110, 117, 23);
				frame.getContentPane().add(btnGoSecond);

				//these two lines are used throughout the code to reset the screen with new changes.
				frame.revalidate();
				frame.repaint();

				
				//what happens to the screen when btnGoFirst is clicked.
				btnGoFirst.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						//btnGoFirst and btnGoSecond are removed.
						frame.getContentPane().remove(btnGoFirst);
						frame.getContentPane().remove(btnGoSecond);

						//9 buttons are created, with their locations defined, and are added to the screen to form the Tic Tac Toe board.
						JButton btn1 = new JButton("");
						btn1.setBounds(56, 143, 141, 141);
						frame.getContentPane().add(btn1);

						JButton btn2 = new JButton("");
						btn2.setBounds(220, 143, 141, 141);
						frame.getContentPane().add(btn2);

						JButton btn3 = new JButton("");
						btn3.setBounds(385, 143, 141, 141);
						frame.getContentPane().add(btn3);

						JButton btn4 = new JButton("");
						btn4.setBounds(56, 305, 141, 141);
						frame.getContentPane().add(btn4);

						JButton btn5 = new JButton("");
						btn5.setBounds(220, 305, 141, 141);
						frame.getContentPane().add(btn5);

						JButton btn6 = new JButton("");
						btn6.setBounds(385, 305, 141, 141);
						frame.getContentPane().add(btn6);

						JButton btn7 = new JButton("");
						btn7.setBounds(56, 467, 141, 141);
						frame.getContentPane().add(btn7);

						JButton btn8 = new JButton("");
						btn8.setBounds(220, 467, 141, 141);
						frame.getContentPane().add(btn8);

						JButton btn9 = new JButton("");
						btn9.setBounds(385, 467, 141, 141);
						frame.getContentPane().add(btn9);
						
						//Creates a button called ragequit
						JButton ragequit = new JButton("RAGE QUIT!");
						ragequit.setForeground(Color.RED);
						ragequit.setFont(new Font("Lucida Bright", Font.BOLD, 25));
						ragequit.setBounds(197, 650, 188, 40);
						frame.getContentPane().add(ragequit);

						//What happens when the button is clicked
						ragequit.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent arg0) {
								
								//Closes the frame
								frame.dispose();
								
							}
						});

						frame.revalidate();
						frame.repaint();

						/*The AI for when the human chooses to go first is composed of 3 main "if" statements.
						 *The human's moves are shown in a red 'X' and the computer's moves are shown in a blue 'O'.
						 *
						 *The FIRST "if" statement runs if the human clicks the button on the first turn. 
						 *Then, turn is incremented, assignments are made to the variable clickedX (where X is the button number) to true so it can't be clicked again, and bX (where X is the button number) to 1 to be used for the win code.
						 *
						 *The SECOND "if" statement sets the computer's first turn. If the human didn't go in btn5 (the middle), the computer will go there.
						 *If the human went into the middle for its first turn, the computer goes to btn1 (top left).
						 *
						 *The THIRD "if" statement is the most complicated. It can be broken down further into five parts.
						 *PART 1 - If the human clicks the corresponding button and there has been more than 3 turns and the button hasn't been clicked, it is labelled as 'X'.
						 *Then, turn is incremented, assignments are made to the variable clickedX (where X is the button number) to true so it can't be clicked again, and bX (where X is the button number) to 1 to be used for the win code.
						 *PART 2 (which runs if PART 1 has occurred) - The computer now checks if there is a way to win. The 24 different scenarios of being 1 click away from winning are checked.
						 *If one of thse scenarios are met, the computer will make its move to win & lblYouLose will appear. If none of these scenarios are available, PART 3 runs.
						 *PART 3 - Checks to see if the player is about to win. 
						 *The 24 scenarios of where the human is one click away from winning is checked, and the computer clicks the button which blocks the human.
						 *A few exceptions have been added to this part so that the human can't "fork" (ie two ways of winning) the computer.
						 *If none of these scenarios are available, PART 4 runs.
						 *PART 4 - The computer moves to an empty square. clicked5 is omitted because it'll always be occupated after the first two turns.
						 *clicked9 is omitted because the computer will never have the last move if it goes second.
						 *clickedX (where X is the button number) is omitted. Ie clicked6 is not checked in the btn6 event.
						 *PART 5 - Is the tie code. If all the buttons are clicked and the computer hasn't won, lbltie will appear.
						 */
						btn1.addActionListener(new ActionListener() {
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn == 1) {
									btn1.setLabel("X"); // IMPORTANT
									btn1.setForeground(Color.RED);
									btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked1 = true;
									b1 = 1;

									frame.revalidate();
									frame.repaint();
								}
								if (turn == 2 && clicked5 == false) {
									btn5.setLabel("O"); // IMPORTANT
									btn5.setForeground(Color.BLUE);
									btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked5 = true;
									b5 = 2;

									frame.revalidate();
									frame.repaint();
								}
								if (turn >= 3 && clicked1 == false){
									btn1.setLabel("X"); // IMPORTANT
									btn1.setForeground(Color.RED);
									btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked1 = true;
									b1 = 1;
									frame.revalidate();
									frame.repaint();

									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}

									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b8 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										JLabel lbltie = new JLabel("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}	
								}
							}
						});

						btn2.addActionListener(new ActionListener() {
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn == 1) {
									btn2.setLabel("X"); // IMPORTANT
									btn2.setForeground(Color.RED);
									btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked2 = true;
									b2 = 1;

									frame.revalidate();
									frame.repaint();
								}
								if (turn == 2 && clicked5 == false) {
									btn5.setLabel("O"); // IMPORTANT
									btn5.setForeground(Color.BLUE);
									btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked5 = true;
									b5 = 2;

									frame.revalidate();
									frame.repaint();
								}
								if (turn >= 3 && clicked2 == false){
									btn2.setLabel("X"); // IMPORTANT
									btn2.setForeground(Color.RED);
									btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked2 = true;
									b2 = 1;
									frame.revalidate();
									frame.repaint();

									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b8 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										JLabel lbltie = new JLabel("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}	
								}
							}
						});

						btn3.addActionListener(new ActionListener() {
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn == 1) {
									btn3.setLabel("X"); // IMPORTANT
									btn3.setForeground(Color.RED);
									btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked3 = true;
									b3 = 1;

									frame.revalidate();
									frame.repaint();
								}
								if (turn == 2 && clicked5 == false) {
									btn5.setLabel("O"); // IMPORTANT
									btn5.setForeground(Color.BLUE);
									btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked5 = true;
									b5 = 2;

									frame.revalidate();
									frame.repaint();
								}
								if (turn >= 3 && clicked3 == false){
									btn3.setLabel("X"); // IMPORTANT
									btn3.setForeground(Color.RED);
									btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked3 = true;
									b3 = 1;
									frame.revalidate();
									frame.repaint();
									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b8 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}

									else if (clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										JLabel lbltie = new JLabel("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}	
								}
							}
						});

						btn4.addActionListener(new ActionListener() {
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn == 1) {
									btn4.setLabel("X"); // IMPORTANT
									btn4.setForeground(Color.RED);
									btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked4 = true;
									b4 = 1;

									frame.revalidate();
									frame.repaint();
								}
								if (turn == 2 && clicked5 == false) {
									btn5.setLabel("O"); // IMPORTANT
									btn5.setForeground(Color.BLUE);
									btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked5 = true;
									b5 = 2;

									frame.revalidate();
									frame.repaint();
								}
								if (turn >= 3 && clicked4 == false){
									btn4.setLabel("X"); // IMPORTANT
									btn4.setForeground(Color.RED);
									btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked4 = true;
									b4 = 1;
									frame.revalidate();
									frame.repaint();
									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b8 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										JLabel lbltie = new JLabel("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}	
								}
							}
						});

						btn5.addActionListener(new ActionListener() {
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn == 1) {
									btn5.setLabel("X"); // IMPORTANT
									btn5.setForeground(Color.RED);
									btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked5 = true;
									b5 = 1;

									frame.revalidate();
									frame.repaint();
								}
								if (turn == 2 && clicked1 == false) {
									btn1.setLabel("O"); // IMPORTANT
									btn1.setForeground(Color.BLUE);
									btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked1 = true;
									b1 = 2;

									frame.revalidate();
									frame.repaint();
								}
							}
						});

						btn6.addActionListener(new ActionListener() {
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn == 1) {
									btn6.setLabel("X"); // IMPORTANT
									btn6.setForeground(Color.RED);
									btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked6 = true;
									b6 = 1;

									frame.revalidate();
									frame.repaint();
								}
								if (turn == 2 && clicked5 == false) {
									btn5.setLabel("O"); // IMPORTANT
									btn5.setForeground(Color.BLUE);
									btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked5 = true;
									b5 = 2;

									frame.revalidate();
									frame.repaint();
								}
								if (turn >= 3 && clicked6 == false){
									btn6.setLabel("X"); // IMPORTANT
									btn6.setForeground(Color.RED);
									btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked6 = true;
									b6 = 1;

									frame.revalidate();
									frame.repaint();

									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}

									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b8 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b7 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										JLabel lbltie = new JLabel("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}	
								}
							}
						});

						btn7.addActionListener(new ActionListener() {
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn == 1) {
									btn7.setLabel("X"); // IMPORTANT
									btn7.setForeground(Color.RED);
									btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked7 = true;
									b7 = 1;

									frame.revalidate();
									frame.repaint();
								}
								if (turn == 2 && clicked5 == false) {
									btn5.setLabel("O"); // IMPORTANT
									btn5.setForeground(Color.BLUE);
									btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked5 = true;
									b5 = 2;

									frame.revalidate();
									frame.repaint();
								}
								if (turn >= 3 && clicked7 == false){
									btn7.setLabel("X"); // IMPORTANT
									btn7.setForeground(Color.RED);
									btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked7 = true;
									b7 = 1;
									frame.revalidate();
									frame.repaint();

									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}

									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b8 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b7 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										JLabel lbltie = new JLabel("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}	
								}
							}
						});

						btn8.addActionListener(new ActionListener() {
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn == 1) {
									btn8.setLabel("X"); // IMPORTANT
									btn8.setForeground(Color.RED);
									btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked8 = true;
									b8 = 1;

									frame.revalidate();
									frame.repaint();
								}
								if (turn == 2 && clicked5 == false) {
									btn5.setLabel("O"); // IMPORTANT
									btn5.setForeground(Color.BLUE);
									btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked5 = true;
									b5 = 2;

									frame.revalidate();
									frame.repaint();
								}
								if (turn >= 3 && clicked8 == false){
									btn8.setLabel("X"); // IMPORTANT
									btn8.setForeground(Color.RED);
									btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked8 = true;
									b8 = 1;
									frame.revalidate();
									frame.repaint();

									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}

									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b8 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b7 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										JLabel lbltie = new JLabel("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}	
								}
							}
						});

						btn9.addActionListener(new ActionListener() {
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn == 1) {
									btn9.setLabel("X"); // IMPORTANT
									btn9.setForeground(Color.RED);
									btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked9 = true;
									b9 = 1;

									frame.revalidate();
									frame.repaint();
								}
								if (turn == 2 && clicked5 == false) {
									btn5.setLabel("O"); // IMPORTANT
									btn5.setForeground(Color.BLUE);
									btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked5 = true;
									b5 = 2;

									frame.revalidate();
									frame.repaint();
								}
								if (turn >= 3 && clicked9 == false){
									btn9.setLabel("X"); // IMPORTANT
									btn9.setForeground(Color.RED);
									btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked9 = true;
									b9 = 1;
									frame.revalidate();
									frame.repaint();

									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}

									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										JLabel lbltie = new JLabel("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}	
								}
							}
						});
					}
				});

				btnGoSecond.addActionListener(new ActionListener() {

					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {

						frame.getContentPane().remove(btnGoFirst);
						frame.getContentPane().remove(btnGoSecond);
						frame.getContentPane().remove(lblWelcome);

						JButton btn1 = new JButton("");
						btn1.setBounds(56, 143, 141, 141);
						frame.getContentPane().add(btn1);

						JButton btn2 = new JButton("");
						btn2.setBounds(220, 143, 141, 141);
						frame.getContentPane().add(btn2);

						JButton btn3 = new JButton("");
						btn3.setBounds(385, 143, 141, 141);
						frame.getContentPane().add(btn3);

						JButton btn4 = new JButton("");
						btn4.setBounds(56, 305, 141, 141);
						frame.getContentPane().add(btn4);

						JButton btn5 = new JButton("");
						btn5.setBounds(220, 305, 141, 141);
						frame.getContentPane().add(btn5);

						JButton btn6 = new JButton("");
						btn6.setBounds(385, 305, 141, 141);
						frame.getContentPane().add(btn6);

						JButton btn7 = new JButton("");
						btn7.setBounds(56, 467, 141, 141);
						frame.getContentPane().add(btn7);

						JButton btn8 = new JButton("");
						btn8.setBounds(220, 467, 141, 141);
						frame.getContentPane().add(btn8);

						JButton btn9 = new JButton("");
						btn9.setBounds(385, 467, 141, 141);
						frame.getContentPane().add(btn9);
						
						//Creates a button called ragequit
						JButton ragequit = new JButton("RAGE QUIT!");
						ragequit.setForeground(Color.RED);
						ragequit.setFont(new Font("Lucida Bright", Font.BOLD, 25));
						ragequit.setBounds(197, 650, 188, 40);
						frame.getContentPane().add(ragequit);

						//What happens when the button is clicked
						ragequit.addActionListener(new ActionListener() {
							
							public void actionPerformed(ActionEvent arg0) {
								
								//Closes the frame
								frame.dispose();
								
							}
						});

						btn5.setLabel("O"); // IMPORTANT
						btn5.setForeground(Color.BLUE);
						btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
						turn++;
						clicked5 = true;
						b5 = 2;

						frame.revalidate();
						frame.repaint();

						btn1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 == 0 && clicked1 == false) {
									btn1.setLabel("X"); // IMPORTANT
									btn1.setForeground(Color.RED);
									btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked1 = true;
									b1 = 1;

									if (turn == 3){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
									}
								}
								if (turn % 2 == 1){
									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}

									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b8 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b7 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked9 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}

								}
								if (turn == 10 && computerwins == false) {
									JLabel lbltie = new JLabel("Tie Game!");
									lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
									lbltie.setBounds(20, 67, 249, 60);
									frame.getContentPane().add(lbltie);
									frame.revalidate();
									frame.repaint();
								}	

							}
						});

						btn2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 == 0 && clicked2 == false) {
									btn2.setLabel("X"); // IMPORTANT
									btn2.setForeground(Color.RED);
									btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked2 = true;
									b2 = 1;

									if (turn == 3){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
									}
								}
								if (turn % 2 == 1){
									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}

									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b8 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b7 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked9 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}

								}
								if (turn == 10 && computerwins == false) {
									JLabel lbltie = new JLabel("Tie Game!");
									lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
									lbltie.setBounds(20, 67, 249, 60);
									frame.getContentPane().add(lbltie);
									frame.revalidate();
									frame.repaint();
								}	
							}
						});

						btn3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 == 0 && clicked3 == false) {
									btn3.setLabel("X"); // IMPORTANT
									btn3.setForeground(Color.RED);
									btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked3 = true;
									b3 = 1;


									if (turn == 3){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
									}
								}
								if (turn % 2 == 1){
									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}

									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b8 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b7 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked9 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}

								}
								if (turn == 10 && computerwins == false) {
									JLabel lbltie = new JLabel("Tie Game!");
									lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
									lbltie.setBounds(20, 67, 249, 60);
									frame.getContentPane().add(lbltie);
									frame.revalidate();
									frame.repaint();
								}	
							}
						});

						btn4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 == 0 && clicked4 == false) {
									btn4.setLabel("X"); // IMPORTANT
									btn4.setForeground(Color.RED);
									btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked4 = true;
									b4 = 1;

									if (turn == 3){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 1;
									}
								}
								if (turn % 2 == 1){
									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}

									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b8 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b7 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked9 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}

								}
								if (turn == 10 && computerwins == false) {
									JLabel lbltie = new JLabel("Tie Game!");
									lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
									lbltie.setBounds(20, 67, 249, 60);
									frame.getContentPane().add(lbltie);
									frame.revalidate();
									frame.repaint();
								}	
							}
						});

						btn6.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 == 0 && clicked6 == false) {
									btn6.setLabel("X"); // IMPORTANT
									btn6.setForeground(Color.RED);
									btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked6 = true;
									b6 = 1;

									if (turn == 3){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
									}
								}
								if (turn % 2 == 1){
									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}

									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b8 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b7 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked9 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}

								}
								if (turn == 10 && computerwins == false) {
									JLabel lbltie = new JLabel("Tie Game!");
									lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
									lbltie.setBounds(20, 67, 249, 60);
									frame.getContentPane().add(lbltie);
									frame.revalidate();
									frame.repaint();
								}	
							}
						});

						btn7.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 == 0 && clicked7 == false) {
									btn7.setLabel("X"); // IMPORTANT
									btn7.setForeground(Color.RED);
									btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked7 = true;
									b7 = 1;

									if (turn == 3){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
									}
								}
								if (turn % 2 == 1){
									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}

									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b8 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b7 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked9 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
								}
								if (turn == 10 && computerwins == false) {
									JLabel lbltie = new JLabel("Tie Game!");
									lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
									lbltie.setBounds(20, 67, 249, 60);
									frame.getContentPane().add(lbltie);
									frame.revalidate();
									frame.repaint();
								}	
							}
						});

						btn8.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 == 0 && clicked8 == false) {
									btn8.setLabel("X"); // IMPORTANT
									btn8.setForeground(Color.RED);
									btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked8 = true;
									b8 = 1;

									if (turn == 3){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
									}
								}
								if (turn % 2 == 1){
									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}

									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b8 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b7 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked9 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
								}
								if (turn == 10 && computerwins == false) {
									JLabel lbltie = new JLabel("Tie Game!");
									lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
									lbltie.setBounds(20, 67, 249, 60);
									frame.getContentPane().add(lbltie);
									frame.revalidate();
									frame.repaint();
								}	
							}
						});

						btn9.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 == 0 && clicked9 == false) {
									btn9.setLabel("X"); // IMPORTANT
									btn9.setForeground(Color.RED);
									btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked9 = true;
									b9 = 1;

									if (turn == 3){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
									}
								}
								if (turn % 2 == 1){
									if (b1 == 2 && b2 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b3 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b3 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b5 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b6 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b6 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b8 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b7 == 2 && b9 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b8 == 2 && b9 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b4 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b7 == 2 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b4 == 2 && b7 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b5 == 2 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b2 == 2 && b8 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b8 == 2 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b6 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b9 == 2 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b6 == 2 && b9 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b5 == 2 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b1 == 2 && b9 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b9 == 2 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b5 == 2 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b3 == 2 && b7 == 2 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (b5 == 2 && b7 == 2 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;
										computerwins = true;
										JLabel lblYouLose = new JLabel("You Lose!");
										lblYouLose.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblYouLose.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblYouLose);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}

									else if (b1 == 1 && b2 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b3 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b3 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b5 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b6 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b6 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b7 == 1 && b9 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b8 == 1 && b9 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b4 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b7 == 1 && clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b4 == 1 && b7 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b5 == 1 && clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b2 == 1 && b8 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b8 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b6 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b9 == 1 && clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b9 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b5 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b9 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b9 == 1 && clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b5 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked5 == false){
										btn5.setLabel("O"); // IMPORTANT
										btn5.setForeground(Color.BLUE);
										btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked5 = true;
										b5 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b7 == 1 && clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b5 == 1 && b7 == 1 && clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b1 == 1 && b8 == 1 && clicked7 == false){
										btn7.setLabel("O"); // IMPORTANT
										btn7.setForeground(Color.BLUE);
										btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked7 = true;
										b7 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b3 == 1 && b8 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (b6 == 1 && b7 == 1 && clicked9 == false){
										btn9.setLabel("O"); // IMPORTANT
										btn9.setForeground(Color.BLUE);
										btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked9 = true;
										b9 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == false){
										btn1.setLabel("O"); // IMPORTANT
										btn1.setForeground(Color.BLUE);
										btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked1 = true;
										b1 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked2 == false){
										btn2.setLabel("O"); // IMPORTANT
										btn2.setForeground(Color.BLUE);
										btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked2 = true;
										b2 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked3 == false){
										btn3.setLabel("O"); // IMPORTANT
										btn3.setForeground(Color.BLUE);
										btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked3 = true;
										b3 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked4 == false){
										btn4.setLabel("O"); // IMPORTANT
										btn4.setForeground(Color.BLUE);
										btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked4 = true;
										b4 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked6 == false){
										btn6.setLabel("O"); // IMPORTANT
										btn6.setForeground(Color.BLUE);
										btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked6 = true;
										b6 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked8 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}
									else if (clicked9 == false){
										btn8.setLabel("O"); // IMPORTANT
										btn8.setForeground(Color.BLUE);
										btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
										turn++;
										clicked8 = true;
										b8 = 2;

										frame.revalidate();
										frame.repaint();
									}

								}
								if (turn == 10 && computerwins == false) {
									JLabel lbltie = new JLabel("Tie Game!");
									lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
									lbltie.setBounds(20, 67, 249, 60);
									frame.getContentPane().add(lbltie);
									frame.revalidate();
									frame.repaint();
								}	
							}
						});
					}
				});

			}
		});
	
		//What happens when btn2Players is clicked
		btn2Players.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				//Removes the labels and buttons from the home screen
				frame.getContentPane().remove(lblWelcome);
				frame.getContentPane().remove(btn2Players);
				frame.getContentPane().remove(btn1Player);

				//label prompts user to enter his / her name
				JLabel enterplayer1name = new JLabel("Enter Player 1's Name:");
				enterplayer1name.setFont(new Font("Lucida Bright", Font.PLAIN, 22));
				enterplayer1name.setBounds(45, 165, 264, 67);
				frame.getContentPane().add(enterplayer1name);
				frame.revalidate();
				frame.repaint();

				//Same as above
				JLabel enterplayer2name = new JLabel("Enter Player 2's Name:");
				enterplayer2name.setFont(new Font("Lucida Bright", Font.PLAIN, 22));
				enterplayer2name.setBounds(45, 263, 264, 67);
				frame.getContentPane().add(enterplayer2name);
				frame.revalidate();
				frame.repaint();

				//allows the users to input their names
				name1 = new JTextField();
				name1.setBounds(316, 182, 186, 32);
				frame.getContentPane().add(name1);
				name1.setColumns(10);
				frame.revalidate();
				frame.repaint();

				name2 = new JTextField();
				name2.setBounds(316, 280, 186, 32);
				frame.getContentPane().add(name2);
				name2.setColumns(10);
				frame.revalidate();
				frame.repaint();

				//A new button called "Let's GOOOOO!" is created, a font is added, and its location is set
				JButton btnLetsGooooo = new JButton("Let's GOOOOO!");
				btnLetsGooooo.setFont(new Font("Lucida Bright", Font.PLAIN, 24));
				btnLetsGooooo.setBounds(142, 391, 305, 88);
				frame.getContentPane().add(btnLetsGooooo);
				frame.revalidate();
				frame.repaint();

				//What happens when the button is clicked
				btnLetsGooooo.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						//Gets the text from the text fields name1 and name2 and assigns them to player1name and player2name
						String player1name = name1.getText();
						String player2name = name2.getText();

						//Everything from previous screen is removed
						frame.getContentPane().remove(enterplayer1name);
						frame.getContentPane().remove(enterplayer2name);
						frame.getContentPane().remove(name1);
						frame.getContentPane().remove(name2);
						frame.getContentPane().remove(btnLetsGooooo);

						//lblp1turn is created and added to the frame that indicated player 1's turn
						JLabel lblp1turn = new JLabel(player1name + "'s Turn");
						lblp1turn.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
						lblp1turn.setBounds(20, 67, 500, 60);
						frame.getContentPane().add(lblp1turn);
						frame.revalidate();
						frame.repaint();

						//lblp2turn is created, but not added to the frame that indicated player 2's turn
						JLabel lblp2turn = new JLabel(player2name + "'s Turn");
						lblp2turn.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
						lblp2turn.setBounds(20, 67, 500, 60);
						frame.revalidate();
						frame.repaint();
						
						//Creates a button called "Replay"
						JButton btnreplay = new JButton("Replay");
						btnreplay.setFont(new Font("Lucida Bright", Font.PLAIN, 26));
						btnreplay.setBounds(56, 650, 141, 40);
						frame.getContentPane().add(btnreplay);

						//Created a button called "Menu"
						JButton btnmenu = new JButton("Menu");
						btnmenu.setFont(new Font("Lucida Bright", Font.PLAIN, 26));
						btnmenu.setBounds(385, 650, 141, 40);
						frame.getContentPane().add(btnmenu);

						//Created buttons in a 3x3 grid for the tic-tac-toe board
						JButton btn1 = new JButton("");
						btn1.setBounds(56, 143, 141, 141);
						frame.getContentPane().add(btn1);
						
						JButton btn2 = new JButton("");
						btn2.setBounds(220, 143, 141, 141);
						frame.getContentPane().add(btn2);
						
						JButton btn3 = new JButton("");
						btn3.setBounds(385, 143, 141, 141);
						frame.getContentPane().add(btn3);
						
						JButton btn4 = new JButton("");
						btn4.setBounds(56, 305, 141, 141);
						frame.getContentPane().add(btn4);
						
						JButton btn5 = new JButton("");
						btn5.setBounds(220, 305, 141, 141);
						frame.getContentPane().add(btn5);
						
						JButton btn6 = new JButton("");
						btn6.setBounds(385, 305, 141, 141);
						frame.getContentPane().add(btn6);
						
						JButton btn7 = new JButton("");
						btn7.setBounds(56, 467, 141, 141);
						frame.getContentPane().add(btn7);
						
						JButton btn8 = new JButton("");
						btn8.setBounds(220, 467, 141, 141);
						frame.getContentPane().add(btn8);
						
						JButton btn9 = new JButton("");
						btn9.setBounds(385, 467, 141, 141);
						frame.getContentPane().add(btn9);
						
						frame.revalidate();
						frame.repaint();
						
						//Creates labels for the winning/losing/tie scenarios, to be used later
						JLabel lblPlayer1Wins = new JLabel(player1name + " Wins!");
						JLabel lblPlayer2Wins = new JLabel(player2name + " Wins!");
						JLabel lbltie = new JLabel("Tie Game!");
						frame.revalidate();
						frame.repaint();
					
						//Creates a label that displays each players name, followed by the number of games they have won.  It is added to the frame
						JLabel lblscore = new JLabel(player1name + ": " + winCount1
								+ "          " + player2name + ": " + winCount2);
						lblscore.setFont(new Font("Lucida Bright", Font.PLAIN, 22));
						lblscore.setBounds(56, 20, 500, 60);
						frame.getContentPane().add(lblscore);
						
						//What happens when the button "Menu" is clicked
						btnmenu.addActionListener(new ActionListener() {
					
							public void actionPerformed(ActionEvent arg0) {
								
								//Everything is removed
								frame.getContentPane().removeAll();
								
								//All of the variables are assigned to the values they had at the beginning of our code
								turn = 1;
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = false;
								b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;
								winCount1 = 0;
								winCount2 = 0;

								//Removes all of the X's and O's
								btn1.setLabel("");
								btn2.setLabel("");
								btn3.setLabel("");
								btn4.setLabel("");
								btn5.setLabel("");
								btn6.setLabel("");
								btn7.setLabel("");
								btn8.setLabel("");
								btn9.setLabel("");
							
								frame.revalidate();
								frame.repaint();
								
								//Adds the buttons and label on the starting menu
								frame.getContentPane().add(lblWelcome);				
								frame.getContentPane().add(btn1Player);
								frame.getContentPane().add(btn2Players);
								
								frame.revalidate();
								frame.repaint();
								
							}
						});
							
						//What happens when the button "replay" is clicked
						btnreplay.addActionListener(new ActionListener() {
							@SuppressWarnings({ "deprecation", "unused" })
							public void actionPerformed(ActionEvent arg0) {

								//All values are assigned to the values they had at the beginning of our code, except for winCount because we want to keep track of that
								turn = 1;
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = false;

								b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = 0;

								//X's and O's removed
								btn1.setLabel("");
								btn2.setLabel("");
								btn3.setLabel("");
								btn4.setLabel("");
								btn5.setLabel("");
								btn6.setLabel("");
								btn7.setLabel("");
								btn8.setLabel("");
								btn9.setLabel("");
								
								//All labels are removed and "lblp1turn" is added, as when the game starts, it will be player 1's turn
								frame.getContentPane().remove(lblp1turn);
								frame.getContentPane().remove(lblp2turn);
								frame.getContentPane().remove(lblPlayer1Wins);
								frame.getContentPane().remove(lblPlayer2Wins);
								frame.getContentPane().remove(lbltie);
								frame.getContentPane().add(lblp1turn);

								frame.revalidate();
								frame.repaint();
							}
						});
						
						/*	
						 * The first if statement checks to see if the turn number odd (meaning it is NOT divisible by 2) and that btn1 has not been clicked before.
						 * 	If this statement is true, btn1 gets "X" as a label.  Then, the turn number is increased by one (turn++), clicked1 is assigned the value
						 * 	of true, and "b1" is assigned the value of 1 (We assigned a 1 if it was "X" and 2 is it was "O").  Then, lblp1turn is removed and lblp2turn
						 * 	is added, which indicated that it is now player 2's turn.
						 * 
						 * 	The else if statement checks to see if btn1 has been clicked before and executes when the turn number is even (because otherwise the if
						 * 	statement above would have been true).  If this statement is true, btn1 gets "O" as a label, Then the turn number is increased by one 
						 * 	(turn++), clicked1 is assigned the value of true, and "b1" is assigned the value of 2 (Which means that it is "O").  Then lblp2turn is removed
						 *  and lblp1turn is added, which indicated that it is now player 1's turn
						 *  
						 *  The second if statement is true if the turn number is 5 or greater and all of the buttons have not been clicked yet.
						 *  
						 *  The next if statement is nested, which means that is only executes when the if statement above is true.  It checks to see if there are three X's
						 *  in a row/column/diagonal anywhere.  It does this by checking to see if all three of the buttons (i.e. b1, b2, b3 OR b2 in any given row all have 
						 *  the value of 1. If the if statement is true, lblp2turn is removed, and lblPlayer1Wins is added.  All clicked_'s are made true, because since the 
						 *  game is won, you should not be able to keep playing.
						 *  
						 *  The next nested else if statement is the same as the one above, however, it checks to see if there are three O's in a row/column/diagonal anywhere 
						 *  (which uses the number 2).  If it is true, it adds lblPlayer2Wins. It also makes all the clicked_'s true
						 *  
						 *  The last nested else if statement simply checks if all clicked_'s are true.  If so, lblp2turn is removed and lbltie is added, since all of the boxes
						 *  have been clicked but neither X or O has three in a row.
						 *  
						 *  NOTE: This block explains btn1, however, it applied to all of the btn_ buttons.					  					
						 */
						btn1.addActionListener(new ActionListener() {
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {

								if (turn % 2 != 0 && clicked1 == false) {
									btn1.setLabel("X"); // IMPORTANT
									btn1.setForeground(Color.RED);
									btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked1 = true;
									b1 = 1;

									frame.getContentPane().remove(lblp1turn);
									frame.getContentPane().add(lblp2turn);
									frame.revalidate();
									frame.repaint();

								} else if (clicked1 == false) {
									btn1.setLabel("O"); // IMPORTANT
									btn1.setForeground(Color.BLUE);
									btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked1 = true;
									b1 = 2;

									frame.getContentPane().remove(lblp2turn);
									frame.getContentPane().add(lblp1turn);
									frame.revalidate();
									frame.repaint();

								}
								if ((turn >= 5) && !(clicked1 == true && clicked2 == true && clicked3 == true
										&& clicked4 == true && clicked5 == true && clicked6 == true
										&& clicked7 == true && clicked8 == true && clicked9 == true)) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										lblPlayer1Wins.setText(player1name + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount1++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
									}
										
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										lblPlayer2Wins.setText(player2name + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount2++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
										lbltie.setText("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}
									
									
								}
								}
							
							});
						
						
					

						
						btn2.addActionListener(new ActionListener() {
							// @SuppressWarnings("deprecation")
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 != 0 && clicked2 == false) {
									btn2.setLabel("X"); // IMPORTANT
									btn2.setForeground(Color.RED);
									btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked2 = true;
									b2 = 1;

									frame.getContentPane().remove(lblp1turn);
									frame.getContentPane().add(lblp2turn);
									frame.revalidate();
									frame.repaint();
								} else if (clicked2 == false) {
									btn2.setLabel("O"); // IMPORTANT
									btn2.setForeground(Color.BLUE);
									btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked2 = true;
									b2 = 2;

									frame.getContentPane().remove(lblp2turn);
									frame.getContentPane().add(lblp1turn);
									frame.revalidate();
									frame.repaint();
								}

								if ((turn >= 5) && !(clicked1 == true && clicked2 == true && clicked3 == true
										&& clicked4 == true && clicked5 == true && clicked6 == true
										&& clicked7 == true && clicked8 == true && clicked9 == true)) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										lblPlayer1Wins.setText(player1name + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount1++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										lblPlayer2Wins.setText(player2name + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount2++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
										lbltie.setText("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}
								}
							}
						});

						
						btn3.addActionListener(new ActionListener() {
							// @SuppressWarnings("deprecation")
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 != 0 && clicked3 == false) {
									btn3.setLabel("X"); // IMPORTANT
									btn3.setForeground(Color.RED);
									btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked3 = true;
									b3 = 1;

									frame.getContentPane().remove(lblp1turn);
									frame.getContentPane().add(lblp2turn);
									frame.revalidate();
									frame.repaint();
								} else if (clicked3 == false) {
									btn3.setLabel("O"); // IMPORTANT
									btn3.setForeground(Color.BLUE);
									btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked3 = true;
									b3 = 2;

									frame.getContentPane().remove(lblp2turn);
									frame.getContentPane().add(lblp1turn);
									frame.revalidate();
									frame.repaint();
								}
								if ((turn >= 5) && !(clicked1 == true && clicked2 == true && clicked3 == true
										&& clicked4 == true && clicked5 == true && clicked6 == true
										&& clicked7 == true && clicked8 == true && clicked9 == true)) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										lblPlayer1Wins.setText(player1name + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount1++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										lblPlayer2Wins.setText(player2name + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount2++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true 											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
										lbltie.setText("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}
								}
							}
						});
						
						btn4.addActionListener(new ActionListener() {
							// @SuppressWarnings("deprecation")
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 != 0 && clicked4 == false) {
									btn4.setLabel("X"); // IMPORTANT
									btn4.setForeground(Color.RED);
									btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked4 = true;
									b4 = 1;

									frame.getContentPane().remove(lblp1turn);
									frame.getContentPane().add(lblp2turn);
									frame.revalidate();
									frame.repaint();
								} else if (clicked4 == false) {
									btn4.setLabel("O"); // IMPORTANT
									btn4.setForeground(Color.BLUE);
									btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked4 = true;
									b4 = 2;

									frame.getContentPane().remove(lblp2turn);
									frame.getContentPane().add(lblp1turn);
									frame.revalidate();
									frame.repaint();
								}
								if ((turn >= 5) && !(clicked1 == true && clicked2 == true && clicked3 == true
										&& clicked4 == true && clicked5 == true && clicked6 == true
										&& clicked7 == true && clicked8 == true && clicked9 == true)) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										lblPlayer1Wins.setText(player1name + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount1++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										lblPlayer2Wins.setText(player2name + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount2++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
										lbltie.setText("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}
								}
							}
						});

						
						btn5.addActionListener(new ActionListener() {
							// @SuppressWarnings("deprecation")
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 != 0 && clicked5 == false) {
									btn5.setLabel("X"); // IMPORTANT
									btn5.setForeground(Color.RED);
									btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked5 = true;
									b5 = 1;

									frame.getContentPane().remove(lblp1turn);
									frame.getContentPane().add(lblp2turn);
									frame.revalidate();
									frame.repaint();
								} else if (clicked5 == false) {
									btn5.setLabel("O"); // IMPORTANT
									btn5.setForeground(Color.BLUE);
									btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked5 = true;
									b5 = 2;

									frame.getContentPane().remove(lblp2turn);
									frame.getContentPane().add(lblp1turn);
									frame.revalidate();
									frame.repaint();
								}
								if ((turn >= 5) && !(clicked1 == true && clicked2 == true && clicked3 == true
										&& clicked4 == true && clicked5 == true && clicked6 == true
										&& clicked7 == true && clicked8 == true && clicked9 == true)) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										lblPlayer1Wins.setText(player1name + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount1++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										lblPlayer2Wins.setText(player2name + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount2++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
										lbltie.setText("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}
								}
							}
						});

						
						btn6.addActionListener(new ActionListener() {
							// @SuppressWarnings("deprecation")
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 != 0 && clicked6 == false) {
									btn6.setLabel("X"); // IMPORTANT
									btn6.setForeground(Color.RED);
									btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked6 = true;
									b6 = 1;

									frame.getContentPane().remove(lblp1turn);
									frame.getContentPane().add(lblp2turn);
									frame.revalidate();
									frame.repaint();
								} else if (clicked6 == false) {
									btn6.setLabel("O"); // IMPORTANT
									btn6.setForeground(Color.BLUE);
									btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked6 = true;
									b6 = 2;

									frame.getContentPane().remove(lblp2turn);
									frame.getContentPane().add(lblp1turn);
									frame.revalidate();
									frame.repaint();
								}
								if ((turn >= 5) && !(clicked1 == true && clicked2 == true && clicked3 == true
										&& clicked4 == true && clicked5 == true && clicked6 == true
										&& clicked7 == true && clicked8 == true && clicked9 == true)) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										lblPlayer1Wins.setText(player1name + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount1++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										lblPlayer2Wins.setText(player2name + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount2++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
										lbltie.setText("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}
								}
							}
						});

					
						btn7.addActionListener(new ActionListener() {
							// @SuppressWarnings("deprecation")
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 != 0 && clicked7 == false) {
									btn7.setLabel("X"); // IMPORTANT
									btn7.setForeground(Color.RED);
									btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked7 = true;
									b7 = 1;

									frame.getContentPane().remove(lblp1turn);
									frame.getContentPane().add(lblp2turn);
									frame.revalidate();
									frame.repaint();
								} else if (clicked7 == false) {
									btn7.setLabel("O"); // IMPORTANT
									btn7.setForeground(Color.BLUE);
									btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked7 = true;
									b7 = 2;

									frame.getContentPane().remove(lblp2turn);
									frame.getContentPane().add(lblp1turn);
									frame.revalidate();
									frame.repaint();
								}
								if ((turn >= 5) && !(clicked1 == true && clicked2 == true && clicked3 == true
										&& clicked4 == true && clicked5 == true && clicked6 == true
										&& clicked7 == true && clicked8 == true && clicked9 == true)) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										lblPlayer1Wins.setText(player1name + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount1++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										lblPlayer2Wins.setText(player2name + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount2++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
										lbltie.setText("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}
								}
							}
						});

						
						btn8.addActionListener(new ActionListener() {
							// @SuppressWarnings("deprecation")
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 != 0 && clicked8 == false) {
									btn8.setLabel("X"); // IMPORTANT
									btn8.setForeground(Color.RED);
									btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked8 = true;
									b8 = 1;

									frame.getContentPane().remove(lblp1turn);
									frame.getContentPane().add(lblp2turn);
									frame.revalidate();
									frame.repaint();
								} else if (clicked8 == false) {
									btn8.setLabel("O"); // IMPORTANT
									btn8.setForeground(Color.BLUE);
									btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked8 = true;
									b8 = 2;

									frame.getContentPane().remove(lblp2turn);
									frame.getContentPane().add(lblp1turn);
									frame.revalidate();
									frame.repaint();
								}
								if ((turn >= 5) && !(clicked1 == true && clicked2 == true && clicked3 == true
										&& clicked4 == true && clicked5 == true && clicked6 == true
										&& clicked7 == true && clicked8 == true && clicked9 == true)) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										lblPlayer1Wins.setText(player1name + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount1++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										lblPlayer2Wins.setText(player2name + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount2++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
										lbltie.setText("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}
								}
							}
						});

						

						
						btn9.addActionListener(new ActionListener() {
							// @SuppressWarnings("deprecation")
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (turn % 2 != 0 && clicked9 == false) {
									btn9.setLabel("X"); // IMPORTANT
									btn9.setForeground(Color.RED);
									btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked9 = true;
									b9 = 1;

									frame.getContentPane().remove(lblp1turn);
									frame.getContentPane().add(lblp2turn);
									frame.revalidate();
									frame.repaint();
								} else if (clicked9 == false) {
									btn9.setLabel("O"); // IMPORTANT
									btn9.setForeground(Color.BLUE);
									btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
									turn++;
									clicked9 = true;
									b9 = 2;

									frame.getContentPane().remove(lblp2turn);
									frame.getContentPane().add(lblp1turn);
									frame.revalidate();
									frame.repaint();
								}
								if ((turn >= 5) && !(clicked1 == true && clicked2 == true && clicked3 == true
										&& clicked4 == true && clicked5 == true && clicked6 == true
										&& clicked7 == true && clicked8 == true && clicked9 == true)) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										lblPlayer1Wins.setText(player1name + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount1++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										lblPlayer2Wins.setText(player2name + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
										winCount2++;
										lblscore.setText(player1name + ": " + winCount1
												+ "          " + player2name + ": " + winCount2);
										frame.getContentPane().add(lblscore);
										frame.revalidate();
										frame.repaint();
									}

									else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
										lbltie.setText("Tie Game!");
										lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lbltie.setBounds(20, 67, 249, 60);
										frame.getContentPane().add(lbltie);
										frame.revalidate();
										frame.repaint();
									}
								}
							}
						});
					}
				});
			}
		});
	}
}