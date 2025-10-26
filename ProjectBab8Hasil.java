/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.praktikumpbo.projectbab8hasil;

/**
 *
 * @author Lenovo
 */
import java.awt.*;
import javax.swing.*;
public class ProjectBab8Hasil {

    public static void main(String[] args) {
        
        //Jframe
        JFrame frame = new JFrame("Judul Window");
        
            //modifikasi JFrame
        frame.setSize(700, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        //JLabel        
        JLabel label1 = new JLabel("Nama");
        JLabel label2 = new JLabel("Selamat Datang", SwingConstants.CENTER);
        ImageIcon icon = new ImageIcon("src\\img\\Capture.png");              
        JLabel label3 = new JLabel(icon);
        JLabel label4 = new JLabel("User", icon, SwingConstants.LEFT);
        
            //modifikasi JLabel
        label1.setText("Username: ");        
        label1.setFont(new Font("Arial", Font.BOLD,16));
        label1.setForeground(Color.BLUE);
        
        //JTextField
        JTextField textField1 = new JTextField(20);
        JTextField textField2 = new JTextField("Teks Default");
        JTextField textField3 = new JTextField("Hello", 15);
        
        String inputText = textField1.getText(); //mendapatkan string teks dari textfield
        
        textField1.setText("Teks Baru");
        
        //JButton
        JButton button1 = new JButton ("Klik Saya!"); //button teks
        JButton button2 = new JButton(icon); //button gambar
        JButton button3 = new JButton("Submit", icon); //button gambar dan teks
        
            //modifikasi button
        button1.setBackground(Color.BLUE);
        button1.setForeground(Color.WHITE);
        
        //Munculkan komponen ke JFrame
            //JLabel
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);

            //JTextField
        frame.add(textField1);
        frame.add(textField2);
        frame.add(textField3);
        
            //JButton
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        
        //memunculkan frame
        frame.setVisible(true);
        
        
    }
}
