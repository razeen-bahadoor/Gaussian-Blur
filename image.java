import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class image {
private BufferedImage im;
private File file;
    public image(String path){
        try{
            file = new File(path);
            im = ImageIO.read(file);

        }
        catch(IOException e){
            System.out.println("Error:invalid image file");
        }
    }

    public BufferedImage getImage(){
        return this.im;
    }


    public void printImage(){
        //this function will print the converted greyscale image
    }

}
