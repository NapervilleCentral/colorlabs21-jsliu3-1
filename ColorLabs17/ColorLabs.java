/**
 * Joshua Liu
 * 11-10-2025
 * Manipulation of Color Labs
 * decription here lol
 */
import java.awt.*; //color class is in awt library
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class ColorLabs
{
    public static void main(String[] args) {
        Picture p = new Picture("images\\caterpillar.jpg");
        Picture p2 = new Picture("images\\caterpillar.jpg");
        Picture p3 = new Picture("images\\caterpillar.jpg");
        Picture p4 = new Picture("images\\caterpillar.jpg");
        Picture p5 = new Picture("images\\caterpillar.jpg");
        Picture p6 = new Picture("images\\caterpillar.jpg");
        p.explore();
        adjustBlue(p,25);
        p.explore();
        negate(p2);
        p2.explore();
        adjustRed(p3,10);
        p3.explore();
        grayscale(p4);
        p4.explore();
        changeColors(p5,23,56,67);
        p5.explore();
        colorify(p6);
        p6.explore();
    }
    public static void adjustRed(Picture p, double factor) {
        Pixel[] pixels = p.getPixels();
        for (Pixel pixel : pixels) {
            int red = pixel.getRed();
            red = (int) (red * (factor/100));
            pixel.setRed(red);
        }
    }
    public static void adjustGreen(Picture p, double factor) {
        Pixel[] pixels = p.getPixels();
        for (Pixel pixel : pixels) {
            int green = pixel.getGreen();
            green = (int) (green * (factor/100));
            pixel.setGreen(green);
        }
    }
    public static void adjustBlue(Picture p, double factor) {
        Pixel[] pixels = p.getPixels();
        for (Pixel pixel : pixels) {
            int blue = pixel.getBlue();
            blue = (int) (blue * (factor/100));
            pixel.setBlue(blue);
        }
    }
    public static void negate(Picture p) {
        Pixel[] pixels = p.getPixels();
        for (Pixel pixel : pixels) {
            int red = pixel.getRed();
            int blue = pixel.getBlue();
            int green = pixel.getGreen();
            red = 255 - red;
            blue = 255 - blue;
            green = 255 - green;
            pixel.setRed(red);
            pixel.setBlue(blue);
            pixel.setGreen(green);
        }
    }
    public static void grayscale(Picture p) {
        Pixel[] pixels = p.getPixels();
        for (Pixel pixel : pixels) {
            int red = pixel.getRed();
            int blue = pixel.getBlue();
            int green = pixel.getGreen();
            
            int avg = (int) ((red + blue + green) / 3.0);
            Color color = new Color(avg, avg, avg);
            pixel.setColor(color);
        }
    }
    public static void darken(Picture p) {
        Pixel[] pixels = p.getPixels();
        for (Pixel pixel: pixels) {
            int red = pixel.getRed();
            int blue = pixel.getBlue();
            int green = pixel.getGreen();
            
            red /= 2.0;
            blue /= 2.0;
            green /= 2.0;
            
            Color color = new Color(red, green, blue);
            pixel.setColor(color);
        }
    }
    public static void changeColors(Picture p, double red, double blue, double green) {
        Pixel[] pixels = p.getPixels();
        for (Pixel pixel: pixels) {
            int red1 = pixel.getRed();
            int blue1 = pixel.getBlue();
            int green1 = pixel.getGreen();
            
            red1 += red;
            blue1 += blue;
            green1 += green;
            
            if (red1 > 255)
                red1 = 255;
            if (blue1 > 255)
                blue1 = 255;
            if (green1 > 255)
                green1 = 255;
                
            Color color = new Color(red1, green1, blue1);
            pixel.setColor(color);
        }
    }
    public static void colorify(Picture p) {
        //changes color of the leaf
        Pixel[] pixels = p.getPixels();
        for (Pixel pixel: pixels) {
            int red = pixel.getRed();
            int blue = pixel.getBlue();
            int green = pixel.getGreen();
            
            boolean redcheck = 0 <= red && red <= 10;
            boolean bluecheck = 0 <= blue && blue <= 10;
            boolean greencheck = 255 >= green && 245 <= green;
            if (redcheck && bluecheck && greencheck) {
                //sets color close to slate blue (106, 90, 205)
                red += 106;
                blue += 205;
                green -= 165;
                Color color = new Color(red, green, blue);
                pixel.setColor(color);
            }
        }
    }
}
