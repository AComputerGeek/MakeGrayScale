import edu.duke.*;
import java.io.*;

/**
* 
* @author: Amir Armion 
* 
* @version: V.01
* 
*/
public class HonorAssignment1 
{

    public ImageResource makeGray(ImageResource inImage) 
    {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());

        for(Pixel pixel: outImage.pixels()) 
        {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int   average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;

            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }

        return outImage;
    }
    
    public void batchGrayscale()
    {
        DirectoryResource dr = new DirectoryResource();

        for(File f: dr.selectedFiles())
        {
            ImageResource originalImage = new ImageResource(f);
            String        fileName      = originalImage.getFileName();
            String        newFileName   = "gray-" + fileName;
            ImageResource grayImage     = makeGray(originalImage);

            grayImage.setFileName(newFileName);
            grayImage.draw();
            grayImage.save();
        }
    }
}
