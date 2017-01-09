immutables-javaslang
===

[![Build Status](https://travis-ci.org/immutables/immutables-javaslang.svg)](https://travis-ci.org/immutables/immutables-javaslang)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.immutables.javaslang/javaslang/badge.png)](https://maven-badges.herokuapp.com/maven-central/org.immutables.javaslang/javaslang)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/cc5eddb214a34815be5b01df4a3b2493)](https://www.codacy.com/app/github_79/immutables-javaslang?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=immutables/immutables-javaslang&amp;utm_campaign=Badge_Grade)

A set of [Immutables](http://immutables.org) encodings for [Javaslang](http://javaslang.io).

Note: Prior to a 1.0.0 release, the encodings are still in the
experimental phase and therefore should not be relied upon to provide
a stable API.

#### Ten Second Tutorial

Include the encodings in your project:

```
<dependency>
  <groupId>org.immutables.javaslang</groupId>
  <artifactId>javaslang-encodings</artifactId>
  <version><!-- Insert latest version here --></version>
  <scope>provided</scope>
</dependency>
```

Annotate your types with `@JavaslangEncodingEnabled`. Alternatively,
you can annotate a `@Style` annotation with `@JavaslangEncodingEnabled`
and have it apply to any types that are using that style. See
[Styles](http://immutables.github.io/style.html).

Now, any use of [Javaslang](http://javaslang.io) collections in your
abstract value types will magically result in the generated `Builder`
types being augmented with methods to build immutable collections
element-by-element. Use of Javaslang's `Option` type will receive
the same special treatment as the standard Java `Optional` type.

