import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGameGUI extends JFrame {
    private int targetNumber;
    private int attempts;

    private JTextField guessField;
    private JLabel messageLabel;
    private JButton submitButton;

    public NumberGameGUI() {
        setTitle("Number Guessing Game");
        setSize(800, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        targetNumber = new Random().nextInt(100) + 1;
        attempts = 0;

        messageLabel = new JLabel("Guess a number between 1 and 100:");
        guessField = new JTextField(10);
        submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        add(messageLabel);
        add(guessField);
        add(submitButton);

        setVisible(true);
    }

    private void checkGuess() {
        try {
            int userGuess = Integer.parseInt(guessField.getText());
            attempts++;

            if (userGuess == targetNumber) {
                messageLabel.setText("Congratulations! You guessed it in " + attempts + " attempts.");
                guessField.setEnabled(false);
                submitButton.setEnabled(false);
            } else if (userGuess < targetNumber) {
                messageLabel.setText("Try higher. Attempts: " + attempts);
            } else {
                messageLabel.setText("Try lower. Attempts: " + attempts);
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Please enter a valid number.");
        }
        guessField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGameGUI();
            }
        });
    }
}

