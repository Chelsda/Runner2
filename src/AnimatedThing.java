import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    protected double x;
    protected double y;
    private ImageView imgHero;
    private double alt=250;
    private int hHero=100;
    private int lHero=85;
    private int deltaT=50000000;
    private long time=0;
    private int index=0;
    private int maxIndex=5;
    private int windSize;
    private int offset=160;
    private int speed=5;
    private boolean jump=false;
    private boolean maxJump=false;


    public AnimatedThing(double x,double y,String fileName){
        this.x=x;
        this.y=y;
        Image player= new Image(fileName);
        this.imgHero= new ImageView(player);
        this.imgHero.setViewport(new Rectangle2D(0,0,85,100));
        this.imgHero.setX(this.x);
        this.imgHero.setY(this.y);
    }

    public ImageView getImgHero(){
        return imgHero;
    }

    public ImageView update(long time) {
        if (time - this.time >= deltaT){
            if(jump==false) {
                if (index < maxIndex) {
                    this.time = time;
                    this.index = this.index + 1;
                } else {
                    this.time = time;
                    this.index = 0;
                }
                this.imgHero.setViewport(new Rectangle2D(index * lHero, 0, lHero, hHero));
            }
            if(jump==true){
                if ((getImgHero().getY()>50)&&(maxJump==false)){
                    this.imgHero.setViewport(new Rectangle2D(0, offset, lHero, hHero));
                    this.getImgHero().setY(this.getImgHero().getY() - speed);
                    if (getImgHero().getY()==100){
                        maxJump=true;
                    }
                }
                else if (getImgHero().getY()<250){
                    this.imgHero.setViewport(new Rectangle2D(lHero, offset, lHero, hHero));
                    this.getImgHero().setY(this.getImgHero().getY()+speed);
                    if (getImgHero().getY()>=250){
                        jump=false;
                        maxJump=false;
                    }
                }
            }
        }
        return imgHero;
    }

    public void jump(){
        jump=true;
    }

    public abstract double getX();
    public abstract double getY();
}
