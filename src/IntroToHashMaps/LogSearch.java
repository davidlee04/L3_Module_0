package IntroToHashMaps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	JFrame frame;
	JPanel panel;
	JButton addEntry;
	JButton searchID;
	JButton viewList;
	JButton removeEntry;
	
	HashMap<Integer, String> id;
	public static void main(String[] args) {
		LogSearch run = new LogSearch();
		run.setUI();
	}
	
	public LogSearch() {
		frame = new JFrame();
		panel = new JPanel();
		addEntry = new JButton();
		searchID = new JButton();
		viewList = new JButton();
		removeEntry = new JButton();
		id = new HashMap<Integer, String>();
	}
	
	void setUI() {
		frame.add(panel);
		panel.add(addEntry);
		panel.add(searchID);
		panel.add(viewList);
		panel.add(removeEntry);
		frame.setVisible(true);
		addEntry.setText("Add Entry");
		searchID.setText("Search By ID");
		viewList.setText("View List");
		removeEntry.setText("Remove Entry");
		addEntry.addActionListener(this);
		searchID.addActionListener(this);
		viewList.addActionListener(this);
		removeEntry.addActionListener(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addEntry) {
			String input = JOptionPane.showInputDialog("Please enter a new ID number.");
			String inputName = JOptionPane.showInputDialog("Please enter your name.");
			int inputInt = Integer.parseInt(input);
			id.put(inputInt, inputName);
		}
		if(e.getSource() == searchID) {
			String desiredID = JOptionPane.showInputDialog("Please enter your ID number.");
			int intID = Integer.parseInt(desiredID);
			if(id.containsKey(intID)) {
				JOptionPane.showMessageDialog(null, id.get(intID));
			}else {
				JOptionPane.showMessageDialog(null, "That ID does not exist.");
			}
		}
		if(e.getSource() == viewList) {
			String list = "";
			for(Integer s : id.keySet()) {
				list += "ID: "+s+" Name: "+id.get(s)+"\n";
			}
			JOptionPane.showMessageDialog(null, list);
		}
		if(e.getSource() == removeEntry) {
			String removedID = JOptionPane.showInputDialog("Please enter an ID.");
			int intRemovedID = Integer.parseInt(removedID);
			if(id.containsKey(intRemovedID)) {
				id.remove(intRemovedID);
				JOptionPane.showMessageDialog(null, "Success!");
			}else {
				JOptionPane.showMessageDialog(null, "That ID does not exist.");
			}
		}
	}
}
