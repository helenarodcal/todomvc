package todomvc;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import todomvc.questions.TheItems;
import todomvc.tasks.AddATodoItem;
import todomvc.tasks.Create;
import todomvc.tasks.Start;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class AddNewTasksStepDefinitions {


    @Given("that {actor} has an empty todo list")
//    public void that_James_has_an_empty_todo_list(String actorName) {
        public void that_James_has_an_empty_todo_list(Actor actor) {
//        OnStage.theActorCalled(actorName).attemptsTo(
//                Start.withAnEmptyList()
//        );
        actor.attemptsTo(
                Start.withAnEmptyList()
        );
    }

    @Given("that {actor} has a list containing {taskList}")
    public void has_a_list_containing(Actor actor, List<String> taskList) throws Exception {
        actor.attemptsTo(
                Start.withAnEmptyList(),
                Create.listOfTasks(taskList)
        );
    }

    @When("^s?he adds '(.*)' to (?:his|her) list$")
    public void he_adds_to_his_list(String taskName)  {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddATodoItem.called(taskName),
                StopAndDebug.here()
        );
    }

    @Then("^'(.*)' should be recorded in (?:his|her) list$")
    public void should_be_recorded_in_his_list(String taskName)  {
        OnStage.theActorInTheSpotlight().should(
                seeThat("the items displayed", TheItems.displayed(), hasItem(taskName)
                )
        );
    }
    @Then("his/her todo list should contain {taskList}")
    public void should_have_a_list_containing(List<String> taskList)  {
        OnStage.theActorInTheSpotlight().should(
                seeThat("the items displayed", TheItems.displayed(), equalTo(taskList)
                )
        );
    }
}
