import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private double num1 = 0, num2 = 0, result = 0;
    private String operator = "";

    public MyCalculator() {
        setTitle("My Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Display field
        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 36));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        String[][] labels = {
            {"C", "DEL", "+/-", "÷"},
            {"%", "√", "xʸ", "×"},
            {"7", "8", "9", "-"},
            {"4", "5", "6", "+"},
            {"1", "2", "3", "="},
            {"0", ".", ""}
        };

        Color red = new Color(255, 102, 102);
        Color green = new Color(204, 204, 0);

        for (int row = 0; row < labels.length; row++) {
            for (int col = 0; col < 4; col++) {
                if (col >= labels[row].length || labels[row][col].isEmpty()) continue;

                gbc.gridx = col;
                gbc.gridy = row;

                JButton button = new JButton(labels[row][col]);
                button.setFont(new Font("Dialog", Font.BOLD, 20));
                button.addActionListener(this);

                // Colors
                String text = button.getText();
                if (text.equals("C") || text.equals("DEL")) {
                    button.setBackground(green);
                    button.setForeground(Color.WHITE);
                } else if (text.matches("[0-9]|\\.")) {
                    button.setBackground(red);
                    button.setForeground(Color.WHITE);
                }

                // "0" spans two columns
                if (text.equals("0")) {
                    gbc.gridwidth = 2;
                    panel.add(button, gbc);
                    col++; // skip next cell
                    gbc.gridwidth = 1;
                } else {
                    panel.add(button, gbc);
                }
            }
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "C":
                display.setText("0");
                num1 = num2 = result = 0;
                operator = "";
                break;
            case "DEL":
                String text = display.getText();
                if (text.length() > 1)
                    display.setText(text.substring(0, text.length() - 1));
                else
                    display.setText("0");
                break;
            case "+/-":
                double val = Double.parseDouble(display.getText());
                display.setText(String.valueOf(-val));
                break;
            case "+":
            case "-":
            case "×":
            case "÷":
                num1 = Double.parseDouble(display.getText());
                operator = cmd;
                display.setText("0");
                break;
            case "=":
                num2 = Double.parseDouble(display.getText());
                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "×": result = num1 * num2; break;
                    case "÷": result = (num2 != 0) ? num1 / num2 : 0; break;
                }
                display.setText(String.valueOf(result));
                break;
            case ".":
                if (!display.getText().contains("."))
                    display.setText(display.getText() + ".");
                break;
            default: // number buttons
                if (display.getText().equals("0"))
                    display.setText(cmd);
                else
                    display.setText(display.getText() + cmd);
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyCalculator::new);
    }
}
