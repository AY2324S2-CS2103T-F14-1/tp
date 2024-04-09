---
  layout: default.md
  title: "John Doe's Project Portfolio Page"
---

<div style="display: flex; justify-content: space-between; align-items: center;">
  <h1>Jawad Afthab</h1>
  <h2>InternHub Project Portfolio</h2>
</div>

<box>

#### Project Overview
* InternHub is a comprehensive project designed to assist Undergraduate students in managing their internship applications. 
* The user interacts with it using a CLI, and it has a GUI created with JavaFX. 
* It is written in Java, and has about 10 kLoC.

</box>

<box light>

#### Technical Skills Utilized in this Project

</box>

In this project, I leveraged a variety of technical skills to develop and maintain the application.
* **Java**
  * Utilized Java as the primary programming language for developing the logic and functionalities of the application.
* **JavaFX**
  * Employed JavaFX framework for building the graphical user interface (GUI) of the application, providing an intuitive and user-friendly experience.
* **Version Control with GitHub & Git**
  * Utilized GitHub as a version control platform along with Git for managing the project's source code, enabling collaborative development, tracking changes, and ensuring code integrity.

<box light>

#### Feature Enhancements

</box>

##### Note Feature

**Issue** : User unable to modify or update _existing_ note content of a contact without **overwriting** the data

**Proposed Solution** : Based on the index, user can retrieve & make updates to the note content of a contact in the command box

**Implementation** : Integrate `NoteCommand` with Model layer & UI component to fetch & update note content

**Challenges**  
  - Implementing a command that communicates with the UI was intricate 
  - Parsing the `CommandResult` to uniquely identify that it is that of a `NoteCommand`

**Benefits**
  - Allows users to efficiently manage and update note content for contacts 
  - Enhance user experience by providing a convenient method to interact with the notes field through the command line

--------------------------------------------------------------------------------------------------------------------

##### Base UI of Company Card

**Issue** : Default UI of a company card does not allow for various fields of a contact to be displayed in a user-friendly manner

**Proposed Solution** : Redesign the layout of the UI for company card to visually organize the data of the contact

**Implementation** : JavaFX file implemented to update the UI independently of other components

**Challenges**
- Getting accustomed to the JavaFX methods to replicate the desired model design
- Integrating a neat design while still maintaining integration of dynamic data
- Analysing for which fields would Label or TextArea be more appropriate

**Benefits**
- Allows users to have a centralised overview of all the data pertaining to a contact
- Visually striking elements like _interview date_ emphasises key details of that contact

<div style="page-break-after: always;"></div>


<box light>

#### Documentation

</box>

##### User Guide

- Added documentation for features `filter` & `view` [\#72]()
- Quick start additions for new users [\#90](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/90)
- Included additions to `glossary` to allow for users to understand technical terms [\#188](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/188)
- Cosmetic tweaks on overall layout of documentation & inclusion of boxes for tips, info and warning [\#105](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/105)

--------------------------------------------------------------------------------------------------------------------

##### Developer Guide

- Added class, sequence & activity diagrams for `NoteCommand` [\#85](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/85), [\#Need to link pr]()
- Implemented `Use Case` scenarios [\#30](https://github.com/AY2324S2-CS2103T-F14-1/tp/pull/30)

<box light>

#### Project Management

</box>

- **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s2.github.io/tp-dashboard/?search=jawad280&breakdown=true)
- Managed releases `v1. (trial)`, `v1.3 (final)` (2 releases) on GitHub
- Creation of Milestones `v1.3b` and `v1.4` coupled with related general issues for respective milestones

<box light>

#### Community

</box>

- PRs reviewed (with non-trivial review comments): [\#12](), [\#32](), [\#19](), [\#42](),
- Contributed to forum discussions (examples: [1](https://github.com/nus-cs2103-AY2324S2/forum/issues/473#issuecomment-1980799998))

--------------------------------------------------------------------------------------------------------------------
