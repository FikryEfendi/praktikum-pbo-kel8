/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.praktikumpbo.projectbab9hasil;


/**
 *
 * @author Lenovo
 */

public class ProjectBab9Latihan {

    public static void main(String[] args) {
        MainJFrame frame = new MainJFrame();
        frame.changeMainPanel(new TambahDataPanel(frame, -1));
        frame.setVisible(true);
        
    }
}
