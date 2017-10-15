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

import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import org.immutables.encode.Encoding;

@Encoding
class VavrListEncoding<T>
{
  @Encoding.Impl
  private List<T> field = List.empty();

  VavrListEncoding()
  {

  }

  @Encoding.Builder
  static final class Builder<T>
  {
    private List<T> list = List.empty();

    Builder()
    {

    }

    @Encoding.Naming(standard = Encoding.StandardNaming.ADD)
    @Encoding.Init
    void add(
      final T element)
    {
      this.list = this.list.append(element);
    }

    @SafeVarargs
    @Encoding.Naming(standard = Encoding.StandardNaming.ADD)
    @Encoding.Init
    final void addVarArgs(
            final T... elements)
    {
      this.list = this.list.appendAll(HashSet.of(elements));
    }

    @Encoding.Naming(standard = Encoding.StandardNaming.ADD_ALL)
    @Encoding.Init
    void addAll(
      final Iterable<T> element)
    {
      this.list = this.list.appendAll(element);
    }

    @Encoding.Init
    @Encoding.Copy
    void set(
      final List<T> elements)
    {
      this.list = elements;
    }

    @Encoding.Naming(value = "setIterable*")
    @Encoding.Init
    void setIterable(
      final Iterable<T> elements)
    {
      this.list = List.ofAll(elements);
    }

    @Encoding.Build
    List<T> build()
    {
      return this.list;
    }
  }
}
