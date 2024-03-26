---
layout: default.md
title: "User Guide"
pageNav: 3
---

# Internhub User Guide

Intern Hub is a **desktop app for managing contacts, optimized for use via a  Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, InternHub can get your contact management tasks done faster than traditional GUI apps.

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `addressbook.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar addressbook.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all contacts.

   * `add c/Food Panda p/12345678 e/panda@food.com a/CBD t/F jd/Front End Intern d/15-04-2024 0900 id/6 months s/500
     ` : Adds a contact named `Food Panda` to the Address Book.

   * `delete 3` : Deletes the 3rd contact shown in the current list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<box type="info" seamless>

**Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add c/COMPANY_NAME`, `COMPANY_NAME` is a parameter which can be used as `add c/Food Panda`.

* Items in square brackets are optional.<br>
  e.g `c/COMPANY_NAME [a/ADDRESS]` can be used as `c/Food Panda a/CBD` or as `c/Food Panda`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `add c/COMPANY_NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER add c/COMPANY_NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</box>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a contact: `add`

To add a internship contact to your address book, follow these simple steps:

1. Type `add` followed by the details of the contact you want to add.
2. Use `c/` for the company name, `p/` for the phone number, `e/` for the email, `a/` for the address, `t/` for tags, `jd/` for job description, `d/` for interview date, `id/` for intern duration, and `s/` for salary.

Format: `add c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL a/[ADDRESS] t/TAG jd/JOB_DESCRIPTION d/[INTERVIEW_DATE] id/INTERN_DURATION s/salary`

<box type="tip" seamless> heheh

</box>

Examples:
* `add c/FoodPanda p/12345678 e/panda@food.com a/CBD t/F jd/Front End Intern d/15-04-2024 0900 id/6 months s/500`
* `add c/Shoppa p/99912345 e/panda@food.com t/F jd/Software Developer Intern  id/6 months s/500`

### Listing all contacts : `list`

Shows a list of all contacts in the address book sorted in ascending order of interview dates. If a company contact does not have any interview dates yet, it will be pushed to the end of the list.

Format: `list`

### Viewing a contact : `view`

Views the details of the contact on the view panel in address book.

Format: `View INDEX`

* Views the contact at the specified `INDEX`. The index refers to the index number shown in the displayed contact list. The index **must be a positive integer** 1, 2, 3, …​

Example:
*  `view 3` Shows the company name of the 3rd contact on the view panel.

### Editing a contact : `edit`

Edits an existing contact detail in the address book.

Format: `Edit INDEX c/[COMPANY_NAME] p/[PHONE_NUMBER] e/[EMAIL] a/[ADDRESS] t/[TAG] jd/[JOB_DESCRIPTION] d/[INTERVIEW_DATE] id/[INTERN_DURATION] s/[SALARY]`

* Edits the contact at the specified `INDEX`. The index refers to the index number shown in the displayed contact list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* For `[INTERVIEW_DATE]`, if you want to remove a date, just enter `d/` and it will remove that field.

Examples:
*  `edit 1 p/91234567 e/foodpanda@example.com` Edits the phone number and email address of the 1st contact to be `91234567` and `foodpanda@example.com` respectively.
*  `edit 2 c/shopee` Edits the company name of the 2nd contact to be `shopee`.

### Locating contacts by name: `find`

Finds contacts whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `shoppa` will match `Shoppa`
* The order of the keywords does not matter. e.g. `Food Panda` will match `Panda Food`
* Only the name is searched.
* Only full words will be matched e.g. `Shopp` will not match `Shoppa`
* Contacts matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Happy Burger` will return `Happy Meal`, `Burger Queen`

Examples:
* `find Happy` returns `happy` and `Happy Burger`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### Deleting a contact : `delete`

Deletes the specified contact from the address book.

Format: `delete INDEX`

* Deletes the contact at the specified `INDEX`.
* The index refers to the index number shown in the displayed contact list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd contact in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st contact in the results of the `find` command.

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

**Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the AddressBook to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.

</box>

### Finding the data

To find specific data entries, use the `find` command followed by keywords related to the data you're looking for. This command will help you quickly locate the information you need within your address book.

Format: `find Grab`

### Filtering the data (by tags)

Filtering data allows you to narrow down your search results to focus on specific criteria. Use the `filter t/` command to filter by tag and find exactly the internships that have an interview.


Format: `filter t/ I`

### Sending reminders

Sending reminders is a great way to stay organized and on top of important tasks. While our application currently doesn't have a built-in reminder feature, you can manually retrieve reminders using this command. It will show the interviews you have within the next 3 days.

Format: `reminder`

--------------------------------------------------------------------------------------------------------------------
## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous InternHub home folder.

**Q**: How do I check my Java version?<br>
**A**: You can check your Java version by opening a command terminal and typing `java -version`.

**Q**: How do I download Java 11?<br>
**A**: You can download Java 11 from the official Oracle website or adoptopenjdk.net. Choose the appropriate installer for your operating system and follow the installation instructions provided.

**Q**: What is a home folder?<br>
**A**: The home folder is the main directory associated with a user account on a computer. It typically contains user-specific settings, documents, downloads, and other personal files.

**Q**: Does the user know how to open the command terminal/how to change directory (cd) into a folder?<br>
**A**: Users should refer to the documentation or help resources specific to their operating system for instructions on opening a command terminal and navigating to a directory using the `cd` command.

**Q**: How do I run addressbook.jar?<br>
**A**: You can run addressbook.jar by opening a command terminal, navigating to the directory containing the jar file using the `cd` command, and then typing `java -jar addressbook.jar` and pressing Enter.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action       | Format, Examples                                                                                                                                                                                                                                           |
|--------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**      | `add c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL a/[ADDRESS] t/TAG jd/JOB_DESCRIPTION d/[INTERVIEW_DATE] id/INTERN_DURATION s/salary` <br> e.g., `add c/FoodPanda p/12345678 e/panda@food.com a/CBD t/F jd/Front End Intern d/15-04-2024 0900 id/6 months s/500` |
| **Clear**    | `clear`                                                                                                                                                                                                                                                    |
| **Delete**   | `delete INDEX`<br> e.g., `delete 3`                                                                                                                                                                                                                        |
| **Edit**     | `Edit INDEX c/[COMPANY_NAME] p/[PHONE_NUMBER] e/[EMAIL] a/[ADDRESS] t/[TAG] jd/[JOB_DESCRIPTION] d/[INTERVIEW_DATE] id/[INTERN_DURATION] s/[salary]`<br> e.g.,`Edit 2 p/9998765`                                                                           |
| **Find**     | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find foodpanda`                                                                                                                                                                                                  |
| **List**     | `list`                                                                                                                                                                                                                                                     |
| **View**     | `view INDEX`<br> e.g., `view 3`                                                                                                                                                                                                                            |
| **Help**     | `help`                                                                                                                                                                                                                                                     |
| **Find**     | `find STRING`<br> e.g., `find Grab`                                                                                                                                                                                                                        |
| **Filter**   | `filter t/ I`                                                                                                                                                                                                                                              |
| **Reminder** | `reminder`                                                                                                                                                                                                                                                 |
