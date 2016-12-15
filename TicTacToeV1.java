package ticTacToe;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TicTacToeV1 {
	private JFrame frame;
	int turn = 0;
	boolean clicked1 = false, clicked2 = false, clicked3 = false, clicked4 = false, clicked5 = false, clicked6 = false,
			clicked7 = false, clicked8 = false, clicked9 = false;
	int b1, b2, b3, b4, b5, b6, b7, b8, b9 = 0;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeV1 window = new TicTacToeV1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicTacToeV1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblWelcomeToKyle = new JLabel("Welcome to Kyle and Andre's Tic Tac Toe!");
		lblWelcomeToKyle.setFont(new Font("Lucida Bright", Font.BOLD, 26));
		lblWelcomeToKyle.setBounds(10, 11, 555, 88);
		frame.getContentPane().add(lblWelcomeToKyle);
		
		JButton btnPlayer = new JButton("1 player");
		btnPlayer.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		btnPlayer.setBounds(88, 110, 117, 23);
		frame.getContentPane().add(btnPlayer);
		
		JButton btnPlayers = new JButton("2 players");
		btnPlayers.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		btnPlayers.setBounds(385, 110, 117, 23);
		frame.getContentPane().add(btnPlayers);
		
	
		btnPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(lblWelcomeToKyle);
				frame.getContentPane().remove(btnPlayer);
				frame.getContentPane().remove(btnPlayers);
				
				JButton btn1 = new JButton("");
				btn1.setBounds(56, 143, 141, 141);
				frame.getContentPane().add(btn1);
				frame.revalidate();
				frame.repaint();
				
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
			}
		});
		
		
		btnPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(lblWelcomeToKyle);
				frame.getContentPane().remove(btnPlayers);
				frame.getContentPane().remove(btnPlayer);
				JButton btn1 = new JButton("");
				btn1.setBounds(56, 143, 141, 141);
				frame.getContentPane().add(btn1);
				frame.revalidate();
				frame.repaint();
				btn1.addActionListener(new ActionListener() {
					// @SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent arg0) {
						if (turn % 2 == 0 && clicked1 == false ) {
							btn1.setLabel("X"); // IMPORTANT
							btn1.setForeground(Color.RED);
							btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked1 = true;
							b1 = 1;
						} else if (clicked1 == false) {
							btn1.setLabel("O"); // IMPORTANT
							btn1.setForeground(Color.BLUE);
							btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked1 = true;
							b1 = 2;
						}
						if (turn >= 5) {
							if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
									|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
									|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
									|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
								JLabel lblPlayerWins = new JLabel("Player 1 Wins!");
							      lblPlayerWins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
							      lblPlayerWins.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
									|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
									|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
									|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)){
								JLabel lblPlayerWins_1 = new JLabel("Player 2 Wins!");
								  lblPlayerWins_1.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lblPlayerWins_1.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins_1);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true && clicked7 == true && clicked8 == true && clicked9 == true){
								JLabel lbltie = new JLabel("Tie Game!");
								  lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lbltie.setBounds(200, 67, 249, 60);
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
					public void actionPerformed(ActionEvent arg0) {
						if (turn % 2 == 0 && clicked2 == false) {
							btn2.setLabel("X"); // IMPORTANT
							btn2.setForeground(Color.RED);
							btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked2 = true;
							b2 = 1;
						} else if (clicked2 == false) {
							btn2.setLabel("O"); // IMPORTANT
							btn2.setForeground(Color.BLUE);
							btn2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked2 = true;
							b2 = 2;
						}
						if (turn >= 5) {
							if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
									|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
									|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
									|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
								JLabel lblPlayerWins = new JLabel("Player 1 Wins!");
							      lblPlayerWins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
							      lblPlayerWins.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
									|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
									|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
									|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)){
								JLabel lblPlayerWins_1 = new JLabel("Player 2 Wins!");
								  lblPlayerWins_1.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lblPlayerWins_1.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins_1);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true && clicked7 == true && clicked8 == true && clicked9 == true){
								JLabel lbltie = new JLabel("Tie Game!");
								  lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lbltie.setBounds(200, 67, 249, 60);
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
					public void actionPerformed(ActionEvent arg0) {
						if (turn % 2 == 0 && clicked3 == false) {
							btn3.setLabel("X"); // IMPORTANT
							btn3.setForeground(Color.RED);
							btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked3 = true;
							b3 = 1;
						} else if (clicked3 == false) {
							btn3.setLabel("O"); // IMPORTANT
							btn3.setForeground(Color.BLUE);
							btn3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked3 = true;
							b3 = 2;
						}
						if (turn >= 5) {
							if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
									|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
									|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
									|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
								JLabel lblPlayerWins = new JLabel("Player 1 Wins!");
							      lblPlayerWins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
							      lblPlayerWins.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
									|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
									|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
									|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)){
								JLabel lblPlayerWins_1 = new JLabel("Player 2 Wins!");
								  lblPlayerWins_1.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lblPlayerWins_1.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins_1);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true && clicked7 == true && clicked8 == true && clicked9 == true){
								JLabel lbltie = new JLabel("Tie Game!");
								  lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lbltie.setBounds(200, 67, 249, 60);
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
					public void actionPerformed(ActionEvent arg0) {
						if (turn % 2 == 0 && clicked4 == false) {
							btn4.setLabel("X"); // IMPORTANT
							btn4.setForeground(Color.RED);
							btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked4 = true;
							b4 = 1;
						} else if (clicked4 == false) {
							btn4.setLabel("O"); // IMPORTANT
							btn4.setForeground(Color.BLUE);
							btn4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked4 = true;
							b4 = 2;
						}
						if (turn >= 5) {
							if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
									|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
									|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
									|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
								JLabel lblPlayerWins = new JLabel("Player 1 Wins!");
							      lblPlayerWins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
							      lblPlayerWins.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
									|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
									|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
									|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)){
								JLabel lblPlayerWins_1 = new JLabel("Player 2 Wins!");
								  lblPlayerWins_1.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lblPlayerWins_1.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins_1);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true && clicked7 == true && clicked8 == true && clicked9 == true){
								JLabel lbltie = new JLabel("Tie Game!");
								  lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lbltie.setBounds(200, 67, 249, 60);
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
					public void actionPerformed(ActionEvent arg0) {
						if (turn % 2 == 0 && clicked5 == false) {
							btn5.setLabel("X"); // IMPORTANT
							btn5.setForeground(Color.RED);
							btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked5 = true;
							b5 = 1;
						} else if (clicked5 == false) {
							btn5.setLabel("O"); // IMPORTANT
							btn5.setForeground(Color.BLUE);
							btn5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked5 = true;
							b5 = 2;
						}
						if (turn >= 5) {
							if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
									|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
									|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
									|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
								JLabel lblPlayerWins = new JLabel("Player 1 Wins!");
							      lblPlayerWins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
							      lblPlayerWins.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
									|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
									|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
									|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)){
								JLabel lblPlayerWins_1 = new JLabel("Player 2 Wins!");
								  lblPlayerWins_1.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lblPlayerWins_1.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins_1);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true && clicked7 == true && clicked8 == true && clicked9 == true){
								JLabel lbltie = new JLabel("Tie Game!");
								  lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lbltie.setBounds(200, 67, 249, 60);
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
					public void actionPerformed(ActionEvent arg0) {
						if (turn % 2 == 0 && clicked6 == false) {
							btn6.setLabel("X"); // IMPORTANT
							btn6.setForeground(Color.RED);
							btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked6 = true;
							b6 = 1;
						} else if (clicked6 == false) {
							btn6.setLabel("O"); // IMPORTANT
							btn6.setForeground(Color.BLUE);
							btn6.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked6 = true;
							b6 = 2;
						}
						if (turn >= 5) {
							if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
									|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
									|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
									|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
								JLabel lblPlayerWins = new JLabel("Player 1 Wins!");
							      lblPlayerWins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
							      lblPlayerWins.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
									|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
									|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
									|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)){
								JLabel lblPlayerWins_1 = new JLabel("Player 2 Wins!");
								  lblPlayerWins_1.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lblPlayerWins_1.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins_1);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true && clicked7 == true && clicked8 == true && clicked9 == true){
								JLabel lbltie = new JLabel("Tie Game!");
								  lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lbltie.setBounds(200, 67, 249, 60);
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
					public void actionPerformed(ActionEvent arg0) {
						if (turn % 2 == 0 && clicked7 == false) {
							btn7.setLabel("X"); // IMPORTANT
							btn7.setForeground(Color.RED);
							btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked7 = true;
							b7 = 1;
						} else if (clicked7 == false) {
							btn7.setLabel("O"); // IMPORTANT
							btn7.setForeground(Color.BLUE);
							btn7.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked7 = true;
							b7 = 2;
						}
						if (turn >= 5) {
							if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
									|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
									|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
									|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
								JLabel lblPlayerWins = new JLabel("Player 1 Wins!");
							      lblPlayerWins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
							      lblPlayerWins.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
									|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
									|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
									|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)){
								JLabel lblPlayerWins_1 = new JLabel("Player 2 Wins!");
								  lblPlayerWins_1.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lblPlayerWins_1.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins_1);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true && clicked7 == true && clicked8 == true && clicked9 == true){
								JLabel lbltie = new JLabel("Tie Game!");
								  lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lbltie.setBounds(200, 67, 249, 60);
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
					public void actionPerformed(ActionEvent arg0) {
						if (turn % 2 == 0 && clicked8 == false) {
							btn8.setLabel("X"); // IMPORTANT
							btn8.setForeground(Color.RED);
							btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked8 = true;
							b8 = 1;
						} else if (clicked8 == false) {
							btn8.setLabel("O"); // IMPORTANT
							btn8.setForeground(Color.BLUE);
							btn8.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked8 = true;
							b8 = 2;
						}
						if (turn >= 5) {
							if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
									|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
									|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
									|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
								JLabel lblPlayerWins = new JLabel("Player 1 Wins!");
							      lblPlayerWins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
							      lblPlayerWins.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
									|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
									|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
									|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)){
								JLabel lblPlayerWins_1 = new JLabel("Player 2 Wins!");
								  lblPlayerWins_1.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lblPlayerWins_1.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins_1);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
							else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true && clicked7 == true && clicked8 == true && clicked9 == true){
								JLabel lbltie = new JLabel("Tie Game!");
								  lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
								  lbltie.setBounds(200, 67, 249, 60);
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
					public void actionPerformed(ActionEvent arg0) {
						if (turn % 2 == 0 && clicked9 == false) {
							btn9.setLabel("X"); // IMPORTANT
							btn9.setForeground(Color.RED);
							btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked9 = true;
							b9 = 1;
						} else if (clicked9 == false) {
							btn9.setLabel("O"); // IMPORTANT
							btn9.setForeground(Color.BLUE);
							btn9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 99));
							turn++;
							clicked9 = true;
							b9 = 2;
						}
						if (turn >= 5) 
							if ((b1 == 1 && b2 == 1 && b3 == 1) || (b4 == 1 && b5 == 1 && b6 == 1)
									|| (b7 == 1 && b8 == 1 && b9 == 1) || (b1 == 1 && b4 == 1 && b7 == 1)
									|| (b2 == 1 && b5 == 1 && b8 == 1) || (b3 == 1 && b6 == 1 && b9 == 1)
									|| (b1 == 1 && b5 == 1 && b9 == 1) || (b3 == 1 && b5 == 1 && b7 == 1)) {
								JLabel lblPlayerWins = new JLabel("Player 1 Wins!");
							      lblPlayerWins.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
							      lblPlayerWins.setBounds(173, 67, 249, 60);
								frame.getContentPane().add(lblPlayerWins);
								frame.revalidate();
								frame.repaint();
								clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
							}
						else if ((b1 == 2 && b2 == 2 && b3 == 2) || (b4 == 2 && b5 == 2 && b6 == 2)
								|| (b7 == 2 && b8 == 2 && b9 == 2) || (b1 == 2 && b4 == 2 && b7 == 2)
								|| (b2 == 2 && b5 == 2 && b8 == 2) || (b3 == 2 && b6 == 2 && b9 == 2)
								|| (b1 == 2 && b5 == 2 && b9 == 2) || (b3 == 2 && b5 == 2 && b7 == 2)){
							JLabel lblPlayerWins_1 = new JLabel("Player 2 Wins!");
							  lblPlayerWins_1.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
							  lblPlayerWins_1.setBounds(173, 67, 249, 60);
							frame.getContentPane().add(lblPlayerWins_1);
							frame.revalidate();
							frame.repaint();
							clicked1 = clicked2 = clicked3 = clicked4 = clicked5 = clicked6 = clicked7 = clicked8 = clicked9 = true;
						}
						else if (clicked1 == true && clicked2 == true && clicked3 == true && clicked4 == true && clicked5 == true && clicked6 == true && clicked7 == true && clicked8 == true && clicked9 == true){
							JLabel lbltie = new JLabel("Tie Game!");
							  lbltie.setFont(new Font("Lucida Bright", Font.PLAIN, 36));
							  lbltie.setBounds(200, 67, 249, 60);
							  frame.getContentPane().add(lbltie);
								frame.revalidate();
								frame.repaint();
					}
					}	
				});
				
			}
		});	
		
	}
}
