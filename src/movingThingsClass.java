import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class movingThingsClass {
    protected double x;
    protected double y;
    private ImageView imgFoe;
    private double offset=25;
    private long time;
    private int deltaT=50000000;

    public movingThingsClass(double x,double y,String fileName) {
        this.x = x;
        this.y = y;
        Image player = new Image(fileName);
        this.imgFoe = new ImageView(player);
        this.imgFoe.setViewport(new Rectangle2D(0, 0, 87, 62));
        this.imgFoe.setX(this.x);
        this.imgFoe.setY(this.y);
    }

    public ImageView update(long time){
        if (time - this.time >= deltaT) {
            if(this.getImgFoe().getX()>=0){
            this.time = time;
            this.getImgFoe().setX(this.getImgFoe().getX() - offset);
            }
            else {
                this.time=time;
                this.getImgFoe().setX(800);
            }
        }
        return imgFoe;
    }
    public ImageView getImgFoe(){
        return imgFoe;
    }
}
