package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.InternDuration;
import seedu.address.model.person.InterviewDate;
import seedu.address.model.person.JobDescription;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Salary;
import seedu.address.model.tag.Tag;
import seedu.address.testutil.TypicalPersons;

class ViewPanelTest {

    @Test
    void constructor_validPerson_displayCorrectInformation() {

        Person expected = TypicalPersons.ALICE;
        Person test = new Person(
                new Name("Alice Pauline"),
                new Phone("94351253"),
                new Email("alice@example.com"),
                new Address("123, Jurong West Ave 6, #08-111"),
                new Tag("NR"),
                new JobDescription("Software engineer developer"),
                new InterviewDate("03-01-2024 1000"),
                new InternDuration("3 months"),
                new Salary("1000")
        );
        TestFxmlObject fxmlObject = new TestFxmlObject();
        fxmlObject.setText(test.toString());
        assertEquals(fxmlObject.getText(), expected.toString());
    }
}
