# Transformation
Testability Transformation Task

This is a maven project developed using Java 11. The main purpose of this project is to use [Spoon Library](https://github.com/INRIA/spoon) to transformed a source code given in Java language to desired output java file. In this project our main focus is to remove a flag inside the input file.

# Technologies Used ( Pre-Requisites) 
* Java 11
* Maven 3.6.3
* Spoon Core 8.2.0
* IntelliJ IDEA Ultimate 2020  or any other IDE with Maven Support.

# How to Run
* git clone https://github.com/muhammadIkramUlHaq/Transformation.git or Download the Project.
* Navigate to Project Directory. `cd Transformation`. 
* Compile the Project.
  `mvn clean` 
  `mvn compile`.
* `cd /src/main/java`. Run TaskRunner in IntelliJ or any other IDE.

# Output
If your TaskRunner is executed without any error. Your `src/main/java/FlagRemovalProcessor` will be executed on your `Input.java` located under `/src/main/resources/src/`.

You can find the generated transformed java file under `/target/transformed/` with `Task.java`. 
