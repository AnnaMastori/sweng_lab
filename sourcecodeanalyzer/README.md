### Source Code Analyzer
This module contains classes that do calculations for metrics of java source code files eg Loc. It also has the corresponding tests. The testing is performed using the junit framework, therefore it has the following dependency.

```
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
```

### Packages
 
**sourcecodeanalyzer**

 The file is read and analyzed and the metrics are exported.
 
 

**demo**
 
 This package has the DemoClient class.

---
 
## Build Instructions

1. Build the executable Java application with: 
   
	`mvn package jacoco:report`

2. Run the executable by executing
   
	`java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4` 

	were args translate to: 	

	- arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
	- arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
	- arg2 = “SourceCodeLocationType” [local|web]
	- arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
	- arg4 = “OutputFileType” [csv|json]
  
	Example: 

	`java –jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv`
	
---

## Solution Overview

There are three primary dimension in the system : 

 **source code analyzer type**

 **source file reader type**

 **metrics exporter type**

To redesign the system based on the SOLID principles, the following design patterns wil be used:
1. The **Strategy** design pattern, to make the dimensions that were mentioned above more extensible and independent from each other, as well as make the addition of dimension-specific functionality more easy.
2. The **Factory** design pattern, to be used as a front- facing interface, that will make the communication with the dimensions more simple.
3. The **Null Object** design pattern, to extend the above-mentioned dimensions, in order to enable the handling of null cases.
4. The **Facade** design pattern, to mask the complexity of the system and hide the implementation details from the client.


The class diagram of the final version of the system is displayed below 
![Class Diagram](src\main\resources\UMLclass.png)

---

## Implementation of the design patterns

Below there is the explanation of every modification that was made in the source code and the pattern that it is associated with.

### Apply the Strategy and Factory pattern on the `MetricsExporter`class

The Strategy pattern was applied to the `MetricsExporter ` class, in order to separate the behavior of the exporter according to the input file type and make it more extensible to support new export file types in the future. The `MetricsExporter` class was replaced by a `MetricsExporter` interface. The classes that were introduced to implement the interface are `CSVMetricsExporter` and the `JsonMetricsExporter`. Each class contains  the `writeFile` method, which is different for every output file type. The Factory pattern is selected to improve the design of the system by hiding the instantiation logic from the `DemoClient` class. Firstly, a `MetricsExporterFactory` class is created to be used, whenever there is a case where we need to determine which type of exporter we will use. If the type of the exporter is invalid an exception is thrown and no instance of the `MetricsExporter` is created.

**Pros:** The exporters are extensible and new file types can be supported by the creation of a new class that implements the `MetricsExporter` interface. Also, new functionality according to the file type can be introduced easily. The instantiation logic is hidden from the `DemoClient` class. Because the null object pattern is not applied, the code errors can not be hidden.


### Apply the Strategy, Factory and Null Object patterns on the `SourceFileReader` class

The `SourceFileReader` class is replaced by the `SourceFileReader` interface. The methods `readFileIntoList` and `readFileIntoString` are implemented accordingly in the classes that implement the interface. The `WebFileReader` class and The `LocalFileReader` class implement the `SourceFileReader` interface and represent where the file that contains the source code is located locally. In addition to the above classes, a `NullSourceFileReader` class also implements the `SourceFileReader` interface by covering the case where the file path is invalid. This way, the system handles the null case by letting the program terminate without interruptions. The `SourceFileReaderFactory` class is responsible for determining the type of the source file reader class that should be used.

**Pros:** The structure of the system is now improved, as new readers can be easily added by implementing the `SourceFileReader` interface. The use of the Factory pattern provides an easy interface that is used to determine the type of reader that will be used, while the use of the Null Object pattern contributes to a more easy handling of null cases.

### Apply the Strategy, Factory, Facade and Null Object patterns on the `SourceCodeAnalyzer` class

The `SourceCodeAnalyzer` class was replaced by a `SourceCodeAnalyzer` interface. The interface groups the methods that calculate the metrics and is implemented by the `RegexAnalyzer` and `StrcompAnalyzer` classes. A `NullSourceCodeAnalyzer` class also implements the interface, according to the Null Object design pattern. This class represents the null case, where the input that was given as an analyzer type is invalid. A `SourceCodeAnalyzerFactory` class is also created to handle the creation of the source code analyzer.

**Pros:**  New readers can be easily added by implementing the `SourceCodeAnalyzer` interface. The use of the Factory pattern provides an easy interface that is used to determine the type of analyzer that will be used and the use of the Null Object pattern helps to handle the case where the input for the type of the source code analyzer is invalid.

**Cons:** The implementations of the `SourceCodeAnalyzer` and the `SourceFileReader` are not completely independent.

### Apply the Facade design pattern to the `SourceCodeAnalyzer`

The Facade design pattern could improve the design of the system by hiding all of the implementation-specific information from the client.
To implement the Facade design pattern, an `SourceCodeAnalyserFacade` class is introduced. The class has an `exportMetrics` method, that performs all of the system operations during the code analysis process.

**Pros:** The complexity of the system is hidden from the client class and the system is independent from the client.


