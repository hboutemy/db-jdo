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


package org.apache.jdo.impl.enhancer.classfile;

import java.io.*;
import java.util.Stack;
import java.util.Vector;
import java.util.Enumeration;

/**
 * ExceptionTable represents the exception handlers within the code
 * of a method.
 */
public class ExceptionTable {
    /* A variable length list of ExceptionRange objects */
    //@olsen: renamed theVector -> handlers
    private Vector handlers = new Vector();

    /* public accessors */

    /**
     * Return an enumeration of the exception handlers
     * Each element in the enumeration is an ExceptionRange
     */
    public Enumeration handlers() {
        return handlers.elements();
    }

    /**
     * Add an exception handler to the list
     */
    public void addElement(ExceptionRange range) {
        handlers.addElement(range);
    }

    public ExceptionTable() { }

    /**
     * Compares this instance with another for structural equality.
     */
    //@olsen: added method
    public boolean isEqual(Stack msg, Object obj) {
        if (!(obj instanceof ExceptionTable)) {
            msg.push("obj/obj.getClass() = "
                     + (obj == null ? null : obj.getClass()));
            msg.push("this.getClass() = "
                     + this.getClass());
            return false;
        }
        ExceptionTable other = (ExceptionTable)obj;

        if (this.handlers.size() != other.handlers.size()) {
            msg.push("handlers.size() "
                     + String.valueOf(other.handlers.size()));
            msg.push("handlers.size() "
                     + String.valueOf(this.handlers.size()));
            return false;
        }

        for (int i = 0; i < handlers.size(); i++) {
            ClassAttribute h1 = (ClassAttribute)this.handlers.get(i);
            ClassAttribute h2 = (ClassAttribute)other.handlers.get(i);
            if (!h1.isEqual(msg, h2)) {
                msg.push("handlers[" + i + "] = "
                         + String.valueOf(h2));
                msg.push("handlers[" + i + "] = "
                         + String.valueOf(h1));
                return false;
            }
        }
        return true;
    }

   /* package local methods */

    static ExceptionTable read(DataInputStream data, CodeEnv env)
        throws IOException {
        ExceptionTable excTable = new ExceptionTable();
        int nExcepts = data.readUnsignedShort();
        while (nExcepts-- > 0) {
            excTable.addElement(ExceptionRange.read(data, env));
        }
        return excTable;
    }

    void write(DataOutputStream out) throws IOException {
        out.writeShort(handlers.size());
        for (int i=0; i<handlers.size(); i++)
            ((ExceptionRange) handlers.elementAt(i)).write(out);
    }

    void print(PrintStream out, int indent) {
        ClassPrint.spaces(out, indent);
        out.println("Exception Table: ");
        for (int i=0; i<handlers.size(); i++)
            ((ExceptionRange) handlers.elementAt(i)).print(out, indent+2);
    }
}