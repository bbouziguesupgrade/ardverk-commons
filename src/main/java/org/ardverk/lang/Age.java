/*
 * Copyright 2010-2011 Roger Kapsi
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.ardverk.lang;

import java.util.concurrent.TimeUnit;

/**
 * Objects that have an age may implement this interface.
 */
public interface Age {

  /**
   * Returns the amount of elapsed time in the given {@link TimeUnit}.
   */
  public long getAge(TimeUnit unit);
  
  /**
   * Returns the amount of elapsed time in milliseconds.
   */
  public long getAgeInMillis();
}