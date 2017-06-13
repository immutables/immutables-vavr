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
import io.vavr.collection.LinkedHashMap;
import io.vavr.collection.Map;
import org.immutables.encode.Encoding;

@Encoding
class VavrLinkedHashMapEncoding<K, V>
{
  @Encoding.Impl
  private LinkedHashMap<K, V> field;

  VavrLinkedHashMapEncoding()
  {

  }

  @Encoding.Builder
  static final class Builder<K, V>
  {
    private LinkedHashMap<K, V> map = LinkedHashMap.empty();

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

    @Encoding.Naming(standard = Encoding.StandardNaming.ADD_ALL)
    @Encoding.Init
    void putEntry(
      final Tuple2<K, V> entry)
    {
      this.map = this.map.put(entry);
    }

    @Encoding.Init
    @Encoding.Copy
    void set(
      final LinkedHashMap<K, V> elements)
    {
      this.map = elements;
    }

    @Encoding.Naming(value = "setJavaMap*")
    @Encoding.Init
    void setJavaMap(
      final java.util.Map<K, V> in_map)
    {
      this.map = LinkedHashMap.ofAll(in_map);
    }

    @Encoding.Naming(value = "setMap*")
    @Encoding.Init
    void setMap(
      final Map<K, V> in_map)
    {
      this.map = LinkedHashMap.ofEntries(in_map.map(x -> x));
    }

    @Encoding.Naming(value = "setEntries*")
    @Encoding.Init
    void setEntries(
      final Iterable<Tuple2<K, V>> entries)
    {
      this.map = LinkedHashMap.ofEntries(entries);
    }

    @Encoding.Build
    LinkedHashMap<K, V> build()
    {
      return this.map;
    }
  }
}
