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

import java.util.Objects;

import org.immutables.encode.Encoding;

import io.vavr.control.Option;

@Encoding
class VavrOptionEncoding<T>
{
  @Encoding.Impl
  private Option<T> field = Option.none();

  VavrOptionEncoding()
  {

  }

  @Encoding.Copy
  public Option<T> withOption(
    final Option<T> value)
  {
    return Objects.requireNonNull(value);
  }

  @Encoding.Copy
  public Option<T> with(
    final T value)
  {
    return Option.some(Objects.requireNonNull(value));
  }

  @Encoding.Of
  static <T> Option<T> init(final Option<T> value) {
    Objects.requireNonNull(value);
    return value;
  }

  @Encoding.Builder
  static final class Builder<T>
  {
    private Option<T> optional = Option.none();

    Builder()
    {

    }

    @Encoding.Init
    @Encoding.Copy
    void set(
      final Option<T> opt)
    {
      this.optional = Objects.requireNonNull(opt);
    }

    @Encoding.Init
    void setValue(
      final T x)
    {
      this.optional = Option.some(Objects.requireNonNull(x));
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
