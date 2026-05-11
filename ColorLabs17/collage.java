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
        copyToCanvas(glung, canvas);
        glung = new Picture("images/he might not be tuff guys.png");
        inverse(glung);
        copyToCanvas(glung, canvas);
        glung = new Picture("images/he might not be tuff guys.png");
        deepfryer(glung);
        copyToCanvas(glung, canvas);
        glung = new Picture("images/he might not be tuff guys.png");
        deeperfryer(glung);
        copyToCanvas(glung, canvas);
        glung = new Picture("images/he might not be tuff guys.png");
        recursiveleftcorner(glung);
        copyToCanvas(glung, canvas);
        glung = new Picture("images/he might not be tuff guys.png");
        brightnessSpam(glung);
        copyToCanvas(glung, canvas);
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
      if (offsetX + source.getWidth() > target.getWidth()) {
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
      double colorrange = 255/5.0;
      for (Pixel pixel : pixels) {
          int color = pixel.getRed();
          if (color < 25) {
              pixel.setColor(darkblue);
          }
          else if (color < 55) {
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
  public static void inverse(Picture image) {
      Pixel[] pixels = image.getPixels();
      for (Pixel pixel: pixels) {
          pixel.setColor(new Color(255 - pixel.getRed(), 255 - pixel.getGreen(), 255 - pixel.getBlue()));
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
  public static void recursiveleftcorner(Picture image) {
      recursiveleftcorner(image, image.getWidth() / 2, image.getHeight() / 2);
  }
  public static void recursiveleftcorner(Picture image, int subwidth, int subheight) {
      Pixel[] pixels = image.getPixels();
      if (subwidth < 25 || subheight < 25) {
          return;
      }
      for (int i = subwidth; i >= 0; i--) {
          for (int j = 0; j < subheight; j++) {
              image.getPixel(i, j).setColor(image.getPixel(i * 2, j * 2).getColor());
          }
      }
      recursiveleftcorner(image, subwidth / 2, subheight / 2);
  }
  public static void deepfryer(Picture image) {
      int border = 256/2;
      Pixel[] pixels = image.getPixels();
      for (Pixel pixel: pixels) {
          if (pixel.getAverage() > border) {
              int newred = pixel.getRed() * 2;
              if (newred > 255)
                  newred = 255;
              int newgreen = pixel.getRed() * 2;
              if (newgreen > 255)
                  newgreen = 255;
              int newblue = pixel.getRed() * 2;
              if (newblue > 255)
                  newblue = 255;
              pixel.setColor(new Color(newred, newgreen, newblue));
          }
          else {
              int newred = pixel.getRed() - 50;
              if (newred < 0)
                  newred = 0;
              int newgreen = pixel.getRed() - 50;
              if (newgreen < 0)
                  newgreen = 0;
              int newblue = pixel.getRed() - 50;
              if (newblue < 0)
                  newblue = 0;
              pixel.setColor(new Color(newred, newgreen, newblue));
          }
      }
  }
  public static void deeperfryer(Picture image) {
      int border = 256/2;
      Pixel[] pixels = image.getPixels();
      for (Pixel pixel: pixels) {
          if (pixel.getAverage() > border) {
              int newred = pixel.getRed() + 75;
              if (newred > 255)
                  newred = 255;
              int newgreen = pixel.getGreen() + 75;
              if (newgreen > 255)
                  newgreen = 255;
              int newblue = pixel.getBlue() + 75;
              if (newblue > 255)
                  newblue = 255;
              pixel.setColor(new Color(newred, newgreen, newblue));
          }
          else {
              int newred = pixel.getRed() - 30;
              if (newred < 0)
                  newred = 0;
              int newgreen = pixel.getGreen() - 30;
              if (newgreen < 0)
                  newgreen = 0;
              int newblue = pixel.getBlue() - 30;
              if (newblue < 0)
                  newblue = 0;
              pixel.setColor(new Color(newred, newgreen, newblue));
          }
      }
  }
  public static void brightnessSpam(Picture image) {
      int border = 256/2;
      Pixel[] pixels = image.getPixels();
      for (Pixel pixel: pixels) {
          if (pixel.getAverage() > border) {
              int newred = pixel.getRed() + 110;
              if (newred > 255)
                  newred = 255;
              int newgreen = pixel.getGreen() + 110;
              if (newgreen > 255)
                  newgreen = 255;
              int newblue = pixel.getBlue() + 110;
              if (newblue > 255)
                  newblue = 255;
              pixel.setColor(new Color(newred, newgreen, newblue));
          }
          else {
              int newred = pixel.getRed() + 50;
              if (newred > 255)
                  newred = 255;
              int newgreen = pixel.getGreen() + 50;
              if (newgreen > 255)
                  newgreen = 255;
              int newblue = pixel.getBlue() + 50;
              if (newblue > 255)
                  newblue = 255;
              pixel.setColor(new Color(newred, newgreen, newblue));
          }
      }
  }
}
