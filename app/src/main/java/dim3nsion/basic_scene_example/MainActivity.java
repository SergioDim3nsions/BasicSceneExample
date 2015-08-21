package dim3nsion.basic_scene_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private Scene scene1;
  private Scene scene2;

  private boolean transitionFlag;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initView();
  }

  private void initView() {
    ViewGroup sceneContainer = (ViewGroup) findViewById(R.id.sceneContainer);
    Button animateButton = (Button) findViewById(R.id.animateButton);

    animateButton.setOnClickListener(this);
    initScene(sceneContainer);
  }

  private void initScene(ViewGroup sceneContainer) {
    scene1 = Scene.getSceneForLayout(sceneContainer, R.layout.scene1, this);
    scene2 = Scene.getSceneForLayout(sceneContainer, R.layout.scene2, this);
  }

  @Override public void onClick(View view) {
    if(!transitionFlag){
      TransitionManager.go(scene2);
    } else {
      TransitionManager.go(scene1);
    }

    transitionFlag = !transitionFlag;
  }
}
