package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPersons.CARL;
import static seedu.address.testutil.TypicalPersons.ELLE;
import static seedu.address.testutil.TypicalPersons.FIONA;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.internhub.logic.commands.FindCommand;
import seedu.internhub.model.Model;
import seedu.internhub.model.ModelManager;
import seedu.internhub.model.UserPrefs;
import seedu.internhub.model.person.NameContainsKeywordsPredicate;

/**
 * Contains integration tests (interaction with the Model) for {@code FindCommand}.
 */
public class FindCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        NameContainsKeywordsPredicate firstPredicate =
                new NameContainsKeywordsPredicate(Collections.singletonList("first"));
        NameContainsKeywordsPredicate secondPredicate =
                new NameContainsKeywordsPredicate(Collections.singletonList("second"));

        FindCommand findFirstCommand = new FindCommand(firstPredicate);
        FindCommand findSecondCommand = new FindCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        FindCommand findFirstCommandCopy = new FindCommand(firstPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }

    @Test
    public void execute_zeroKeywords_noPersonFound() {
        // String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 0);
        NameContainsKeywordsPredicate predicate = preparePredicate(" ");
        FindCommand command = new FindCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);


        // this test will always fail because the way I implemented the find the list of found names will be
        // returned as a separate list instead of modifying the existing list inside the model which is
        // what assertCommandSuccess checks for.
        // with the current implementation this test is also kind of irrelevant since the find command will not
        // actually modify the model itself.

        //assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.generateNewFilteredPersonList(predicate));
        assertEquals(Collections.emptyList(), command.execute(model).getViewList());

        assertEquals(0, model.generateNewFilteredPersonList(predicate).size());
        // theres no view size i hope that's not a problem
    }

    @Test
    public void execute_multipleKeywords_multiplePersonsFound() {
        // String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 3);
        NameContainsKeywordsPredicate predicate = preparePredicate("Kurz Elle Kunz");
        FindCommand command = new FindCommand(predicate);
        // expectedModel.updateFilteredPersonList(predicate);

        //following line will always fail; see above
        //assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(CARL, ELLE, FIONA), model.generateNewFilteredPersonList(predicate));
        assertEquals(Arrays.asList(CARL, ELLE, FIONA), command.execute(model).getViewList());
        assertEquals(3, model.generateNewFilteredPersonList(predicate).size());
    }

    @Test
    public void toStringMethod() {
        NameContainsKeywordsPredicate predicate = new NameContainsKeywordsPredicate(Arrays.asList("keyword"));
        FindCommand findCommand = new FindCommand(predicate);
        String expected = FindCommand.class.getCanonicalName() + "{predicate=" + predicate + "}";
        assertEquals(expected, findCommand.toString());
    }

    /**
     * Parses {@code userInput} into a {@code NameContainsKeywordsPredicate}.
     */
    private NameContainsKeywordsPredicate preparePredicate(String userInput) {
        return new NameContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
