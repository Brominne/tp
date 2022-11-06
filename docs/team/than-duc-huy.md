# Than Duc Huy - Project Portfolio Page

## Overview

I contributed to this project

## Summary of Contributions

### Features

#### Add Recipe

- What: Add new recipe

- Justification

I initially made the CLI add functionality. I proposed the GUI Add functionality because it will more user-friendly and
a faster way to add recipe for fast typer as the amount of specific flags worsen the user experience

#### GUI Functionality (Add, Edit)

- What: Add the component that call the GUI and the interaction between GUI, CLI
- Justification:

To make the transition between the GUI and CLI workflow seamless. Since the functionality of edit and add in GUI mode
are the similar, the GUI component is also used for the Edit Command (whose CLI functionality was handled
by [William](snuckerzlol.md))

- Highlight:

Added other useful sub-features to make the GUI experience useful

- Template file: to give a user guide on how to use add
- Temporary file: remember the state of the invalid version of the file that the user input, allowing the user to revise
  quickly without re-write the whole thing again
- Save and Exit option: Allow the user to abort the editing without saving
- Option to fix invalid file without exiting the `/add` command: When the user text input is cannot be parsed, it will
  be saved in the temporary file and a question will be asked to the user on whether they want to change without having
  to type `/add` or `/edit` to access the command again

#### Text to Recipe Parsing

- What: A parser that parse text file generated from the GUI into a valid Recipe that can be stored in the Recipe Object
  by the program
- Justification:

Because the user can type virtually anything in a text file, a robust parser to a valid Recipe Object that the program
can understand is important

- Highlight:

The parser is strict but allow the user some freedom to key in the data

- Strict: only 4 headings as stated in the template is allowed
- Freedom:
    - The headings can be in any order (preferably following the template)
    - (Excessive) Whitespace will not affect the parsing
    - Whitespace in the DESCRIPTION will not be deleted, allowing the user to be creative in writing Recipe description.

#### Storage: interaction with the data files

- What: storage Recipe data from the mode
- Justification:

The bulk of the code for Storage is made by [Qian Hui](qianz-z.md). However, due to my GUI proposal, the complexity of
storing the data evolved over time and I helped to code various helper functions to ensure that the interaction between
the data files and the program is seamless

### Code Contribution [Reposense Link](https://nus-cs2113-ay2223s1.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2022-09-16&tabOpen=true&tabType=authorship&zFR=false&tabAuthor=Than-Duc-Huy&tabRepo=AY2223S1-CS2113-T18-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

### Project Management

- Propose changes direction from pure CLI to hybrid CLI-GUI to suit the use case
- Communicate the change in direction with TAs and Professor for approval
- Contributed frequently for various milestones

### Documentation

- User Guide
    - Major revision of the content after PED
    - Give suggestion of for the parsing of other functionality
    - Command Summary
- Developer Guide
    - Add functionality
    - GUI functionality
    - Text to Recipe Parsing
    - Text to Recipe List Parsing
    - Add detailed manual testing for GUI and Storage features