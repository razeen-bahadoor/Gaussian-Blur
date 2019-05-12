import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

public class main {

    public static void main(String[] args) {
        BufferedImage source;
        String FilePath = args[0];
        int Radius = Integer.parseInt(args[1]);
        Double Strength = Double.parseDouble(args[2]);

        try {
            source = ImageIO.read(new File(FilePath));
            BufferedImage destination = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
            GaussianKernel bl = new GaussianKernel(Radius);
            bl.genKernel(Strength);
            Kernel k = new Kernel(Radius, Radius, bl.getKernel());
            BufferedImageOp im = new ConvolveOp(k);
            BufferedImage aux = im.filter(source, destination);
            ImageIO.write(aux, "jpg", new File("output.jpeg"));


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
