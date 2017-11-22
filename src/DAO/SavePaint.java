/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author admin
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SavePaint extends JPanel
{
    private static SavePaint instance;

    public static SavePaint getInstance() {
        if(instance==null)instance=new SavePaint();
        return instance;
    }
    
    public SavePaint()
    {
        JFrame frame = new JFrame("TheFrame");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);

        try
        {
            BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            frame.paint(graphics2D);
            ImageIO.write(image,"jpeg", new File("/home/deniz/Desktop/jmemPractice.jpeg"));
        }
        catch(Exception exception)
        {
            //code
        }
    }

    protected void paintComponent(Graphics g)
    {
        g.drawRect(50,50,50,50);
    }

    public static void main(String[] args)
    {
        new SavePaint();
    }
}