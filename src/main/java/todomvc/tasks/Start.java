package todomvc.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import todomvc.ui.ApplicationHomePage;

public class Start implements Performable{

    private ApplicationHomePage applicationHomePage;
    public static Performable withAnEmptyList() {
        return Instrumented.instanceOf(Start.class).newInstance();
    }

    @Override
    @Step("{0} starts with an empty list")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(ApplicationHomePage.class)
        );

    }
}
