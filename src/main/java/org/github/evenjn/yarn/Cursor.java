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
 * A Cursor provides access to a sequence of elements, each element being (a
 * reference to) an object.
 * </p>
 * 
 * <h2>Service Contract</h2>
 * 
 * <p>
 * An object implementing the {@code Cursor} interface fulfils the following
 * contract.
 * </p>
 * 
 * <p>
 * Elements can be accessed one by one, by invoking the {@link #next()} method.
 * The first time the method is invoked, the first element in the sequence is
 * returned. Subsequent invocations return successive elements. After all
 * elements have been returned, subsequent invocations will throw a
 * {@link EndOfCursorException}.
 * </p>
 * 
 * <h2>Disclaimer</h2>
 * 
 * <p>
 * An object implementing the {@code Cursor} interface does not provides
 * implicit guarantees. In particular: there is no implicit guarantee that
 * element references are not {@code null}; there is no implicit guarantee that
 * any two element references refer to distinct objects; there is no implicit
 * guarantee that, after an invocation of next, the element references returned
 * at previous invocations are valid. There is no implicit guarantee of thread
 * safety. This means that a system that receives a {@code Cursor} should not
 * assume that it is safe to have multiple threads invoke {@link #next()} on the
 * same object.
 * </p>
 * 
 * <h2>Design rationale</h2>
 * 
 * <p>
 * There are situations where we must develop a function that takes in input a
 * sequence of elements, but it does not need those elements to be all in memory
 * at the same time and it does not need to read that sequence more than once.
 * </p>
 * 
 * <p>
 * In such a situation, perhaps we might declare our function to take in input a
 * {@link java.util.List} or a {@link java.lang.Iterable}. These interfaces,
 * however, require clients to fulfil all the obligations that come with those
 * interfaces. With {@code List}, the clients must provide an object
 * implementing random access and allow modifications. With {@code Iterable},
 * the clients must provide an object that allows multiple parallel iterations.
 * </p>
 * 
 * <p>
 * Most of the times the clients invoking our function will have no problems in
 * fulfilling those obligations. But this could be too much of a burden when
 * dealing with a very large number of elements, or with systems that consume
 * resources to carry out iterations. In cases where {@code List} and
 * {@code Iterable} might place too much of a burdern on the clients, the
 * {@code Cursor} interface can solve the issue.
 * </p>
 * 
 * @author Marco Trevisan
 *
 * @param <I>
 *          The type of objects in the sequence.
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
