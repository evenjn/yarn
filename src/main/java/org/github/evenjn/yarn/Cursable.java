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
 * A Cursable provides repeatable access to a sequence of elements, each element
 * being (a reference to) an object.
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
 * Elements in the sequence can be accessed through a {@link Cursor} obtained by
 * invoking {@link #pull(Rook)}. The function {@link #pull(Rook)} never returns
 * {@code null}.
 * </p>
 * 
 * <p>
 * Whenever it is necessary to acquire {@linkplain java.lang.AutoCloseable
 * auto-closeable} resources (such as files or connections) in order to access
 * those elements, the cursable acquires those resources autonomously and
 * delegates the release of those resources via the argument
 * {@link org.github.yarn.Rook Rook}. (The actor that created the {@code Rook}
 * takes the responsibility of closing them as soon as the returned
 * {@code Cursor} is not needed).
 * </p>
 * 
 * <p>
 * Multiple cursors may be used in parallel, as long as there are enough
 * computational resources to do so.
 * </p>
 * 
 * <p>
 * Let {@code Foobar} be any function that combines information obtained
 * exclusively from the argument {@code Cursable} and its elements. As long as
 * {@code Foobar} never changes the state of the objects accessbile via the
 * argument {@code Cursable}, the results of mutiple invocations of
 * {@code Foobar} on the same argument are all equal to each other.
 * </p>
 * 
 * <p>
 * There are no other constraints in the service contract.
 * </p>
 * 
 * 
 * <h2>Disclaimer</h2>
 * 
 * <p>
 * An object implementing the {@code Cursable} interface does not provide
 * implicit guarantees.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that element references are not {@code null}.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that any two element references refer to
 * distinct objects.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee of thread safety. This means that a system
 * that receives a {@code Cursable} should not assume that it is safe to have
 * multiple threads invoke {@link #pull(Rook)} on the same object.
 * </p>
 * 
 * <p>
 * However, classes implementing Cursor or interfaces extending Cursor might
 * provide explicit guarantees.
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
 * There is no need to reach the end of a cursor before obtaining another one.
 * </p>
 * 
 * @param <I>
 *          The type of objects in the sequence.
 * @since 1.0
 * 
 */
@FunctionalInterface
public interface Cursable<I> {

	/**
	 * Returns a cursor iterating over the elements in this sequence.
	 * 
	 * @param rook
	 *          An object that takes the responsibility to close the resources
	 *          that have been opened to obtain access to the elements in this
	 *          sequence.
	 * @return A cursor iterating over the elements in this sequence.
	 * @since 1.0
	 */
	Cursor<I> pull( Rook rook );
}
