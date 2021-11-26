import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThings {
    private double x;
    private double y;
    private ImageView img;
    private int deltaT=50000000;
    private long time=0;
    private int dec;
    private int index=0;
    private int indexMax=40;
    private int v=20;      //permet de gérer la vitesse de défilage


    public StaticThings(double x,double y,String fileName){
        this.x=x;
        this.y=y;
        Image background= new Image(fileName);
        this.img= new ImageView(background);
        this.img.setViewport(new Rectangle2D(0,0,800,400));
        this.img.setX(this.x);
        this.img.setY(this.y);

    }

    public ImageView getImg(){
        return img;
    }

    public ImageView update(long time, int x){
        if (time-this.time>=deltaT) {
            if(index<indexMax) {
                this.time=time;
                this.index = this.index + 1;
            }
            else{
                this.time=time;
                this.index=0;
            }
            this.img.setViewport(new Rectangle2D(0,0,800,400));
            this.img.setX(x-v*index);
        }
        return img;
    }
}
