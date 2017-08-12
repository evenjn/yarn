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
 * A Cursor provides access to a sequence of references to objects.
 * </p>
 * 
 * <p>
 * References can only be accessed one by one, by invoking the {@link #next()}
 * method. In this respect Cursor is similar to {@link java.util.Iterator}.
 * </p>
 * 
 * <p>
 * There are no restrictions on the references. In particular: there is no
 * guarantee that references are not {@code null}; there is no guarantee that
 * any two references refer to distinct objects; there is no guarantee that,
 * after an invocation of next, the references returned at previous invocations
 * are valid.
 * </p>
 * 
 * @author Marco Trevisan
 *
 * @param <I>
 *          The type of elements in the cursor.
 * @since 1.0
 */
public interface Cursor<I> {

	/**
	 * Returns a reference to the next object in the sequence. It might be
	 * {@code null}.
	 * 
	 * @return A reference to the next object in the sequence. It might be
	 *         {@code null}.
	 * @throws EndOfCursorException
	 *           When all references in the sequence have already been returned.
	 * @since 1.0
	 */
	I next( )
			throws EndOfCursorException;
}
