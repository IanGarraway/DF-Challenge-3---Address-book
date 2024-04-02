# Challenge 3 - Address Book Challenge (Java)

```
            /;
           / |'-,.
          /  '    `"---,.__
         /  '    ,'     ,  '"--,"|
        /  '    ,     ,'     ,"::|
       /  '   ,'    ,      ,"::::|
      /  '   ,    ,'     ,"::::::L
     /  '  ,'   ,'     ,"::::::::L
    /  '  ,    ,     ,":::::::::J
    k-,._    ,'   _.":::::::::::J
     \.  `"----'"".J::::::::::::|
      \.    .-,    .L:::::::::::|
       \.  (       .J:::::::::::!
        \.  `--     .L:::::::::/
         \.   .-.   .|::::::::/
          \. (   )  .J:::::::/
           \. `-'    .L:::::/
            \.  L    .|::::/
             \. !__  .J:::/
              \.  __  .L:/
               \. L_) .|/
                `-,__,-'    
```

## Introduction

After the resounding success of the Secret Diary, DFCorp are now looking to extend their range of products and have decided to create an Address Book application.  The address book will allow users to access an independent application to store their contacts in.

> Before proceeding, ensure that you have a solid understanding of why the customer needs this software and the benefits that it will bring to them (See Task 1)

### Core Features

The Business Analyst team, working with the client has identified the following features that should be implemented in the first release of the application:

- The user should be able to add a contact to the address book
  - A contact should have at least a name, phone number and email address
- The user should be able to search for a contact by name and have the results displayed
- The user should be able to remove a contact from the address book
- The user should be able to edit a contact's details
- Duplicate phone numbers or email addresses should not be allowed, i.e. no two contacts should have the same phone number or email address
- The user should be able to view all contacts in the address book
- The user should be using a console interface to interact with the application

> **Note:** The use of a generative AI tool to complete tasks relating to the specific requirements above is NOT allowed.  All work here should be your own.

### Additional Features

In addition to these core features, the client has the following requests for functionality that they would like to see in the application if you have time:

- The user should be able to search for a contact by phone number and have the results displayed
- The user should be able to search for a contact by email address and have the results displayed
- The user should be able to search for a contact by name, phone number or email address and have the results displayed in alphabetical order
- The user should be able to delete all contacts at once, confirming that they want to do this before proceeding

> **Note:** The use of a generative AI tool to help complete tasks relating to these further requirements is allowed but should be clearly documented.

---

## Tasks

1. Explain why the customer needs this software and the benefits that it will bring to them.  You should include the following in your explanation:
   - The problem that the software will solve
   - The benefits that the software will bring to the user
   - The impact that the software will have on the customer's business
2. From the requirements listed above, create user stories that break the functionality required down
3. From the user stories, create domain models and/or class diagrams for the core features of the application.  You should include the following in your domain models:
   - The classes that you will need to create
   - The data types of each attribute
   - The access modifiers of each attribute and method
   - The return types of each method
   - The relationships between the classes
4. Using a test-driven approach, implement the core features of the application.
5. Create a program that will put some contacts in the application, run in the console and take the user's input to navigate a menu to use the features

---

## Acceptance Criteria

DFCorp has requested that the following criteria are met:

- The application meets at least the core features listed above
- - The application is able to be run through the console and the user is able to navigate the menu
- The domain models and/or class diagrams are clearly documented and show the relationships between the classes
- The application is tested using a test-driven approach
- The code is written clean and uses appropriate conventions found in Java

---

## Tips

- Commit regularly to GitHub with clear commit messages - write a failing test, pass the test, commit, etc
- You should put your domain models and test plans in the markdown file in the `docs` folder, if you decide to use some form of Kanban board to track your progress, you should include a screenshot of this in the markdown file
- You should use the [Java Coding Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html) when writing your code
- You should use the [JUnit 5](https://junit.org/junit5/docs/current/user-guide/) testing framework to test your code with any additional libraries you feel are necessary (e.g. Mockito, coverage tools, etc)
- Your source code should go into the `src` folder and follow an appropriate package structure
- Your test code should go into the `test` folder and follow an appropriate package structure
- Add comments to your code to document its intent where necessary

---

## Grading Criteria

### Digital Futures Software Engineering Progression Management Framework

In this Challenge, you will have the opportunity to demonstrate the following competencies from the Software Engineering Progression Management framework:

---

#### Writes software that meets a user’s functional and non-functional requirements

|               | Description                                                                                                                                                                                                         | Where assessed?                 |
| ------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------- |
| ***Level 2*** | The engineer can code a solution that functionally and non-functionally meets requirements and can review their own code identifying opportunities to improve it             | Code submitted                  |
| ***Level 3*** | The engineer can code a solution that functionally and non-functionally meets requirements for several **simple** requirements             | Code submitted                  |

---

#### Can interpret business requirements into coding requirements
  
|               | Description                                                                                                                                                                                                  | Where assessed?                 |
| ------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------- |
| ***Level 1*** | The engineer can create **simple user stories** from user requirements (i.e. clearly defined story using “As a”, “Able to”, “So that” or “Given/When/Then” structure that could be solved using simple code) | Markdown file in `docs` folder  |
| ***Level 2*** | The engineer can create **domain models** for **simple user stories**                                                                                                                                        | Markdown file in `docs` folder  |
| ***Level 2*** | The engineer can create **domain models** for **simple user stories** using **simple, suitable prompts** and a **Generative AI tool** (such as Chat-GPT)                                                     | Markdown file in `docs` folder  |
| ***Level 3*** | The engineer can create **domain models** and/or apply object-oriented principles in them for simple user stories                                                                                                                                          | Markdown file in `docs` folder and code submitted |

---

#### Develop code through Test-Driven Development and/or Behaviour Driven Development

|               | Description                                                                                                                                                                                                 | Where assessed?                        |
| ------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------- |
| ***Level 2*** | The engineer can write **tests** and/or **working code** that demonstrates that the **TDD process** has been followed through a commit history with clear commit messages                                   | Code submitted - GitHub commit history |
| ***Level 3*** | The engineer can write **tests** and/or **working code** that pass covering the **main functionality** of the code using a standard, **third-party** testing framework | Code submitted |
| ***Level 3*** | The engineer can write **tests** and/or **working code** that demonstrates the use of a **Generative AI** tool to identify and write test cases and/or code for tests | Code submitted and Markdown file in `docs` folder |
| ***Level 4*** | The engineer can write **tests** and/or **working code** that passes tests that cover **some edge cases** of the code **that they have identified** using a standard, **third-party** testing framework | Code submitted |
| ***Level 4*** | The engineer can write **tests** and/or **working code** that demonstrates the use of a **Generative AI** tool to identify and write tests for **further edge cases** | Code submitted and Markdown file in `docs` folder |
| ***Level 5*** | The engineer can write **tests** and/or **working code** that passes tests that cover most **edge cases** of the code using a standard, **third-party** testing framework | Code submitted and Markdown file in `docs` folder |
| ***Level 5*** | The engineer can write **tests** and/or **working code** that demonstrates the use of a **Generative AI** tool to identify and write tests for **further edge or corner cases** | Code submitted and Markdown file in `docs` folder |

---

#### Writes clean code

|                | Description                                                                                                                                                                                                       | Where assessed? |
| -------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------- |
| ***Level 1***  | The engineer can write code that is **functionally correct** using **simple** coding structures (loops, conditionals, data structures, etc)                                                                       | Code submitted  |
| ***Level 2***  | The engineer can write code that is **functionally correct** using applying **some** principles of clean-coding (e.g. 5-line functions, no nested loops or conditional statements)                                | Code submitted  |
| ***Level 2***  | The engineer can write code that is **functionally correct** and has been made **more efficient** by a **Generative AI** tool | Code submitted and Markdown file in `docs` folder |
| ***Level 2***  | The engineer can write code that is **functionally correct** and has **demonstrated** the use of **Generative AI** to help within the **debugging** process | Code submitted and Markdown file in `docs` folder |
| ***Level 3***  | The engineer can write code that is **functionally correct** using applying **single responsibility** and other clean-coding practices (e.g. **abstraction**) to **some** of the classes/functions/methods and blocks of code | Code submitted  |
| ***Level 3*** | The engineer can write code that is **functionally correct** and can use **Generative AI** to help **refactor** code | Code submitted and Markdown file in `docs` folder |
| ***Level 4***  | The engineer can write code that is **functionally correct** using applying **single responsibility** and other clean-coding practices (e.g. **abstraction**) to **most** of the classes/functions/methods and blocks of code | Code submitted  |
| ***Level 4*** | The engineer can write code that is **functionally correct** and can use **Generative AI** to help **document their own** or the **code of others** | Code submitted and Markdown file in `docs` folder |
| ***Level 5***  | The engineer can write code that is **functionally correct** using applying **single responsibility** and other clean-coding practices (e.g. **abstraction**) to all of the classes/functions/methods and blocks of code to create **loosely-coupled**, **highly-cohesive** code | Code submitted and Markdown file in `docs` folder |

---

### Digital Futures Professional Skills Progression Management Framework

In this Challenge, you will have the opportunity to demonstrate the following competencies from the Professional Skills Progression Management framework:

---

#### Communications

|               | Description                                                                                            | Where assessed?                |
| ------------- | ------------------------------------------------------------------------------------------------------ | ------------------------------ |
| ***Level 1*** | Can express themselves fluently in both verbal and written English                                     | Markdown file in `docs` folder |
| ***Level 1*** | Demonstrates attentive listening                                                                       | During assignment introduction |
| ***Level 2*** | Convey technical information to technical stakeholders in both verbal and written forms                | Markdown file in `docs` folder |
| ***Level 2*** | Creates content to a professional standard that is concise, well-structured, and grammatically correct | Markdown file in `docs` folder |

---

#### Business Awareness

|               | Description                                                                                                                                  | Where assessed?                                    |
| ------------- | -------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------- |
| ***Level 1*** | Recognises importance of customer/stakeholder-centricity                                                                                     | Markdown file in `docs` folder                     |
| ***Level 2*** | Applies basic requirement elicitation techniques and can gather and document simple requirements that align towards the business’ objectives | Markdown file in `docs` folder                     |
| ***Level 3*** | Creates clear project documentation detailing project objectives, approach and results                                                       | Markdown file in `docs` folder and in code files   |
| ***Level 3*** | Applies prioritisation techniques to ensure resource efficiency and project alignment within timescales and business objectives              | Markdown file in `docs` folder (Trello screenshot) |

---

#### Professional Development (Assessed after submission via Self-Review)

|               | Description                                                                                                    | Where assessed?                  |
| ------------- | -------------------------------------------------------------------------------------------------------------- | -------------------------------- |
| ***Level 1*** | Demonstrates self-awareness by identifying areas of strength and self-improvement (via review)                 | Review comments after submission |
| ***Level 2*** | Applies self-reflective frameworks to highlight actions, decisions, and experiences to learn from (via review) | Review comments after submission |
| ***Level 2*** | Constructs SMART goal based on their identified areas of improvement | SMART goal review |
| ***Level 2*** | Achieves a self-made SMART goal | Previous SMART goal review |
| ***Level 3*** | Demonstrates consistency in achieving small to medium (<2 weeks) SMART goals (x3 goals)  | SMART Goal review |
| ***Level 3*** | Demonstrates ability to experiment with new techniques or approaches that work best for them | SMART Goal review |

---

#### Adaptability

|               | Description                                                                                       | Where assessed?                                  |
| ------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------ |
| ***Level 2*** | Understands fundamental Agile terms, such as User Stories, Scrum, Kanban, and the Agile Manifesto | Project files and Markdown file in `docs` folder |
| ***Level 3*** | Demonstrates experimentation with different approaches, tools, or methods                         | Project files and Markdown file in `docs` folder |

---

## Submission

Your Challenge attempt should be submitted via commits to the forked project from GitHub Classroom.  Your trainer will have supplied you with the appropriate link to do access this, you need to take no further action on this platform.  To indicate that you have completed the Challenge, you should you the Assignment Submission link in the Challenge course for your Cohort on Noodle.  The Progression Management Frameworks will be assessed via a marking rubric in Noodle and you will be able to see how you performed in each competency.

You are not permitted to collaborate with anyone to complete this challenge.  You should complete the *Core Functionality* using traditional skills, knowledge and understanding of software engineering and all code submitted for this should be your own.  You may use a *Generative AI tool* to help you complete the *Additional Functionality* but this should be clearly documented.

---

## Feedback

After submission of your challenge attempt, your trainer will record and submit feedback in Noodle and/or via GitHub for comments in your code .  You will then be able to view this feedback via Noodle and your GitHub account.

Your trainer will also provide general feedback to the cohort via the Discord channel.

---
