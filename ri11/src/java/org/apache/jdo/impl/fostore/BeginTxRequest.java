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

package org.apache.jdo.impl.fostore;

import java.io.DataInput;
import java.io.IOException;

/**
* Represents a request to inform the store that a transaction is beginning.
*
* @author Dave Bristor
*/
//
// This is client-side code.  It does not need to live in the server.
//
class BeginTxRequest extends AbstractRequest {
    /** Indicates whether an optimistic (true) or datastore (false)
     * transaction is started.
     */
    private final boolean optimistic;
    
    BeginTxRequest(Message m, FOStorePMF pmf, boolean optimistic) {
        super(m, pmf);
        this.optimistic = optimistic;
    }

    //
    // Methods from AbstractRequest
    //

    protected void doRequestBody() throws IOException {
        //
        // The format of this request is (aside from the request header):
        //
        // optimistic: boolean, indicates whether transaction is optimistic or
        // datastore
        //

        if (logger.isDebugEnabled()) 
            logger.debug("BeginTxRequest.dRB: " + optimistic); // NOI18N
        out.writeBoolean(optimistic);
    }

    //
    // Methods from Request
    //
    
    public void handleReply(Status status, DataInput in, int length)
        throws IOException {

        if (logger.isDebugEnabled()) 
            logger.debug("BeginTxRequest.hR: " + status); // NOI18N
    }
}