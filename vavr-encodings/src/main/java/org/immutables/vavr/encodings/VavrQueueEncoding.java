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
import io.vavr.collection.Queue;
import org.immutables.encode.Encoding;

@Encoding
class VavrQueueEncoding<T>
{
  @Encoding.Impl
  private Queue<T> field = Queue.empty();

  VavrQueueEncoding()
  {

  }

  @Encoding.Builder
  static final class Builder<T>
  {
    private Queue<T> queue = Queue.empty();

    Builder()
    {

    }

    @Encoding.Naming(value = "enqueue*", depluralize = true)
    @Encoding.Init
    void enqueue(
      final T element)
    {
      this.queue = this.queue.enqueue(element);
    }


    @SafeVarargs
    @Encoding.Naming(value = "enqueue*", depluralize = true)
    @Encoding.Init
    final void enqueuedVarArgs(
            final T... elements)
    {
      this.queue = this.queue.appendAll(HashSet.of(elements));
    }

    @Encoding.Naming(value = "enqueueAll*", depluralize = true)
    @Encoding.Init
    void enqueueAll(
      final Iterable<T> element)
    {
      this.queue = this.queue.enqueueAll(element);
    }

    @Encoding.Init
    @Encoding.Copy
    void set(
      final Queue<T> elements)
    {
      this.queue = elements;
    }

    @Encoding.Naming(value = "setIterable*")
    @Encoding.Init
    void setIterable(
      final Iterable<T> elements)
    {
      this.queue = Queue.ofAll(elements);
    }

    @Encoding.Build
    Queue<T> build()
    {
      return this.queue;
    }
  }
}
