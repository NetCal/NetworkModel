# NetworkModel
A generic model that can be extended to model any communication network no matter the protocol it uses.

# Development with Eclipse

This small guide assumes you have installed Eclipse 2019-06 (modelling version!), a Java 12 JDK and a git command line client.

## Setting up the Project in Eclipse
* Navigate to you Eclipse workspace directory, clone the NetCal/NetworkModel repository to it and pull the code.

* In Eclipse, navigate to `File > New > Java Project`, use the name `NetworkModel` and click `Finish` (you do not need to create a module-info in the next dialog). This creates a `DNC` project in your workbench.

* Right-click on `NetworkModel` and select `Configure > Convert to Maven Project`. Your workspace will be rebuilt accordingly.

* In CLI run command 'mvn compile' to generate the model code

* Please do not make changes in model code but on the UML model itself

* To edit the model open 'model' directory, open the tree network.aird file and in desgin open the 'network' class diagram
