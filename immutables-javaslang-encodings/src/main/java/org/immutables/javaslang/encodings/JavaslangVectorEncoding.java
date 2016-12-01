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

import javaslang.collection.Vector;
import org.immutables.encode.Encoding;

@Encoding
class JavaslangVectorEncoding<T>
{
  JavaslangVectorEncoding()
  {

  }

  @Encoding.Impl
  private Vector<T> field;

  @Encoding.Builder
  static final class Builder<T>
  {
    Builder()
    {

    }

    private Vector<T> vector = Vector.empty();

    @Encoding.Naming(value = "add*", depluralize = true)
    @Encoding.Init
    void add(
      final T element)
    {
      this.vector = this.vector.append(element);
    }

    @Encoding.Naming(value = "addAll*", depluralize = true)
    @Encoding.Init
    void addAll(
      final Iterable<T> element)
    {
      this.vector = this.vector.appendAll(element);
    }

    @Encoding.Naming(value = "set*")
    @Encoding.Init
    @Encoding.Copy
    void set(
      final Vector<T> elements)
    {
      this.vector = elements;
    }

    @Encoding.Naming(value = "setIterable*")
    @Encoding.Init
    void setIterable(
      final Iterable<T> elements)
    {
      this.vector = Vector.ofAll(elements);
    }

    @Encoding.Build
    Vector<T> build()
    {
      return this.vector;
    }
  }
}
