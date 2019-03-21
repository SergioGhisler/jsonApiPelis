package com.api;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.api.main.peliculasPopulares;

public class App {
    private JButton peliculasFamosasButton;
    private JPanel panel1;

            public App(){
                peliculasFamosasButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            JOptionPane.showMessageDialog(null,peliculasPopulares());
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                });
            }
        public  static void main(String[] args) throws Exception {
            JFrame frame = new JFrame("APP");
            frame.setContentPane(new App().panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);


        }
    }
