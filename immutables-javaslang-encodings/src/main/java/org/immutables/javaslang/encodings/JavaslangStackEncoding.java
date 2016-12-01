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

import javaslang.collection.List;
import javaslang.collection.Stack;
import org.immutables.encode.Encoding;

@Encoding
class JavaslangStackEncoding<T>
{
  @Encoding.Impl
  private Stack<T> field;

  JavaslangStackEncoding()
  {

  }

  @Encoding.Builder
  static final class Builder<T>
  {
    private Stack<T> stack = List.empty();

    Builder()
    {

    }

    @Encoding.Naming(value = "push*", depluralize = true)
    @Encoding.Init
    void push(
      final T element)
    {
      this.stack = this.stack.push(element);
    }

    @Encoding.Naming(value = "pushAll*", depluralize = true)
    @Encoding.Init
    void pushAll(
      final Iterable<T> element)
    {
      this.stack = this.stack.pushAll(element);
    }

    @Encoding.Init
    @Encoding.Copy
    void set(
      final Stack<T> elements)
    {
      this.stack = elements;
    }

    @Encoding.Naming(value = "setIterable*")
    @Encoding.Init
    void setIterable(
      final Iterable<T> elements)
    {
      this.stack = List.ofAll(elements);
    }

    @Encoding.Build
    Stack<T> build()
    {
      return this.stack;
    }
  }
}
