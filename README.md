# Rep Max Calculator
Maven repository of a refactored version of my 2015 rookie project, a fitness calculator written in JavaFX. One of my first ever JavaFX projects. 
Originally built on Microsoft Windows 8.1. Refactored version has only been built/tested on SUSE Linux.

# Platform 
- Any supporting the Oracle JVM for Java SE 10+.

# Requirements
- Apacha Maven 3.5.2
- Java SE 10.
- javapackager requirements:
	- dpkg-deb package for building debian executables.
	- rpm-build package for building SUSE/RHEL executables.
	- macOS

# Maven Tasks
- mvn package - Build Application

# How To Run
- Call java -cp target/RepMaxCalculator-1.0-SNAPSHOT.jar com.adriandavid.me.RMC at root.
  This is presently the only solution that will copy the image resources.
- java -jar/double-click on executable-jar in dist/jar.

# Known Problems
- Standalone JAR is missing image resouces in classpath (05/11/2018).
- RPM package does not work properly (05/11/2018) on SUSE Linux.
- Several others.

# Execution Screenshot
![alt text](https://raw.githubusercontent.com/afinlay5/RepMaxCalculator/master/run.png)
![alt text](https://raw.githubusercontent.com/afinlay5/RepMaxCalculator/master/run2.png)

