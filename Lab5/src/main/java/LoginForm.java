import javax.swing.*;
import java.awt.*;

public class LoginForm {
    private static final String VALID_LOGIN = "admin";
    private static final String VALID_PASSWORD = "1234";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Форма входа (Вариант 2)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(380, 220);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

            JLabel loginLabel = new JLabel("Логин:");
            JTextField loginField = new JTextField();

            JLabel passwordLabel = new JLabel("Пароль:");
            JPasswordField passwordField = new JPasswordField();

            JButton loginButton = new JButton("Войти");
            JButton clearButton = new JButton("Очистить");

            JLabel statusLabel = new JLabel("Введите данные для входа", SwingConstants.CENTER);

            loginButton.addActionListener(e -> {
                String enteredLogin = loginField.getText().trim();
                String enteredPassword = new String(passwordField.getPassword());

                if (enteredLogin.isEmpty() || enteredPassword.isEmpty()) {
                    statusLabel.setForeground(new Color(180, 100, 0));
                    statusLabel.setText("Заполните логин и пароль!");
                } else if (VALID_LOGIN.equals(enteredLogin) && VALID_PASSWORD.equals(enteredPassword)) {
                    statusLabel.setForeground(new Color(0, 130, 0));
                    statusLabel.setText("Вход выполнен успешно!");
                } else {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Неверный логин или пароль!");
                }
            });

            clearButton.addActionListener(e -> {
                loginField.setText("");
                passwordField.setText("");
                statusLabel.setForeground(Color.DARK_GRAY);
                statusLabel.setText("Поля очищены");
            });

            panel.add(loginLabel);
            panel.add(loginField);
            panel.add(passwordLabel);
            panel.add(passwordField);
            panel.add(loginButton);
            panel.add(clearButton);

            frame.setLayout(new BorderLayout());
            frame.add(panel, BorderLayout.CENTER);
            frame.add(statusLabel, BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }
}
