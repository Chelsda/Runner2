
public class Hero extends AnimatedThing{

    public Hero(double x,double y,String fileName){
        super(x, y, fileName);
    }

    public double getX(){
        return super.x;
    }

    public double getY(){
        return super.y;
    }
}
