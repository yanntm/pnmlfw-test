# pnmlfw-test
A basic maven setup for a Java application using PNMLFW

## Motivation

We might want to use PNMLFW from a basic non eclipse application. 
Unfortunately our dependency system is heavily eclipse/tycho biased.

This project gives some basic setup that allows to build using maven and run using java, without any eclipse.

## How to build

Basically call maven.

```
mvn clean generate-sources package install 
```

## What is built

You get the result in target, a jar with your code, and a `lib/` folder that contains all our transitive dependencies.

Example invocation :

```
cd target
java -cp "TestPNML-1.0.0-SNAPSHOT.jar;lib/*" fr.test.Testit ../model.pnml
```

So basically add all the jar in the lib folder to the classpath.


## License

Built as an example by Yann Thierry-Mieg, Sorbonne Université & CNRS, 2023.

Released under EPL, so do what you want with it.