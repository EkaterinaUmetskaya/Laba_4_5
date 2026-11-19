import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class NotesApp {
    private static final String NOTES_FILE = "notes.txt";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Заметки (Вариант 2)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(460, 340);
            frame.setLocationRelativeTo(null);

            JTextArea textArea = new JTextArea();
            textArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setMargin(new Insets(10, 10, 10, 10));

            JScrollPane scrollPane = new JScrollPane(textArea);

            JButton saveButton = new JButton("Сохранить в файл");
            JLabel statusLabel = new JLabel("Готово к работе");
            statusLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

            saveButton.addActionListener(e -> {
                try (FileWriter writer = new FileWriter(NOTES_FILE, false)) {
                    writer.write(textArea.getText());
                    statusLabel.setForeground(new Color(0, 130, 0));
                    statusLabel.setText("Сохранено в " + NOTES_FILE);
                } catch (IOException ex) {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Ошибка сохранения: " + ex.getMessage());
                }
            });

            JPanel bottomPanel = new JPanel(new BorderLayout(10, 0));
            bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            bottomPanel.add(saveButton, BorderLayout.WEST);
            bottomPanel.add(statusLabel, BorderLayout.CENTER);

            frame.setLayout(new BorderLayout());
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(bottomPanel, BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }
}
