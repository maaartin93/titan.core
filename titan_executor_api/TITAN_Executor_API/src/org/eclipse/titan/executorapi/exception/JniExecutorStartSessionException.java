/******************************************************************************
 * Copyright (c) 2000-2019 Ericsson Telecom AB
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/org/documents/epl-2.0/EPL-2.0.html
 *
 * Contributors:
 *   Balasko, Jeno
 *   Lovassy, Arpad
 *
 ******************************************************************************/
package org.eclipse.titan.executorapi.exception;

import org.eclipse.titan.executorapi.JniExecutor;

/**
 *  Exception for startSession(), it is thrown, when {@link JniExecutor#startSession} returns with a port number, which is <= 0.
 *  @see JniExecutor#startSession()
 */
public class JniExecutorStartSessionException extends JniExecutorException {

	/**
	 * Generated serial version ID
	 * (to avoid warning)
	 */
	private static final long serialVersionUID = 1424510192926444506L;

	public JniExecutorStartSessionException( final String aMsg ) {
		super( aMsg );
	}
}
