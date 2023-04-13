# SEIP Lab Assignments

<h1 align="center">
	<img height="171"  width="800" src="media/dmst-aueb.jpeg" alt="">
</h1>

The main purpose of the current repository, is the submission of the lab
assignments for the needs of the of Software Engineering in Practice course. 
Build automation tools, unit testing and design patterns, are some key 
demonstrative topics that will be covered through the practical assignments.

## Maven Assignment

Getting started with the Maven build automation tool, we structure a parent-module project.
Being dependant on the JFree java library, the module provides the functionality stated below:

1. Embedded in HistogramGenerator class, readGrades reads grades as integers, 
included in a txt file. The grades file is passed as command line argument
at runtime.
2. Provided with the grades, generateChart method generates the histogram, that being a XYLineChart chart.
3. The main method needs to call the above methods, in order to present the chart.


### Getting started with the Maven project

#### Software Prequisities

- [Git](https://git-scm.com/)
- [Java](https://www.java.com/en/)
- [Maven](https://maven.apache.org/)


#### Project Structure

Implementing project inherintance, we follow an hierarchical parent - child structure, with:

- [seip-lab](https://www.github.com/demetres12/seip-lab), being the **parent**, and
	- [gradeshistogram](https://www.github.com/demetres12/seip-lab/tree/development/gradeshistogram), being the **module**

##### Structure of the module before building
<h1 align="center">
	<img height="600"  width="500" src="media/module-tree-before-build.png" alt="">
</h1>

##### Structure of the module after building

<h1 align="center">
	<img height="600"  width="500" src="media/module-tree-after-build.png" alt="">
</h1>


#### What to do?

1. First you will need to clone the maven project "seip-lab", so you can obtain the source code locally. We are going to do that through the terminal. For Unix-based os open the utility application "Terminal", while for MS Windows use a Unix-like environment, like CygWin.

```bash
git clone https://github.com/demetres12/seip-lab.git
```

2. Change directory and move to seip-lab. You can track your working directory, via the `pwd` command.

```bash
cd seip-lab
```

3. Build the project, executing the following commands, that represent the key default lifecycle phases.

```bash
mvn compile
```
```bash
mvn package
```

- Note that the `mvn package` command, includes the compilation of the project, so `mvn compile` command is not mandatory, but it comes in handy when we want to focus on compilation errors.
- In case you need to remove all files generated by the previous build, execute the command `mvn clean`, and notice that the target dir will be removed. Combining lifecycles is also a common case,(e.g.`mvn clean package`).
- Execute tests on compiled code, with the `mvn test` command.

4. The build's output is placed under the target dir, containing the fat jar, which will be executed via the following command.

```java
java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar gradeshistogram/src/main/resources/grades.txt
```
Notice that the `jar-with-dependencies.jar` is the executable.




