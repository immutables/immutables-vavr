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

import org.immutables.vavr.examples.ImmutableExampleSetType;
import org.junit.Assert;
import org.junit.Test;

import io.vavr.collection.HashSet;

public final class ExampleSetTest
{
  @Test
  public void testAdd()
  {
    final ImmutableExampleSetType.Builder b =
            ImmutableExampleSetType.builder();

    b.addIntegers(Integer.valueOf(0));
    b.addIntegers(Integer.valueOf(1));
    b.addIntegers(Integer.valueOf(2));

    final ImmutableExampleSetType a0 = b.build();
    Assert.assertEquals(3L, (long) a0.integers().size());
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(0)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(1)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(2)));
  }

  @Test
  public void testAddVarArgs()
  {
    final ImmutableExampleSetType.Builder b =
            ImmutableExampleSetType.builder();

    b.addIntegers(
            Integer.valueOf(0),
            Integer.valueOf(1),
            Integer.valueOf(0), // add duplicate
            Integer.valueOf(2));

    final ImmutableExampleSetType a0 = b.build();
    Assert.assertEquals(3L, (long) a0.integers().size());
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(0)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(1)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(2)));
  }

  @Test
  public void testSet()
  {
    final ImmutableExampleSetType.Builder b =
            ImmutableExampleSetType.builder();

    b.integers(HashSet.of(
            Integer.valueOf(0),
            Integer.valueOf(1),
            Integer.valueOf(2)));

    final ImmutableExampleSetType a0 = b.build();
    Assert.assertEquals(3L, (long) a0.integers().size());
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(0)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(1)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(2)));
  }

  @Test
  public void testSetIterable()
  {
    final ImmutableExampleSetType.Builder b =
            ImmutableExampleSetType.builder();

    b.setIterableIntegers(HashSet.of(
            Integer.valueOf(0),
            Integer.valueOf(1),
            Integer.valueOf(2)));

    final ImmutableExampleSetType a0 = b.build();
    Assert.assertEquals(3L, (long) a0.integers().size());
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(0)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(1)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(2)));
  }

  @Test
  public void testAddAll()
  {
    final ImmutableExampleSetType.Builder b =
            ImmutableExampleSetType.builder();

    final HashSet<Integer> s0 = HashSet.of(
            Integer.valueOf(0),
            Integer.valueOf(1),
            Integer.valueOf(2));

    final HashSet<Integer> s1 = HashSet.of(
            Integer.valueOf(10),
            Integer.valueOf(11),
            Integer.valueOf(12));

    b.addAllIntegers(s0);
    b.addAllIntegers(s1);

    final ImmutableExampleSetType a0 = b.build();
    Assert.assertEquals(6L, (long) a0.integers().size());
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(0)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(1)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(2)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(10)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(11)));
    Assert.assertTrue(a0.integers().contains(Integer.valueOf(12)));
  }
}
