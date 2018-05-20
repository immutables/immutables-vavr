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

package org.immutables.vavr.encodings;

import io.vavr.collection.CharSeq;

import org.immutables.encode.Encoding;

import java.util.Arrays;

@Encoding
class VavrCharSeqEncoding
{
  @Encoding.Impl
  private CharSeq field = CharSeq.empty();

  VavrCharSeqEncoding()
  {

  }

  @Encoding.Builder
  static final class Builder
  {
    private CharSeq string = CharSeq.empty();

    Builder()
    {

    }

    @Encoding.Naming(standard = Encoding.StandardNaming.ADD)
    @Encoding.Init
    void add(
      final Character element)
    {
      this.string = this.string.append(element);
    }


    @Encoding.Naming(standard = Encoding.StandardNaming.ADD)
    @Encoding.Init
    void addVarArgs(
            final Character... elements)
    {
      this.string = this.string.appendAll(Arrays.asList(elements));
    }

    @Encoding.Naming(standard = Encoding.StandardNaming.ADD_ALL)
    @Encoding.Init
    void addAll(
      final Iterable<Character> elements)
    {
      this.string = this.string.appendAll(elements);
    }

    @Encoding.Init
    @Encoding.Copy
    void set(
      final CharSeq elements)
    {
      this.string = elements;
    }

    @Encoding.Naming(value = "setIterable*")
    @Encoding.Init
    void setIterable(
      final Iterable<Character> elements)
    {
      this.string = CharSeq.ofAll(elements);
    }

    @Encoding.Build
    CharSeq build()
    {
      return this.string;
    }
  }
}
