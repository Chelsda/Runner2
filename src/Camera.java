

public class Camera {
    private double x;
    private double y;
    private Hero hero;
    private long time;
    private int deltaT=50000000;

    public Camera(Hero hero){
        this.hero = hero;
        this.x=this.hero.getX();
        this.y=this.hero.getY();
    }

    public double getx() {

        return x;
    }
    public double gety() {

        return y;
    }

    public String toString(){
        String coord= getx()+","+gety();
        return coord;
    }


    public void update(long time){

    }

}
