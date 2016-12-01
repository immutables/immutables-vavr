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

import javaslang.collection.List;
import javaslang.collection.Stack;
import org.immutables.encode.Encoding;

@Encoding
class JavaslangStackEncoding<T>
{
  JavaslangStackEncoding()
  {

  }

  @Encoding.Impl
  private Stack<T> field;

  @Encoding.Builder
  static final class Builder<T>
  {
    Builder()
    {

    }

    private Stack<T> stack = List.empty();

    @Encoding.Naming(value = "enqueue*", depluralize = true)
    @Encoding.Init
    void push(
      final T element)
    {
      this.stack = this.stack.push(element);
    }

    @Encoding.Naming(value = "enqueueAll*", depluralize = true)
    @Encoding.Init
    void pushAll(
      final Iterable<T> element)
    {
      this.stack = this.stack.pushAll(element);
    }

    @Encoding.Naming(value = "set*")
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
