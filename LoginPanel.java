import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.text.JTextComponent;

public class LoginPanel extends JPanel {
    private MainAppFrame parentFrame;
    private static final String USN_PH = "Username Admin";
    private static final String PASS_PH = "Password";

    public LoginPanel(MainAppFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new GridLayout(1, 2));
        setBackground(UITheme.SURFACE);

        // Panel Kiri (Branding)
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(new BorderLayout(UITheme.PADDING_LARGE, UITheme.PADDING_LARGE));
        leftPanel.setBorder(new EmptyBorder(UITheme.PADDING_EXTRA_LARGE, UITheme.PADDING_LARGE, 
                                           UITheme.PADDING_EXTRA_LARGE, UITheme.PADDING_LARGE));

        JLabel titleLabel = new JLabel("Sistem Perpustakaan");
        titleLabel.setFont(UITheme.FONT_TITLE);
        titleLabel.setForeground(UITheme.TEXT_PRIMARY);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitleLabel = new JLabel("Admin Portal");
        subtitleLabel.setFont(UITheme.FONT_HEADING_2);
        subtitleLabel.setForeground(UITheme.TEXT_SECONDARY);
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel topPanel = new JPanel(new GridLayout(2, 1, UITheme.SPACING_SMALL, UITheme.SPACING_SMALL));
        topPanel.setOpaque(false);
        topPanel.add(titleLabel);
        topPanel.add(subtitleLabel);
        leftPanel.add(topPanel, BorderLayout.NORTH);

        try {
            ImageIcon originalIcon = new ImageIcon(getClass().getResource("/assets/login_illustration.jpg"));
            Image scaledImage = originalIcon.getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            leftPanel.add(imageLabel, BorderLayout.CENTER);
        } catch (Exception e) {
            JLabel placeholder = new JLabel("📚 Admin Access");
            placeholder.setFont(UITheme.FONT_HEADING_1);
            placeholder.setForeground(UITheme.TEXT_PRIMARY);
            placeholder.setHorizontalAlignment(SwingConstants.CENTER);
            leftPanel.add(placeholder, BorderLayout.CENTER);
        }

        JTextArea infoArea = new JTextArea("Kelola peminjaman dan pengembalian buku perpustakaan.");
        infoArea.setFont(UITheme.FONT_BODY);
        infoArea.setForeground(UITheme.TEXT_SECONDARY);
        infoArea.setBackground(new Color(0, 0, 0, 0));
        infoArea.setEditable(false);
        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);
        infoArea.setBorder(new EmptyBorder(0, UITheme.PADDING_LARGE, 0, UITheme.PADDING_LARGE));
        leftPanel.add(infoArea, BorderLayout.SOUTH);

        // Panel Kanan (Form Login)
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(176, 196, 222));
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.setBorder(new EmptyBorder(UITheme.PADDING_EXTRA_LARGE, UITheme.PADDING_EXTRA_LARGE, 
                                            UITheme.PADDING_EXTRA_LARGE, UITheme.PADDING_EXTRA_LARGE));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(UITheme.SPACING_LARGE, 0, UITheme.SPACING_LARGE, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel formTitle = new JLabel("Login Admin");
        formTitle.setFont(UITheme.FONT_HEADING_1);
        formTitle.setForeground(UITheme.TEXT_PRIMARY);
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, UITheme.PADDING_LARGE, 0);
        rightPanel.add(formTitle, gbc);

        JLabel idLabel = new JLabel("Username");
        idLabel.setFont(UITheme.FONT_SMALL_BOLD);
        idLabel.setForeground(UITheme.TEXT_PRIMARY);
        gbc.gridy = 1;
        gbc.insets = new Insets(UITheme.SPACING_MEDIUM, 0, UITheme.SPACING_SMALL, 0);
        rightPanel.add(idLabel, gbc);

        JTextField idField = new JTextField(15);
        idField.setText(USN_PH);
        idField.setForeground(UITheme.TEXT_HINT);
        idField.setFont(UITheme.FONT_BODY);
        idField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(UITheme.BORDER, 1),
            BorderFactory.createEmptyBorder(UITheme.PADDING_MEDIUM, UITheme.PADDING_MEDIUM, 
                                           UITheme.PADDING_MEDIUM, UITheme.PADDING_MEDIUM)
        ));
        idField.addFocusListener(new PlaceholderFocusListener(idField, USN_PH, false));
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, UITheme.SPACING_LARGE, 0);
        rightPanel.add(idField, gbc);

        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(UITheme.FONT_SMALL_BOLD);
        passLabel.setForeground(UITheme.TEXT_PRIMARY);
        gbc.gridy = 3;
        gbc.insets = new Insets(UITheme.SPACING_MEDIUM, 0, UITheme.SPACING_SMALL, 0);
        rightPanel.add(passLabel, gbc);

        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setText(PASS_PH);
        passwordField.setForeground(UITheme.TEXT_HINT);
        passwordField.setFont(UITheme.FONT_BODY);
        passwordField.setEchoChar((char) 0);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(UITheme.BORDER, 1),
            BorderFactory.createEmptyBorder(UITheme.PADDING_MEDIUM, UITheme.PADDING_MEDIUM, 
                                           UITheme.PADDING_MEDIUM, UITheme.PADDING_MEDIUM)
        ));
        passwordField.addFocusListener(new PlaceholderFocusListener(passwordField, PASS_PH, true));
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, UITheme.SPACING_LARGE, 0);
        rightPanel.add(passwordField, gbc);

        ModernButton loginButton = new ModernButton("Masuk");
        loginButton.setPreferredSize(new Dimension(0, 45));
        loginButton.setFont(UITheme.FONT_HEADING_3);
        loginButton.setButtonType(ModernButton.ButtonType.PRIMARY);
        gbc.gridy = 5;
        gbc.insets = new Insets(UITheme.SPACING_LARGE, 0, 0, 0);
        rightPanel.add(loginButton, gbc);

        // Action Listener Login
        loginButton.addActionListener(e -> {
            String username = idField.getText().equals(USN_PH) ? "" : idField.getText();
            String password = new String(passwordField.getPassword());
            if (password.equals(PASS_PH)) {
                password = "";
            }
            this.parentFrame.attemptLogin(username, password);
            
            // Reset fields
            idField.setText(USN_PH); 
            idField.setForeground(UITheme.TEXT_HINT);
            passwordField.setText(PASS_PH); 
            passwordField.setForeground(UITheme.TEXT_HINT);
            passwordField.setEchoChar((char) 0);
        });

        add(leftPanel);
        add(rightPanel);
    }

    private class PlaceholderFocusListener extends FocusAdapter {
        private JTextComponent component;
        private String placeholder;
        private boolean isPassword;

        public PlaceholderFocusListener(JTextComponent comp, String ph, boolean isPass) {
            this.component = comp;
            this.placeholder = ph;
            this.isPassword = isPass;
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (component.getText().equals(placeholder)) {
                component.setText("");
                component.setForeground(UITheme.TEXT_PRIMARY);
                if (isPassword) {
                    ((JPasswordField) component).setEchoChar('*');
                }
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (isPassword) {
                if (((JPasswordField) component).getPassword().length == 0) {
                    component.setText(placeholder);
                    component.setForeground(UITheme.TEXT_HINT);
                    ((JPasswordField) component).setEchoChar((char) 0);
                }
            } else {
                if (component.getText().isEmpty()) {
                    component.setText(placeholder);
                    component.setForeground(UITheme.TEXT_HINT);
                }
            }
        }
    }
}
