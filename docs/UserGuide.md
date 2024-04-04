---
layout: default.md
title: "User Guide"
pageNav: 3
---

# Internhub User Guide

## Welcome !
Are you currently navigating the intricate maze of internship opportunities as an undergraduate? 
Your search ends here! InternHub is poised to transform the way you handle your internship contacts.
InternHub stands as a beacon of productivity, offering you a comprehensive platform to manage and organize all your internship applications effectively.

This User Guide (UG) acts as your trusted companion, providing a wealth of information to assist you in understanding and harnessing the full potential of our application. 
From installation to usage and navigation, each step is meticulously outlined to ensure you derive maximum benefits from InternHub in managing your internship contacts.

## Who can use InternHub ?
InternHub caters to undergraduates from all fields, providing them with a seamless and efficient approach to managing their internship contacts. 
Professors and career guidance officers, we invite you to share this invaluable resource with your students, empowering them to secure their dream internships.

InternHub is designed with **user-friendliness** in mind, catering to individuals with varying levels of computer experience. 
Whether you're a tech-savvy enthusiast or just dipping your toes into the world of desktop applications, rest assured that our interface is intuitive and easy to navigate.
We're committed to supporting you every step of the way on your internship management journey. 

Welcome aboard, and let's embark on this exciting adventure together!

For users who are **new to InternHub**, click [here](#introduction-to-the-user-guide) for a helpful starting point !

Experienced users can jump straight to exploring our [features](#features) !

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## Table of Contents
- [Introduction](#introduction-to-the-user-guide)
- [Quick Start](#quick-start)
- [Getting Familiar with UI](#getting-familiar-with-the-ui-of-internhub)
- [Features](#features)
    - [Help](#viewing-help-help)
    - [Basic Commands](#basic-commands)
        - [Adding a Contact](#adding-a-contact-add)
        - [Deleting a Contact](#deleting-a-contact-delete)
        - [Editing a Contact](#editing-a-contact-edit)
        - [Viewing a Contact](#viewing-a-contact-view)
    - [Advanced Commands](#advanced-commands)
        - [Listing all Contacts](#listing-all-contacts-list)
        - [Locating Contacts by Name](#locating-contacts-by-name-find)
        - [Adding a Note](#adding-a-note-note)
        - [Filter Contacts by Tags](#filtering-the-data-by-tags-filter)
        - [Sending Reminders](#sending-reminders-reminder)
    - [Miscellaneous Commands](#miscellaneous-commands)
        - [Clearing all Entries](#clearing-all-entries-clear)
        - [Exiting the Program](#exiting-the-program-exit)
    - [Storage & Data](#storage-and-amp-data)
        - [Saving the Data](#saving-the-data)
        - [Editing the Data](#editing-the-data-file)
- [FAQ](#faq)
- [Known Issues](#known-issues)
- [Command Summary](#command-summary)

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------
## Introduction to the User Guide
Our team at InternHub have carefully designed this user guide to be your one-stop solution for everything related to InternHub !

### Icons used

<box type="info" >Additional useful information</box>
<box type="warning" >Provides warnings on some potential errors</box>
<box type="tip" >Nifty tricks to make your experience smoother</box>

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Check Java Version & Install Java
    - For this application, your system is required to have Java 11 installed
    - To check if you have Java installed, open your command prompt or terminal and type : `java -version`
        - If Java is installed, you will see the version number in the output :
        - <img src="images/quickstart/java-installation.png" >
    - If Java is not installed or your version does not match as the output above :
        - Visit the Official [Oracle website](https://www.oracle.com/java/technologies/downloads/#java11) to download jdk-11 & follow the download instructions
        - For **mac** users, download the jdk-11 from [here](https://www.azul.com/downloads/?version=java-11-lts&os=macos&architecture=arm-64-bit&package=jdk-fx#zulu)

2. Download the latest `internhub.jar` from [here](https://github.com/AY2324S2-CS2103T-F14-1/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your InternHub.
    - The home folder will serve as InternHub's central location
    - This folder is where InternHub will keep all its important files and saved data

4. Once you have set up the _home folder_, right-click on the _home folder_ and click copy to copy the path to this directory.

5. Open up a new terminal or command prompt window

6. Type `cd ` and paste the _home folder_ path, your command should look something like this : `cd /Users/john/home folder`, then hit enter.

7. Now in the same command prompt or terminal window, enter the `java -jar internhub.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/UserGuide/Ui_new.png)

8. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * `list` : Lists all contacts.

    * `add c/Pixar p/98765432 e/Pixar@example.com a/123 Animation Avenue, Emeryville, CA, 94608, USA t/O jd/Junior Animator intern id/3 months s/1000 n/Assist in the creation of animated sequences, collaborate with the animation team to bring characters and scenes to life
      ` : Adds a contact named `Pixar` to the Address Book.

    * `delete 3` : Deletes the 3rd contact shown in the current list.

    * `clear` : Deletes all contacts.

    * `exit` : Exits the app.

9. Refer to the [Features](#features) for details of each command.

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## Getting familiar with the UI of InternHub

![Ui](images/UserGuide/GUI_annotation.png)

- **Command Box**
    - This is where you enter the commands !
- **Result Display**
    - The output message after each command is displayed here
- **List of Contacts**
    - The panel displays list of all internship company contacts
- **View Panel**
    - The panel displays the internship company contact card

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## Features

<box type="info">

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

You can list all the commands recognised by InternHub by typing `help` into the command box and pressing Enter.

Format: `help`

<box type="tip"> 

You can also execute this command by using the `F1` key on your keyboard.

</box>

**Expected Outcome**

A separate help window will appear.

![help message](images/UserGuide/helpMessage.png)

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## Basic Commands

### Adding a contact: `add`

To seamlessly add a new internship application contact to your address book, simply follow these steps:

1. Begin by typing `add`, followed by the specific details of the contact you wish to include in your records.
2Utilize the following prefixes to ensure accurate categorization of each detail:

   | Parameter | Description      | Example                          |
   |-----------|------------------|----------------------------------|
   | `c/`      | Company name     | `c/ABC Corporation`              |
   | `p/`      | Phone number     | `p/123-456-7890`                 |
   | `e/`      | Email address    | `e/example@example.com`          |
   | `a/`      | Physical address | `a/123 Main St, City, Country`   |
   | `t/`      | Tags             | `t/NR`                           |
   | `jd/`     | Job description  | `jd/Software Developer Intern`   |
   | `d/`      | Interview date   | `d/2024-04-14 15:00`             |
   | `id/`     | Intern duration  | `id/3 months`                    |
   | `s/`      | Salary           | `s/Unpaid`                       |
   | `n/`      | Notes            | `n/Previous experience required` |


Format: `add c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL a/[ADDRESS] t/TAG jd/JOB_DESCRIPTION d/[INTERVIEW_DATE] id/INTERN_DURATION s/SALARY n/[NOTE]`

<box type="info">

Each contact is uniquely identified by the combination of **Company Name** and **Job Description**
   - You **can** have 2 contacts of the same company name but **different** job descriptions
   - You **cannot** have 2 contacts of the same company name **and** same job description

</box>

<box type="tip"> 

Make sure to include the appropriate tag after `t/` to denote the status of the internship application
- NR: No Reply - Indicates that there has been no response from the company regarding the internship application.
- I: Interview - Signifies that an interview for the internship has been scheduled with the company.
- O: Offered - Indicates that an offer for the internship has been received from the company.
- OA: Online Assessment - Denotes that an online assessment or test is required.
- R: Rejected - Indicates that the internship application has been rejected by the company.

</box>

<box type="info"> 

We've made the address, interview date, and note fields optional. 
This acknowledges that you might not have immediate information about the interview date and location at the time of application.

</box>

<div style="page-break-after: always;"></div>

**Example 1:**

This example represents an application for a Creative Design Internship position at MediaCorp.
The tag t/I indicates that an interview has been scheduled with the company.
All parameters are provided, including optional parameters such as address, interview date and notes.
The notes section provides additional information about Mediacorp and suggests topics for discussion during the interview.

`add c/MediaCorp p/12345678 e/jobs@mediacorp-digital.com a/321 Media Lane, Singapore 238163 t/I jd/Creative Design Intern d/11-04-2024 0900 id/3 months s/1000 n/Mediacorp is a leading media company in Singapore, offering a wide range of media and entertainment services, including television, radio, digital media, and content production. Be prepared to discuss current trends in the media industry and how Mediacorp is adapting to digital transformation.
`

Expected Outcome

![add command example 1](images/UserGuide/addCommandExample1.png)

**Example 2:**

This example represents an application for a Junior Animator Internship position at Pixar.
The tag t/O indicates that an offer has been received from the company.
All required parameters are provided, including contact information, job details, internship duration, and salary.
Optional parameters such as the address, interview date, and notes are omitted, demonstrating that their absence does not impact the completeness of this command.

`add c/Pixar p/98765432 e/Pixar@example.com t/O jd/Junior Animator intern id/3 months s/1000`

Expected Outcome

![add command example 2](images/UserGuide/addCommandExample2.png)


**More examples:**
- `add c/Grab p/66550000 e/careers@grab.com a/6 Temasek Boulevard t/I jd/Software Developer Intern d/12-04-2024 0900 id/6 months s/1500 n/Grab offers various services like ride-sharing, food delivery and etc. For this interview, I need to revise topics like : Data structures, complexities and algorithms`

- `add c/DBS Bank p/12345678 e/careers@dbs-bank-online.com a/321 Media Lane, Singapore 238163 t/OA jd/Creative Design Intern d/14-04-2024 0900 id/3 months s/1000 n/DBS Bank offer a wide range of banking services, including retail banking, corporate banking, and investment banking. Familiarize yourself with the banking industry and current trends in finance and technology. Showcase your understanding of financial concepts and your ability to apply them in real-world scenarios.`

- `add c/Happy Burger p/98765432 e/HappyBurger@example.com a/311, Clementi Ave 2, #02-25 t/R jd/Software Developer intern d/03-05-2024 1200 id/3 months s/1000`

- `add c/A STAR  p/12345678 e/info@astar-research.org a/456 Science Street, Singapore 117543 t/NR jd/Research Assistant Intern id/6 months s/1200 n/A*STAR is a leading research agency in Singapore, dedicated to advancing science and technology. They conduct research across various fields, including biomedical sciences, physical sciences, and engineering. Be prepared to discuss your research experience, methodologies, and any publications or projects you've worked on.`


### Deleting a contact : `delete`

Deletes a contact by index from the address book.

Format: `delete INDEX`

* Deletes the contact at the specified `INDEX`.
* The index refers to the index number shown in the displayed contact list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd contact.
* `find Happy Burger` followed by `delete 1` deletes the 1st contact in the results of the `find` command.

<div style="page-break-after: always;"></div>

### Editing a contact : `edit`

Edits an existing contact detail in the address book.

1. Begin by typing `edit`, followed by the `INDEX` of the application. 
The index refers to the index number shown in the displayed contact list.
2. Next, include only specific prefix for the fields of the contact you wish to edit in your records. 
At least one of the optional fields must be provided and at most one of each field can be provided.
3. After pressing enter, existing values will be updated to the input values.

<box>

Format: `Edit INDEX c/[COMPANY_NAME] p/[PHONE_NUMBER] e/[EMAIL] a/[ADDRESS] t/[TAG] jd/[JOB_DESCRIPTION] d/[INTERVIEW_DATE] id/[INTERN_DURATION] s/[SALARY]`

</box>
  
<box type="tip">

For `[NOTE]`, please refer to the "Adding a note" section below for more details.
For `[INTERVIEW_DATE]`, if you want to remove a date, just enter `d/` and it will remove that field.

</box>

**Example:**
In this scenario, we've received confirmation of an interview details from a previously unresponsive company, A STAR. 

![edit command](images/UserGuide/beforeEditCommand.png)

To update the status tag from "NR" to "I," please utilize the following command:

`edit 5 t/I`.

Additionally, to include the interview date on 14th of April 2024 at 3pm, use:

`edit 5 d/14-04-2024 1500`.

When both commands are executed together, it will appear as follows: 

`edit 5 t/I d/14-04-2024 1500`. 

This not only alters the tag to "Interview" but also specifies the interview schedule as indicated:
![edit command](images/UserGuide/afterEditCommand.png)

### Viewing a contact : `view`

Views the details of the contact on the view panel in address book.

Format: `View INDEX`

* Views the contact at the specified `INDEX`. The index refers to the index number shown in the displayed contact list. The index **must be a positive integer** 1, 2, 3, …​

Example:
*  `view 3` Displays the company card of the 3rd contact in the list on the view panel.
![view result 3](images/view/view3Result.png)

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## Advanced Commands

### Listing all contacts : `list`

This command shows a list of all internship application entries in the address book sorted in ascending order of interview dates.
Internship application entries with interview dates will be listed first, followed by internship application entries without interview dates.

Format: `list`

Expected Outcome

All internship application entries will be shown on the left side of the window.

![list](images/UserGuide/list.png)

### Locating contacts by name: `find`

Finds contacts whose company names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* All matching results of the find will be displayed in your view panel
* The search is case-insensitive. e.g `shoppa` will match `Shoppa`
* The order of the keywords does not matter. e.g. `Food Panda` will match `Panda Food`
* Only the name is searched.
* Only full words will be matched e.g. `Shopp` will not match `Shoppa`
* Contacts matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Happy Burger` will return `Happy Meal`, `Burger Queen`

Examples:
* `find burger` returns `Happy Burger` and `Sad Burger`<br>
  ![result for 'find burger'](images/find/findBurgerResult.png)


### Adding a Note : `note`

This command will allow you to add & edit notes to an internship company contact. There are 2 ways to execute this command based on your use<br>

Format: `note INDEX`

1. Adding a note when **creating a new company contact**
    - Simply include the note you want in the **add** command using the syntax `n/[NOTE]`
    - `add c/FoodPanda ...other attributes... n/This is a note`

2. Updating a note of an **existing company contact**
    - Suppose you want to edit the note of company contact at index **2**
    - Use the note command as follows : `note 2`
      ![enter note 2](images/note-feature/note_1.png)
    - When you hit enter, it will retrieve the note content of the company contact at index 2 in the command box **as an edit command** :
      ![command executes](images/note-feature/note_2.png)
    - Simply update the note content and hit enter again :
      ![command executes](images/note-feature/note_3.png)
    - The next time you view the contact, the note section will be updated :
      ![command executes](images/note-feature/note_4.png)


<box type="tip">

To clear a note, simply use `edit INDEX n/`

</box>


<box type="warning">

**Caution:**
If you use `edit INDEX n/your updates for the new note`, this **WILL OVERWRITE** the old note of the company contact at `INDEX`<br>
For these kinds of scenarios, make use of the `note INDEX` function !

</box>

### Filtering the data (by tags) : `filter`

Filtering data allows you to narrow down your search results to focus on internship contacts based on their status. 
Use the `filter` command to filter by tag and find exactly the internships that have an interview.

Format: `filter [VALID TAG]`

<box type="info">

Valid Tag Inputs   
- NR: No Reply
- I: Interview
- O: Offered
- OA: Online Assessment
- R: Rejected

</box>

Examples:
- `filter I`
- Filters the list of contacts to only have internship company contacts that have an Interview status
![resultFilter](images/filter/filterIResult.png)

### Sending reminders : `reminder`

Sending reminders is a pivotal practice to uphold organization and ensure timely completion of crucial tasks. 
Although our application presently lacks a built-in reminder feature, fear not! 
You can effortlessly retrieve reminders manually using this command. 
It conveniently displays the interviews scheduled within the upcoming N days, 
keeping you well-prepared and on track.

<box>

Format: `reminder INT`

</box>

**Examples:**
- `reminder 0` : Shows you the interviews you have today.
- `reminder 2` : Shows you the interviews you have in the next two days, including today.
- `reminder 20` : Shows you the interviews you have in the next twenty days, including today.

![reminder command](images/UserGuide/reminderCommand.png)

<box type="tip"> 
This is a quick and easy way to be reminded of the upcoming interviews in order to not miss them.
</box>


--------------------------------------------------------------------------------------------------------------------

## Miscellaneous Commands

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## Storage & Data

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning">

**Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the AddressBook to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.

</box>

--------------------------------------------------------------------------------------------------------------------
## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous InternHub home folder.

**Q**: What is a home folder?<br>
**A**: The home folder is the main directory associated with a user account on a computer. It typically contains user-specific settings, documents, downloads, and other personal files.

**Q**: Does the user know how to open the command terminal/how to change directory (cd) into a folder?<br>
**A**: Users should refer to the documentation or help resources specific to their operating system for instructions on opening a command terminal and navigating to a directory using the `cd` command.

**Q**: How do I run internhub.jar?<br>
**A**: You can run internhub.jar by opening a command terminal, navigating to the directory containing the jar file using the `cd` command, and then typing `java -jar internhub.jar` and pressing Enter.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action       | Format, Examples                                                                                                                                                                                                                                           |
|--------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**      | `add c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL a/[ADDRESS] t/TAG jd/JOB_DESCRIPTION d/[INTERVIEW_DATE] id/INTERN_DURATION s/salary` <br> e.g., `add c/FoodPanda p/12345678 e/panda@food.com a/CBD t/F jd/Front End Intern d/15-04-2024 0900 id/6 months s/500` |
| **Clear**    | `clear`                                                                                                                                                                                                                                                    |
| **Delete**   | `delete INDEX`<br> e.g., `delete 3`                                                                                                                                                                                                                        |
| **Edit**     | `Edit INDEX c/[COMPANY_NAME] p/[PHONE_NUMBER] e/[EMAIL] a/[ADDRESS] t/[TAG] jd/[JOB_DESCRIPTION] d/[INTERVIEW_DATE] id/[INTERN_DURATION] s/[salary]`<br> e.g.,`Edit 2 p/9998765`                                                                           |
| **Find**     | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find foodpanda`                                                                                                                                                                                                  |
| **Note**     | `note INDEX`                                                                                                                                                                                                                                               |
| **List**     | `list`                                                                                                                                                                                                                                                     |
| **View**     | `view INDEX`<br> e.g., `view 3`                                                                                                                                                                                                                            |
| **Help**     | `help`                                                                                                                                                                                                                                                     |
| **Find**     | `find STRING`<br> e.g., `find Grab`                                                                                                                                                                                                                        |
| **Filter**   | `filter I`                                                                                                                                                                                                                                                 |
| **Reminder** | `reminder`                                                                                                                                                                                                                                                 |
