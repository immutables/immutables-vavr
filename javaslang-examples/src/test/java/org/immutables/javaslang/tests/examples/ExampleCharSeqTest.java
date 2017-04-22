/*
 * Copyright 2013-2016 Immutables Authors and Contributors
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

package org.immutables.javaslang.tests.examples;

import javaslang.collection.Array;
import javaslang.collection.CharSeq;
import org.immutables.javaslang.examples.ImmutableExampleArrayType;
import org.immutables.javaslang.examples.ImmutableExampleCharSeqType;
import org.junit.Assert;
import org.junit.Test;

public final class ExampleCharSeqTest
{
  @Test public void testAdd()
  {
    final ImmutableExampleCharSeqType.Builder b =
      ImmutableExampleCharSeqType.builder();

    b.addText(Character.valueOf('a'));
    b.addText(Character.valueOf('b'));
    b.addText(Character.valueOf('c'));

    final ImmutableExampleCharSeqType a0 = b.build();
    Assert.assertEquals((long) 'a', (long) a0.text().get(0).charValue());
    Assert.assertEquals((long) 'b', (long) a0.text().get(1).charValue());
    Assert.assertEquals((long) 'c', (long) a0.text().get(2).charValue());
  }

  @Test public void testAddAll()
  {
    final ImmutableExampleCharSeqType.Builder b =
      ImmutableExampleCharSeqType.builder();

    b.addAllText(CharSeq.of('a', 'b', 'c'));

    final ImmutableExampleCharSeqType a0 = b.build();
    Assert.assertEquals((long) 'a', (long) a0.text().get(0).charValue());
    Assert.assertEquals((long) 'b', (long) a0.text().get(1).charValue());
    Assert.assertEquals((long) 'c', (long) a0.text().get(2).charValue());
  }
}
