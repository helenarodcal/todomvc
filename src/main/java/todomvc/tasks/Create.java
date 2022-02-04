package todomvc.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class Create implements Performable {
    private final List<String> tasks;

    public Create(List<String> tasks) {
        this.tasks = tasks;
    }

    public static Performable listOfTasks(List<String> tasks) {
        return Instrumented.instanceOf(Create.class).withProperties(tasks);
    }

    @Override
    @Step("{0} creates a new list including: #tasks")
    public <T extends Actor> void performAs(T actor) {
        tasks.stream().forEach(
            task -> {
                actor.attemptsTo(
                        AddATodoItem.called(task)
                );
            }
        );
    }
}
