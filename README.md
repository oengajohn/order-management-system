# Java EE 7 Samples #


This workspace consists of Java EE 8 Samples and unit tests. They are categorized in different directories, one for each sample database.

Some samples/tests have documentation, otherwise read the code.


## How to run? ##

Samples are tested on Wildfly and more using the Arquillian ecosystem.

A brief instruction how to clone, build, import and run the samples on your local machine @oengajohn provides in this sample video https://youtu.be/I8t1TLSeEBw

Only one container profile can be active at a given time otherwise there will be dependency conflicts.

There is 1 available container profile, for 2 different servers:

* WildFly

    * ``wildfly-ci-managed``

      This profile will install a Wildfly server and start up the server per sample.
      Useful for CI servers. The WildFly version that's used can be set via the ``wildfly.version`` property.

    * ``wildfly-embedded``

      This profile is almost identical to wildfly-ci-managed. It will install the same Wildfly server and start up
      that server per sample again, but instead uses the Arquillian embedded connector to run it in the same JVM.
      Useful for CI servers. The WildFly version that's used can be set via the ``wildfly.version`` property.

    * ``wildfly-remote``

      This profile requires you to start up a Wildfly server outside of the build. Each sample will then
      reuse this instance to run the tests.
      Useful for development to avoid the server start up cost per sample.

    * ``wildfly-swarm``

      This profile uses WildFly Swarm, which allows building uberjars that contain just enough of the WildFly
      application server. Here, the parts of WildFly that are included are selected based on inspecting the application
      and looking for the Java EE APIs that are actually used. The WildFly Swarm version that's used can be set via
      the ``wildfly.swarm.version`` property.


* `-Dwildfly.version=8.1.0.Final`

  This will change the version from the current one (e.g. 10.1.0.Final) to 8.1.0.Final for WildFly.




**To run them in the console do**:

1. In the terminal, ``mvn test -fae`` at the top-level directory to start the tests for the default profile.

When developing and runing them from IDE, remember to activate the profile before running the test.

To learn more about Arquillian please refer to the [Arquillian Guides](http://arquillian.org/guides/)

**To run only a subset of the tests do at the top-level directory**:

1. Install top level dependencies: ``mvn clean install -pl "test-utils,util" -am``
1. cd into desired module, e.g.: ``cd jaspic``
1. Run tests against desired server, e.g.: ``mvn clean test -P liberty-ci-managed``


## How to contribute ##

With your help we can improve this set of samples, learn from each other and grow the community full of passionate people who care about the technology, innovation and code quality. Every contribution matters!

There is just a bunch of things you should keep in mind before sending a pull request, so we can easily get all the new things incorporated into the master branch.

Standard tests are jUnit based - for example [this commit](servlet/servlet-filters/src/test/java/org/javaee7/servlet/filters/FilterServletTest.java). Test classes naming must comply with surefire naming standards `**/*Test.java`, `**/*Test*.java` or `**/*TestCase.java`.

For the sake of clarity and consistency, and to minimize the upfront complexity, we prefer standard jUnit tests using Java, with as additional helpers HtmlUnit, Hamcrest and of course Arquillian. Please don't use alternatives for these technologies. If any new dependency has to be introduced into this project it should provide something that's not covered by these existing dependencies.


### Some coding principles ###

* When creating new source file do not put (or copy) any license header, as we use top-level license (MIT) for each and every file in this repository.
* Please follow JBoss Community code formatting profile as defined in the [jboss/ide-config](https://github.com/jboss/ide-config#readme) repository. The details are explained there, as well as configurations for Eclipse, IntelliJ and NetBeans.


### Small Git tips ###

* Make sure your [fork](https://help.github.com/articles/fork-a-repo) is always up-to-date. Simply run ``git pull upstream master`` and you are ready to hack.
* When developing new features please create a feature branch so that we incorporate your changes smoothly. It's also convenient for you as you could work on few things in parallel ;) In order to create a feature branch and switch to it in one swoop you can use ``git checkout -b my_new_cool_feature``

That's it! Welcome in the community!

