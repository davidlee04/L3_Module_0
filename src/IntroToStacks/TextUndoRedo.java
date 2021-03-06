package IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	JFrame frame;
	JPanel panel;
	JLabel label;

	Stack<String> text = new Stack<String>();

	public static void main(String[] args) {
		TextUndoRedo run = new TextUndoRedo();
		run.setUI();

	}

	public TextUndoRedo() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
	}

	void setUI() {
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	String input = "";

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (!(e.getKeyChar() == KeyEvent.VK_BACK_SPACE) && !(e.getKeyChar() == KeyEvent.VK_BACK_SLASH)) {
			input = input += e.getKeyChar();
		    label.setText(input);
		}

		if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
			text.push(input.charAt(input.length() - 1) + "");
			input = input.substring(0, input.length()-1);
			label.setText(input);
		}
		
		if(e.getKeyChar() == KeyEvent.VK_BACK_SLASH) {
			String undo = text.pop();
			input = input+undo;
			label.setText(input);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
