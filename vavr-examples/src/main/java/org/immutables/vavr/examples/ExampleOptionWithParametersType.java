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

package org.immutables.vavr.examples;

import org.immutables.value.Value;

import io.vavr.control.Option;

/**
 * An example with {@link Option} using {@link Value.Parameter} annotation
 */

@Value.Immutable
@org.immutables.vavr.encodings.VavrOptionEncodingEnabled
public interface ExampleOptionWithParametersType
{
  /**
   * @return Some data
   */
  @Value.Parameter
  Option<Integer> optionalInteger();
}