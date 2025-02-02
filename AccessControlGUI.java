import java.time.LocalDateTime;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccessControlGUI {
    private JFrame frame;
    private JTextField cardIdField, floorField, roomField;
    private JTextArea resultArea;
    private AccessControlSystem system;

    public AccessControlGUI() {
        system = new AccessControlSystem();
        frame = new JFrame("Access Control System");
        frame.setLayout(new FlowLayout());

        // Text Fields
        cardIdField = new JTextField(15);
        floorField = new JTextField(5);
        roomField = new JTextField(5);

        // Buttons
        JButton checkAccessButton = new JButton("Check Access");
        JButton addCardButton = new JButton("Add Card");

        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        // Adding components to the frame
        frame.add(new JLabel("Card ID:"));
        frame.add(cardIdField);
        frame.add(new JLabel("Floor:"));
        frame.add(floorField);
        frame.add(new JLabel("Room:"));
        frame.add(roomField);
        frame.add(checkAccessButton);
        frame.add(addCardButton);
        frame.add(new JScrollPane(resultArea));

        // Button actions
        checkAccessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cardId = cardIdField.getText();
                String floor = floorField.getText();
                String room = roomField.getText();
                boolean access = system.checkCardAccess(cardId, floor, room);
                resultArea.setText("Access " + (access ? "Granted" : "Denied"));
            }
        });

        addCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic to add a new card (pop up dialog for user input or hardcoded for testing)
                AccessCard newCard = new AccessCard("card123", "user001", "Low,Medium", "Room1,Room2", LocalDateTime.now().plusDays(1));
                system.addAccessCard(newCard);
                resultArea.setText("Card added successfully.");
            }
        });

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Main method: Starts the GUI application
        new AccessControlGUI();
    }
}
