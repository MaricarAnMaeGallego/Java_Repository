import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabActivity4EmpInfoSystemGUI {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Employee Information System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLayout(new GridLayout(8, 2, 5, 5));

        // Labels and text fields
        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField();

        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField();

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();

        JLabel hoursLabel = new JLabel("Hours Worked:");
        JTextField hoursField = new JTextField();

        JLabel rateLabel = new JLabel("Hourly Rate:");
        JTextField rateField = new JTextField();

        JButton submitButton = new JButton("Submit");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        // Add components to the frame
        frame.add(firstNameLabel); frame.add(firstNameField);
        frame.add(lastNameLabel);  frame.add(lastNameField);
        frame.add(ageLabel);       frame.add(ageField);
        frame.add(hoursLabel);     frame.add(hoursField);
        frame.add(rateLabel);      frame.add(rateField);
        frame.add(new JLabel("")); frame.add(submitButton);
        frame.add(new JLabel("Result:")); frame.add(resultArea);

        // Compute button action
        submitButton.addActionListener(e -> {
            try {
                String firstName = firstNameField.getText().trim();
                String lastName = lastNameField.getText().trim();
                String ageText = ageField.getText().trim();
                String hoursText = hoursField.getText().trim();
                String rateText = rateField.getText().trim();

                // Validation
                if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() ||
                        hoursText.isEmpty() || rateText.isEmpty()) {
                    throw new IllegalArgumentException("All fields must be filled out.");
                }

                int age = Integer.parseInt(ageText);
                double hours = Double.parseDouble(hoursText);
                double rate = Double.parseDouble(rateText);

                if (age <= 0 || hours <= 0 || rate <= 0) {
                    throw new IllegalArgumentException("Age, hours, and rate must be positive values.");
                }

                double salary = hours * rate;

                // Format result output to match screenshot style
                String output = "First Name: " + firstName +
                              "\nLast Name: " + lastName +
                              "\nAge: " + age + " years old" +
                              "\nDaily Salary: PHP " + String.format("%.2f", salary);

                resultArea.setText(output);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Please enter valid numbers for age, hours, and hourly rate.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame,
                        ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame,
                        "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Make the window visible
        frame.setVisible(true);
    }
}
