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
    private Hero hero;
    private AnimationTimer timer;
    private Stone stone;
    private double deltaAlt=40;
    private int nbLifeLeft=3;
    private int sizeHeart= 34;

    public GameScene(Parent p, double x, double y){
        super (p,x,y);
        this.left = new StaticThings(0,0,"desert.png");
        this.right = new StaticThings(800,0,"desert.png");
        this.life = new DisplayLife(0,0,"vie.png");
        this.hero = new Hero(100, 250, "heros.png");
        this.camera = new Camera(this.hero);
        this.stone = new Stone(800,290,"pierre.png");

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

}
