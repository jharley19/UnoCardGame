package unogame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hardknocks.Drafter;

public class UNO implements ActionListener {

	private enum Actions {
		START, REDZERO, BLUEZERO, GREENZERO, YELLOWZERO, REDONE, BLUEONE, GREENONE, YELLOWONE, REDTWO, BLUETWO,
		GREENTWO, YELLOWTWO, REDTHREE, BLUETHREE, GREENTHREE, YELLOWTHREE, REDFOUR, BLUEFOUR, GREENFOUR, YELLOWFOUR,
		REDFIVE, BLUEFIVE, GREENFIVE, YELLOWFIVE, REDSIX, BLUESIX, GREENSIX, YELLOWSIX, REDSEVEN, BLUESEVEN, GREENSEVEN,
		YELLOWSEVEN, REDEIGHT, BLUEEIGHT, GREENEIGHT, YELLOWEIGHT, REDNINE, BLUENINE, GREENNINE, YELLOWNINE, REDSKIP,
		BLUESKIP, GREENSKIP, YELLOWSKIP, REDDRAW, BLUEDRAW, GREENDRAW, YELLOWDRAW, REDREV, BLUEREV, GREENREV, YELLOWREV,
		WILD, WILDDRAW, SUBMIT, SUBMITDRAW, DRAW, RESET
	}

	private static Card redZero = new Card("red 0", "red", "0", "no");
	private static Card blueZero = new Card("blue 0", "blue", "0", "no");
	private static Card greenZero = new Card("green 0", "green", "0", "no");
	private static Card yellowZero = new Card("yellow 0", "yellow", "0", "no");

	private static Card redOne = new Card("red 1", "red", "1", "no");
	private static Card blueOne = new Card("blue 1", "blue", "1", "no");
	private static Card greenOne = new Card("green 1", "green", "1", "no");
	private static Card yellowOne = new Card("yellow 1", "yellow", "1", "no");
	private static Card redOne1 = new Card("red 1", "red", "1", "no");
	private static Card blueOne1 = new Card("blue 1", "blue", "1", "no");
	private static Card greenOne1 = new Card("green 1", "green", "1", "no");
	private static Card yellowOne1 = new Card("yellow 1", "yellow", "1", "no");

	private static Card redTwo = new Card("red 2", "red", "2", "no");
	private static Card blueTwo = new Card("blue 2", "blue", "2", "no");
	private static Card greenTwo = new Card("green 2", "green", "2", "no");
	private static Card yellowTwo = new Card("yellow 2", "yellow", "2", "no");
	private static Card redTwo1 = new Card("red 2", "red", "2", "no");
	private static Card blueTwo1 = new Card("blue 2", "blue", "2", "no");
	private static Card greenTwo1 = new Card("green 2", "green", "2", "no");
	private static Card yellowTwo1 = new Card("yellow 2", "yellow", "2", "no");

	private static Card redThree = new Card("red 3", "red", "3", "no");
	private static Card blueThree = new Card("blue 3", "blue", "3", "no");
	private static Card greenThree = new Card("green 3", "green", "3", "no");
	private static Card yellowThree = new Card("yellow 3", "yellow", "3", "no");
	private static Card redThree1 = new Card("red 3", "red", "3", "no");
	private static Card blueThree1 = new Card("blue 3", "blue", "3", "no");
	private static Card greenThree1 = new Card("green 3", "green", "3", "no");
	private static Card yellowThree1 = new Card("yellow 3", "yellow", "3", "no");

	private static Card redFour = new Card("red 4", "red", "4", "no");
	private static Card blueFour = new Card("blue 4", "blue", "4", "no");
	private static Card greenFour = new Card("green 4", "green", "4", "no");
	private static Card yellowFour = new Card("yellow 4", "yellow", "4", "no");
	private static Card redFour1 = new Card("red 4", "red", "4", "no");
	private static Card blueFour1 = new Card("blue 4", "blue", "4", "no");
	private static Card greenFour1 = new Card("green 4", "green", "4", "no");
	private static Card yellowFour1 = new Card("yellow 4", "yellow", "4", "no");

	private static Card redFive = new Card("red 5", "red", "5", "no");
	private static Card blueFive = new Card("blue 5", "blue", "5", "no");
	private static Card greenFive = new Card("green 5", "green", "5", "no");
	private static Card yellowFive = new Card("yellow 5", "yellow", "5", "no");
	private static Card redFive1 = new Card("red 5", "red", "5", "no");
	private static Card blueFive1 = new Card("blue 5", "blue", "5", "no");
	private static Card greenFive1 = new Card("green 5", "green", "5", "no");
	private static Card yellowFive1 = new Card("yellow 5", "yellow", "5", "no");

	private static Card redSix = new Card("red 6", "red", "6", "no");
	private static Card blueSix = new Card("blue 6", "blue", "6", "no");
	private static Card greenSix = new Card("green 6", "green", "6", "no");
	private static Card yellowSix = new Card("yellow 6", "yellow", "6", "no");
	private static Card redSix1 = new Card("red 6", "red", "6", "no");
	private static Card blueSix1 = new Card("blue 6", "blue", "6", "no");
	private static Card greenSix1 = new Card("green 6", "green", "6", "no");
	private static Card yellowSix1 = new Card("yellow 6", "yellow", "6", "no");

	private static Card redSeven = new Card("red 7", "red", "7", "no");
	private static Card blueSeven = new Card("blue 7", "blue", "7", "no");
	private static Card greenSeven = new Card("green 7", "green", "7", "no");
	private static Card yellowSeven = new Card("yellow 7", "yellow", "7", "no");
	private static Card redSeven1 = new Card("red 7", "red", "7", "no");
	private static Card blueSeven1 = new Card("blue 7", "blue", "7", "no");
	private static Card greenSeven1 = new Card("green 7", "green", "7", "no");
	private static Card yellowSeven1 = new Card("yellow 7", "yellow", "7", "no");

	private static Card redEight = new Card("red 8", "red", "8", "no");
	private static Card blueEight = new Card("blue 8", "blue", "8", "no");
	private static Card greenEight = new Card("green 8", "green", "8", "no");
	private static Card yellowEight = new Card("yellow 8", "yellow", "8", "no");
	private static Card redEight1 = new Card("red 8", "red", "8", "no");
	private static Card blueEight1 = new Card("blue 8", "blue", "8", "no");
	private static Card greenEight1 = new Card("green 8", "green", "8", "no");
	private static Card yellowEight1 = new Card("yellow 8", "yellow", "8", "no");

	private static Card redNine = new Card("red 9", "red", "9", "no");
	private static Card blueNine = new Card("blue 9", "blue", "9", "no");
	private static Card greenNine = new Card("green 9", "green", "9", "no");
	private static Card yellowNine = new Card("yellow 9", "yellow", "9", "no");
	private static Card redNine1 = new Card("red 9", "red", "9", "no");
	private static Card blueNine1 = new Card("blue 9", "blue", "9", "no");
	private static Card greenNine1 = new Card("green 9", "green", "9", "no");
	private static Card yellowNine1 = new Card("yellow 9", "yellow", "9", "no");

	private static Card redSkip = new Card("red skip", "red", "skip", "no");
	private static Card blueSkip = new Card("blue skip", "blue", "skip", "no");
	private static Card greenSkip = new Card("green skip", "green", "skip", "no");
	private static Card yellowSkip = new Card("yellow skip", "yellow", "skip", "no");
	private static Card redSkip1 = new Card("red skip", "red", "skip", "no");
	private static Card blueSkip1 = new Card("blue skip", "blue", "skip", "no");
	private static Card greenSkip1 = new Card("green skip", "green", "skip", "no");
	private static Card yellowSkip1 = new Card("yellow skip", "yellow", "skip", "no");

	private static Card redRev = new Card("red reverse", "red", "reverse", "no");
	private static Card blueRev = new Card("blue reverse", "blue", "reverse", "no");
	private static Card greenRev = new Card("green reverse", "green", "reverse", "no");
	private static Card yellowRev = new Card("yellow reverse", "yellow", "reverse", "no");
	private static Card redRev1 = new Card("red reverse", "red", "reverse", "no");
	private static Card blueRev1 = new Card("blue reverse", "blue", "reverse", "no");
	private static Card greenRev1 = new Card("green reverse", "green", "reverse", "no");
	private static Card yellowRev1 = new Card("yellow reverse", "yellow", "reverse", "no");

	private static Card redDraw = new Card("red draw 2", "red", "draw 2", "+2");
	private static Card blueDraw = new Card("blue draw 2", "blue", "draw 2", "+2");
	private static Card greenDraw = new Card("green draw 2", "green", "draw 2", "+2");
	private static Card yellowDraw = new Card("yellow draw 2", "yellow", "draw 2", "+2");
	private static Card redDraw1 = new Card("red draw 2", "red", "draw 2", "+2");
	private static Card blueDraw1 = new Card("blue draw 2", "blue", "draw 2", "+2");
	private static Card greenDraw1 = new Card("green draw 2", "green", "draw 2", "+2");
	private static Card yellowDraw1 = new Card("yellow draw 2", "yellow", "draw 2", "+2");

	private static Card wild1 = new Card("wild", "wild", "wild", "no");
	private static Card wild2 = new Card("wild", "wild", "wild", "no");
	private static Card wild3 = new Card("wild", "wild", "wild", "no");
	private static Card wild4 = new Card("wild", "wild", "wild", "no");

	private static Card wildDraw1 = new Card("wild draw 4", "wild", "wild draw 4", "+4");
	private static Card wildDraw2 = new Card("wild draw 4", "wild", "wild draw 4", "+4");
	private static Card wildDraw3 = new Card("wild draw 4", "wild", "wild draw 4", "+4");
	private static Card wildDraw4 = new Card("wild draw 4", "wild", "wild draw 4", "+4");

	private static ArrayList<Card> cardList = new ArrayList<Card>();
	private static ArrayList<Card> discard = new ArrayList<Card>();

	private static ArrayList<Card> myCards = new ArrayList<Card>();
	private static ArrayList<Card> cpu1 = new ArrayList<Card>();
	private static ArrayList<Card> cpu2 = new ArrayList<Card>();
	private static ArrayList<Card> cpu3 = new ArrayList<Card>();
	private static ArrayList<Card> cpu4 = new ArrayList<Card>();

	private ArrayList<Card> theirTurn;
	private JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	private boolean gameStarted = false;
	private boolean gameOver = false;
	JButton start;
	JButton topCard;
	private JTextField t;
	private JButton wildSource;
	private String whosUp = "Me";
	private boolean clockwise = true;

	JButton cpu1butt = new JButton("");
	JButton cpu2butt = new JButton("");
	JButton cpu3butt = new JButton("");
	JButton cpu4butt = new JButton("");

	public UNO() {
		// create a grid of 10 teams and 15 picks each

		start = new JButton("Start Game");
		start.setActionCommand(Actions.START.name());
		start.addActionListener(this);
		panel.add(start, BorderLayout.CENTER);
		panel.setBackground(new Color(40, 180, 40));
		panel.setSize(1024, 768);
		frame.setSize(1024, 768);
		frame.add(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Uno Game");
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == Actions.START.name()) {
			if (gameStarted == false) {
				gameStarted = true;
				panel.remove(start);
				panel.repaint();
				panel.setBackground(new Color(40, 180, 40));
				start();
			}
		} else if (e.getActionCommand() == Actions.REDZERO.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("red ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 0")
					|| topCard.getText().matches("wild (draw 4 )?red")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.BLUEZERO.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (source.getText().matches("blue ([0-9]|draw 2|skip|reverse)")
					|| source.getText().matches("(red|green|blue|yellow) 0")
					|| topCard.getText().matches("wild (draw 4 )?blue")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.GREENZERO.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (source.getText().matches("green ([0-9]|draw 2|skip|reverse)")
					|| source.getText().matches("(red|green|blue|yellow) 0")
					|| topCard.getText().matches("wild (draw 4 )?green")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.YELLOWZERO.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (source.getText().matches("yellow ([0-9]|draw 2|skip|reverse)")
					|| source.getText().matches("(red|green|blue|yellow) 0")
					|| topCard.getText().matches("wild (draw 4 )?yellow")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.REDONE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("red ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 1")
					|| topCard.getText().matches("wild (draw 4 )?red")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.BLUEONE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("blue ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 1")
					|| topCard.getText().matches("wild (draw 4 )?blue")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.GREENONE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("green ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 1")
					|| topCard.getText().matches("wild (draw 4 )?green")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.YELLOWONE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("yellow ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 1")
					|| topCard.getText().matches("wild (draw 4 )?yellow")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.REDTWO.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("red ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 2")
					|| topCard.getText().matches("wild (draw 4 )?red")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.BLUETWO.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("blue ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 2")
					|| topCard.getText().matches("wild (draw 4 )?blue")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.GREENTWO.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("green ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 2")
					|| topCard.getText().matches("wild (draw 4 )?green")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.YELLOWTWO.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("yellow ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 2")
					|| topCard.getText().matches("wild (draw 4 )?yellow")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.REDTHREE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("red ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 3")
					|| topCard.getText().matches("wild (draw 4 )?red")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.BLUETHREE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("blue ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 3")
					|| topCard.getText().matches("wild (draw 4 )?blue")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.GREENTHREE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("green ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 3")
					|| topCard.getText().matches("wild (draw 4 )?green")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.YELLOWTHREE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("yellow ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 3")
					|| topCard.getText().matches("wild (draw 4 )?yellow")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.REDFOUR.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("red ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 4")
					|| topCard.getText().matches("wild (draw 4 )?red")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.BLUEFOUR.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("blue ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 4")
					|| topCard.getText().matches("wild (draw 4 )?blue")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.GREENFOUR.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("green ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 4")
					|| topCard.getText().matches("wild (draw 4 )?green")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.YELLOWFOUR.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("yellow ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 4")
					|| topCard.getText().matches("wild (draw 4 )?yellow")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.REDFIVE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("red ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 5")
					|| topCard.getText().matches("wild (draw 4 )?red")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.BLUEFIVE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("blue ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 5")
					|| topCard.getText().matches("wild (draw 4 )?blue")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.GREENFIVE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("green ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 5")
					|| topCard.getText().matches("wild (draw 4 )?green")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.YELLOWFIVE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("yellow ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 5")
					|| topCard.getText().matches("wild (draw 4 )?yellow")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.REDSIX.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("red ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 6")
					|| topCard.getText().matches("wild (draw 4 )?red")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.BLUESIX.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("blue ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 6")
					|| topCard.getText().matches("wild (draw 4 )?blue")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.GREENSIX.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("green ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 6")
					|| topCard.getText().matches("wild (draw 4 )?green")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.YELLOWSIX.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("yellow ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 6")
					|| topCard.getText().matches("wild (draw 4 )?yellow")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.REDSEVEN.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("red ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 7")
					|| topCard.getText().matches("wild (draw 4 )?red")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.BLUESEVEN.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("blue ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 7")
					|| topCard.getText().matches("wild (draw 4 )?blue")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.GREENSEVEN.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("green ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 7")
					|| topCard.getText().matches("wild (draw 4 )?green")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.YELLOWSEVEN.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("yellow ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 7")
					|| topCard.getText().matches("wild (draw 4 )?yellow")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.REDEIGHT.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("red ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 8")
					|| topCard.getText().matches("wild (draw 4 )?red")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.BLUEEIGHT.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("blue ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 8")
					|| topCard.getText().matches("wild (draw 4 )?blue")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.GREENEIGHT.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("green ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 8")
					|| topCard.getText().matches("wild (draw 4 )?green")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.YELLOWEIGHT.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("yellow ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 8")
					|| topCard.getText().matches("wild (draw 4 )?yellow")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.REDNINE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("red ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 9")
					|| topCard.getText().matches("wild (draw 4 )?red")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.BLUENINE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("blue ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 9")
					|| topCard.getText().matches("wild (draw 4 )?blue")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
				;
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.GREENNINE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("green ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 9")
					|| topCard.getText().matches("wild (draw 4 )?green")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				whosNext(c);
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.YELLOWNINE.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("yellow ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) 9")
					|| topCard.getText().matches("wild (draw 4 )?yellow")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.REDSKIP.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("red ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) skip")
					|| topCard.getText().matches("wild (draw 4 )?red")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.BLUESKIP.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("blue ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) skip")
					|| topCard.getText().matches("wild (draw 4 )?blue")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.GREENSKIP.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("green ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) skip")
					|| topCard.getText().matches("wild (draw 4 )?green")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.YELLOWSKIP.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("yellow ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) skip")
					|| topCard.getText().matches("wild (draw 4 )?yellow")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.REDREV.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("red ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) reverse")
					|| topCard.getText().matches("wild (draw 4 )?red")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.BLUEREV.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("blue ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) reverse")
					|| topCard.getText().matches("wild (draw 4 )?blue")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.GREENREV.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("green ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) reverse")
					|| topCard.getText().matches("wild (draw 4 )?green")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.YELLOWREV.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("yellow ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) reverse")
					|| topCard.getText().matches("wild (draw 4 )?yellow")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.REDDRAW.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("red ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) draw 2")
					|| topCard.getText().matches("wild (draw 4 )?red")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.BLUEDRAW.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("blue ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) draw 2")
					|| topCard.getText().matches("wild (draw 4 )?blue")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.GREENDRAW.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("green ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) draw 2")
					|| topCard.getText().matches("wild (draw 4 )?green")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.YELLOWDRAW.name()) {
			JButton source = (JButton) e.getSource();
			Card c = findCard(source.getText(), myCards);
			if (topCard.getText().matches("yellow ([0-9]|draw 2|skip|reverse)")
					|| topCard.getText().matches("(red|green|blue|yellow) draw 2")
					|| topCard.getText().matches("wild (draw 4 )?yellow")) {
				topCard.setText(source.getText());
				theirTurn.remove(c);
				discard.add(c);
				panel.remove(source);
				whosNext(c);
				isGameOver();
				if (!gameOver) {
					playing();
				}
			} else {
				System.out.println("Illegal Move");
			}
		} else if (e.getActionCommand() == Actions.WILD.name()) {
			JFrame f = new JFrame("textfield");

			// create a label to display text
			JLabel l = new JLabel("Pick a color: red, blue, green, yellow");

			wildSource = (JButton) e.getSource();
			// create a new button
			JButton b = new JButton("Submit");

			b.setActionCommand(Actions.SUBMIT.name());
			b.addActionListener(this);
			// create a object of JTextField with 16 columns
			t = new JTextField(16);

			// create a panel to add buttons and textfield
			JPanel p = new JPanel();

			// add buttons and textfield to panel
			p.add(l);
			p.add(t);
			p.add(b);

			// add panel to frame
			f.add(p);

			// set the size of frame
			f.setSize(300, 300);

			f.show();
		} else if (e.getActionCommand() == Actions.WILDDRAW.name()) {
			JFrame f = new JFrame("textfield");

			// create a label to display text
			JLabel l = new JLabel("Pick a color: red, blue, green, yellow");

			wildSource = (JButton) e.getSource();

			// create a new button
			JButton b = new JButton("Submit");

			b.setActionCommand(Actions.SUBMITDRAW.name());
			b.addActionListener(this);
			// create a object of JTextField with 16 columns
			t = new JTextField(16);

			// create a panel to add buttons and textfield
			JPanel p = new JPanel();

			// add buttons and textfield to panel
			p.add(l);
			p.add(t);
			p.add(b);

			// add panel to frame
			f.add(p);

			// set the size of frame
			f.setSize(300, 300);

			f.show();

		} else if (e.getActionCommand() == Actions.SUBMIT.name()) {
			Card c = findCard(wildSource.getText(), myCards);
			topCard.setText(wildSource.getText() + " " + t.getText());
			theirTurn.remove(c);
			discard.add(c);
			panel.remove(wildSource);
			whosNext(c);
			isGameOver();
			if (!gameOver) {
				playing();
			}
		} else if (e.getActionCommand() == Actions.SUBMITDRAW.name()) {
			Card c = findCard(wildSource.getText(), myCards);
			topCard.setText(wildSource.getText() + " " + t.getText());
			theirTurn.remove(c);
			discard.add(c);
			panel.remove(wildSource);
			whosNext(c);
			isGameOver();
			if (!gameOver) {
				playing();
			}
		} else if (e.getActionCommand() == Actions.DRAW.name()) {
			Random random = new Random();
			int value = random.nextInt(cardList.size());
			Card c = cardList.get(value);

			String arr[] = topCard.getText().split(" ", 2);

			String topColor = arr[0]; // red/green/blue/yellow/wild
			String topType = arr[1]; // 0-9/reverse/draw 2/draw 4/skip/red/green/blue/yellow/draw 4 red/draw 4
			// green/draw 4 blue/draw 4 yellow

			// if you can play the card you just picked up, play it!
			if (c.getColor().equals(topColor) || c.getType().equals(topType) || c.getColor().equals("wild")) {
				theirTurn.add(c);
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				panel.setBackground(new Color(40, 180, 40));
				panel.add(topCard);
				setMyCards();
			} else {
				theirTurn.add(c);
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				panel.setBackground(new Color(40, 180, 40));
				panel.add(topCard);
				setMyCards();
				whosNext(c);
				playing();
			}
		} else if (e.getActionCommand() == Actions.RESET.name()) {
			cardList = new ArrayList<Card>();
			discard = new ArrayList<Card>();

			myCards = new ArrayList<Card>();
			cpu1 = new ArrayList<Card>();
			cpu2 = new ArrayList<Card>();
			cpu3 = new ArrayList<Card>();
			cpu4 = new ArrayList<Card>();

			cardList.add(redZero);
			cardList.add(blueZero);
			cardList.add(greenZero);
			cardList.add(yellowZero);
			cardList.add(redOne);
			cardList.add(blueOne);
			cardList.add(greenOne);
			cardList.add(yellowOne);
			cardList.add(redOne1);
			cardList.add(blueOne1);
			cardList.add(greenOne1);
			cardList.add(yellowOne1);
			cardList.add(redTwo);
			cardList.add(blueTwo);
			cardList.add(greenTwo);
			cardList.add(yellowTwo);
			cardList.add(redTwo1);
			cardList.add(blueTwo1);
			cardList.add(greenTwo1);
			cardList.add(yellowTwo1);
			cardList.add(redThree);
			cardList.add(blueThree);
			cardList.add(greenThree);
			cardList.add(yellowThree);
			cardList.add(redThree1);
			cardList.add(blueThree1);
			cardList.add(greenThree1);
			cardList.add(yellowThree1);
			cardList.add(redFour);
			cardList.add(blueFour);
			cardList.add(greenFour);
			cardList.add(yellowFour);
			cardList.add(redFour1);
			cardList.add(blueFour1);
			cardList.add(greenFour1);
			cardList.add(yellowFour1);
			cardList.add(redFive);
			cardList.add(blueFive);
			cardList.add(greenFive);
			cardList.add(yellowFive);
			cardList.add(redFive1);
			cardList.add(blueFive1);
			cardList.add(greenFive1);
			cardList.add(yellowFive1);
			cardList.add(redSix);
			cardList.add(blueSix);
			cardList.add(greenSix);
			cardList.add(yellowSix);
			cardList.add(redSix1);
			cardList.add(blueSix1);
			cardList.add(greenSix1);
			cardList.add(yellowSix1);
			cardList.add(redSeven);
			cardList.add(blueSeven);
			cardList.add(greenSeven);
			cardList.add(yellowSeven);
			cardList.add(redSeven1);
			cardList.add(blueSeven1);
			cardList.add(greenSeven1);
			cardList.add(yellowSeven1);
			cardList.add(redEight);
			cardList.add(blueEight);
			cardList.add(greenEight);
			cardList.add(yellowEight);
			cardList.add(redEight1);
			cardList.add(blueEight1);
			cardList.add(greenEight1);
			cardList.add(yellowEight1);
			cardList.add(redNine);
			cardList.add(blueNine);
			cardList.add(greenNine);
			cardList.add(yellowNine);
			cardList.add(redNine1);
			cardList.add(blueNine1);
			cardList.add(greenNine1);
			cardList.add(yellowNine1);
			cardList.add(redSkip);
			cardList.add(blueSkip);
			cardList.add(greenSkip);
			cardList.add(yellowSkip);
			cardList.add(redSkip1);
			cardList.add(blueSkip1);
			cardList.add(greenSkip1);
			cardList.add(yellowSkip1);
			cardList.add(redRev);
			cardList.add(blueRev);
			cardList.add(greenRev);
			cardList.add(yellowRev);
			cardList.add(redRev1);
			cardList.add(blueRev1);
			cardList.add(greenRev1);
			cardList.add(yellowRev1);
			cardList.add(redDraw);
			cardList.add(blueDraw);
			cardList.add(greenDraw);
			cardList.add(yellowDraw);
			cardList.add(redDraw1);
			cardList.add(blueDraw1);
			cardList.add(greenDraw1);
			cardList.add(yellowDraw1);
			cardList.add(wild1);
			cardList.add(wild2);
			cardList.add(wild3);
			cardList.add(wild4);
			cardList.add(wildDraw1);
			cardList.add(wildDraw2);
			cardList.add(wildDraw3);
			cardList.add(wildDraw4);
			new UNO();
		}

	}

	private void playing() {
		// TODO Auto-generated method stub
		if (whosUp.equals("Me")) {
			theirTurn = myCards;

		} else if (whosUp.equals("CPU 1")) {
			theirTurn = cpu1;
			autopick();
			// System.out.println("CPU1: " +Arrays.toString(cpu1.toArray()));
		} else if (whosUp.equals("CPU 2")) {
			theirTurn = cpu2;
			autopick();
			// System.out.println("CPU2: " +Arrays.toString(cpu2.toArray()));
		} else if (whosUp.equals("CPU 3")) {
			theirTurn = cpu3;
			autopick();
			// System.out.println("CPU3: " +Arrays.toString(cpu3.toArray()));
		} else if (whosUp.equals("CPU 4")) {
			theirTurn = cpu4;
			autopick();
			// System.out.println("CPU4: " +Arrays.toString(cpu4.toArray()));
		}
	}

	private void autopick() {
		int wildExists = -1;
		boolean foundCard = false;
		String chosenWildColor = "";
		String arr[] = topCard.getText().split(" ", 2);

		String topColor = arr[0]; // red/green/blue/yellow/wild
		String topType = arr[1]; // 0-9/reverse/draw 2/draw 4/skip/red/green/blue/yellow/draw 4 red/draw 4
		// green/draw 4 blue/draw 4 yellow

		// if topCard is wild, make topColor the chosen color
		if (topColor.equals("wild")) {
			if (topType.equals("red") || topType.equals("blue") || topType.equals("green")
					|| topType.equals("yellow")) {
				topColor = topType;
			} else {
				arr = topCard.getText().split(" ");
				topColor = arr[arr.length - 1];
			}
		}

		// check to see if there is a number or color card that matches then use those
		// first,
		// keep note of wild cards to use if there are none.
		for (int i = 0; i < theirTurn.size(); i++) {
			if (theirTurn.get(i).getColor().equals("wild") && wildExists == -1) {
				wildExists = i;
			} else if (theirTurn.get(i).getColor().equals(topColor) || theirTurn.get(i).getType().equals(topType)) {
				foundCard = true;
				topCard.setText(theirTurn.get(i).getName());
				// never a wild here
				if (cpu1 == theirTurn) {
					System.out.println("CPU1 played a " + theirTurn.get(i).getName());
				} else if (cpu2 == theirTurn) {
					System.out.println("CPU2 played a " + theirTurn.get(i).getName());
				} else if (cpu3 == theirTurn) {
					System.out.println("CPU3 played a " + theirTurn.get(i).getName());
				} else if (cpu4 == theirTurn) {
					System.out.println("CPU4 played a " + theirTurn.get(i).getName());
				}
				wildExists = -1;
				whosNext(theirTurn.get(i));
				theirTurn.remove(i);
				break;
			}
		}
		// wild, assuming another color exists in their hand
		if (wildExists != -1 && theirTurn.size() != numWilds()) {
			Card first = firstColorCard();
			chosenWildColor = first.getColor();
			topCard.setText(theirTurn.get(wildExists).getName() + " " + chosenWildColor);
			cardList.remove(theirTurn.get(wildExists));
			if (cpu1 == theirTurn) {
				System.out.println("CPU1 played a " + theirTurn.get(wildExists).getName());
			} else if (cpu2 == theirTurn) {
				System.out.println("CPU2 played a " + theirTurn.get(wildExists).getName());
			} else if (cpu3 == theirTurn) {
				System.out.println("CPU3 played a " + theirTurn.get(wildExists).getName());
			} else if (cpu4 == theirTurn) {
				System.out.println("CPU4 played a " + theirTurn.get(wildExists).getName());
			}
			whosNext(theirTurn.get(wildExists));
			theirTurn.remove(wildExists);
		}
		// wild, with a hand of only wild card(s)
		else if (wildExists != -1 && theirTurn.size() == numWilds()) {
			Card first = theirTurn.get(wildExists);
			chosenWildColor = "red";
			topCard.setText(first.getName() + " " + chosenWildColor);
			cardList.remove(first);
			if (cpu1 == theirTurn) {
				System.out.println("CPU1 played a " + theirTurn.get(wildExists).getName());
			} else if (cpu2 == theirTurn) {
				System.out.println("CPU2 played a " + theirTurn.get(wildExists).getName());
			} else if (cpu3 == theirTurn) {
				System.out.println("CPU3 played a " + theirTurn.get(wildExists).getName());
			} else if (cpu4 == theirTurn) {
				System.out.println("CPU4 played a " + theirTurn.get(wildExists).getName());
			}
			whosNext(first);
			theirTurn.remove(wildExists);
		}
		// if there is no card available in the current hand, draw 1
		else if (foundCard == false) {
			if (cpu1 == theirTurn) {
				System.out.println("CPU1 drawed 1");
			} else if (cpu2 == theirTurn) {
				System.out.println("CPU2 drawed 1");
			} else if (cpu3 == theirTurn) {
				System.out.println("CPU3 drawed 1 ");
			} else if (cpu4 == theirTurn) {
				System.out.println("CPU4 drawed 1");
			}
			whosNext(new Card("draw 1", "no", "draw 1", "+1"));
		}

		isGameOver();
		if (!gameOver) {
			playing();
		}
	}

	private int numWilds() {
		int ret = 0;
		for (int i = 0; i < theirTurn.size(); i++) {
			if (theirTurn.get(i).getColor().equals("wild")) {
				ret++;
			}
		}
		return ret;
	}

	private void whosNext(Card c) {
		// System.out.println("Who's up: " + whosUp + " Clockwise: " + clockwise + "
		// Type: " + c.getType());
		if (whosUp.equals("Me")) {
			if (clockwise == true) {
				switch (c.getType()) {
				case "skip":
					whosUp = "CPU 2";
					break;
				case "reverse":
					whosUp = "CPU 4";
					clockwise = false;
					break;
				case "draw 2":
					draw(2, cpu1);
					whosUp = "CPU 2";
					break;
				case "wild":
					whosUp = "CPU 1";
					break;
				case "wild draw 4":
					draw(4, cpu1);
					whosUp = "CPU 2";
					break;
				case "draw 1":
					draw(1, myCards);
					whosUp = "CPU 1";
					break;
				default:
					whosUp = "CPU 1";
				}
			} else {
				switch (c.getType()) {
				case "skip":
					whosUp = "CPU 3";
					break;
				case "reverse":
					whosUp = "CPU 1";
					clockwise = true;
					break;
				case "draw 2":
					draw(2, cpu4);
					whosUp = "CPU 3";
					break;
				case "wild":
					whosUp = "CPU 4";
					break;
				case "wild draw 4":
					draw(4, cpu4);
					setMyCards();
					whosUp = "CPU 3";
					break;
				case "draw 1":
					draw(1, myCards);
					whosUp = "CPU 4";
					break;
				default:
					whosUp = "CPU 4";
				}
			}
		} else if (whosUp.equals("CPU 1")) {
			if (clockwise == true) {
				switch (c.getType()) {
				case "skip":
					whosUp = "CPU 3";
					break;
				case "reverse":
					whosUp = "Me";
					clockwise = false;
					break;
				case "draw 2":
					draw(2, cpu2);
					whosUp = "CPU 3";
					break;
				case "wild":
					whosUp = "CPU 2";
					break;
				case "wild draw 4":
					draw(4, cpu2);
					whosUp = "CPU 3";
					break;
				case "draw 1":
					draw(1, cpu1);
					whosUp = "CPU 2";
					break;
				default:
					whosUp = "CPU 2";
				}
			} else {
				switch (c.getType()) {
				case "skip":
					whosUp = "CPU 4";
					break;
				case "reverse":
					whosUp = "CPU 2";
					clockwise = true;
					break;
				case "draw 2":
					draw(2, myCards);
					setMyCards();
					whosUp = "CPU 4";
					break;
				case "wild":
					whosUp = "Me";
					break;
				case "wild draw 4":
					draw(4, myCards);
					setMyCards();
					whosUp = "CPU 4";
					break;
				case "draw 1":
					draw(1, cpu1);
					whosUp = "Me";
					break;
				default:
					whosUp = "Me";
				}
			}
		} else if (whosUp.equals("CPU 2")) {
			if (clockwise == true) {
				switch (c.getType()) {
				case "skip":
					whosUp = "CPU 4";
					break;
				case "reverse":
					whosUp = "CPU 1";
					clockwise = false;
					break;
				case "draw 2":
					draw(2, cpu3);
					whosUp = "CPU 4";
					break;
				case "wild":
					whosUp = "CPU 3";
					break;
				case "wild draw 4":
					draw(4, cpu3);
					whosUp = "CPU 4";
					break;
				case "draw 1":
					draw(1, cpu2);
					whosUp = "CPU 3";
					break;
				default:
					whosUp = "CPU 3";
				}
			} else {
				switch (c.getType()) {
				case "skip":
					whosUp = "Me";
					break;
				case "reverse":
					whosUp = "CPU 3";
					clockwise = true;
					break;
				case "draw 2":
					draw(2, cpu1);
					whosUp = "Me";
					break;
				case "wild":
					whosUp = "CPU 1";
					break;
				case "wild draw 4":
					draw(4, cpu1);
					whosUp = "Me";
					break;
				case "draw 1":
					draw(1, cpu2);
					whosUp = "CPU 1";
					break;
				default:
					whosUp = "CPU 1";
				}
			}
		} else if (whosUp.equals("CPU 3")) {
			if (clockwise == true) {
				switch (c.getType()) {
				case "skip":
					whosUp = "Me";
					break;
				case "reverse":
					whosUp = "CPU 2";
					clockwise = false;
					break;
				case "draw 2":
					draw(2, cpu4);
					whosUp = "Me";
					break;
				case "wild":
					whosUp = "CPU 4";
					break;
				case "wild draw 4":
					draw(4, cpu4);
					whosUp = "Me";
					break;
				case "draw 1":
					draw(1, cpu3);
					whosUp = "CPU 4";
					break;
				default:
					whosUp = "CPU 4";
				}
			} else {
				switch (c.getType()) {
				case "skip":
					whosUp = "CPU 1";
					break;
				case "reverse":
					whosUp = "CPU 4";
					clockwise = true;
					break;
				case "draw 2":
					draw(2, cpu2);
					whosUp = "CPU 1";
					break;
				case "wild":
					whosUp = "CPU 2";
					break;
				case "wild draw 4":
					draw(4, cpu2);
					whosUp = "CPU 1";
					break;
				case "draw 1":
					draw(1, cpu3);
					whosUp = "CPU 2";
					break;
				default:
					whosUp = "CPU 2";
				}
			}
		} else if (whosUp.equals("CPU 4")) {
			if (clockwise == true) {
				switch (c.getType()) {
				case "skip":
					whosUp = "CPU 1";
					break;
				case "reverse":
					whosUp = "CPU 3";
					clockwise = false;
					break;
				case "draw 2":
					draw(2, myCards);
					setMyCards();
					whosUp = "CPU 1";
					break;
				case "wild":
					whosUp = "Me";
					break;
				case "wild draw 4":
					draw(4, myCards);
					setMyCards();
					whosUp = "CPU 1";
					break;
				case "draw 1":
					draw(1, cpu4);
					whosUp = "Me";
					break;
				default:
					whosUp = "Me";
				}
			} else {
				switch (c.getType()) {
				case "skip":
					whosUp = "CPU 2";
					break;
				case "reverse":
					whosUp = "Me";
					clockwise = true;
					break;
				case "draw 2":
					draw(2, cpu3);
					whosUp = "CPU 2";
					break;
				case "wild":
					whosUp = "CPU 3";
					break;
				case "wild draw 4":
					draw(4, cpu3);
					whosUp = "CPU 2";
					break;
				case "draw 1":
					draw(1, cpu4);
					whosUp = "CPU 3";
					break;
				default:
					whosUp = "CPU 3";
				}
			}
		}
	}

	private void draw(int num, ArrayList<Card> curr) {
		if (cardList.size() < 4) {
			cardList = discard;
			discard = new ArrayList<Card>();
		}
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			int value = random.nextInt(cardList.size());
			Card pickUp = cardList.get(value);
			cardList.remove(value);
			// if you are only drawing one card, check to see if you can play
			// that card immediately
			if (num == 1) {
				String arr[] = topCard.getText().split(" ", 2);

				String topColor = arr[0]; // red/green/blue/yellow/wild
				String topType = arr[1]; // 0-9/reverse/draw 2/draw 4/skip/red/green/blue/yellow/draw 4 red/draw 4
				// green/draw 4 blue/draw 4 yellow

				// if topCard is wild, make topColor the chosen color
				if (topColor.equals("wild")) {
					if (topType.equals("red") || topType.equals("blue") || topType.equals("green")
							|| topType.equals("yellow")) {
						topColor = topType;
					} else {
						arr = topCard.getText().split(" ");
						topColor = arr[arr.length - 1];
					}
				}

				// if the card picked up is a wild card, set the color as the first non-wild
				// card color in their hand
				if (pickUp.getColor().equals("wild")) {
					Card first = firstColorCard();
					String chosenWildColor = first.getColor();
					topCard.setText(pickUp.getName() + " " + chosenWildColor);
					cardList.remove(pickUp);

					// if the card picked up can be played, play it
				} else if (pickUp.getColor().equals(topColor) || pickUp.getType().equals(topType)) {
					topCard.setText(pickUp.getName());
					cardList.remove(pickUp);
				} else {
					cardList.remove(pickUp);
					curr.add(pickUp);
				}
			} else {
				if (curr == myCards) {
					curr.add(pickUp);
					panel.removeAll();
					panel.revalidate();
					panel.repaint();
					panel.setBackground(new Color(40, 180, 40));
					panel.add(topCard);
					setMyCards();
				} else {
					curr.add(pickUp);
				}
				cardList.remove(pickUp);

			}
		}
	}

	private Card firstColorCard() {
		for (int i = 0; i < theirTurn.size(); i++) {
			if (!theirTurn.get(i).getColor().equals("wild")) {
				return theirTurn.get(i);
			}
		}
		System.out.println("size of deck: " + theirTurn.size());
		return null;
	}

	// check to see if the game is over
	private void isGameOver() {
		if (theirTurn.size() == 1) {
			if (theirTurn == myCards) {
				System.out.println("I have Uno!");
			} else if (theirTurn == cpu1) {
				System.out.println("CPU 1 has Uno!");
			} else if (theirTurn == cpu2) {
				System.out.println("CPU 2 has Uno!");
			} else if (theirTurn == cpu3) {
				System.out.println("CPU 3 has Uno!");
			} else if (theirTurn == cpu4) {
				System.out.println("CPU 4 has Uno!");
			}
			;
		} else if (theirTurn.size() == 0) {
			gameOver = true;
			if (theirTurn == myCards) {
				System.out.println("Game Over! I won!");
			} else if (theirTurn == cpu1) {
				System.out.println("Game Over! CPU 1 won!");
			} else if (theirTurn == cpu2) {
				System.out.println("Game Over! CPU 2 won!");
			} else if (theirTurn == cpu3) {
				System.out.println("Game Over! CPU 3 won!");
			} else if (theirTurn == cpu4) {
				System.out.println("Game Over! CPU 4 won!");
			}

			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			panel.setBackground(new Color(40, 180, 40));
			JButton butt = new JButton("Reset");
			butt.setActionCommand(Actions.RESET.name());
			butt.addActionListener(this);
			panel.add(butt, BorderLayout.SOUTH);
		}
	}

	private Card findCard(String text, ArrayList<Card> list) {
		text = text.toUpperCase();
		for (int i = 0; i < list.size(); i++) {
			if (text.equals(list.get(i).getName().toUpperCase())) {
				return list.get(i);
			}
		}
		return null;
	}

	private void start() {
		Random random = new Random();
		whosUp = "Me";

		for (int i = 0; i < 7; i++) {
			int value = random.nextInt(cardList.size());
			myCards.add(cardList.get(value));
			cardList.remove(value);
		}
		for (int i = 0; i < 7; i++) {
			int value = random.nextInt(cardList.size());
			cpu1.add(cardList.get(value));
			cardList.remove(value);
		}
		for (int i = 0; i < 7; i++) {
			int value = random.nextInt(cardList.size());
			cpu2.add(cardList.get(value));
			cardList.remove(value);
		}
		for (int i = 0; i < 7; i++) {
			int value = random.nextInt(cardList.size());
			cpu3.add(cardList.get(value));
			cardList.remove(value);
		}
		for (int i = 0; i < 7; i++) {
			int value = random.nextInt(cardList.size());
			cpu4.add(cardList.get(value));
			cardList.remove(value);
		}

		boolean bool = false;
		int value = 0;
		Card cardi = null;
		// you have to start the game with a number card
		while (bool == false) {
			value = random.nextInt(cardList.size());
			cardi = cardList.get(value);
			if (cardi.getType().matches("[0-9]")) {
				bool = true;
			}
		}

		cardList.remove(value);

		topCard = new JButton(cardi.getName());
		// add the buttons for the player's cards
		setMyCards();
		// frame.setSize(1024, 768);
		frame.add(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Uno Game");
		frame.pack();
		frame.setVisible(true);
		playing();

	}

	private void setMyCards() {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();

		panel.setLayout(new GridLayout(3, 8));
		cpu1butt.setText("CPU1 has " + cpu1.size() + " Cards");
		panel.add(cpu1butt, BorderLayout.CENTER);

		cpu2butt.setText("CPU2 has " + cpu2.size() + " Cards");
		panel.add(cpu2butt, BorderLayout.CENTER);

		JButton blank1 = new JButton("");
		blank1.setBackground(new Color(40, 180, 40));
		panel.add(blank1, BorderLayout.CENTER);

		// System.out.println(cardi.getColor() + " " + cardi.getType());

		panel.add(topCard, BorderLayout.CENTER);

		JButton blank2 = new JButton("");
		blank2.setBackground(new Color(40, 180, 40));
		panel.add(blank2, BorderLayout.CENTER);
		
		JButton blank3 = new JButton("");
		blank3.setBackground(new Color(40, 180, 40));
		panel.add(blank3, BorderLayout.CENTER);

		cpu3butt.setText("CPU3 has " + cpu3.size() + " Cards");
		panel.add(cpu3butt, BorderLayout.CENTER);

		cpu4butt.setText("CPU4 has " + cpu4.size() + " Cards");
		panel.add(cpu4butt, BorderLayout.CENTER);

		panel.setBackground(new Color(40, 180, 40));
		
		for (int i = 0; i < 8; i++) {
			JButton blank = new JButton("");
			blank.setBackground(new Color(40, 180, 40));
			panel.add(blank, BorderLayout.CENTER);
		}

		for (int i = 0; i < myCards.size(); i++) {
			JButton butt = new JButton();
			Card c = myCards.get(i);
			if (c.getColor().equals("red")) {
				butt.setBackground(Color.RED);
				switch (c.getType()) {
				case "0":
					butt.setActionCommand(Actions.REDZERO.name());
					butt.setText("red 0");
					break;
				case "1":
					butt.setActionCommand(Actions.REDONE.name());
					butt.setText("red 1");
					break;
				case "2":
					butt.setActionCommand(Actions.REDTWO.name());
					butt.setText("red 2");
					break;
				case "3":
					butt.setActionCommand(Actions.REDTHREE.name());
					butt.setText("red 3");
					break;
				case "4":
					butt.setActionCommand(Actions.REDFOUR.name());
					butt.setText("red 4");
					break;
				case "5":
					butt.setActionCommand(Actions.REDFIVE.name());
					butt.setText("red 5");
					break;
				case "6":
					butt.setActionCommand(Actions.REDSIX.name());
					butt.setText("red 6");
					break;
				case "7":
					butt.setActionCommand(Actions.REDSEVEN.name());
					butt.setText("red 7");
					break;
				case "8":
					butt.setActionCommand(Actions.REDEIGHT.name());
					butt.setText("red 8");
					break;
				case "9":
					butt.setActionCommand(Actions.REDNINE.name());
					butt.setText("red 9");
					break;
				case "skip":
					butt.setActionCommand(Actions.REDSKIP.name());
					butt.setText("red skip");
					break;
				case "reverse":
					butt.setActionCommand(Actions.REDREV.name());
					butt.setText("red reverse");
					break;
				case "draw 2":
					butt.setActionCommand(Actions.REDDRAW.name());
					butt.setText("red draw 2");
					break;
				}
			} else if (c.getColor().equals("blue")) {
				butt.setBackground(Color.BLUE);
				switch (c.getType()) {
				case "0":
					butt.setActionCommand(Actions.BLUEZERO.name());
					butt.setText("blue 0");
					break;
				case "1":
					butt.setActionCommand(Actions.BLUEONE.name());
					butt.setText("blue 1");
					break;
				case "2":
					butt.setActionCommand(Actions.BLUETWO.name());
					butt.setText("blue 2");
					break;
				case "3":
					butt.setActionCommand(Actions.BLUETHREE.name());
					butt.setText("blue 3");
					break;
				case "4":
					butt.setActionCommand(Actions.BLUEFOUR.name());
					butt.setText("blue 4");
					break;
				case "5":
					butt.setActionCommand(Actions.BLUEFIVE.name());
					butt.setText("blue 5");
					break;
				case "6":
					butt.setActionCommand(Actions.BLUESIX.name());
					butt.setText("blue 6");
					break;
				case "7":
					butt.setActionCommand(Actions.BLUESEVEN.name());
					butt.setText("blue 7");
					break;
				case "8":
					butt.setActionCommand(Actions.BLUEEIGHT.name());
					butt.setText("blue 8");
					break;
				case "9":
					butt.setActionCommand(Actions.BLUENINE.name());
					butt.setText("blue 9");
					break;
				case "skip":
					butt.setActionCommand(Actions.BLUESKIP.name());
					butt.setText("blue skip");
					break;
				case "reverse":
					butt.setActionCommand(Actions.BLUEREV.name());
					butt.setText("blue reverse");
					break;
				case "draw 2":
					butt.setActionCommand(Actions.BLUEDRAW.name());
					butt.setText("blue draw 2");
					break;
				}
			} else if (c.getColor().equals("green")) {
				butt.setBackground(Color.GREEN);
				switch (c.getType()) {
				case "0":
					butt.setActionCommand(Actions.GREENZERO.name());
					butt.setText("green 0");
					break;
				case "1":
					butt.setActionCommand(Actions.GREENONE.name());
					butt.setText("green 1");
					break;
				case "2":
					butt.setActionCommand(Actions.GREENTWO.name());
					butt.setText("green 2");
					break;
				case "3":
					butt.setActionCommand(Actions.GREENTHREE.name());
					butt.setText("green 3");
					break;
				case "4":
					butt.setActionCommand(Actions.GREENFOUR.name());
					butt.setText("green 4");
					break;
				case "5":
					butt.setActionCommand(Actions.GREENFIVE.name());
					butt.setText("green 5");
					break;
				case "6":
					butt.setActionCommand(Actions.GREENSIX.name());
					butt.setText("green 6");
					break;
				case "7":
					butt.setActionCommand(Actions.GREENSEVEN.name());
					butt.setText("green 7");
					break;
				case "8":
					butt.setActionCommand(Actions.GREENEIGHT.name());
					butt.setText("green 8");
					break;
				case "9":
					butt.setActionCommand(Actions.GREENNINE.name());
					butt.setText("green 9");
					break;
				case "skip":
					butt.setActionCommand(Actions.GREENSKIP.name());
					butt.setText("green skip");
					break;
				case "reverse":
					butt.setActionCommand(Actions.GREENREV.name());
					butt.setText("green reverse");
					break;
				case "draw 2":
					butt.setActionCommand(Actions.GREENDRAW.name());
					butt.setText("green draw 2");
					break;
				}
			} else if (c.getColor().equals("yellow")) {
				butt.setBackground(Color.YELLOW);
				switch (c.getType()) {
				case "0":
					butt.setActionCommand(Actions.YELLOWZERO.name());
					butt.setText("yellow 0");
					break;
				case "1":
					butt.setActionCommand(Actions.YELLOWONE.name());
					butt.setText("yellow 1");
					break;
				case "2":
					butt.setActionCommand(Actions.YELLOWTWO.name());
					butt.setText("yellow 2");
					break;
				case "3":
					butt.setActionCommand(Actions.YELLOWTHREE.name());
					butt.setText("yellow 3");
					break;
				case "4":
					butt.setActionCommand(Actions.YELLOWFOUR.name());
					butt.setText("yellow 4");
					break;
				case "5":
					butt.setActionCommand(Actions.YELLOWFIVE.name());
					butt.setText("yellow 5");
					break;
				case "6":
					butt.setActionCommand(Actions.YELLOWSIX.name());
					butt.setText("yellow 6");
					break;
				case "7":
					butt.setActionCommand(Actions.YELLOWSEVEN.name());
					butt.setText("yellow 7");
					break;
				case "8":
					butt.setActionCommand(Actions.YELLOWEIGHT.name());
					butt.setText("yellow 8");
					break;
				case "9":
					butt.setActionCommand(Actions.YELLOWNINE.name());
					butt.setText("yellow 9");
					break;
				case "skip":
					butt.setActionCommand(Actions.YELLOWSKIP.name());
					butt.setText("yellow skip");
					break;
				case "reverse":
					butt.setActionCommand(Actions.YELLOWREV.name());
					butt.setText("yellow reverse");
					break;
				case "draw 2":
					butt.setActionCommand(Actions.YELLOWDRAW.name());
					butt.setText("yellow draw 2");
					break;
				}
			} else if (c.getColor().equals("wild")) {
				butt.setBackground(Color.LIGHT_GRAY);
				switch (c.getType()) {
				case "wild":
					butt.setActionCommand(Actions.WILD.name());
					butt.setText("wild");
					break;
				case "wild draw 4":
					butt.setActionCommand(Actions.WILDDRAW.name());
					butt.setText("wild draw 4");
					break;
				}
			}

			butt.addActionListener(this);
			panel.add(butt, BorderLayout.SOUTH);
		}
		JButton butt = new JButton();
		butt.setActionCommand(Actions.DRAW.name());
		butt.setText("Draw");
		butt.addActionListener(this);
		panel.add(butt, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		cardList.add(redZero);
		cardList.add(blueZero);
		cardList.add(greenZero);
		cardList.add(yellowZero);
		cardList.add(redOne);
		cardList.add(blueOne);
		cardList.add(greenOne);
		cardList.add(yellowOne);
		cardList.add(redOne1);
		cardList.add(blueOne1);
		cardList.add(greenOne1);
		cardList.add(yellowOne1);
		cardList.add(redTwo);
		cardList.add(blueTwo);
		cardList.add(greenTwo);
		cardList.add(yellowTwo);
		cardList.add(redTwo1);
		cardList.add(blueTwo1);
		cardList.add(greenTwo1);
		cardList.add(yellowTwo1);
		cardList.add(redThree);
		cardList.add(blueThree);
		cardList.add(greenThree);
		cardList.add(yellowThree);
		cardList.add(redThree1);
		cardList.add(blueThree1);
		cardList.add(greenThree1);
		cardList.add(yellowThree1);
		cardList.add(redFour);
		cardList.add(blueFour);
		cardList.add(greenFour);
		cardList.add(yellowFour);
		cardList.add(redFour1);
		cardList.add(blueFour1);
		cardList.add(greenFour1);
		cardList.add(yellowFour1);
		cardList.add(redFive);
		cardList.add(blueFive);
		cardList.add(greenFive);
		cardList.add(yellowFive);
		cardList.add(redFive1);
		cardList.add(blueFive1);
		cardList.add(greenFive1);
		cardList.add(yellowFive1);
		cardList.add(redSix);
		cardList.add(blueSix);
		cardList.add(greenSix);
		cardList.add(yellowSix);
		cardList.add(redSix1);
		cardList.add(blueSix1);
		cardList.add(greenSix1);
		cardList.add(yellowSix1);
		cardList.add(redSeven);
		cardList.add(blueSeven);
		cardList.add(greenSeven);
		cardList.add(yellowSeven);
		cardList.add(redSeven1);
		cardList.add(blueSeven1);
		cardList.add(greenSeven1);
		cardList.add(yellowSeven1);
		cardList.add(redEight);
		cardList.add(blueEight);
		cardList.add(greenEight);
		cardList.add(yellowEight);
		cardList.add(redEight1);
		cardList.add(blueEight1);
		cardList.add(greenEight1);
		cardList.add(yellowEight1);
		cardList.add(redNine);
		cardList.add(blueNine);
		cardList.add(greenNine);
		cardList.add(yellowNine);
		cardList.add(redNine1);
		cardList.add(blueNine1);
		cardList.add(greenNine1);
		cardList.add(yellowNine1);
		cardList.add(redSkip);
		cardList.add(blueSkip);
		cardList.add(greenSkip);
		cardList.add(yellowSkip);
		cardList.add(redSkip1);
		cardList.add(blueSkip1);
		cardList.add(greenSkip1);
		cardList.add(yellowSkip1);
		cardList.add(redRev);
		cardList.add(blueRev);
		cardList.add(greenRev);
		cardList.add(yellowRev);
		cardList.add(redRev1);
		cardList.add(blueRev1);
		cardList.add(greenRev1);
		cardList.add(yellowRev1);
		cardList.add(redDraw);
		cardList.add(blueDraw);
		cardList.add(greenDraw);
		cardList.add(yellowDraw);
		cardList.add(redDraw1);
		cardList.add(blueDraw1);
		cardList.add(greenDraw1);
		cardList.add(yellowDraw1);
		cardList.add(wild1);
		cardList.add(wild2);
		cardList.add(wild3);
		cardList.add(wild4);
		cardList.add(wildDraw1);
		cardList.add(wildDraw2);
		cardList.add(wildDraw3);
		cardList.add(wildDraw4);
		new UNO();

	}

}
