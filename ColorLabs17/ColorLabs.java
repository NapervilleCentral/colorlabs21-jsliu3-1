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
        adjustBlue(p, 25);
        p.explore();
        negate(p2);
        p2.explore();
        adjustRed(p3, 10);
        p3.explore();
        grayscale(p4);
        p4.explore();
        //p5.changeColors(23,56,67);
        p5.explore();

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
}
