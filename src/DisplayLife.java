import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DisplayLife {
    private double x;
    private double y;
    private ImageView img;
    private double sizeHeart=34;

    public DisplayLife(double x,double y,String fileName) {
        this.x = x;
        this.y = y;
        Image life = new Image(fileName);
        this.img = new ImageView(life);
        this.img.setViewport(new Rectangle2D(0, 0, 102, 30));
        this.img.setX(this.x);
        this.img.setY(this.y);
    }


    public ImageView getImgLife(){
        return img;
    }
}
