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

import io.vavr.control.Option;
import org.immutables.vavr.examples.ImmutableExampleOptionType;
import org.immutables.vavr.examples.ImmutableExampleOptionWithParametersType;
import org.junit.Assert;
import org.junit.Test;

public final class ExampleOptionTest
{
  @Test
  public void testSetValue()
  {
    final ImmutableExampleOptionType.Builder b =
      ImmutableExampleOptionType.builder();

    b.optionalInteger(Integer.valueOf(23));

    final ImmutableExampleOptionType a0 = b.build();
    Assert.assertEquals(Option.of(Integer.valueOf(23)), a0.optionalInteger());
  }

  @Test
  public void testSetValueNone()
  {
    final ImmutableExampleOptionType.Builder b =
      ImmutableExampleOptionType.builder();

    final ImmutableExampleOptionType a0 = b.build();
    Assert.assertEquals(Option.none(), a0.optionalInteger());
  }

  @Test
  public void testFrom()
  {
    final ImmutableExampleOptionType.Builder b =
      ImmutableExampleOptionType.builder();

    b.optionalInteger(Option.of(Integer.valueOf(23)));

    final ImmutableExampleOptionType a0 = b.build();
    Assert.assertEquals(Option.of(Integer.valueOf(23)), a0.optionalInteger());
  }

  @Test
  public void testUnset()
  {
    final ImmutableExampleOptionType.Builder b =
      ImmutableExampleOptionType.builder();

    b.optionalInteger(Integer.valueOf(23));
    b.unsetOptionalInteger();

    final ImmutableExampleOptionType a0 = b.build();
    Assert.assertEquals(Option.none(), a0.optionalInteger());
  }
  
  @Test(expected = NullPointerException.class)
  public void testSetNullValue()
  {
    final ImmutableExampleOptionType.Builder b =
            ImmutableExampleOptionType.builder();
    b.optionalInteger((Integer)null);
  }

  @Test(expected = NullPointerException.class)
  public void testSetNullOption()
  {
    final ImmutableExampleOptionType.Builder b =
            ImmutableExampleOptionType.builder();
    b.optionalInteger((Option<Integer>)null);
  }
  
  @Test(expected = NullPointerException.class)
  public void testWithNull()
  {
    final ImmutableExampleOptionType b =
            ImmutableExampleOptionType.builder().build();
    b.withOptionalInteger((Integer)null);
  }

  @Test(expected = NullPointerException.class)
  public void testWithNullOption()
  {
    final ImmutableExampleOptionType b =
            ImmutableExampleOptionType.builder().build();
    b.withOptionalInteger((Option<Integer>)null);
  }
  
  @Test
  public void testParameter() 
  {
    final ImmutableExampleOptionWithParametersType b = ImmutableExampleOptionWithParametersType.of(Option.of(1));
    Assert.assertEquals(Option.of(1), b.optionalInteger());
  }
  
  @Test(expected = NullPointerException.class)
  public void testParameterWithNullOption()
  {
    final ImmutableExampleOptionWithParametersType b = ImmutableExampleOptionWithParametersType.of(null);
  }
}
