---
layout: default.md
title: "Developer Guide"
pageNav: 3
---

# InternHub Developer Guide

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## **Acknowledgements**

_{ list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well }_

--------------------------------------------------------------------------------------------------------------------

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

--------------------------------------------------------------------------------------------------------------------

## **Design**

### Architecture

<puml src="diagrams/ArchitectureDiagram.puml" width="280" />

The ***Architecture Diagram*** given above explains the high-level design of the App.

Given below is a quick overview of main components and how they interact with each other.

**Main components of the architecture**

**`Main`** (consisting of classes [`Main`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java)) is in charge of the app launch and shut down.
* At app launch, it initializes the other components in the correct sequence, and connects them up with each other.
* At shut down, it shuts down the other components and invokes cleanup methods where necessary.

The bulk of the app's work is done by the following four components:

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<puml src="diagrams/ArchitectureSequenceDiagram.puml" width="574" />

Each of the four main components (also shown in the diagram above),

* defines its *API* in an `interface` with the same name as the Component.
* implements its functionality using a concrete `{Component Name}Manager` class (which follows the corresponding API `interface` mentioned in the previous point.

For example, the `Logic` component defines its API in the `Logic.java` interface and implements its functionality using the `LogicManager.java` class which follows the `Logic` interface. Other components interact with a given component through its interface rather than the concrete class (reason: to prevent outside component's being coupled to the implementation of a component), as illustrated in the (partial) class diagram below.

<puml src="diagrams/ComponentManagers.puml" width="300" />

The sections below give more details of each component.

### UI component

The **API** of this component is specified in [`Ui.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/Ui.java)

<puml src="diagrams/UiClassDiagram.puml" alt="Structure of the UI Component"/>

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `PersonListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class which captures the commonalities between classes that represent parts of the visible GUI.

The `UI` component uses the JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* executes user commands using the `Logic` component.
* listens for changes to `Model` data so that the UI can be updated with the modified data.
* keeps a reference to the `Logic` component, because the `UI` relies on the `Logic` to execute commands.
* depends on some classes in the `Model` component, as it displays `Person` object residing in the `Model`.

### Logic component

**API** : [`Logic.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/logic/Logic.java)

Here's a (partial) class diagram of the `Logic` component:

<puml src="diagrams/LogicClassDiagram.puml" width="550"/>

The sequence diagram below illustrates the interactions within the `Logic` component, taking `execute("delete 1")` API call as an example.

<puml src="diagrams/DeleteSequenceDiagram.puml" alt="Interactions Inside the Logic Component for the `delete 1` Command" />

<box type="info" seamless>

**Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline continues till the end of diagram.
</box>

How the `Logic` component works:

1. When `Logic` is called upon to execute a command, it is passed to an `AddressBookParser` object which in turn creates a parser that matches the command (e.g., `DeleteCommandParser`) and uses it to parse the command.
1. This results in a `Command` object (more precisely, an object of one of its subclasses e.g., `DeleteCommand`) which is executed by the `LogicManager`.
1. The command can communicate with the `Model` when it is executed (e.g. to delete a person).<br>
   Note that although this is shown as a single step in the diagram above (for simplicity), in the code it can take several interactions (between the command object and the `Model`) to achieve.
1. The result of the command execution is encapsulated as a `CommandResult` object which is returned back from `Logic`.

Here are the other classes in `Logic` (omitted from the class diagram above) that are used for parsing a user command:

<puml src="diagrams/ParserClasses.puml" width="600"/>

How the parsing works:
* When called upon to parse a user command, the `AddressBookParser` class creates an `XYZCommandParser` (`XYZ` is a placeholder for the specific command name e.g., `AddCommandParser`) which uses the other classes shown above to parse the user command and create a `XYZCommand` object (e.g., `AddCommand`) which the `AddressBookParser` returns back as a `Command` object.
* All `XYZCommandParser` classes (e.g., `AddCommandParser`, `DeleteCommandParser`, ...) inherit from the `Parser` interface so that they can be treated similarly where possible e.g, during testing.

### Model component
**API** : [`Model.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/model/Model.java)

<puml src="diagrams/ModelClassDiagram.puml" width="450" />


The `Model` component,

* stores the address book data i.e., all `Person` objects (which are contained in a `UniquePersonList` object).
* stores the currently 'selected' `Person` objects (e.g., results of a search query) as a separate _filtered_ list which is exposed to outsiders as an unmodifiable `ObservableList<Person>` that can be 'observed' e.g. the UI can be bound to this list so that the UI automatically updates when the data in the list change.
* stores a `UserPref` object that represents the user’s preferences. This is exposed to the outside as a `ReadOnlyUserPref` objects.
* does not depend on any of the other three components (as the `Model` represents data entities of the domain, they should make sense on their own without depending on other components)

### Storage component

**API** : [`Storage.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/storage/Storage.java)

<puml src="diagrams/StorageClassDiagram.puml" width="550" />

The `Storage` component,
* can save both address book data and user preference data in JSON format, and read them back into corresponding objects.
* inherits from both `AddressBookStorage` and `UserPrefStorage`, which means it can be treated as either one (if only the functionality of only one is needed).
* depends on some classes in the `Model` component (because the `Storage` component's job is to save/retrieve objects that belong to the `Model`)

### Common classes

Classes used by multiple components are in the `seedu.addressbook.commons` package. The three over-arching sub-packages are `core`, `exceptions`, and `util`.

`core`: This package defines classes for user configuration, GUI settings, and even a version number.

`exceptions`: This package defines exceptions thrown by InternHub when it encounters an error state.

`util`: This package defines utility classes for certain operations, like file I/O, argument validation, and image processing.

--------------------------------------------------------------------------------------------------------------------

## **Implementation**

This section describes some noteworthy details on how certain features are implemented.

### Add Command

#### Implementation
This command adds an internship application into the InternHub using the company name, phone number, email, address, tag, job description, interview date, intern duration, salary and note.

The following steps show how the add internship application feature works:

The `add` command entered by the user is parsed and the different fields are tokenized.

`AddCommand#execute(Model model)` is invoked which checks for validity of the entered parameter values.

The command is then executed by creating a new Person object using the parameter values entered and adding the Person object into the InternHub.

If successful, a `CommandResult` object is created to show a success message in the feedback box of the ui.

The diagram below shows the class diagram for AddCommand.

<puml src="diagrams/AddCommandClassDiagram.puml" width="300" />

#### Design Considerations
Alternative 1 (current choice): Creates a new Person object in AddCommandParser.

Pros: Simpler to test and understand.

Cons: Command object should not know details about model i.e. Person.

Alternative 2: New Person object is created and added to InternHub in model.

Pros: Command has no knowledge of Model and its attributes.

Cons: More prone to error.

The Diagram below shows the sequence diagram for AddCommand. All Initialization commands above are similar in their interactions with the [logic component](###logic-component) and [model component](###model-component).

<puml src="diagrams/AddSequenceDiagram.puml" />

### Filter Command

#### Implementation
The Filter Command allows users to filter the current list of contacts by a specified tag, such that only contacts with said tag will be displayed in the contact list.

The following steps outline how the Filter Command feature operates:

1. Command Parsing
    - When a user inputs the `filter` command followed by a `tag`, the `FilterCommandParser` is invoked to parse this input
    - The tag provided is extracted from the input string
2. List filtering
    - Upon parsing, a `MatchingTagPredicate` is instantiated with the parsed tag String
    - The `FilteredPersonList` representing the list of contacts is then updated with the new `MatchingTagPredicate` which checks if the `tag` field of each list entry matches the specified `tag`
3. Execute
    - A `FilterCommand` is instantiated with the number of entries in the updated `FilteredPersonList`.
    - The `FilterCommand#execute(Model model)` is then called, passing the current application model
4. Command Result
    - The `FilterCommand` constructs a new `CommandResult` with the following params :
        - **feedbackToUser** : `[size of filtered list] persons listed~`

### Edit Command

#### Implementation

The `EditCommand` allows users to modify the details of an existing person in the address book.

#### Command Structure

- **Command Word**: `edit`
- **Parameters**:
- `INDEX`: Positive integer representing the index of the person in the displayed list.
- `[NAME]`, `[PHONE]`, `[EMAIL]`, `[ADDRESS]`, `[JOB DESCRIPTION]`, `[INTERVIEW DATE]`, `[INTERN DURATION]`, `[SALARY]`, `[TAG]`: Optional parameters to specify the new values for corresponding fields. Existing values will be overwritten.

#### Execution Steps

1. Parsing:
- The input arguments are parsed to extract the index and the new values for the person's details.
2. Validation:
- The validity of the index and the absence of duplicate prefixes are verified.
3. Creation of Edit Descriptor:
- An `EditPersonDescriptor` object is created to store the edited details.
4. Field Editing:
- Each provided field is set in the `EditPersonDescriptor`.
5. Execution:
- The `EditCommand` is executed, modifying the specified person's details in the address book.
6. Feedback:
- A success message is generated to confirm the editing operation.

#### Design Considerations

- **Overwriting vs. Appending**: The command allows overwriting existing details with new ones. This simplifies the implementation and usage of the command.
- **Error Handling**: The command ensures that at least one field is edited and provides appropriate error messages for invalid inputs.

<puml src="diagrams/EditCommandClassDiagram.puml" width="300" />

#### Implementation

Suppose we have a person with the following details:

- Name: John Doe
- Phone: 12345678
- Email: johndoe@example.com
- Address: Block 123, Avenue Street, #08-123
- Job Description: Software Engineer
- Interview Date: 2024-04-15
- Intern Duration: 3 months
- Salary: $3000
- Tags: #java, #software

Now, the user wants to edit John Doe's phone number and address. They issue the following command:
edit 1 p/87654321 a/Block 456, New Avenue, #05-678

The `EditCommand` will update John Doe's phone number to `87654321` and address to `Block 456, New Avenue, #05-678`. 
Upon successful execution, a message will be displayed confirming the changes made to John Doe's details.

<puml src="diagrams/EditSequenceDiagram.puml" width="600" />

### View Command

#### Implementation
The View Command allows users to view the company contact based on its index in the view panel

The following steps outline how the View Command feature operates :

1. Command Parsing
    - When a user inputs the `view` command followed by an `index`, the `ViewCommandParser` is invoked to parse this input
    - The index provided is extracted from the input string
2. Execution
    - Upon parsing, the `ViewCommand` is instantiated with the parsed index.
    - The `ViewCommand#execute(Model model)` is then called, passing the current application model
3. Index validation
    - Within the `execute` method, the validity of the index entered is checked. This involves ensuring the index falls within the current range of the contact list
    - If index is invalid, a `CommandException` is thrown with an error message
4. Command Result
    - The `ViewCommand` constructs a new `CommandResult` with the following param :
        - **personToView** : `Current company contact`
5. UI 
    - The `ViewPanel` class displays the **personToView** with all its details and fields

#### Design Considerations

- Fetch `Person` object based on the index
- Utilize the `CommandResult` to pass the `Person` object to the UI component

The following sequence diagram shows what happens when `view 3` is the command input

<puml src="diagrams/ViewSequenceDiagram.puml" />


The following activity diagram shows what the logic behind the command `view 3`

<puml src="diagrams/ViewActivityDiagram.puml" />


### Note Command

#### Implementation
The Note Command feature allows users to retrieve the note attribute of a contact based on its index and reflects it in the Command Box as an edit command, enabling users to make changes to the note seamlessly.

The following steps outline how the Note Command feature operates:

1. Command Parsing
    - When a user inputs the `note` command followed by an `index`, the `NoteCommandParser` is invoked to parse this input
    - The index provided is extracted from the input string
2. Execution
    - Upon parsing, the `NoteCommand` is instantiated with the parsed index.
    - The `NoteCommand#execute(Model model)` is then called, passing the current application model
3. Index validation
    - Within the `execute` method, the validity of the index entered is checked. This involves ensuring the index falls within the current range of the contact list
    - If index is invalid, a `CommandException` is thrown with an error message
4. Note Retrieval
    - Assuming the index is valid, the `NoteCommand` retrieves the **filtered list of contacts** (`List<Person>`) from the model
    - The note content of the contact corresponding to the provided index is then fetched.
5. Command Result
    - Upon retrieving the note content, the `NoteCommand` constructs a new `CommandResult` with the following params :
        - **feedbackToUser** : `edit [INDEX of Contact] n/{existing note}`
        - **personToView** : `Current company contact`
6. Reflecting the feedback on Command Box
    - In `CommandBox#handleCommandEntered()`, if the `feedbackToUser` of the CommandResult object starts with `edit ` (ie our note Command Result), we set the text of the command box to be the `feedbackToUser`

<puml src="diagrams/NoteCommandClassDiagram.puml" width="300" />

#### Design Considerations
**Alternative 1 : Use edit to make changes to note attribute**
- Pros:
    - Easier implementation
    - No need for new command to be created
- Cons:
    - Edit will **OVERWRITE** old data

**Alternative 2 (Current Implementation) : Create `note` command**
- Pros:
    - Allows for editing and updating existing note content
    - Will not overwrite old data
- Cons:
    - An additional command has to be implemented
    - Essentially an abstracted & glorified edit feature

<puml src="diagrams/NoteSequenceDiagram.puml" />

The following activity diagram shows how the user can interact with the Note Command

<puml src="diagrams/NoteActivityDiagram.puml" />

### \[Proposed\] Undo/redo feature

#### Proposed Implementation

The proposed undo/redo mechanism is facilitated by `VersionedAddressBook`. It extends `AddressBook` with an undo/redo history, stored internally as an `addressBookStateList` and `currentStatePointer`. Additionally, it implements the following operations:

* `VersionedAddressBook#commit()` — Saves the current address book state in its history.
* `VersionedAddressBook#undo()` — Restores the previous address book state from its history.
* `VersionedAddressBook#redo()` — Restores a previously undone address book state from its history.

These operations are exposed in the `Model` interface as `Model#commitAddressBook()`, `Model#undoAddressBook()` and `Model#redoAddressBook()` respectively.

Given below is an example usage scenario and how the undo/redo mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `VersionedAddressBook` will be initialized with the initial address book state, and the `currentStatePointer` pointing to that single address book state.

<puml src="diagrams/UndoRedoState0.puml" alt="UndoRedoState0" />

Step 2. The user executes `delete 5` command to delete the 5th person in the address book. The `delete` command calls `Model#commitAddressBook()`, causing the modified state of the address book after the `delete 5` command executes to be saved in the `addressBookStateList`, and the `currentStatePointer` is shifted to the newly inserted address book state.

<puml src="diagrams/UndoRedoState1.puml" alt="UndoRedoState1" />

Step 3. The user executes `add n/David …​` to add a new person. The `add` command also calls `Model#commitAddressBook()`, causing another modified address book state to be saved into the `addressBookStateList`.

<puml src="diagrams/UndoRedoState2.puml" alt="UndoRedoState2" />

<box type="info" seamless>

**Note:** If a command fails its execution, it will not call `Model#commitAddressBook()`, so the address book state will not be saved into the `addressBookStateList`.

</box>

Step 4. The user now decides that adding the person was a mistake, and decides to undo that action by executing the `undo` command. The `undo` command will call `Model#undoAddressBook()`, which will shift the `currentStatePointer` once to the left, pointing it to the previous address book state, and restores the address book to that state.

<puml src="diagrams/UndoRedoState3.puml" alt="UndoRedoState3" />


<box type="info" seamless>

**Note:** If the `currentStatePointer` is at index 0, pointing to the initial AddressBook state, then there are no previous AddressBook states to restore. The `undo` command uses `Model#canUndoAddressBook()` to check if this is the case. If so, it will return an error to the user rather
than attempting to perform the undo.

</box>

The following sequence diagram shows how an undo operation goes through the `Logic` component:

<puml src="diagrams/UndoSequenceDiagram-Logic.puml" alt="UndoSequenceDiagram-Logic" />

<box type="info" seamless>

**Note:** The lifeline for `UndoCommand` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.

</box>

Similarly, how an undo operation goes through the `Model` component is shown below:

<puml src="diagrams/UndoSequenceDiagram-Model.puml" alt="UndoSequenceDiagram-Model" />

The `redo` command does the opposite — it calls `Model#redoAddressBook()`, which shifts the `currentStatePointer` once to the right, pointing to the previously undone state, and restores the address book to that state.

<box type="info" seamless>

**Note:** If the `currentStatePointer` is at index `addressBookStateList.size() - 1`, pointing to the latest address book state, then there are no undone AddressBook states to restore. The `redo` command uses `Model#canRedoAddressBook()` to check if this is the case. If so, it will return an error to the user rather than attempting to perform the redo.

</box>

Step 5. The user then decides to execute the command `list`. Commands that do not modify the address book, such as `list`, will usually not call `Model#commitAddressBook()`, `Model#undoAddressBook()` or `Model#redoAddressBook()`. Thus, the `addressBookStateList` remains unchanged.

<puml src="diagrams/UndoRedoState4.puml" alt="UndoRedoState4" />

Step 6. The user executes `clear`, which calls `Model#commitAddressBook()`. Since the `currentStatePointer` is not pointing at the end of the `addressBookStateList`, all address book states after the `currentStatePointer` will be purged. Reason: It no longer makes sense to redo the `add n/David …​` command. This is the behavior that most modern desktop applications follow.

<puml src="diagrams/UndoRedoState5.puml" alt="UndoRedoState5" />

The following activity diagram summarizes what happens when a user executes a new command:

<puml src="diagrams/CommitActivityDiagram.puml" width="250" />

#### Design considerations:

**Aspect: How undo & redo executes:**

* **Alternative 1 (current choice):** Saves the entire address book.
  * Pros: Easy to implement.
  * Cons: May have performance issues in terms of memory usage.

* **Alternative 2:** Individual command knows how to undo/redo by
  itself.
  * Pros: Will use less memory (e.g. for `delete`, just save the person being deleted).
  * Cons: We must ensure that the implementation of each individual command are correct.

_{more aspects and alternatives to be added}_

### \[Proposed\] Data archiving

_{Explain here how the data archiving feature will be implemented}_


--------------------------------------------------------------------------------------------------------------------

## **Documentation, logging, testing, configuration, dev-ops**

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

--------------------------------------------------------------------------------------------------------------------

## **Appendix A : Requirements**

### Product scope

**Target user profile**:

* Undergraduate students
* has a need to keep track of contacts of companies and interview dates during their internship hunt
* prefer a one-stop, centralised dashboard to manage all contact details of companies
* is reasonably comfortable in using a more CLI based app
* wants to be better organized

**Value proposition**: Ultimate companion for Undergraduate students embarking on their internship journey !

### User stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`


| Priority | As an …​             | I want to …​                                            | So that I can…​                                                                                   |
|----------|----------------------|---------------------------------------------------------|---------------------------------------------------------------------------------------------------|
| `* * *`  | internship applicant | add contact information of internship companies         | easily access their details when needed                                                           |
| `* * *`  | internship applicant | delete contact information of internship companies      | easily remove any old or irrelevant company contacts                                              |
| `* * *`  | internship applicant | edit contact information of internship companies        | easily update any details on the go                                                               |
| `* * *`  | internship applicant | see usage instructions                                  | refer to instructions when I forget how to use the AddressBook                                    |
| `* * *`  | internship applicant | find the contact information of a certain company       | easily search which company contact I want by name                                                |
| `* * *`  | internship applicant | keep track of the status of each internship application | categorize and easily follow up accordingly                                                       |
| `* * *`  | internship applicant | sort company contacts by dates                          | prioritize and plan for upcoming interviews                                                       |
| `* * `   | internship applicant | filter company contacts by date                         | quickly access contacts associated with a specific date                                           |
| `* * `   | internship applicant | filter company contacts by tag                          | easily find and manage contacts within specific categories                                        |
| `* * `   | internship applicant | add a time to a company contact                         | record when a specific task or interaction needs to be done                                       |
| `* `     | internship applicant | add notes to company contacts                           | include important details or information about specific interviews and what I can learn from them |


### Use cases

(For all use cases below, the **System** is the `AddressBook` and the **Actor** is the `user`, unless specified otherwise)

**Use Case: Input Company Contact Information**

**Actor:** Internship Applicant

**Main Success Scenario (MSS):**

1. Internship Applicant inputs contact information of internship company.
2. System stores the contact information.
3. Use case ends.

**Extensions:**

* 1a. System detects an error in the entered data.
    * 1a1. System requests for the correct data.
    * 1a2. Internship Applicant enters new data.
    * Steps 1a1-1a2 are repeated until the data entered are correct.
    * Use case resumes from step 2.

* *a. At any time, Internship Applicant chooses to cancel the input.
    * Use case ends.

---

**Use Case: Delete Company Contact Information**

**Actor:** Internship Applicant

**Main Success Scenario (MSS):**

1. Internship Applicant inputs index of contact to be deleted.
2. System deletes the relevant contact information.
3. Use case ends.

**Extensions:**

* 1a. System detects an error in index of contact
    * 1a1. System requests for proper input of index (1 to current number of contacts)
    * 1a2. Internship Applicant enters the correct index.
    * Steps 1a1-1a2 are repeated until the selection is correct.
    * Use case resumes from step 2.

* *a. At any time, the Internship Applicant chooses to cancel to detect contact.
    * *a1. System cancels deletion of contact.
    * Use case ends.

---

**Use Case: Edit Contacts Info**

**Actor:** Internship Applicant

**Main Success Scenario (MSS):**

1. Internship Applicant chooses contact to edit by its index and enters relevant fields to be modified
2. System modifies that corresponding field of that contact
3. Use case ends

**Extensions:**

* 1a. System detects an error in index of contact
    * 1a1. System requests for proper input of index (1 to current number of contacts)
    * 1a2. Internship Applicant enters the correct index.
    * Steps 1a1-1a2 are repeated until the selection is correct.
    * Use case resumes from step 2.

* 1a. System detects an error in the fields to be edited (No fields at all or incorrect field prefixes)
    * 1a1. System requests for proper input of fields and correct prefix
    * 1a2. Internship Applicant enters the fields to be edited.
    * Steps 1a1-1a2 are repeated until the selection is correct.
    * Use case resumes from step 2.

* *a. At any time, the Internship Applicant chooses to cancel to edit contact.
    * *a1. System cancels edit of contact.
    * Use case ends.

---

**Use Case: Filter Contacts by Tag**

**Actor:** Internship Applicant

**Main Success Scenario (MSS):**

1. Internship Applicant chooses to filter contacts by tag.
2. Internship Applicant inputs the tag.
3. System filters the contacts associated with the selected tag.
4. System displays the filtered contacts.
5. Use case ends.

**Extensions:**

* 2a. System detects an error in tag to be filtered
    * 2a1. System requests for proper input of tag (One of existing tags)
    * 2a2. Internship Applicant enters the correct tag.
    * Steps 2a1-2a2 are repeated until the selection is correct.
    * Use case resumes from step 3.

* *a. At any time, the Internship Applicant chooses to cancel the filtering.
    * *a1. System cancels the filtering.
    * Use case ends.

---

**Use Case: View information of a contact**

**Actor:** Internship Applicant

**Main Success Scenario (MSS):**

1. Internship Applicant chooses contact to be viewed on view panel.
2. System requests for the specific contact index.
3. Internship Applicant enters the contact index.
4. System views the relevant contact on the view panel.
5. Use case ends.

**Extensions:**

* 3a. IH detects an error in index of contact
    * 3a1. System requests for proper input of index (1 to current number of contacts)
    * 3a2. Internship Applicant enters the correct index.
    * Steps 3a1-3a2 are repeated until the selection is correct.
    * Use case resumes from step 3.

* *a. At any time, Internship Applicant chooses to cancel to view contact.
    * *a1. System cancels viewing of contact.
    * Use case ends.

---

### Non-Functional Requirements

1.  Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2.  Should be able to hold up to 1000 persons without a noticeable sluggishness in performance for typical usage.
3.  A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.

### Glossary

* **Mainstream OS**: Windows, Linux, Unix, MacOS
* **Private contact detail**: A contact detail that is not meant to be shared with others

--------------------------------------------------------------------------------------------------------------------

## **Appendix B : Planned Enhancements**

Team size : 5

1. **Handling of invalid date to be with accordance of Gregorian Calendar**
2. 

--------------------------------------------------------------------------------------------------------------------

## **Appendix C : Instructions for manual testing**

Given below are instructions to test the app manually.


**Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.


### Launch and shutdown

1. Initial launch

   1. Download the jar file and copy into an empty folder

   2. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

2. Saving window preferences

   1. Resize the window to an optimum size. Move the window to a different location. Close the window.

   2. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

3. _{ more test cases …​ }_

### Deleting a person

1. Deleting a person while all persons are being shown

   1. Prerequisites: List all persons using the `list` command. Multiple persons in the list.

   2. Test case: `delete 1`<br>
      Expected: First contact is deleted from the list. Details of the deleted contact shown in the status message. Timestamp in the status bar is updated.

   3. Test case: `delete 0`<br>
      Expected: No person is deleted. Error details shown in the status message. Status bar remains the same.

   4. Other incorrect delete commands to try: `delete`, `delete x`, `...` (where x is larger than the list size)<br>
      Expected: Similar to previous.

2. _{ more test cases …​ }_

### Viewing a company contact

1. Viewing a contact with an empty contact list

   1. Prerequisites: Clear all contacts using `clear` command. Will empty the contacts

   2. Test case : `view 2`<br>
      Expected : Error message should be shown in the **result display** as there are no contacts to view from !

2. Viewing a contact in a populated list

    1. Prerequisites: Ensure at least 1 company contact is in the contact list of InternHub

    2. Test case : `view 2` (Assuming there are at least 2 contacts)<br>
       Expected : The contact details of the company at index 2 will be aptly displayed on the view panel on the right

### Saving data

1. Dealing with missing/corrupted data files

   i. Test case: Deleting name field (the `key` attribute) from a contact in the InternHub data file.<br>
      Expected: After the app is reboot, the now corrupt data file `internhub.json` will be detected and all the data in the file will be wiped out, causing the app to recreate an empty data file.
   
   ii. Test case: Delete InternHub data file.<br>
      Expected: If the data file `internhub.json` is nowhere to be found, the app will simply recreate the an empty data file.
   
   iii. Test case: Modify the json format in which InternHub data file is stored.<br>
      Expected: If data file `internhub.json` is still in the correct format, the app will run as per normal. However, if the data file becomes unreadable by the program, then all the data in the file will be wiped out, causing the app to recreate and run with an empty data file from scratch.

--------------------------------------------------------------------------------------------------------------------

## **Appendix D : Effort**

