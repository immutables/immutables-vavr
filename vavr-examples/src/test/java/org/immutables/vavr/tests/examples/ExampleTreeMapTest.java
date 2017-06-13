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

import io.vavr.collection.TreeMap;
import org.immutables.vavr.examples.ImmutableExampleTreeMapType;
import org.junit.Assert;
import org.junit.Test;
import io.vavr.Tuple;

public final class ExampleTreeMapTest
{
  @Test
  public void testAdd()
  {
    final ImmutableExampleTreeMapType.Builder b =
      ImmutableExampleTreeMapType.builder();

    b.putIntegers("A", Integer.valueOf(0));
    b.putIntegers("B", Integer.valueOf(1));
    b.putIntegers("C", Integer.valueOf(2));

    final ImmutableExampleTreeMapType a0 = b.build();
    Assert.assertEquals(Integer.valueOf(0), a0.integers().get("A").get());
    Assert.assertEquals(Integer.valueOf(1), a0.integers().get("B").get());
    Assert.assertEquals(Integer.valueOf(2), a0.integers().get("C").get());
  }

  @Test
  public void testAddAll()
  {
    final ImmutableExampleTreeMapType.Builder b =
      ImmutableExampleTreeMapType.builder();

    b.integers(TreeMap.of(
      "A", Integer.valueOf(0),
      "B", Integer.valueOf(1),
      "C", Integer.valueOf(2)));

    final ImmutableExampleTreeMapType a0 = b.build();
    Assert.assertEquals(Integer.valueOf(0), a0.integers().get("A").get());
    Assert.assertEquals(Integer.valueOf(1), a0.integers().get("B").get());
    Assert.assertEquals(Integer.valueOf(2), a0.integers().get("C").get());
  }

  @Test
  public void testSetJavaMap()
  {
    final ImmutableExampleTreeMapType.Builder b =
      ImmutableExampleTreeMapType.builder();

    final java.util.TreeMap<String, Integer> m = new java.util.TreeMap<>();
    m.put("A", Integer.valueOf(0));
    m.put("B", Integer.valueOf(1));
    m.put("C", Integer.valueOf(2));

    b.setJavaMapIntegers(m);

    final ImmutableExampleTreeMapType a0 = b.build();
    Assert.assertEquals(Integer.valueOf(0), a0.integers().get("A").get());
    Assert.assertEquals(Integer.valueOf(1), a0.integers().get("B").get());
    Assert.assertEquals(Integer.valueOf(2), a0.integers().get("C").get());
  }

  @Test
  public void testMap()
  {
    final ImmutableExampleTreeMapType.Builder b =
      ImmutableExampleTreeMapType.builder();

    final java.util.TreeMap<String, Integer> m = new java.util.TreeMap<>();
    m.put("A", Integer.valueOf(0));
    m.put("B", Integer.valueOf(1));
    m.put("C", Integer.valueOf(2));

    b.setJavaMapIntegers(m);

    final ImmutableExampleTreeMapType a0 = b.build();
    final ImmutableExampleTreeMapType.Builder b2 =
      ImmutableExampleTreeMapType.builder();
    b2.setMapIntegers(a0.integers());

    final ImmutableExampleTreeMapType a1 = b2.build();
    Assert.assertEquals(Integer.valueOf(0), a1.integers().get("A").get());
    Assert.assertEquals(Integer.valueOf(1), a1.integers().get("B").get());
    Assert.assertEquals(Integer.valueOf(2), a1.integers().get("C").get());
  }

  @Test
  public void testEntries()
  {
    final ImmutableExampleTreeMapType.Builder b =
      ImmutableExampleTreeMapType.builder();

    b.putEntryIntegers(Tuple.of("A", Integer.valueOf(0)));
    b.putEntryIntegers(Tuple.of("B", Integer.valueOf(1)));
    b.putEntryIntegers(Tuple.of("C", Integer.valueOf(2)));

    final ImmutableExampleTreeMapType a0 = b.build();
    Assert.assertEquals(Integer.valueOf(0), a0.integers().get("A").get());
    Assert.assertEquals(Integer.valueOf(1), a0.integers().get("B").get());
    Assert.assertEquals(Integer.valueOf(2), a0.integers().get("C").get());
  }

  @Test
  public void testSetEntries()
  {
    final ImmutableExampleTreeMapType.Builder b0 =
      ImmutableExampleTreeMapType.builder();

    b0.integers(TreeMap.of(
      "A", Integer.valueOf(0),
      "B", Integer.valueOf(1),
      "C", Integer.valueOf(2)));

    final ImmutableExampleTreeMapType a0 = b0.build();

    final ImmutableExampleTreeMapType.Builder b1 =
      ImmutableExampleTreeMapType.builder();
    b1.setEntriesIntegers(a0.integers());

    final ImmutableExampleTreeMapType a1 = b1.build();
    Assert.assertEquals(Integer.valueOf(0), a1.integers().get("A").get());
    Assert.assertEquals(Integer.valueOf(1), a1.integers().get("B").get());
    Assert.assertEquals(Integer.valueOf(2), a1.integers().get("C").get());
  }
}
