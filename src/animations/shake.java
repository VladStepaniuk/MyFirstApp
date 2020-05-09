package animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class shake {
    private TranslateTransition tt;

    public shake(Node node){
        tt=new TranslateTransition(Duration.millis(70), node);
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setCycleCount(5);
        tt.setAutoReverse(true);
    }
    public void playAnim(){
        tt.playFromStart();
    }
}
