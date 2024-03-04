/*
 * Copyright (c) 2010, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package org.glassfish.concurro.test;

public class RunnableImpl extends TaskRunEnvironmentTracker implements Runnable {
    public volatile boolean runCalled = false;
    protected RuntimeException runException = null;
    
    public RunnableImpl(ManagedTaskListenerImpl taskListener) {
        super(taskListener);
    }
    
    public RunnableImpl(ManagedTaskListenerImpl taskListener, RuntimeException runException) {
        super(taskListener);
        this.runException = runException;
    }
    
    @Override
    public void run() {
        captureThreadContexts();
        runCalled = true;
        if (runException != null) {
            throw runException;
        }
    }

    @Override
    public int hashCode() {
        captureThreadContexts();
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        captureThreadContexts();
        return super.equals(obj);
    }

    @Override
    public String toString() {
        captureThreadContexts();
        return super.toString();
    }
}
