/*
 * Copyright 2005 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */

/*
 * QueryResultIterator.java
 *
 * Created on March 18, 2001, 12:34 PM
 */

package org.apache.jdo.query;

/** This interface is used to iterate a query result.  It is
 * returned to the user in response to the iterator() method
 * of the query result Collection.
 * @author Craig Russell
 * @version 0.9
 */
public interface QueryResultIterator extends java.util.Iterator {

    /** Close this iterator and release any resources held.  After
     * this method completes, the iterator will return false to
     * hasNext(), and will throw NoSuchElementException to next().
     */
    void close();
    
}
