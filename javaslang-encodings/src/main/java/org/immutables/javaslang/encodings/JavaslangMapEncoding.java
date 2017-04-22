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

import javaslang.Tuple2;
import javaslang.collection.HashMap;
import javaslang.collection.Map;
import org.immutables.encode.Encoding;

@Encoding
class JavaslangMapEncoding<K, V>
{
  @Encoding.Impl
  private Map<K, V> field;

  JavaslangMapEncoding()
  {

  }

  @Encoding.Builder
  static final class Builder<K, V>
  {
    private Map<K, V> map = HashMap.empty();

    Builder()
    {

    }

    @Encoding.Naming(standard = Encoding.StandardNaming.PUT)
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

    @Encoding.Init
    @Encoding.Copy
    void set(
      final Map<K, V> elements)
    {
      this.map = elements;
    }

    @Encoding.Naming(value = "setJavaMap*")
    @Encoding.Init
    void setJavaMap(
      final java.util.Map<K, V> in_map)
    {
      this.map = HashMap.ofAll(in_map);
    }

    @Encoding.Naming(value = "setEntries*")
    @Encoding.Init
    void setEntries(
      final Iterable<Tuple2<K, V>> entries)
    {
      this.map = HashMap.ofEntries(entries);
    }

    @Encoding.Build
    Map<K, V> build()
    {
      return this.map;
    }
  }
}
