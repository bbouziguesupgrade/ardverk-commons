/*
 * Copyright 2009, 2010 Roger Kapsi
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.ardverk.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @see AsyncExecutorService
 * @see AsyncProcessExecutor
 */
public interface AsyncProcessExecutorService 
        extends AsyncExecutorService, AsyncProcessExecutor {

    /**
     * Sets the default timeout for {@link #submit(AsyncProcess)}
     */
    public void setTimeout(long timeout, TimeUnit unit);
    
    /**
     * Returns the default timeout for {@link #submit(AsyncProcess)}
     */
    public long getTimeout(TimeUnit unit);
    
    /**
     * Returns the default timeout for {@link #submit(AsyncProcess)} 
     * in milliseconds.
     */
    public long getTimeoutInMillis();
    
    /**
     * Submits the given {@link AsyncProcess} for execution.
     * 
     * @see #getTimeout(TimeUnit)
     * @see #setTimeout(long, TimeUnit)
     */
    public <T> AsyncFuture<T> submit(AsyncProcess<T> process);
    
    /**
     * Submits the given {@link AsyncProcess} for execution.
     */
    public <T> AsyncFuture<T> submit(AsyncProcess<T> process, 
            long timeout, TimeUnit unit);
}
