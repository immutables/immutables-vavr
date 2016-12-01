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

import javaslang.collection.LinearSeq;
import javaslang.collection.List;
import org.immutables.encode.Encoding;

@Encoding
class JavaslangLinearSeqEncoding<T>
{
  JavaslangLinearSeqEncoding()
  {

  }

  @Encoding.Impl
  private LinearSeq<T> field;

  @Encoding.Builder
  static final class Builder<T>
  {
    Builder()
    {

    }

    private LinearSeq<T> linear_seq = List.empty();

    @Encoding.Naming(value = "add*", depluralize = true)
    @Encoding.Init
    void add(
      final T element)
    {
      this.linear_seq = this.linear_seq.append(element);
    }

    @Encoding.Naming(value = "addAll*", depluralize = true)
    @Encoding.Init
    void addAll(
      final Iterable<T> element)
    {
      this.linear_seq = this.linear_seq.appendAll(element);
    }

    @Encoding.Naming(value = "set*")
    @Encoding.Init
    @Encoding.Copy
    void set(
      final LinearSeq<T> elements)
    {
      this.linear_seq = elements;
    }

    @Encoding.Naming(value = "setIterable*")
    @Encoding.Init
    void setIterable(
      final Iterable<T> elements)
    {
      this.linear_seq = List.ofAll(elements);
    }

    @Encoding.Build
    LinearSeq<T> build()
    {
      return this.linear_seq;
    }
  }
}
