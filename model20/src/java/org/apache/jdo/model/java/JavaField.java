/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package org.apache.jdo.model.java;

/**
 * A JavaField instance represents a field declared by a class. It allows
 * to get detailed information about the field such as name, modifiers,
 * type, declaring class and the JDO meta data for the field (if
 * available). 
 * <p>
 * Different environments (runtime, enhancer, development) will have
 * different JavaField implementations to provide answers to the various
 * methods. 
 * 
 * @author Michael Bouschen
 * @since JDO 1.0.1
 * @version JDO 2.0
 */
public interface JavaField extends JavaMember 
{
}