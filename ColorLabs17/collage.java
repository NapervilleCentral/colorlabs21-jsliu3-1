/**
 * Write a description of class collage here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*; //color class is in awt library
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class collage
{
  static int offsetX, offsetY = 0;
  public static void main(String[] args) {
        Picture glung = new Picture("images/he might not be tuff guys.png");
        Picture canvas = new Picture("images/canvas.jpg");
        copyToCanvas(glung, canvas);
        mirrorImage(glung);
        //copyToCanvas(glung, canvas);
        glung = new Picture("images/he might not be tuff guys.png");
        posterize(glung);
        copyToCanvas(glung, canvas);
        glung = new Picture("images/he might not be tuff guys.png");
        canvas.explore();
  }
  public static void copyToCanvas(Picture source, Picture target) {
      Pixel sourcePix = null;
      Pixel targetPix = null;
      for (int sourceX = 0, targetX = 0; sourceX < source.getWidth(); sourceX++, targetX++) {
          for (int sourceY = 0, targetY = 0; sourceY < source.getHeight(); sourceY++, targetY++) {
              sourcePix = source.getPixel(sourceX, sourceY);
              targetPix = target.getPixel(targetX + offsetX, targetY + offsetY);
              targetPix.setColor(sourcePix.getColor());
          }
      }
      offsetX += source.getWidth();
      if (offsetX > target.getWidth()) {
          offsetX = 0;
          offsetY += source.getHeight();
      }
  }
    public static void mirrorImage(Picture image) {
      int width = image.getWidth();
      int mirrorpt = width/2;
      Pixel left = null;
      Pixel right = null;
      for (int y = 0; y < image.getHeight(); y++) {
          for (int x = 0; x < mirrorpt; x++) {
              left = image.getPixel(x,y);
              right = image.getPixel(width - 1 - x, y);
              left.setColor(right.getColor());
          }
      }
  }
  public static void posterize(Picture image) {
      grayscale(image);
      Color darkblue = new Color(95,158,160);
      Color lightblue = new Color(173,216,230);
      Color red = new Color(255,0,0);
      Color white = new Color(245,245,245);
      Pixel[] pixels = image.getPixels();
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
  }
  public static void grayscale(Picture image) {
      Pixel[] pixels = image.getPixels();
      for (Pixel pixel : pixels) {
             int avg = (int) pixel.getAverage();
             Color grayscale = new Color(avg,avg,avg);
             pixel.setColor(grayscale);
         }
  }
}
