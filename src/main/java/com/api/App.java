package com.api;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
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
                            URL url2 = new URL("https://www.themoviedb.org/assets/2/v4/logos/208x226-stacked-green-9484383bd9853615c113f020def5cbe27f6d08a84ff834f41371f223ebad4a3c.png");
                            Image image = ImageIO.read(url2);
                            ImageIcon icon = new ImageIcon(image);

                             String pelis[] = getPeliculasPopulares();
                            String peli= (String) JOptionPane.showInputDialog(null,"¿Qué pelicula te interesa?","Peliculas populares",JOptionPane.PLAIN_MESSAGE,icon,pelis,pelis[0]);
//                           JOptionPane titulo = new NarrowOptionPane();
//                           titulo.setIcon(icon);
//                           JOptionPane dialog = titulo.(null, getPeliculasPopulares());
//                           String peli=JOptionPane.showInputDialog(null,getPeliculasPopulares());



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
                            URL url2 = new URL("https://www.themoviedb.org/assets/2/v4/logos/208x226-stacked-green-9484383bd9853615c113f020def5cbe27f6d08a84ff834f41371f223ebad4a3c.png");
                            Image image = ImageIO.read(url2);
                            ImageIcon icon = new ImageIcon(image);
                            String pelis[] =buscarPeli(URLEncoder.encode(query,"UTF-8"));
                            String peli= (String) JOptionPane.showInputDialog(null,"¿Qué pelicula te interesa?",query,JOptionPane.PLAIN_MESSAGE,icon,pelis,pelis[0]);
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