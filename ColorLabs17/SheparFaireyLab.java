
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
         double previous = 0;
         for (Pixel pixel : pixels) {
             int red1 = pixel.getRed();
             int green1 = pixel.getGreen();
             int blue1 = pixel.getBlue();
             
             double avg = (red1 + green1 + blue1) / 3.0;
             if (counter == 0) {
                 previous = avg;
             }
             else {
                 if (avg < previous) {
                     Pixel temp1 = pixels[counter - 1];
                     Pixel temp2 = pixels[counter];
                     pixelorder[counter] = temp1;
                     pixelorder[counter - 1] = temp2;
                 }
             }
             counter++;
         }
         
         int length = pixels.length / 4;
         int index = 0;
         for (int i = 0; i < 4; i++) {
             for (int j = 0; j < length; j++) {
                 if (i == 0) {
                     index = Arrays.binarySearch(pixels, pixelorder[j + (length * i)]);
                     pixels[index].setColor(darkblue);
                 }
                 if (i == 1) {
                     index = Arrays.binarySearch(pixels, pixelorder[j + (length * i)]);
                     pixels[index].setColor(lightblue);
                 }
                 if (i == 2) {
                     index = Arrays.binarySearch(pixels, pixelorder[j + (length * i)]);
                     pixels[index].setColor(red);
                 }
                 if (i == 3) {
                     index = Arrays.binarySearch(pixels, pixelorder[j + (length * i)]);
                     pixels[index].setColor(white);
                 }
             }
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
