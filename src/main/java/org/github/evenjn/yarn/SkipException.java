/**
 *
 * Copyright 2017 Marco Trevisan
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
 * 
 */
package org.github.evenjn.yarn;

/**
 * {@link org.github.evenjn.yarn.SkipMap SkipMap} and
 * {@link org.github.evenjn.yarn.SkipFold SkipFold} use {@code SkipException} to
 * signal that no output is associated to the given input.
 * 
 * <h2>⚠ Warning</h2>
 * <p>
 * Code that relies on exceptions to implement anything other than aborting and
 * logging is error-prone. This is the case even with so-called <em>checked
 * exceptions</em>. Specifically, adding an invocation that throws a checked
 * exception into a block that already deals with that exception gives no
 * warning to the developer, and the fact that the invocation throws a checked
 * exception may go unnoticed. If so, this introduces a hidden control flow path
 * which may have unintended consequences.
 * </p>
 * 
 * <p>
 * Code that deals with exceptions, either by floating them or by catching them,
 * always requires a careful inspection of all signatures of invoked methods to
 * make sure no hidden control flow paths exist. For this reason, exceptions are
 * best avoided if possible.
 * </p>
 * 
 * <p>
 * In particular, we recommend against using {@code SkipException} for purposes
 * other than its intended one. This means we recommend not to declare functions
 * that throw {@code SkipException} except functions that implement interface
 * methods.
 * </p>
 */
public final class SkipException
		extends Exception {

	private static final long serialVersionUID = -2291360632606432290L;

	private SkipException() {
	}

	/**
	 * Singleton instance.
	 */
	public static final SkipException neo = new SkipException( );
}
