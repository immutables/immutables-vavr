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

import io.vavr.Tuple2;
import io.vavr.collection.HashMap;
import io.vavr.collection.HashMultimap;
import io.vavr.collection.Multimap;
import org.immutables.encode.Encoding;

@Encoding
class VavrMultimapEncoding<K, V>
{
  @Encoding.Impl
  private Multimap<K, V> field = HashMultimap.withSet().empty();

  VavrMultimapEncoding()
  {

  }

  @Encoding.Builder
  static final class Builder<K, V>
  {
    private Multimap<K, V> map = HashMultimap.withSet().empty();

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
      final Multimap<K, V> elements)
    {
      this.map = elements;
    }

    @Encoding.Naming(value = "setJavaMultimap*")
    @Encoding.Init
    void setJavaMap(
      final java.util.Map<K, V> in_map)
    {
      this.map = HashMultimap.withSet().ofEntries(HashMap.ofAll(in_map));
    }

    @Encoding.Naming(value = "setEntries*")
    @Encoding.Init
    void setEntries(
      final Iterable<Tuple2<K, V>> entries)
    {
      this.map = HashMultimap.withSet().ofEntries(entries);
    }

    @Encoding.Build
    Multimap<K, V> build()
    {
      return this.map;
    }
  }
}
