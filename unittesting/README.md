### Unit testing
This module contains classes that do math calculations and file handling. It also has there corresponding tests. For the tests the junit framework is used and therefore it has junit as a maven dependency.

```
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
```

### Packages
 
### math
 The math calculations are performed in the MyMath and the ArithmeticOperations classes. The tests cover their normal functionality, edge cases and the exceptions they throw. For the tests the project uses the junit framework.

### io
 
 This package has the FileIO class that reads a file and returns the integers it contains.