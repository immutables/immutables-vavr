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

import org.immutables.vavr.examples.ImmutableExampleLinkedHashSetType;
import org.junit.Assert;
import org.junit.Test;

import io.vavr.collection.Iterator;
import io.vavr.collection.LinkedHashSet;

public final class ExampleLinkedHashSetTest
{
  @Test
  public void testAdd()
  {
    final ImmutableExampleLinkedHashSetType.Builder b =
      ImmutableExampleLinkedHashSetType.builder();

    b.addIntegers(Integer.valueOf(0));
    b.addIntegers(Integer.valueOf(1));
    b.addIntegers(Integer.valueOf(2));

    final ImmutableExampleLinkedHashSetType a0 = b.build();
    Assert.assertEquals(3L, (long) a0.integers().size());
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(0)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(1)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(2)));
  }

  @Test
  public void testAddVarArgs()
  {
    final ImmutableExampleLinkedHashSetType.Builder b =
            ImmutableExampleLinkedHashSetType.builder();

    b.addIntegers(
            Integer.valueOf(0),
            Integer.valueOf(2),
            Integer.valueOf(0), // add duplicate - must be ignored
            Integer.valueOf(1));

    final ImmutableExampleLinkedHashSetType a0 = b.build();
    Assert.assertEquals(3L, (long) a0.integers().size());
    Iterator<Integer> iterator = a0.integers().iterator();
    Assert.assertEquals(Integer.valueOf(0), iterator.next());
    // order must be preserved
    Assert.assertEquals(Integer.valueOf(2), iterator.next());
    Assert.assertEquals(Integer.valueOf(1), iterator.next());
    Assert.assertFalse(iterator.hasNext());
  }

  @Test
  public void testSet()
  {
    final ImmutableExampleLinkedHashSetType.Builder b =
      ImmutableExampleLinkedHashSetType.builder();

    b.integers(LinkedHashSet.of(
      Integer.valueOf(0),
      Integer.valueOf(1),
      Integer.valueOf(2)));

    final ImmutableExampleLinkedHashSetType a0 = b.build();
    Assert.assertEquals(3L, (long) a0.integers().size());
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(0)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(1)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(2)));
  }

  @Test
  public void testSetIterable()
  {
    final ImmutableExampleLinkedHashSetType.Builder b =
      ImmutableExampleLinkedHashSetType.builder();

    b.setIterableIntegers(LinkedHashSet.of(
      Integer.valueOf(0),
      Integer.valueOf(1),
      Integer.valueOf(2)));

    final ImmutableExampleLinkedHashSetType a0 = b.build();
    Assert.assertEquals(3L, (long) a0.integers().size());
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(0)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(1)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(2)));
  }

  @Test
  public void testAddAll()
  {
    final ImmutableExampleLinkedHashSetType.Builder b =
      ImmutableExampleLinkedHashSetType.builder();

    final LinkedHashSet<Integer> s0 = LinkedHashSet.of(
      Integer.valueOf(0),
      Integer.valueOf(1),
      Integer.valueOf(2));

    final LinkedHashSet<Integer> s1 = LinkedHashSet.of(
      Integer.valueOf(10),
      Integer.valueOf(11),
      Integer.valueOf(12));

    b.addAllIntegers(s0);
    b.addAllIntegers(s1);

    final ImmutableExampleLinkedHashSetType a0 = b.build();
    Assert.assertEquals(6L, (long) a0.integers().size());
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(0)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(1)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(2)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(10)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(11)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(12)));
  }
}
