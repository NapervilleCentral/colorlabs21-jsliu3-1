
/**
 * Write a description of class SheparFaireyLab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class SheparFaireyLab
{
    /**
     * main method, to test the picture
     */
    public static void main(String[] args)
    {
         //relative path
         Picture apic = new Picture("images\\ogimage.jpg");
         //change with selfie picture
         Picture me = new Picture("images/ogimage.jpg");
         Picture me1 = new Picture("images/ogimage.jpg");
         Picture me2 = new Picture("images/ogimage.jpg");
         
         Color darkblue = new Color(95,158,160);
         Color lightblue = new Color(173,216,230);
         Color red = new Color(255,0,0);
         Color white = new Color(245,245,245);
         
         /**
          * method 1 change
          * four equal color groups (balanced)
          */
         /*
         Pixel[] pixels = me.getPixels();
         int counter = 0;
         int previous = 0;
         for (Pixel pixel : pixels) {
             int avg = (int) pixel.getAverage();
             Color grayscale = new Color(avg,avg,avg);
             pixel.setColor(grayscale);
         }
         double colorrange = 255/4.0;
         for (Pixel pixel : pixels) {
             int color = pixel.getRed();
             if (color < colorrange) {
                 pixel.setColor(darkblue);
             }
             else if (color < colorrange * 2) {
                 pixel.setColor(lightblue);
             }
             else if (color < colorrange * 3) {
                 pixel.setColor(red);
             }
             else {
                 pixel.setColor(white);
             }
         }
         me.explore();
         me.write("images/SFMethod1.jpg");
         
         */
         /**
          * method 2 change
          * range based on minimum and maximum
          */
         
         int max = -1, min = 256;
         Pixel[] pixels2 = me1.getPixels();
         for (Pixel pixel : pixels2) {
             int avg = (int) pixel.getAverage();
             Color grayscale = new Color(avg,avg,avg);
             pixel.setColor(grayscale);
             
             if (pixel.getRed() > max) {
                 max = pixel.getRed();
             }
             if (pixel.getRed() < min) {
                 min = pixel.getRed();
             }
         }
         double range = (max - min) / 4.0;
         for (Pixel pixel : pixels2) {
             int color = pixel.getRed();
             if (color < range) {
                 pixel.setColor(darkblue);
             }
             else if (color < range * 2) {
                 pixel.setColor(lightblue);
             }
             else if (color < range * 3) {
                 pixel.setColor(red);
             }
             else {
                 pixel.setColor(white);
             }
         }
         /*
         me1.explore();
         me1.write("images/SFMethod2.jpg");
         */
         /**
          * custom color palette (yellow/blue)
          */
         Color lightyellow = new Color(255,255,0);
         Color darkyellow = new Color(218,165,32);
         max = -1;
         min = 256;
         Pixel[] pixels3 = me2.getPixels();
         for (Pixel pixel : pixels3) {
             int avg = (int) pixel.getAverage();
             Color grayscale = new Color(avg,avg,avg);
             pixel.setColor(grayscale);
             
             if (pixel.getRed() > max) {
                 max = pixel.getRed();
             }
             if (pixel.getRed() < min) {
                 min = pixel.getRed();
             }
         }
         range = (max - min) / 4.0;
         for (Pixel pixel : pixels3) {
             int color = pixel.getRed();
             if (color < range) {
                 pixel.setColor(darkblue);
             }
             else if (color < range * 2) {
                 pixel.setColor(lightblue);
             }
             else if (color < range * 3) {
                 pixel.setColor(darkyellow);
             }
             else {
                 pixel.setColor(lightyellow);
             }
         }
         me2.explore();
         me2.write("images/SFTry1.jpg");
    }//main      
    public static int sum(Pixel p) { return p.getRed() + p.getGreen() + p.getBlue(); }
}//class
