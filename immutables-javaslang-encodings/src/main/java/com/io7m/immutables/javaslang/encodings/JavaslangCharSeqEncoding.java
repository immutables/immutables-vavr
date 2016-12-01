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

import javaslang.collection.CharSeq;
import org.immutables.encode.Encoding;

@Encoding
class JavaslangCharSeqEncoding
{
  JavaslangCharSeqEncoding()
  {

  }

  @Encoding.Impl
  private CharSeq field;

  @Encoding.Builder
  static final class Builder
  {
    Builder()
    {

    }

    private CharSeq string = CharSeq.empty();

    @Encoding.Naming(value = "add*", depluralize = true)
    @Encoding.Init
    void add(
      final Character element)
    {
      this.string = this.string.append(element);
    }

    @Encoding.Naming(value = "addAll*", depluralize = true)
    @Encoding.Init
    void addAll(
      final Iterable<Character> elements)
    {
      this.string = this.string.appendAll(elements);
    }

    @Encoding.Naming(value = "set*")
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
