
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
         Color white = new Color(255,255,255);
         
         /**
          * method 1 change
          * four equal color groups (balanced)
          */
         Pixel[] pixels = me.getPixels();
         Pixel[] pixelorder = pixels;
         int counter = 0;
         int previous = 0;
         boolean sort = true;
         for (Pixel pixel : pixels) {
             int avg = (int) pixel.getAverage();
             Color grayscale = new Color(avg,avg,avg);
             pixel.setColor(grayscale);
         }
         while (sort) {
             sort = false;
             for (Pixel pixel : pixels) {
                 int pixel1 = pixel.getRed();
                 if (counter == 0) {
                     previous = pixel1;
                 }
                 else {
                     if (pixel1 < previous) {
                         Pixel temp1 = pixels[counter - 1];
                         Pixel temp2 = pixels[counter];
                         pixelorder[counter] = temp1;
                         pixelorder[counter - 1] = temp2;
                         previous = pixel1;
                         sort = true;
                     }
                 }
                 counter++;
                }
         }
         
         int length = pixels.length / 4;
         pixels = pixelorder;
         final double tolerance = 0.0001;
         Pixel[] pixels1 = Arrays.copyOfRange(pixels, 0, length);
         Pixel[] pixels2 = Arrays.copyOfRange(pixels, length, length * 2);
         Pixel[] pixels3 = Arrays.copyOfRange(pixels, length * 2, length * 3);
         Pixel[] pixels4 = Arrays.copyOfRange(pixels, length * 3, length * 4);
         for (Pixel pixel : pixels1) {
             pixel.setColor(darkblue);
         }
         for (Pixel pixel : pixels2) {
             pixel.setColor(lightblue);
         }
         for (Pixel pixel : pixels3) {
             pixel.setColor(red);
         }
         for (Pixel pixel : pixels4) {
             pixel.setColor(white);
         }
         me.explore();
         
         
         /**
          * method 2 change
          * 
          */
         
         /**
          * custom color palette
          */

         
    }//main       
}//class
