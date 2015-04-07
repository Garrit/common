Common Java Components for Garrit
=================================

[![Build Status](https://secure.travis-ci.org/Garrit/java-common.svg?branch=master)](https://travis-ci.org/Garrit/java-common)

This repository contains Java classes modeling messages to be exchanged between
Garrit services. It also provides problem definition parsing.

Installation
------------

After checking out the repository, it can be built with
[Maven](http://maven.apache.org/):

```
mvn install
```

Usage
-----

To use the components provided by this project, include a reference to it in
your POM:

```xml
<dependency>
    <groupId>org.garrit</groupId>
    <artifactId>java-common</artifactId>
    <version>1.0.0</version>
</dependency>
```