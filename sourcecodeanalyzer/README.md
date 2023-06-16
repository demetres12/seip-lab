# Design Patterns Assignment

# Table of contents
- [Introduction](#introduction)
- [Overview on Design Patterns](#overview)
- [Creational Design Patterns](#creational)
  - [Factory Method](#factorymethod)
- [Structural Design Patterns](#structural)
  - [Bridge](#bridge)
- [Behavioral Design Patterns](#behavioral)
  - [Strategy](#strategy)
  - [Null Object](#nullobject)
- [Step by Step](#stepbystep)


## Introduction <a name="introduction"></a>

The purpose of the current module is the refactoring & redesign processes that should be performed
upon an existing poorly designed project. Identifying several design principles violation we implement
both creational, structural and behavioral design patterns, to redesign the system properly.
 Following up to that approach, we reconstruct a `maintenable`, `reusable` and `scalable` codebase that:
 
 - records low levels of `rigidity` and `fragility`
 - avoids unwanted complexity and repetition, by including additional abstraction levels
 - follows SOLID principles

 ---

### System design before refactoring

<h1 align="center">
	<img height="400"  width="600" src="../media/system-design-before-refactoring.png" alt="">
</h1>


### System design before refactoring

<h1 align="center">
	<img height="400"  width="600" src="../media/system-design-after-refactoring.png" alt="">
</h1>

#### About the refactored system structure

- We propose the creation of three sub-packages (i.e. `reader`, `calculator` and `exporter`) under the `codeanalyzer` package
- As you may notice several abstraction levels were considered in order to follow the interface segregation principle, where many specific interfaces are better than general-purpose abstraction. (see `AnalysisType`, `MetricsExportFormatter` and `FileContentReader`)
- By refactoring the codebase, classes are now responsible for one operation and serve a single purpose. Furthermore, the current entities are open for extension, but not for modification.
- The design patterns applied are discussed below.

## Overview on Design Patterns <a name="overview"></a>

Design Patterns can be defined as typical solutions to common problems in software design. We may think
of them like a blueprint that we can customize to solve a particular design problem in our code.
They propose a way to address recurring design challenges and guide developers in creating well-structured
and maintainable code.

## Creational Design Patterns <a name="creational"></a>

### Factory Method <a name="factory"></a>

#### Intention and problem solving

#### Implementation

#### How does it affect our system?

##### Benefits

##### Trade-offs




## Structural Design Patterns <a name="structural"></a>

### Bridge <a name="bridge"></a>

#### Intention and problem solving

#### Implementation

#### How does it affect our system?

##### Benefits

##### Trade-offs


## Behavioral Design Patterns <a name="behavioral"></a>


### Strategy <a name="strategy"></a>

#### Intention and problem solving

#### Implementation

#### How does it affect our system?

##### Benefits

##### Trade-offs


### Null Object <a name="nullobject"></a>

#### Intention and problem solving

#### Implementation

#### How does it affect our system?

##### Benefits

##### Trade-offs





## Step By Step <a name="stepbystep"></a>

1. Initially, it's recommended to take a look at the main [README](https://github.com/demetres12/seip-lab/blob/development-2/README.md), in order to get familiar with Maven's lifecycles.

2. Moreover, there is a detailed and explanatory overview on Unit Testing located in the unittesting's module [README](https://github.com/demetres12/seip-lab/blob/development-2/unittesting/README.md).

Executing the module requires the following steps:

1. Build the executable Java application with:

```bash 
	# clean --> It comes in handy when we need to clean the previous build
	# jacoco:report --> Generates data reports regarding the code coverage levels
	mvn clean package jacoco:report
```

2. Run the executable by executing

```bash 
	java -jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
```

Where args translate to:

```	
	arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
	arg1 = “sourceCodeAnalysisType” [regex|strcomp]
	arg2 = “SourceCodeLocationSourceType” [local|web]
	arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
	arg4 = “OutputFileType” [csv|json]
```

Example given:

```bash
	# Be aware that your working directory is the one including the pox.xml configuration file
	java -jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv
```

