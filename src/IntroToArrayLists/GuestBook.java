package IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame frame;
	JPanel panel;
	JButton addName;
	JButton viewName;
	
	ArrayList<String> input = new ArrayList<String>();
	
	public GuestBook () {
		frame = new JFrame();
		panel = new JPanel();
		addName = new JButton();
		viewName = new JButton();
		
		setUI();
	}
	public static void main(String[] args) {
		GuestBook hi = new GuestBook();
	}
	
	void setUI() {
		frame.add(panel);
		panel.add(addName);
		panel.add(viewName);
		frame.setVisible(true);
		addName.addActionListener(this);
		viewName.addActionListener(this);
		addName.setText("Add A Name");
		viewName.setText("View Names");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addName) {
			String name = JOptionPane.showInputDialog("Enter a name.");
			input.add(name);
		}
		if(e.getSource() == viewName) {
			String s = "";
			for(int i = 0; i<input.size(); i++) {
				s += "Guest #"+(i+1)+": "+input.get(i)+"\n";
				
			}
			    JOptionPane.showMessageDialog(null, s+"");
		}
	}

}
