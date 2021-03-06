/*
 * Copyright 2010-2012 Roger Kapsi
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

/**
 * An object that is bindable to some other object.
 */
public interface Bindable<T> {

  /**
   * Binds this to the given object.
   */
  public void bind(T t) throws Exception;
  
  /**
   * Unbinds this from the other object.
   */
  public void unbind() throws Exception;
  
  /**
   * Returns {@code true} if this object is bound to some other Object.
   */
  public boolean isBound();
}