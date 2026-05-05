/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*; //color class is in awt library
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17_2
{

    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      //opens picture using a dialog box (if needed)
      /*
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
     */

     //opens a pictue using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     
     //relative path (directory/folder/file) (file must be in same folder as code)
     //Picture apic = new Picture("images\\beach.jpg");
     //Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg"); //copies pixels into a picture object
     //Picture moto = new Picture("images/blueMotorcycle.jpg");
     //Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");
    Picture temple = new Picture("images/temple.jpg");
    Picture glung = new Picture("images/he might not be tuff guys.png");
     //apic.explore(); (displays and refreshes the picture (needed))
     //moto.explore();
     mirrorTemple(temple);
     temple.explore();
     //to change color of picture, get all of the pixels
     //makes an array of pixels
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     pixels = glung.getPixels();
    
     //how many pixels or how large array


    /**/
        //access each index using array notation
    //access each pixel using method .getPixel()
    
   // loop to access indexes of array or collection
    
    /*
    int value;
    final double  FACTOR = .5;
        for (Pixel pixelObj : pixels)
        {

        //get the redvalue
        value = pixelObj.getRed();
        //System.out.println(value);

        //decrease the red value by 50%
        
        //set the red value of the current pixel to the new value
        

    }
    // use new picture when changing or it will make changes to 
    // pic you already changed
    ferris1.explore();
    ferris2.explore();

      /**/ 
    //write/save a picture as a file

    /**/
  }//main
  public static void mirrorTemple(Picture temple) {
      int width = temple.getWidth();
      int mirrorpt = width/2;
      Pixel left = null;
      Pixel right = null;
      for (int y = 0; y < 145; y++) {
          for (int x = 0; x < mirrorpt; x++) {
              left = temple.getPixel(x,y);
              right = temple.getPixel(width - 1 - x, y);
              right.setColor(left.getColor());
          }
      }
  }
}//class
