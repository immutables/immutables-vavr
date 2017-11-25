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

import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.collection.Queue;
import org.immutables.vavr.examples.ImmutableExampleQueueType;
import org.junit.Assert;
import org.junit.Test;

public final class ExampleQueueTest
{
  @Test
  public void testPush()
  {
    final ImmutableExampleQueueType.Builder b =
      ImmutableExampleQueueType.builder();

    b.enqueueIntegers(Integer.valueOf(0));
    b.enqueueIntegers(Integer.valueOf(1));
    b.enqueueIntegers(Integer.valueOf(2));

    final ImmutableExampleQueueType a0 = b.build();

    final Tuple2<Integer, ? extends Queue<Integer>> p0 = a0.integers().dequeue();
    Assert.assertEquals(Integer.valueOf(0), p0._1);
    final Tuple2<Integer, ? extends Queue<Integer>> p1 = p0._2.dequeue();
    Assert.assertEquals(Integer.valueOf(1), p1._1);
    final Tuple2<Integer, ? extends Queue<Integer>> p2 = p1._2.dequeue();
    Assert.assertEquals(Integer.valueOf(2), p2._1);
    Assert.assertTrue(p2._2.isEmpty());
  }

  @Test
  public void testPushVarArgs()
  {
    final ImmutableExampleQueueType.Builder b =
            ImmutableExampleQueueType.builder();

    b.enqueueIntegers(
            Integer.valueOf(0),
            Integer.valueOf(1),
            Integer.valueOf(0), // add a duplicate
            Integer.valueOf(2));

    final ImmutableExampleQueueType a0 = b.build();

    final Tuple2<Integer, ? extends Queue<Integer>> p0 = a0.integers().dequeue();
    Assert.assertEquals(Integer.valueOf(0), p0._1);
    final Tuple2<Integer, ? extends Queue<Integer>> p1 = p0._2.dequeue();
    Assert.assertEquals(Integer.valueOf(1), p1._1);
    final Tuple2<Integer, ? extends Queue<Integer>> p2 = p1._2.dequeue();
    Assert.assertEquals(Integer.valueOf(0), p2._1);
    final Tuple2<Integer, ? extends Queue<Integer>> p3 = p2._2.dequeue();
    Assert.assertEquals(Integer.valueOf(2), p3._1);
    Assert.assertTrue(p3._2.isEmpty());
  }
  @Test
  public void testPushAll()
  {
    final ImmutableExampleQueueType.Builder b =
      ImmutableExampleQueueType.builder();

    b.enqueueAllIntegers(List.of(
      Integer.valueOf(0),
      Integer.valueOf(1),
      Integer.valueOf(2)
    ));

    final ImmutableExampleQueueType a0 = b.build();

    final Tuple2<Integer, ? extends Queue<Integer>> p0 = a0.integers().dequeue();
    Assert.assertEquals(Integer.valueOf(0), p0._1);
    final Tuple2<Integer, ? extends Queue<Integer>> p1 = p0._2.dequeue();
    Assert.assertEquals(Integer.valueOf(1), p1._1);
    final Tuple2<Integer, ? extends Queue<Integer>> p2 = p1._2.dequeue();
    Assert.assertEquals(Integer.valueOf(2), p2._1);
    Assert.assertTrue(p2._2.isEmpty());
  }
}
