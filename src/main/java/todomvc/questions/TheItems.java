package todomvc.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import todomvc.ui.TodoList;

import java.util.List;

public class TheItems {
    public static <T> Question<List<String>> displayed() {
        return Text.of(TodoList.ITEMS).asListOf(String.class);
    }
}
