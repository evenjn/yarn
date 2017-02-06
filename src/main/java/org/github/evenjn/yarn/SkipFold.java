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
 * A {@code SkipFold} represents a process that transforms a sequence of input
 * elements into a sequence of output elements.
 * </p>
 * 
 * <p>
 * This process is carried out by feeding the {@code SkipFold} with the input
 * elements, one by one, in the exact order they appear in the sequence. For
 * each input element, the client must invoke the {@link #next(Object)} method,
 * passing the input element as argument.
 * </p>
 * 
 * <p>
 * After all the elements have been fed to the {@code SkipFold}, the client must
 * invoke the {@link #end()} method.
 * </p>
 * 
 * <p>
 * At the end of each invocation of either {@code next} or {@code end}, the
 * {@code SkipFold} returns an output element or throws a
 * {@link org.github.evenjn.yarn.SkipException SkipException} {@linkplain org.github.evenjn.yarn.SkipException ⚠}.
 * Client code should immediately catch and discard any {@code SkipException}
 * thrown. The only purpose of {@code SkipException} is to signal that no output
 * is available at this stage of the process.
 * </p>
 * 
 * 
 * <p>
 * Unlike {@link org.github.evenjn.yarn.OptionFold OptionFold}, this kind of
 * fold allows {@code null} output elements. We recommend client code to provide
 * {@code OptionFold} instead of {@code SkipFold} whenever the client code does
 * not produce {@code null} output elements. We recommend client code to require
 * {@code SkipFold} whenever the client can deal with {@code null} output
 * elements.
 * </p>
 *
 * @param <I>
 *          the type of input elements
 * @param <O>
 *          the type of output elements
 * @since 1.0
 */
public interface SkipFold<I, O> {

	/**
	 * <p>
	 * Takes the argument element, then returns an output element or throws a
	 * {@link org.github.evenjn.yarn.SkipException SkipException} {@linkplain org.github.evenjn.yarn.SkipException ⚠}.
	 * </p>
	 * 
	 * @param input
	 *          an input element. It may be {@code null}.
	 * @return an output element. It may be {@code null}.
	 * @throws SkipException
	 *           when no output is available.
	 * @since 1.0
	 */
	O next( I input )
			throws SkipException;

	/**
	 * <p>
	 * Resets this object to its initial state, then returns an output element, or
	 * throws a {@link org.github.evenjn.yarn.SkipException SkipException} {@linkplain org.github.evenjn.yarn.SkipException ⚠}.
	 * </p>
	 * <p>
	 * After the invocation of this method, this {@code SkipFold} object is ready
	 * to carry out a new fold.
	 * </p>
	 * 
	 * @return an output element. It may be {@code null}.
	 * @throws SkipException
	 *           when no output is available.
	 * @since 1.0
	 */
	default O end( )
			throws SkipException {
		throw SkipException.neo;
	}
}
