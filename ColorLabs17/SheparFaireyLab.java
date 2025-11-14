
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
         Pixel[] pixelsnew = pixels;
         int counter = 0;
         int previous = 0;
         for (Pixel pixel : pixels) {
             int avg = (int) pixel.getAverage();
             Color grayscale = new Color(avg,avg,avg);
             pixel.setColor(grayscale);
         }
         Arrays.sort(pixelsnew,(num1,num2) -> Integer.compare(sum(num1), sum(num2)));
         
         int length = pixels.length / 4;
         Pixel[] pixels1 = Arrays.copyOfRange(pixelsnew, 0, length);
         System.out.println(pixels1);
         Pixel[] pixels2 = Arrays.copyOfRange(pixelsnew, length, length * 2);
         Pixel[] pixels3 = Arrays.copyOfRange(pixelsnew, length * 2, length * 3);
         Pixel[] pixels4 = Arrays.copyOfRange(pixelsnew, length * 3, length * 4);
         ArrayList<Pixel> pixelslist = new ArrayList<>(Arrays.asList(pixelsnew));
         for (Pixel pixel : pixels1) {
             pixels[pixelslist.indexOf(pixel)].setColor(darkblue);
         }
         for (Pixel pixel : pixels2) {
             pixels[pixelslist.indexOf(pixel)].setColor(lightblue);
         }
         for (Pixel pixel : pixels3) {
             pixels[pixelslist.indexOf(pixel)].setColor(red);
         }
         for (Pixel pixel : pixels4) {
             pixels[pixelslist.indexOf(pixel)].setColor(white);
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
    public static int sum(Pixel p) { return p.getRed() + p.getGreen() + p.getBlue(); }
}//class
