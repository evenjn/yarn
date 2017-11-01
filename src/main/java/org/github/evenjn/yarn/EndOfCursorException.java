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
 * <p>
 * An {@code EndOfCursorException} signals an attempt to read past the end of a
 * {@link org.github.evenjn.yarn.Cursor Cursor}.
 * </p>
 * 
 * <p>
 * A reference to the singleton {@code EndOfCursorException} object may be
 * obtained using static method {@link #neo()}.
 * </p>
 * 
 * <p>
 * This class is part of package {@link org.github.evenjn.yarn Yarn}.
 * </p>
 * 
 * @since 1.0
 */
public final class EndOfCursorException
		extends Exception {

	private static final long serialVersionUID = -4059996515894331359L;

	private EndOfCursorException() {
	}

	private static final EndOfCursorException neo =
			new EndOfCursorException( );

	/**
	 * <p>
	 * Returns a reference to the singleton {@code EndOfCursorException} object.
	 * </p>
	 * 
	 * @return a reference to the singleton {@code EndOfCursorException} object.
	 * 
	 * @since 1.0
	 */
	public static final EndOfCursorException neo( ) {
		return neo;
	}
}
