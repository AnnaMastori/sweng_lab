# sweng_lab
This project contains modules that are part of the lab assignments for the SEIP course. 

![Build Status](https://github.com/AnnaMastori/sweng_lab/actions/workflows/maven.yml/badge.svg)


## Project Structure
This repository consists of a parent Maven project and one sub-project (module).

1) [Grades Histogram](gradeshistogram) - creates a histogram from a given set of grades

2) [Unit testing](unittesting/README.md) - does math operations and has the unit tests

3) [Source Code Analysis](sourcecodeanalyzer/README.md) - calculates metrics (e.g Loc) of a given file

Execute the following command in the repository root directory in order to build all modules. 
```
mvn package
```
This command generates a seperate jar file in each module's corresponding target (```module/target```) directory.  

### Grades Histogram
This module requires one runtime dependency which is packaged in the main jar (fat-jar). To create a fat-jar you need to use the ```maven-assembly-plugin``` plugin and also define the class that is the main entry point of the system (the class that contains the main method). 
```
<plugin>
    <artifactId>maven-assembly-plugin</artifactId>
    <configuration>
        <archive>
            <manifest>
                <mainClass>gradeshistogram.HistogramGenerator</mainClass> 
            </manifest>
        </archive>
        <descriptorRefs>
            <descriptorRef>jar-with-dependencies</descriptorRef>
        </descriptorRefs>
    </configuration>
    <executions>
        <execution>
            <id>make-assembly</id>
            <phase>package</phase>
            <goals>
                <goal>single</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

The produced jar is located in the target directory and can be executed as following:
```
java -jar gradeshistogram\target\gradeshistogram-jar-with-dependencies.jar
Note that the gradeshistogram\target\gradeshistogram.jar is not executable. 
