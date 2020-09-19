
package view.effects;

import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.util.Duration;

public class FadeEffectTransition
{
    public FadeEffectTransition(Parent parent)
    {
        FadeTransition fade = new FadeTransition(Duration.millis(500), parent);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }
}