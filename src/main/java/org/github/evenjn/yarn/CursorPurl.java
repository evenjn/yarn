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
 * 
 * <h1>Purl</h1>
 * 
 * <p>
 * To purl a sequence of elements means to transform it into another sequence of
 * elements by means of a purl machine.
 * </p>
 * 
 * <p>
 * A purl machine is a system designed to receive input elements orderly, one by
 * one, via invocations of {@link #next(Object)}, and to produce zero, one or more
 * output elements for each such input element.
 * </p>
 * 
 * <p>
 * Moreover, a purl machine is designed to be given the chance to finalize the
 * transformation, via the invocation of {@link #end()}, after it received all
 * the input elements. At this time the purl machine has one last chance to
 * produce zero, one or more output elements.
 * </p>
 * 
 * <p>
 * The result of the transformation is the sequence obtained by concatenating
 * all sequences of output elements produced by the purl machine.
 * </p>
 * 
 * <p>
 * The purl machine may (and typically will) be stateful: it may accumulate
 * information while processing elements, and use such information to produce
 * output elements.
 * </p>
 * 
 * <p>
 * A purl machine encapsulates state and behaviour necessary to carry out a
 * single purl transformation. The same purl machine cannot be reused to carry
 * out two or more purl transformations. Compliant implementations must throw
 * exception accordingly.
 * </p>
 * 
 * <h1>CursorPurl</h1>
 * 
 * <p>
 * A CursorPurl implements a purl machine that aggregates output elements into
 * {@link org.github.evenjn.yarn.Cursor Cursors}.
 * </p>
 * 
 * @author Marco Trevisan
 *
 * @param <I>
 *          The type of elements input to the purl transformation.
 * @param <O>
 *          The type of elements output of the purl transformation.
 * @since 1.0
 */
public interface CursorPurl<I, O> {

	/**
	 * <p>
	 * Returns a cursor of output elements produced by taking into accout some of,
	 * none of or all the input elements received in input so far (including the
	 * argument {@code input}), possibily taking order into account.
	 * </p>
	 * 
	 * <p>
	 * There is no guarantee that the returned cursor (and/or any objects it
	 * provides access to) will survive subsequent invocations of {@link #next(Object)}
	 * and/or {@link #end()}.
	 * </p>
	 * 
	 * <p>
	 * Invoking this function might invalidate cursors (and/or any objects they
	 * provide access to) returned in previous invocations of {@link #next(Object)}.
	 * </p>
	 * 
	 * @param input
	 *          An input element.
	 * @return A cursor of output elements produced by taking into accout some of,
	 *         none of or all the input elements received in input so far
	 *         (including the argument {@code input}), possibily taking order into
	 *         account.
	 * @throws IllegalStateException
	 *           when {@link #end()} has already been invoked.
	 * @since 1.0
	 */
	Cursor<O> next( I input )
			throws IllegalStateException;

	/**
	 * <p>
	 * Returns a cursor of output elements produced by taking into accout some of,
	 * none of or all the input elements received in input so far, possibily
	 * taking order into account.
	 * </p>
	 * 
	 * <p>
	 * Invoking this function might invalidate cursors (and/or any objects they
	 * provide access to) returned in previous invocations of {@link #next(Object)}.
	 * </p>
	 * 
	 * @return A cursor of output elements produced by taking into accout some of,
	 *         none of or all the input elements received in input so far
	 *         (including the argument {@code input}), possibily taking order into
	 *         account.
	 * @throws IllegalStateException
	 *           when {@link #end()} has already been invoked.
	 * @since 1.0
	 */
	Cursor<O> end( )
			throws IllegalStateException;
}
