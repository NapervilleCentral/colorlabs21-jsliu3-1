/**
 * Joshua Liu
 */
import java.awt.*; //color class is in awt library
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class collage
{
  static int offsetX, offsetY = 0;
  public static void main(String[] args) {
        Picture glung = new Picture("images/orb.png");
        Picture other = new Picture("images/he might not be tuff guys.png");
        Picture canvas = new Picture("images/canvas.jpg");
        copyToCanvas(glung, canvas);
        mirrorImage(glung);
        copyToCanvas(glung, canvas);
        glung = new Picture("images/orb.png");
        blender(glung, other);
        copyToCanvas(glung, canvas);
        glung = new Picture("images/orb.png");
        blackfryer(glung);
        copyToCanvas(glung, canvas);
        glung = new Picture("images/orb.png");
        flashbang(glung);
        copyToCanvas(glung, canvas);
        glung = new Picture("images/orb.png");
        recursiveleftcorner(glung);
        copyToCanvas(glung, canvas);
        glung = new Picture("images/orb.png");
        redspam(glung);
        copyToCanvas(glung, canvas);
        glung = new Picture("images/orb.png");
        deepfryer(glung);
        copyToCanvas(glung, canvas);
        glung = new Picture("images/orb.png");
        yellowspam(glung);
        copyToCanvas(glung, canvas);
        canvas.explore();
        
        canvas.write(FileChooser.getMediaPath("images/canvas.jpg"));
        canvas.write("images/finalcollage.jpg");
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
  public static void blender(Picture image1, Picture image2) {
      Pixel[] pixels1 = image1.getPixels();
      Pixel[] pixels2 = image2.getPixels();
      Picture blended = image1;
      Pixel[] pixelnew = blended.getPixels();
      for (int i = 0; i < pixels1.length; i++) {
          int newred = (pixels1[i].getRed() + pixels2[i].getRed()) / 2;
          int newgreen = (pixels1[i].getGreen() + pixels2[i].getGreen()) / 2;
          int newblue = (pixels1[i].getBlue() + pixels2[i].getBlue()) / 2;
          pixelnew[i].setColor(new Color(newred, newgreen, newblue));
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
      //base case
      if (subwidth < 25 || subheight < 25) {
          return;
      }
      //recursive case
      for (int i = subwidth; i >= 0; i--) {
          for (int j = 0; j < subheight; j++) {
              image.getPixel(i, j).setColor(new Color(255 - image.getPixel(i * 2, j * 2).getRed(), 255 - image.getPixel(i * 2, j * 2).getGreen(), 255 - image.getPixel(i * 2, j * 2).getBlue()));
          }
      }
      recursiveleftcorner(image, subwidth / 2, subheight / 2);
  }
  public static void blackfryer(Picture image) {
      grayscale(image);
      Color black = new Color(2, 2, 2);
      Color darkgray = new Color(96, 96, 96);
      Color gray = new Color(160, 160, 160);
      Color white = new Color(245,245,245);
      Pixel[] pixels = image.getPixels();
      for (Pixel pixel : pixels) {
          int color = pixel.getRed();
          if (color < 60) {
              pixel.setColor(black);
          }
          else if (color < 128) {
              pixel.setColor(darkgray);
          }
          else if (color < 192) {
              pixel.setColor(gray);
          }
          else {
              pixel.setColor(white);
          }
      }
  }
  public static void deepfryer(Picture image) {
      int border = 256/2;
      Pixel[] pixels = image.getPixels();
      for (Pixel pixel: pixels) {
          if (pixel.getAverage() > border) {
              int newred = pixel.getRed() + 85;
              if (newred > 255)
                  newred = 255;
              int newgreen = pixel.getGreen() + 85;
              if (newgreen > 255)
                  newgreen = 255;
              int newblue = pixel.getBlue() + 85;
              if (newblue > 255)
                  newblue = 255;
              pixel.setColor(new Color(newred, newgreen, newblue));
          }
          else {
              int newred = pixel.getRed() - 40;
              if (newred < 0)
                  newred = 0;
              int newgreen = pixel.getGreen() - 40;
              if (newgreen < 0)
                  newgreen = 0;
              int newblue = pixel.getBlue() - 40;
              if (newblue < 0)
                  newblue = 0;
              pixel.setColor(new Color(newred, newgreen, newblue));
          }
      }
  }
  public static void redspam(Picture image) {
      Pixel[] pixels = image.getPixels();
      for (Pixel pixel: pixels) {
          int newred = pixel.getRed();
          int newgreen = pixel.getGreen();
          int newblue = pixel.getBlue();
          
          newred = pixel.getRed() + 115;
          if (newred > 255)
              newred = 255;
          pixel.setColor(new Color(newred, newgreen, newblue));
      }
  }
  public static void flashbang(Picture image) {
      Pixel[] pixels = image.getPixels();
      for (Pixel pixel: pixels) {
          int red = pixel.getRed() + 155;
          int green = pixel.getGreen() + 155;
          int blue = pixel.getBlue() + 155;
          if (red > 255) {
              red = 255;
          }
          if (green > 255) {
              green = 255;
          }
          if (blue > 255) {
              blue = 255;
          }
          pixel.setColor(new Color(red, green, blue));
      }
  }
  public static void yellowspam(Picture image) {
      Pixel[] pixels = image.getPixels();
      for (Pixel pixel: pixels) {
          int red = pixel.getRed() + 67;
          int green = pixel.getGreen() + 67;
          int blue = pixel.getBlue();
          if (red > 255) {
              red = 255;
          }
          if (green > 255) {
              green = 255;
          }
          if (blue > 255) {
              blue = 255;
          }
          pixel.setColor(new Color(red, green, blue));
      }
  }
}