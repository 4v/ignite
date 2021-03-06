/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.processors.odbc;

import org.apache.ignite.internal.GridKernalContext;
import org.apache.ignite.internal.util.GridSpinBusyLock;

/**
 * Connection-related data.
 */
class OdbcConnectionData {
    /** Request handler. */
    private final OdbcRequestHandler handler;

    /** Message parser. */
    private final OdbcMessageParser parser;

    /**
     * Constructor.
     *
     * @param ctx Context.
     * @param busyLock Shutdown busy lock.
     * @param maxCursors Maximum cursors.
     */
    public OdbcConnectionData(GridKernalContext ctx, GridSpinBusyLock busyLock, int maxCursors) {
        handler = new OdbcRequestHandler(ctx, busyLock, maxCursors);
        parser = new OdbcMessageParser(ctx);
    }

    /**
     * Handler getter.
     * @return Request handler for the connection.
     */
    public OdbcRequestHandler getHandler() {
        return handler;
    }

    /**
     * Parser getter
     * @return Message parser for the connection.
     */
    public OdbcMessageParser getParser() {
        return parser;
    }
}
