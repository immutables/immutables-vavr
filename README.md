immutables-vavr
===

[![Build Status](https://travis-ci.org/immutables/immutables-vavr.svg)](https://travis-ci.org/immutables/immutables-vavr)
[![Maven Central](https://img.shields.io/maven-central/v/org.immutables.vavr/vavr.png?style=flat-square)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22org.immutables.vavr%22)
[![Maven Central (snapshot)](https://img.shields.io/nexus/s/https/oss.sonatype.org/org.immutables.vavr/vavr.svg?style=flat-square)](https://oss.sonatype.org/content/repositories/snapshots/org/immutables/vavr/)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/98691df562e44db69bcace5ee9913855)](https://www.codacy.com/app/github_79/immutables-vavr?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=immutables/immutables-vavr&amp;utm_campaign=Badge_Grade)

A set of [Immutables](http://immutables.org) encodings for [Vavr](http://vavr.io).

Note: Prior to a 1.0.0 release, the encodings are still in the
experimental phase and therefore should not be relied upon to provide
a stable API.

#### Ten Second Tutorial

Include the encodings in your project:

```
<dependency>
  <groupId>org.immutables.vavr</groupId>
  <artifactId>vavr-encodings</artifactId>
  <version><!-- Insert latest version here --></version>
  <scope>provided</scope>
</dependency>
```

Annotate your types with `@VavrEncodingEnabled`. Alternatively,
you can annotate a `@Style` annotation with `@VavrEncodingEnabled`
and have it apply to any types that are using that style. See
[Styles](http://immutables.github.io/style.html).

Now, any use of [Vavr](http://vavr.io) collections in your
abstract value types will magically result in the generated `Builder`
types being augmented with methods to build immutable collections
element-by-element. Use of Vavr's `Option` type will receive
the same special treatment as the standard Java `Optional` type.

