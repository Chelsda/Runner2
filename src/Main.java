import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Runner");
        Group root = new Group();
        GameScene theGameScene = new GameScene(root,600,400);
        primaryStage.setScene(theGameScene);
        root.getChildren().add(theGameScene.getImgLeft().getImg());
        root.getChildren().add(theGameScene.getImgRight().getImg());
        root.getChildren().add(theGameScene.getHero().getImgHero());
        root.getChildren().add(theGameScene.getImgLife().getImgLife());
        root.getChildren().add(theGameScene.getFoe().getImgFoe());
        //root.getChildren().add(theGameScene.getImgLife(1).getImgLife());
        //root.getChildren().add(theGameScene.getImgLife(2).getImgLife());
        //root.getChildren().add(theGameScene.getImgLife(3).getImgLife());

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
	// write your code here
    }

}

