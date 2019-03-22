package com.api;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URLEncoder;
import static com.api.main.*;

public class App {
    private JButton peliculasFamosasButton;
    private JPanel panel1;
    private JButton buscarPeliculaButton;

    public App(){
                peliculasFamosasButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                           String peli=JOptionPane.showInputDialog(null,getPeliculasPopulares());
                            JOptionPane optionPane = new NarrowOptionPane();
                            optionPane.setIcon( getFoto(peli));
                            optionPane.setMessage(getDescripcionPelicula(peli));

                            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                            JDialog dialog = optionPane.createDialog(null, getNombrePelicula(peli));
                            dialog.setVisible(true);

                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                buscarPeliculaButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String query = JOptionPane.showInputDialog("¿Qué pelicula quieres buscar?");
                        try {
                            String peli= JOptionPane.showInputDialog(null,buscarPeli(URLEncoder.encode(query,"UTF-8")));
                            JOptionPane optionPane = new NarrowOptionPane();
                            optionPane.setIcon( getFoto(peli));
                            optionPane.setMessage(getDescripcionPelicula(peli));

                            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                            JDialog dialog = optionPane.createDialog(null, getNombrePelicula(peli));
                            dialog.setVisible(true);
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
class NarrowOptionPane extends JOptionPane {

    NarrowOptionPane() {
    }

    public int getMaxCharactersPerLineCount() {
        return 100;
    }
}