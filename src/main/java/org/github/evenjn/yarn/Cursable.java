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

import org.github.evenjn.lang.Rook;

/**
 * <p>
 * A Cursable provides repeatable iterative access to a sequence of elements,
 * each element being (a reference to) an object.
 * </p>
 * 
 * <h2>Protocol</h2>
 * 
 * <p>
 * Elements in the sequence can be accessed through a
 * {@link org.github.evenjn.yarn.Cursor Cursor} obtained by invoking
 * {@link #pull(Rook)}.
 * </p>
 * 
 * <p>
 * Whenever it is necessary to acquire {@linkplain java.lang.AutoCloseable
 * auto-closeable} resources (such as files or connections) in order to access
 * those elements, the cursable acquires those resources autonomously and
 * delegates the release of those resources via the argument
 * {@link org.github.evenjn.lang.Rook Rook}. (The actor that created the {@code Rook}
 * takes the responsibility of closing them as soon as the returned
 * {@code Cursor} is not needed).
 * </p>
 * 
 * <h2>Service Contract</h2>
 * 
 * <p>
 * An object implementing the {@code Cursable} interface fulfils the following
 * contract.
 * </p>
 * 
 * <p>
 * The function {@link #pull(Rook)} never returns {@code null}.
 * </p>
 * 
 * <p>
 * Multiple cursors may be used in parallel, as long as there are enough
 * computational resources to do so. There is no need to reach the end of a
 * cursor before obtaining another one.
 * </p>
 * 
 * <h2>Disclaimer</h2>
 * 
 * <p>
 * An object implementing the {@code Cursable} interface does not provide
 * implicit guarantees.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee of thread safety. This means that a system
 * that receives a {@code Cursable} should not assume that it is safe to have
 * multiple threads invoke {@link #pull(Rook)} on the same object.
 * </p>
 * 
 * <p>
 * However, classes implementing {@code Cursable} or interfaces extending
 * {@code Cursable} might provide explicit guarantees.
 * </p>
 * 
 * <h2>Design rationale</h2>
 * 
 * <p>
 * This interface is designed to be used in signatures of functions that read
 * sequences of elements, do not need those elements to be all in memory at the
 * same time and might need to read that sequence more than once.
 * </p>
 * 
 * <p>
 * This interface is part of package {@link org.github.evenjn.yarn Yarn}.
 * </p>
 * 
 * @param <I>
 *          The type of objects in the sequence.
 * @since 1.0
 */
@FunctionalInterface
public interface Cursable<I> {

	/**
	 * Returns a {@link org.github.evenjn.yarn.Cursor Cursor} providing access to
	 * the elements in this sequence.
	 * 
	 * @param rook
	 *          An object that takes the responsibility to close the resources
	 *          that have been opened to obtain access to the elements in this
	 *          sequence.
	 * @return A {@link org.github.evenjn.yarn.Cursor Cursor} providing access to
	 *         the elements in this sequence.
	 * @since 1.0
	 */
	Cursor<I> pull( Rook rook );
}
