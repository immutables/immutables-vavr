/*
 * Copyright 2013-2017 Immutables Authors and Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.immutables.vavr.tests.examples;

import io.vavr.Tuple;
import io.vavr.collection.HashMultimap;
import io.vavr.collection.HashSet;
import org.immutables.vavr.examples.ImmutableExampleMultimapType;
import org.junit.Assert;
import org.junit.Test;

public final class ExampleMultimapMapTest
{
  @Test
  public void testAdd()
  {
    final ImmutableExampleMultimapType.Builder b =
      ImmutableExampleMultimapType.builder();

    b.putIntegers("A", Integer.valueOf(0));
    b.putIntegers("B", Integer.valueOf(1));
    b.putIntegers("C", Integer.valueOf(2));

    final ImmutableExampleMultimapType a0 = b.build();
    Assert.assertEquals(
      HashSet.of(Integer.valueOf(0)),
      a0.integers().get("A").get());
    Assert.assertEquals(
      HashSet.of(Integer.valueOf(1)),
      a0.integers().get("B").get());
    Assert.assertEquals(
      HashSet.of(Integer.valueOf(2)),
      a0.integers().get("C").get());
  }

  @Test
  public void testAddAll()
  {
    final ImmutableExampleMultimapType.Builder b =
      ImmutableExampleMultimapType.builder();

    b.integers(HashMultimap.withSet().of(
      "A", Integer.valueOf(0),
      "B", Integer.valueOf(1),
      "C", Integer.valueOf(2)));

    final ImmutableExampleMultimapType a0 = b.build();
    Assert.assertEquals(
      HashSet.of(Integer.valueOf(0)),
      a0.integers().get("A").get());
    Assert.assertEquals(
      HashSet.of(Integer.valueOf(1)),
      a0.integers().get("B").get());
    Assert.assertEquals(
      HashSet.of(Integer.valueOf(2)),
      a0.integers().get("C").get());
  }

  @Test
  public void testSetJavaMap()
  {
    final ImmutableExampleMultimapType.Builder b =
      ImmutableExampleMultimapType.builder();

    final java.util.HashMap<String, Integer> m = new java.util.HashMap<>(3);
    m.put("A", Integer.valueOf(0));
    m.put("B", Integer.valueOf(1));
    m.put("C", Integer.valueOf(2));

    b.setJavaMultimapIntegers(m);

    final ImmutableExampleMultimapType a0 = b.build();
    Assert.assertEquals(
      HashSet.of(Integer.valueOf(0)),
      a0.integers().get("A").get());
    Assert.assertEquals(
      HashSet.of(Integer.valueOf(1)),
      a0.integers().get("B").get());
    Assert.assertEquals(
      HashSet.of(Integer.valueOf(2)),
      a0.integers().get("C").get());
  }

  @Test
  public void testEntries()
  {
    final ImmutableExampleMultimapType.Builder b =
      ImmutableExampleMultimapType.builder();

    b.putEntryIntegers(Tuple.of("A", Integer.valueOf(0)));
    b.putEntryIntegers(Tuple.of("B", Integer.valueOf(1)));
    b.putEntryIntegers(Tuple.of("C", Integer.valueOf(2)));

    final ImmutableExampleMultimapType a0 = b.build();
    Assert.assertEquals(
      HashSet.of(Integer.valueOf(0)),
      a0.integers().get("A").get());
    Assert.assertEquals(
      HashSet.of(Integer.valueOf(1)),
      a0.integers().get("B").get());
    Assert.assertEquals(
      HashSet.of(Integer.valueOf(2)),
      a0.integers().get("C").get());
  }

  @Test
  public void testSetEntries()
  {
    final ImmutableExampleMultimapType.Builder b0 =
      ImmutableExampleMultimapType.builder();

    b0.integers(HashMultimap.withSet().of(
      "A", Integer.valueOf(0),
      "B", Integer.valueOf(1),
      "C", Integer.valueOf(2)));

    final ImmutableExampleMultimapType a0 = b0.build();

    final ImmutableExampleMultimapType.Builder b1 =
      ImmutableExampleMultimapType.builder();
    b1.setEntriesIntegers(a0.integers());

    final ImmutableExampleMultimapType a1 = b1.build();
    Assert.assertEquals(
      HashSet.of(Integer.valueOf(0)),
      a1.integers().get("A").get());
    Assert.assertEquals(
      HashSet.of(Integer.valueOf(1)),
      a1.integers().get("B").get());
    Assert.assertEquals(
      HashSet.of(Integer.valueOf(2)),
      a1.integers().get("C").get());
  }
}
