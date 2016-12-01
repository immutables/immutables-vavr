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

import javaslang.Tuple2;
import javaslang.collection.TreeMap;
import javaslang.collection.Map;
import org.immutables.encode.Encoding;

@Encoding
class JavaslangTreeMapEncoding<K, V>
{
  JavaslangTreeMapEncoding()
  {

  }

  @Encoding.Impl
  private TreeMap<K, V> field;

  @Encoding.Builder
  static final class Builder<K extends Comparable<K>, V>
  {
    Builder()
    {

    }

    private TreeMap<K, V> map = TreeMap.empty();

    @Encoding.Naming(value = "put*", depluralize = true)
    @Encoding.Init
    void put(
      final K key,
      final V value)
    {
      this.map = this.map.put(key, value);
    }

    @Encoding.Naming(value = "putEntry*", depluralize = true)
    @Encoding.Init
    void putEntry(
      final Tuple2<K, V> entry)
    {
      this.map = this.map.put(entry);
    }

    @Encoding.Naming(value = "set*")
    @Encoding.Init
    @Encoding.Copy
    void set(
      final TreeMap<K, V> elements)
    {
      this.map = elements;
    }

    @Encoding.Naming(value = "setJavaMap*")
    @Encoding.Init
    void setJavaMap(
      final java.util.Map<K, V> in_map)
    {
      this.map = TreeMap.ofAll(in_map);
    }

    @Encoding.Naming(value = "setMap*")
    @Encoding.Init
    void setMap(
      final Map<K, V> in_map)
    {
      this.map = TreeMap.ofEntries(in_map.map(x -> x));
    }

    @Encoding.Naming(value = "setEntries*")
    @Encoding.Init
    void setEntries(
      final Iterable<Tuple2<K, V>> entries)
    {
      this.map = TreeMap.ofEntries(entries);
    }

    @Encoding.Build
    TreeMap<K, V> build()
    {
      return this.map;
    }
  }
}
