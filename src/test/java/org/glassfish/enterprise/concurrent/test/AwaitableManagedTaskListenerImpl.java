/*
 * Copyright (c) 2023 Contributors to the Eclipse Foundation
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
package org.glassfish.enterprise.concurrent.test;

import jakarta.enterprise.concurrent.ManagedExecutorService;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.glassfish.enterprise.concurrent.test.ManagedTaskListenerImpl;

/**
 *
 * @author Ondro Mihalyi
 */
public class AwaitableManagedTaskListenerImpl extends ManagedTaskListenerImpl {

    private CompletableFuture taskDone = new CompletableFuture<Void>();

    @Override
    public void taskDone(Future<?> future, ManagedExecutorService executor, Object task, Throwable exception) {
        super.taskDone(future, executor, task, exception);
        taskDone.complete(null);
    }

    public CompletableFuture whenDone() {
        return taskDone;
    }

}
