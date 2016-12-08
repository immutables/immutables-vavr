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

package org.immutables.javaslang.encodings;

import javaslang.collection.Array;
import javaslang.collection.Seq;
import org.immutables.encode.Encoding;

@Encoding
class JavaslangSeqEncoding<T>
{
  @Encoding.Impl
  private Seq<T> field;

  JavaslangSeqEncoding()
  {

  }

  @Encoding.Builder
  static final class Builder<T>
  {
    private Seq<T> seq = Array.empty();

    Builder()
    {

    }

    @Encoding.Naming(standard = Encoding.StandardNaming.ADD)
    @Encoding.Init
    void add(
      final T element)
    {
      this.seq = this.seq.append(element);
    }

    @Encoding.Naming(standard = Encoding.StandardNaming.ADD_ALL)
    @Encoding.Init
    void addAll(
      final Iterable<T> element)
    {
      this.seq = this.seq.appendAll(element);
    }

    @Encoding.Init
    @Encoding.Copy
    void set(
      final Seq<T> elements)
    {
      this.seq = elements;
    }

    @Encoding.Naming(value = "setIterable*")
    @Encoding.Init
    void setIterable(
      final Iterable<T> elements)
    {
      this.seq = Array.ofAll(elements);
    }

    @Encoding.Build
    Seq<T> build()
    {
      return this.seq;
    }
  }
}
