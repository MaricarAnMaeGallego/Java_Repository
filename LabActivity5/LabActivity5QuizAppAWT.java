import java.awt.*;
import java.awt.event.*;

public class LabActivity5QuizAppAWT {
    public static void main(String[] args) {
        new QuizApp();
    }
}

class QuizApp extends Frame implements ActionListener {
    Label questionLabel, instructionLabel;
    Checkbox choice1, choice2, choice3, choice4;
    Button nextButton;
    CheckboxGroup choicesGroup;

    String[] questions = {
        "What is the capital of France?",
        "Which language is used for Android development?",
        "What is the result of 2 + 2 * 2?"
    };

    String[][] options = {
        {"A. Paris", "B. Rome", "C. Berlin", "D. Madrid"},
        {"A. Swift", "B. Java", "C. Python", "D. Kotlin"},
        {"A. 6", "B. 8", "C. 4", "D. 10"}
    };

    char[] answers = {'A', 'B', 'A'};

    int current = 0;
    int score = 0;

    QuizApp() {
        setTitle("Quiz App");
        setSize(500, 300);
        setLayout(null);
        setResizable(false);

        questionLabel = new Label();
        questionLabel.setBounds(50, 50, 400, 30);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(questionLabel);

        choicesGroup = new CheckboxGroup();
        choice1 = new Checkbox("", choicesGroup, false);
        choice1.setBounds(50, 100, 150, 30);
        choice1.setForeground(Color.BLUE);

        choice2 = new Checkbox("", choicesGroup, false);
        choice2.setBounds(250, 100, 150, 30);
        choice2.setForeground(Color.BLUE);

        choice3 = new Checkbox("", choicesGroup, false);
        choice3.setBounds(50, 140, 150, 30);
        choice3.setForeground(Color.BLUE);

        choice4 = new Checkbox("", choicesGroup, false);
        choice4.setBounds(250, 140, 150, 30);
        choice4.setForeground(Color.BLUE);

        add(choice1);
        add(choice2);
        add(choice3);
        add(choice4);

        instructionLabel = new Label("Please select an answer.");
        instructionLabel.setBounds(150, 180, 200, 20);
        instructionLabel.setAlignment(Label.CENTER);
        add(instructionLabel);

        nextButton = new Button("Next");
        nextButton.setBounds(180, 210, 120, 30);
        nextButton.setBackground(Color.LIGHT_GRAY);
        nextButton.addActionListener(this);
        add(nextButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        displayQuestion();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (choicesGroup.getSelectedCheckbox() == null) {
            instructionLabel.setText("Please select an answer.");
            return;
        }

        String selected = choicesGroup.getSelectedCheckbox().getLabel();
        if (selected.charAt(0) == answers[current]) {
            score++;
        }

        current++;
        if (current < questions.length) {
            displayQuestion();
        } else {
            showResult();
        }
    }

    void displayQuestion() {
        questionLabel.setText(questions[current]);
        choice1.setLabel(options[current][0]);
        choice2.setLabel(options[current][1]);
        choice3.setLabel(options[current][2]);
        choice4.setLabel(options[current][3]);
        choicesGroup.setSelectedCheckbox(null);
        instructionLabel.setText("Please select an answer.");
    }

    void showResult() {
        questionLabel.setText("Quiz Completed! Your score: " + score + " out of " + questions.length);
        choice1.setEnabled(false);
        choice2.setEnabled(false);
        choice3.setEnabled(false);
        choice4.setEnabled(false);
        nextButton.setEnabled(false);
        instructionLabel.setText("");
    }
}
