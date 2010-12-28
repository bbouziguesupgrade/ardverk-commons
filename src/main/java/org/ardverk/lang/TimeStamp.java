/*
 * Copyright 2010 Roger Kapsi
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

package org.ardverk.lang;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * A {@link TimeStamp} is a relative point in the JVM's time. It's based on
 * {@link System#nanoTime()} and like nano time it's only good for measuring 
 * elapsed time. It's not related to any other notion of system or wall-clock 
 * time.
 */
public class TimeStamp implements Epoch, Age, Comparable<TimeStamp>, Serializable {
    
    private static final long serialVersionUID = -981788126324372167L;

    /**
     * The initial system time (UTC). We use/need it to terminate the 
     * {@link TimeStamp}'s creation time.
     */
    private static final long INIT_SYSTEM_TIME = System.currentTimeMillis();
    
    /**
     * The initial JVM time. We use/need it to terminate the {@link TimeStamp}'s
     * creation time.
     */
    private static final long INIT_TIME_STAMP = System.nanoTime();
    
    /**
     * Creates and returns a {@link TimeStamp}.
     */
    public static TimeStamp now() {
        return new TimeStamp();
    }
    
    /**
     * The JVM time when this {@link TimeStamp} was created. We must store it
     * as a relative value to enable serialization because the time as returned
     * by {@link System#nanoTime()} is some fixed but arbitrary time.
     */
    private final long timeStamp = System.nanoTime() - INIT_TIME_STAMP;
    
    private TimeStamp() {}
    
    /**
     * Returns the {@link TimeStamp}'s value
     * 
     * @see System#nanoTime()
     */
    public long getTimeStamp() {
        return INIT_TIME_STAMP + timeStamp;
    }
    
    @Override
    public long getCreationTime() {
        return INIT_SYSTEM_TIME + TimeUnit.NANOSECONDS.toMillis(timeStamp);
    }
    
    /**
     * Returns the {@link TimeStamp}'s age in nanoseconds.
     * 
     * <p>NOTE: This is the internal/native representation of the
     * {@link TimeStamp}'s age.
     */
    public long getAgeInNanos() {
        return System.nanoTime() - getTimeStamp();
    }
    
    @Override
    public long getAge(TimeUnit unit) {
        return unit.convert(getAgeInNanos(), TimeUnit.NANOSECONDS);
    }
    
    @Override
    public long getAgeInMillis() {
        return getAge(TimeUnit.MILLISECONDS);
    }
    
    @Override
    public int compareTo(TimeStamp other) {
        return Longs.compare(timeStamp, other.timeStamp);
    }
    
    @Override
    public int hashCode() {
        return (int)timeStamp;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof TimeStamp)) {
            return false;
        }
        
        TimeStamp other = (TimeStamp)o;
        return timeStamp == other.timeStamp;
    }
    
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Creation Time: ").append(new Date(getCreationTime()))
            .append(", Age=").append(getAgeInMillis()).append("ms");
        return buffer.toString();
    }
}
