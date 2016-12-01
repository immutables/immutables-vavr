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

import javaslang.control.Option;
import org.immutables.encode.Encoding;

@Encoding
class JavaslangOptionEncoding<T>
{
  JavaslangOptionEncoding()
  {

  }

  @Encoding.Impl
  private Option<T> field;

  @Encoding.Builder
  static final class Builder<T>
  {
    Builder()
    {

    }

    private Option<T> optional = Option.none();

    @Encoding.Naming(value = "set*")
    @Encoding.Init
    @Encoding.Copy
    void set(
      final Option<T> opt)
    {
      this.optional = opt;
    }

    @Encoding.Naming(value = "setValue*")
    @Encoding.Init
    void setValue(
      final T x)
    {
      this.optional = Option.of(x);
    }

    @Encoding.Naming(value = "unset*")
    @Encoding.Init
    void unset()
    {
      this.optional = Option.none();
    }

    @Encoding.Build
    Option<T> build()
    {
      return this.optional;
    }
  }
}
