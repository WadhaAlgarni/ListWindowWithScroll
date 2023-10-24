package ListWindowWithScroll;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
/**
6 This class demonstrates the List Component.
7 */
public class ListWindowWithScroll extends JFrame
{
private JPanel monthPanel; // To hold components
private JPanel selectedMonthPanel; // To hold components
private JList seasonList; // The months
private JScrollPane scrollPane; // A scroll pane
private JTextField selectedMonth; // The selected month
private JLabel label; // A message
// The following array holds the values that will
// be displayed in the monthList list component.
private String[] season = { "Summar", "Autumn","Winter" ,"Spring"};
/**
26 Constructor
27 */
public ListWindowWithScroll()
{
// Set the title.
setTitle("Favourite season ");
// Specify an action for the close button.
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Add a BorderLayout manager.
setLayout(new BorderLayout());
// Build the month and selectedMonth panels.
buildMonthPanel();
buildSelectedMonthPanel();
// Add the panels to the content pane.
JLabel Label2= new JLabel("Please select your faviorate season: ");

add(Label2,BorderLayout.NORTH);
add(monthPanel, BorderLayout.CENTER);
add(selectedMonthPanel, BorderLayout.SOUTH);
// Pack and display the window.
pack();
setVisible(true);
}
/**
54 The buildMonthPanel method adds a list containing
55 the names of the months to a panel.
56 */
private void buildMonthPanel()
{
// Create a panel to hold the list.
monthPanel = new JPanel();
// Create the list.
seasonList = new JList(season);
// Set the selection mode to single selection.
seasonList.setSelectionMode(
ListSelectionModel.SINGLE_SELECTION);
// Register the list selection listener.
seasonList.addListSelectionListener(
new ListListener());
// Set the number of visible rows to 6.
seasonList.setVisibleRowCount(3);
// Add the list to a scroll pane.
scrollPane = new JScrollPane(seasonList);
// Add the scroll pane to the panel.
monthPanel.add(scrollPane);
}
/**
85 The buildSelectedMonthPanel method adds an
86 uneditable text field to a panel.
87 */
private void buildSelectedMonthPanel()
{
// Create a panel to hold the text field.
selectedMonthPanel = new JPanel();
// Create the label.
label = new JLabel("You selected: ");
// Create the text field.
selectedMonth = new JTextField(10);
// Make the text field uneditable.
selectedMonth.setEditable(false);
// Add the label and text field to the panel.
selectedMonthPanel.add(label);
selectedMonthPanel.add(selectedMonth);
}
/**
109 Private inner class that handles the event when
110 the user selects an item from the list.
111 */
private class ListListener
implements ListSelectionListener
{
public void valueChanged(ListSelectionEvent e)
{
// Get the selected month.
String selection =
(String) seasonList.getSelectedValue();
// Put the selected month in the text field.
selectedMonth.setText(selection);
}
}
/**
128 The main method creates an instance of the
129 ListWindowWithScroll class which causes it
130 to display its window.
131 */
public static void main(String[] args)
{
new ListWindowWithScroll();
}
}
