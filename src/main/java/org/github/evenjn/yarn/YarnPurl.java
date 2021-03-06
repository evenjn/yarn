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
 * <h1>YarnPurl</h1>
 * 
 * <p>
 * A {@code YarnPurl} provides methods to obtain a sequence of output elements
 * associated to a sequence of input elements, building the resulting sequence
 * incrementally. We refer to this operation as <em>purl</em>, and to the
 * resulting sequence as the <em>result of the purl</em>
 * </p>
 * 
 * <h2>Protocol</h2>
 * 
 * <p>
 * An object implementing the {@code YarnPurl} interface requires that the
 * client invokes {@link #next(Object)} once for each element of the input
 * sequence, each time providing as argument an element of the input sequence,
 * in the same order they appear in the input sequence.
 * </p>
 * 
 * <p>
 * An object implementing the {@code YarnPurl} interface requires that, after
 * the client has invoked {@link #next(Object)} once for each element in the
 * input sequence, the client invokes {@link #end()}.
 * </p>
 * 
 * <p>
 * An object implementing the {@code YarnPurl} interface requires that, once the
 * client has invoked {@link #end()}, the client does not invoke {@link #end()}
 * or {@link #next(Object)} any more.
 * </p>
 * 
 * <h2>Service Contract</h2>
 * 
 * <p>
 * An object implementing the {@code YarnPurl} interface fulfils the following
 * contract.
 * </p>
 * 
 * <p>
 * The {@link #next(Object)} method never returns {@code null}.
 * </p>
 * 
 * <p>
 * The {@link #end()} method never returns {@code null}.
 * </p>
 * 
 * <h2>Disclaimer</h2>
 * 
 * <p>
 * An object implementing the {@code YarnPurl} interface does not provide
 * implicit guarantees.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that all elements in the containers returned
 * by {@link #next(Object)} or {@link #end()} are not {@code null}. There is no
 * implicit guarantee that the containers returned by {@link #next(Object)} or
 * {@link #end()} are never empty.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that the {@link #next(Object)} works with any
 * input. In particular, it might or it might not work with {@code null} input.
 * We recommend that implementations throw an
 * {@link java.lang.IllegalArgumentException IllegalArgumentException} when
 * {@link #next(Object)} is invoked with an argument that is not supported.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee of thread safety. This means that a system
 * that receives a {@code YarnPurl} should not assume that it is safe to have
 * multiple threads invoke {@link #next(Object)} or {@link #end()} on the same
 * object.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that containers returned by invocations of
 * {@link #next(Object)} or {@link #end()}, and the object they provide access
 * to, are not affected by subsequent invocations of {@link #next(Object)} or
 * {@link #end()}.
 * </p>
 * 
 * <p>
 * However, classes implementing {@code YarnPurl} or interfaces extending
 * {@code YarnPurl} might provide explicit guarantees.
 * </p>
 * 
 * <h2>Design Notes</h2>
 * 
 * <p>
 * A {@code YarnPurl} object may (and typically will) be stateful: it may
 * accumulate information while processing elements, and use such information to
 * produce output elements.
 * </p>
 * 
 * <p>
 * A {@code YarnPurl} object encapsulates state and behaviour necessary to carry
 * out a single operation. The same {@code YarnPurl} object cannot be reused to
 * carry out two or more purls. Compliant implementations must throw exception
 * accordingly.
 * </p>
 * 
 * <p>
 * {@code YarnPurl} is similar to {@link org.github.evenjn.yarn.YarnRingPurl
 * YarnRingPurl}. Unlike {@code YarnRingPurl}, {@code YarnPurl} does not provide
 * support for {@linkplain java.lang.AutoCloseable auto-closeable} resources.
 * </p>
 * 
 * <p>
 * This interface is part of package {@link org.github.evenjn.yarn Yarn}.
 * </p>
 * 
 * @param <I>
 *          The type of input elements.
 * @param <O>
 *          The type of output objects.
 * @param <C>
 *          The type of output object containers.
 * @since 1.0
 *
 */
public interface YarnPurl<I, O, C> {

	/**
	 * <p>
	 * {@code next} returns a container with none of, some of, or all the output
	 * objects associated to the sequence of elements received in input so far
	 * (including the argument {@code input}).
	 * </p>
	 * 
	 * @param input
	 *          An input object.
	 * @return A container of output objects.
	 * @throws IllegalStateException
	 *           when {@link #end()} has already been invoked.
	 * @since 1.0
	 */
	C next( I input )
			throws IllegalStateException;

	/**
	 * <p>
	 * {@code end} returns a container with none of, some of, or all the output
	 * objects associated to the sequence of elements received in input so far.
	 * </p>
	 * 
	 * @return A container of output objects.
	 * @throws IllegalStateException
	 *           when {@link #end()} has already been invoked.
	 * @since 1.0
	 */
	C end( )
			throws IllegalStateException;
}
