package todomvc.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import todomvc.ui.TodoList;

import java.util.List;

public class TheItems {
    public static <T> Question<List<String>> displayed() {
        return actor -> Text.ofEach(TodoList.ITEMS).asListOf(String.class).answeredBy(actor);
    }
}
