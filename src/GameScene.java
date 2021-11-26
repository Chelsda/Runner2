import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameScene extends Scene {

    private Camera camera;
    private StaticThings left;
    private StaticThings right;
    private DisplayLife life;
    //private DisplayLife lifeUn;
    //private DisplayLife lifeDeux;
    //private DisplayLife lifeTrois;
    private Hero hero;
    private AnimationTimer timer;
    private Stone stone;
    private double deltaAlt=40;
    //private ArrayList<DisplayLife> lifeLeft;
    private int nbLifeLeft=3;
    private int sizeHeart= 34;

    public GameScene(Parent p, double x, double y){
        super (p,x,y);
        this.left = new StaticThings(0,0,"desert.png");
        this.right = new StaticThings(800,0,"desert.png");
        this.life = new DisplayLife(0,0,"vie.png");
        //this.lifeUn = new DisplayLife(0,0,"vie.png");
        //this.lifeDeux = new DisplayLife(sizeHeart,0,"vie.png");
        //this.lifeTrois = new DisplayLife(2*sizeHeart,0,"vie.png");
        //this.lifeLeft=new ArrayList<DisplayLife>();
        //lifeLeft.add(lifeUn);
        //lifeLeft.add(lifeDeux);
        //lifeLeft.add(lifeTrois);
        this.hero = new Hero(100, 250, "heros.png");
        this.camera = new Camera(this.hero);
        //this.foes= new ArrayList<Foe>();
        this.stone = new Stone(800,290,"pierre.png");
        //foes.add(250,stone);
        //posFoe=foes.indexOf(stone);

        this.timer = new AnimationTimer() {
            @Override
            public void handle(long time) {
                hero.update(time);
                camera.update(time);
                left.update(time,0);
                right.update(time,800);
                stone.update(time);
                            }
        };
        this.timer.start();

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode()== KeyCode.SPACE){
                    System.out.println("Jump");
                    hero.jump();
                }
            }
        });


    }

    public StaticThings getImgLeft(){
        return left;
    }
    public StaticThings getImgRight(){
        return right;
    }
    public DisplayLife getImgLife(){
        return life;
    }
    public Hero getHero(){
        return hero;
    }
    public Stone getFoe(){
        return stone;
    }
    /*public ArrayList<DisplayLife> getLifeLeft(){
        return lifeLeft;
    }*/

}
