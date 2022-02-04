package todomvc;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class StopAndDebug {
    public static Performable here() {
       return Task.where(
                actor -> {
                    System.out.println("DEBUGGING");
                }
        );
    }
}
