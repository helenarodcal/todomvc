package todomvc;

import com.google.common.base.Splitter;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

public class ScreenplaySupport {


    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @ParameterType(".*")
    public List<String> taskList(String tasks) {
        return Splitter.on(",").trimResults().splitToList(tasks);
    }

    @ParameterType(".*")
    public String taskName(String taskName) {
        return taskName;
    }
}
