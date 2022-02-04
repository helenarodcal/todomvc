package todomvc;

import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import todomvc.questions.TheItems;
import todomvc.tasks.AddATodoItem;
import todomvc.tasks.Start;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.hasItem;

public class AddNewTasksStepDefinitions {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that (.*) has an empty todo list$")
    public void that_James_has_an_empty_todo_list(String actorName) {
        OnStage.theActorCalled(actorName).attemptsTo(
                Start.withAnEmptyList()
        );
    }

    @Given("^that (?:.*) has a list containing (.*)$")
    public void has_a_list_containing(List<String> tasks) throws Exception {
        // TODO
        throw new PendingException();
    }

    @When("^s?he adds '(.*)' to (?:his|her) list$")
    public void he_adds_to_his_list(String taskName)  {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddATodoItem.called(taskName)
        );
    }

    @Then("^'(.*)' should be recorded in (?:his|her) list$")
    public void should_be_recorded_in_his_list(String taskName)  {
        OnStage.theActorInTheSpotlight().should(
                seeThat("the items displayed", TheItems.displayed(), hasItem(taskName)
                )
        );
    }

    @Then("^(?:his|her) todo list should contain (.*)$")
    public void list_should_contain(List<String> tasks){
        // TODO

    }
}
