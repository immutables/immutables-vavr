/*
 * Copyright © 2016 <code@io7m.com> http://io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.immutables.javaslang.encodings;

import javaslang.collection.Queue;
import org.immutables.encode.Encoding;

@Encoding
class JavaslangQueueEncoding<T>
{
  JavaslangQueueEncoding()
  {

  }

  @Encoding.Impl
  private Queue<T> field;

  @Encoding.Builder
  static final class Builder<T>
  {
    Builder()
    {

    }

    private Queue<T> queue = Queue.empty();

    @Encoding.Naming(value = "enqueue*", depluralize = true)
    @Encoding.Init
    void enqueue(
      final T element)
    {
      this.queue = this.queue.enqueue(element);
    }

    @Encoding.Naming(value = "enqueueAll*", depluralize = true)
    @Encoding.Init
    void enqueueAll(
      final Iterable<T> element)
    {
      this.queue = this.queue.enqueueAll(element);
    }

    @Encoding.Naming(value = "set*")
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
