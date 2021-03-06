import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TicTacToeV1_1 {

	private JFrame frame;

	int turn = 1;
	boolean clicked1 = false, clicked2 = false, clicked3 = false, clicked4 = false, clicked5 = false, clicked6 = false,
			clicked7 = false, clicked8 = false, clicked9 = false;

	int b1, b2, b3, b4, b5, b6, b7, b8, b9 = 0;		
	//will later be changed to reflect value in the box (ie 'X' will be represented by 1, 'O' will be represented by 2)

	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * 
	 * Launch the application.
	 * 
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeV1_1 window = new TicTacToeV1_1();
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

	public TicTacToeV1_1() {
		initialize();

	}

	/**
	 * 
	 * Initialize the contents of the frame.
	 * 
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblWelcome = new JLabel("Welcome to Kyle and Andre's Tic Tac Toe!");
		lblWelcome.setFont(new Font("Lucida Bright", Font.BOLD, 26));
		lblWelcome.setBounds(10, 11, 555, 88);
		frame.getContentPane().add(lblWelcome);

		JButton btn1Player = new JButton("1 player");
		btn1Player.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		btn1Player.setBounds(88, 110, 117, 23);
		frame.getContentPane().add(btn1Player);

		JButton btn2Players = new JButton("2 players");
		btn2Players.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		btn2Players.setBounds(385, 110, 117, 23);
		frame.getContentPane().add(btn2Players);

		btn1Player.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				frame.getContentPane().remove(lblWelcome);
				frame.getContentPane().remove(btn1Player);
				frame.getContentPane().remove(btn2Players);

				JLabel lblGoFirst = new JLabel("You go first!");
				lblGoFirst.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
				lblGoFirst.setBounds(20, 67, 500, 60);
				frame.getContentPane().add(lblGoFirst);
				frame.revalidate();
				frame.repaint();

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
							frame.getContentPane().remove(lblGoFirst);
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
							frame.getContentPane().remove(lblGoFirst);
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
							frame.getContentPane().remove(lblGoFirst);
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
							frame.getContentPane().remove(lblGoFirst);
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
							frame.getContentPane().remove(lblGoFirst);
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
							frame.getContentPane().remove(lblGoFirst);
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
							frame.getContentPane().remove(lblGoFirst);
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
							frame.getContentPane().remove(lblGoFirst);
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
							frame.getContentPane().remove(lblGoFirst);
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
							frame.getContentPane().remove(lblGoFirst);
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

		btn2Players.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				frame.getContentPane().remove(lblWelcome);
				frame.getContentPane().remove(btn2Players);
				frame.getContentPane().remove(btn1Player);

				JLabel entername1 = new JLabel("Enter Player 1's Name:");
				entername1.setFont(new Font("Lucida Bright", Font.PLAIN, 22));
				entername1.setBounds(45, 165, 264, 67);
				frame.getContentPane().add(entername1);
				frame.revalidate();
				frame.repaint();

				JLabel entername2 = new JLabel("Enter Player 2's Name:");
				entername2.setFont(new Font("Lucida Bright", Font.PLAIN, 22));
				entername2.setBounds(45, 263, 264, 67);
				frame.getContentPane().add(entername2);
				frame.revalidate();
				frame.repaint();

				textField_1 = new JTextField();
				textField_1.setBounds(316, 182, 186, 32);
				frame.getContentPane().add(textField_1);
				textField_1.setColumns(10);
				frame.revalidate();
				frame.repaint();

				textField_2 = new JTextField();
				textField_2.setBounds(316, 280, 186, 32);
				frame.getContentPane().add(textField_2);
				textField_2.setColumns(10);
				frame.revalidate();
				frame.repaint();

				JButton btnLetsGooooo = new JButton("Let's GOOOOO!");
				btnLetsGooooo.setFont(new Font("Lucida Bright", Font.PLAIN, 24));
				btnLetsGooooo.setBounds(142, 391, 305, 88);
				frame.getContentPane().add(btnLetsGooooo);
				frame.revalidate();
				frame.repaint();

				btnLetsGooooo.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						String name1 = textField_1.getText();
						String name2 = textField_2.getText();

						frame.getContentPane().remove(entername1);
						frame.getContentPane().remove(entername2);
						frame.getContentPane().remove(textField_1);
						frame.getContentPane().remove(textField_2);
						frame.getContentPane().remove(btnLetsGooooo);

						JLabel lblp1turn = new JLabel(name1 + "'s Turn");
						lblp1turn.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
						lblp1turn.setBounds(20, 67, 500, 60);
						frame.getContentPane().add(lblp1turn);
						frame.revalidate();
						frame.repaint();

						JLabel lblp2turn = new JLabel(name2 + "'s Turn");
						lblp2turn.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
						lblp2turn.setBounds(20, 67, 500, 60);
						frame.revalidate();
						frame.repaint();

						JButton btn1 = new JButton("");
						btn1.setBounds(56, 143, 141, 141);
						frame.getContentPane().add(btn1);
						frame.revalidate();
						frame.repaint();
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
								if (turn >= 5) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										JLabel lblPlayer1Wins = new JLabel(name1 + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;

										JButton btnRestart = new JButton("Play Again!");
										btnRestart.setBounds(322, 67, 200, 50);
										btnRestart.setFont(new Font("Lucida Bright", Font.PLAIN, 24));
										frame.getContentPane().add(btnRestart);

										btnRestart.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {

												System.exit(0);

											}
										});


									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										JLabel lblPlayer2Wins = new JLabel(name2 + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
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

						JButton btn2 = new JButton("");
						btn2.setBounds(220, 143, 141, 141);
						frame.getContentPane().add(btn2);
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

								if (turn >= 5) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										JLabel lblPlayer1Wins = new JLabel(name1 + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										JLabel lblPlayer2Wins = new JLabel(name2 + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
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

						JButton btn3 = new JButton("");
						btn3.setBounds(385, 143, 141, 141);
						frame.getContentPane().add(btn3);
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
								if (turn >= 5) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										JLabel lblPlayer1Wins = new JLabel(name1 + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										JLabel lblPlayer2Wins = new JLabel(name2 + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true 											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
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
						JButton btn4 = new JButton("");
						btn4.setBounds(56, 305, 141, 141);
						frame.getContentPane().add(btn4);
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
								if (turn >= 5) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										JLabel lblPlayer1Wins = new JLabel(name1 + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										JLabel lblPlayer2Wins = new JLabel(name2 + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
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

						JButton btn5 = new JButton("");
						btn5.setBounds(220, 305, 141, 141);
						frame.getContentPane().add(btn5);
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
								if (turn >= 5) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										JLabel lblPlayer1Wins = new JLabel(name1 + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										JLabel lblPlayer2Wins = new JLabel(name2 + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
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

						JButton btn6 = new JButton("");
						btn6.setBounds(385, 305, 141, 141);
						frame.getContentPane().add(btn6);
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
								if (turn >= 5) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										JLabel lblPlayer1Wins = new JLabel(name1 + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										JLabel lblPlayer2Wins = new JLabel(name2 + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
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

						JButton btn7 = new JButton("");
						btn7.setBounds(56, 467, 141, 141);
						frame.getContentPane().add(btn7);
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
								if (turn >= 5) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										JLabel lblPlayer1Wins = new JLabel(name1 + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										JLabel lblPlayer2Wins = new JLabel(name2 + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
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

						JButton btn8 = new JButton("");
						btn8.setBounds(220, 467, 141, 141);
						frame.getContentPane().add(btn8);
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
								if (turn >= 5) {
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										JLabel lblPlayer1Wins = new JLabel(name1 + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										JLabel lblPlayer2Wins = new JLabel(name2 + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if (clicked1 == true && clicked2 == true && clicked3 == true
											&& clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
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

						JButton btn9 = new JButton("");
						btn9.setBounds(385, 467, 141, 141);
						frame.getContentPane().add(btn9);
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
								if (turn >= 5)
									if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
											|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
											|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
											|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
										frame.getContentPane().remove(lblp2turn);
										JLabel lblPlayer1Wins = new JLabel(name1 + " Wins!");
										lblPlayer1Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer1Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer1Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}
									else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
											|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
											|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
											|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)) {
										frame.getContentPane().remove(lblp1turn);
										JLabel lblPlayer2Wins = new JLabel(name2 + " Wins!");
										lblPlayer2Wins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
										lblPlayer2Wins.setBounds(20, 67, 500, 60);
										frame.getContentPane().add(lblPlayer2Wins);
										frame.revalidate();
										frame.repaint();
										clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
									}

									else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true
											&& clicked7 == true && clicked8 == true && clicked9 == true) {
										frame.getContentPane().remove(lblp2turn);
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
	}
}
