import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class LabActivity6SwingToDoList {
    public static void main(String[] args) {
        new TaskViewer();
    }
}

class TaskViewer extends JFrame {
    JTable table;
    DefaultTableModel model;

    public TaskViewer() {
        setTitle("To-Do List Viewer");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table setup
        String[] columns = {"Task Name", "Task Description", "Status"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Add Task button
        JButton addBtn = new JButton("Add Task");
        addBtn.addActionListener(e -> new TaskForm(this));
        add(addBtn, BorderLayout.NORTH);

        setVisible(true);
    }

    public void addTask(String name, String desc, String status) {
        model.addRow(new Object[]{name, desc, status});
    }
}

class TaskForm extends JFrame {
    private JTextField taskNameField;
    private JTextArea taskDescArea;
    private JComboBox<String> statusBox;
    private TaskViewer viewer;

    public TaskForm(TaskViewer viewer) {
        this.viewer = viewer;
        setTitle("Add New Task");
        setSize(400, 250);
        setLayout(new GridLayout(5, 2));

        // Task Name
        add(new JLabel("Task Name:"));
        taskNameField = new JTextField();
        add(taskNameField);

        // Task Description
        add(new JLabel("Task Description:"));
        taskDescArea = new JTextArea();
        add(taskDescArea);

        // Status
        add(new JLabel("Status:"));
        String[] statuses = {"Not Started", "Ongoing", "Completed"};
        statusBox = new JComboBox<>(statuses);
        add(statusBox);

        // Empty labels to align layout
        add(new JLabel());
        add(new JLabel());

        // Save Button
        JButton saveBtn = new JButton("Save Task");
        saveBtn.addActionListener(e -> {
            String name = taskNameField.getText().trim();
            String desc = taskDescArea.getText().trim();
            String status = (String) statusBox.getSelectedItem();

            if (name.isEmpty() || status.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in Task Name and Status.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } else {
                viewer.addTask(name, desc, status);
                dispose(); // Close form
            }
        });

        add(saveBtn);

        setVisible(true);
    }
}
