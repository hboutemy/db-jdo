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

package org.apache.jdo.pc;

import java.util.HashSet;

/**
* A sample department class. Used with other classes which 
* names end with "1".
*
* @author Marina Vatkina.
*/
public class PCDepartment1 {
    public long deptid;
    
    public String name;
    
    public java.util.HashSet employees;

    public String toString() {
        return "Dept: " + name + ", id=" + deptid +
            ", emps: " + employees.size();
    }

    public PCDepartment1() {
    }

    public PCDepartment1(long _id, String _name) {
        deptid = _id;
        name = _name;
    }
    
    public long getDeptid() {
        return deptid;
    }
    
    public void setDeptid(long deptid) {
        this. deptid = deptid;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this. name = name;
    }
    
    public java.util.HashSet getEmployees() {
        return employees;
    }
    
    public void setEmployees(java.util.HashSet employees) {
        this. employees = employees;
    }
    
    public static class Oid {
        public long deptid;
        
        public Oid() {
        }
        
        public boolean equals(java.lang.Object obj) {
            if( obj==null ||
            !this.getClass().equals(obj.getClass()) ) return( false );
            Oid o=(Oid) obj;
            if( this.deptid!=o.deptid ) return( false );
            return( true );
        }
        
        public int hashCode() {
            int hashCode=0;
            hashCode += deptid;
            return( hashCode );
        }
    }
}
