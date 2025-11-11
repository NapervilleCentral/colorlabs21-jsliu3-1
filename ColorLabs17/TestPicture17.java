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
public class TestPicture17
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
     Picture apic = new Picture("images\\beach.jpg");
     Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg"); //copies pixels into a picture object
     Picture moto = new Picture("images/blueMotorcycle.jpg");
     Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");

     //apic.explore(); (displays and refreshes the picture (needed))
     //moto.explore();
     
     //to change color of picture, get all of the pixels
     //makes an array of pixels
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     pixels = ferris1.getPixels();
    
     //how many pixels or how large array
    System.out.println("This is a large array "+pixels.length  );


    /**/
        //access each index using array notation
    System.out.println(pixels[17]);
    //access each pixel using method .getPixel()
    Pixel spot = ferris1.getPixel(100,100);
    Pixel spot50 = ferris1.getPixel(50,50);
    Color lbsteel = new Color(176,196,222);;
    
    Pixel spot17 = pixels[17];
    spot17.setRed(200);
    spot17.setGreen(175);
    spot17.setBlue(150);
    ferris1.explore();
    
    spot.setColor(Color.yellow);
    spot50.setColor(lbsteel);
    //gets the color of the pixel
    System.out.println(pixels[17].getColor());
    System.out.println(spot);
    /*
    pixels[17].setColor(Color.blue);
    spot.setColor(new Color(252,252,252));
    pixels[500034].setColor(Color.blue);
    */
    
   // loop to access indexes of array or collection

    //for each loop spot  is a ?
    int red, blue, green, count = 0;
    for (Pixel spot1 : pixels) {
        /*
        red = spot1.getRed();
        red = (int) (red * 0.25);
        spot1.setRed(red);
        
        double amount = Math.random();
        blue = spot1.getBlue();
        blue = (int) (blue * amount);
        spot1.setBlue(blue);
        
        amount = Math.random();
        green = spot1.getGreen();
        green = (int) (green * amount);
        spot1.setGreen(green);
        */
       
        if (count % 20 == 0) {
            spot1.setColor(Color.yellow);
        }
        /**/
         /**
          * Method to reduce red from picture by a factor of n
          * @param none
          * @return none
          */
        count++;
    }
    ferris1.explore();
    ferris1.write("images/SFtry1.jpg");
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
    ferris1.write("images/ferris11.jpg");

    /**/
  }//main
}//class
