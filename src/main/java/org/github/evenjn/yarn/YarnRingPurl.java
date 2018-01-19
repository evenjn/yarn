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
 * <h1>YarnRingPurl</h1>
 * 
 * <p>
 * A {@code YarnRingPurl} provides methods to obtain a sequence of output
 * elements associated to a sequence of input elements, building the resulting
 * sequence incrementally, while transferring the responsiblity of closing any
 * associated {@linkplain java.lang.AutoCloseable auto-closeable} resources to
 * {@link org.github.evenjn.lang.Rook Rook} objects. We refer to this operation
 * as <em>purl</em>, and to the resulting sequence as the <em>result of the
 * purl</em>
 * </p>
 * 
 * <p>
 * The <em>result of a purl</em> is the sequence obtained by concatenating all
 * sequences of output elements returned by all invocations of
 * {@link #next(Rook,Object)} and {@link #end(Rook)}, in the same order they
 * were returned.
 * </p>
 * 
 * <h2>Protocol</h2>
 * 
 * <p>
 * An object implementing the {@code YarnRingPurl} interface requires that the
 * client invokes {@link #next(Rook,Object)} once for each element of the input
 * sequence, each time providing as argument an element of the input sequence,
 * in the same order they appear in the input sequence.
 * </p>
 * 
 * <p>
 * An object implementing the {@code YarnRingPurl} interface requires that,
 * after the client has invoked {@link #next(Rook,Object)} once for each element
 * in the input sequence, the client invokes {@link #end(Rook)}.
 * </p>
 * 
 * <p>
 * An object implementing the {@code YarnRingPurl} interface requires that, once
 * the client has invoked {@link #end(Rook)}, the client does not invoke
 * {@link #end(Rook)} or {@link #next(Rook,Object)} any more.
 * </p>
 * 
 * <h2>Service Contract</h2>
 * 
 * <p>
 * An object implementing the {@code YarnRingPurl} interface fulfils the
 * following contract.
 * </p>
 * 
 * <p>
 * The {@link #next(Rook,Object)} method never returns {@code null}.
 * </p>
 * 
 * <p>
 * The {@link #end(Rook)} method never returns {@code null}.
 * </p>
 * 
 * <p>
 * When processing an invocation of {@link #next(Rook,Object)} or
 * {@link #end(Rook)} requires opening {@linkplain java.lang.AutoCloseable
 * auto-closeable} resources (e.g. files) in order to produce output objects,
 * and those resources must stay open for the output objects to work as
 * intended, the {@code YarnRingPurl} opens those resources and hooks them to
 * the argument {@link org.github.evenjn.lang.Rook Rook}, which takes the
 * responsibility of closing those resources.
 * </p>
 * 
 * <h2>Disclaimer</h2>
 * 
 * <p>
 * An object implementing the {@code YarnRingPurl} interface does not provide
 * implicit guarantees.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that all elements in the containers returned
 * by {@link #next(Rook,Object)} or {@link #end(Rook)} are not {@code null}.
 * There is no implicit guarantee that the containers returned by
 * {@link #next(Rook,Object)} or {@link #end(Rook)} are never empty.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that the {@link #next(Rook,Object)} works with
 * any input. In particular, it might or it might not work with {@code null}
 * input. We recommend that implementations throw an
 * {@link java.lang.IllegalArgumentException IllegalArgumentException} when
 * {@link #next(Rook,Object)} is invoked with an argument that is not supported.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee of thread safety. This means that a system
 * that receives a {@code YarnRingPurl} should not assume that it is safe to
 * have multiple threads invoke {@link #next(Rook,Object)} or {@link #end(Rook)}
 * on the same object.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that containers returned by invocations of
 * {@link #next(Rook,Object)} or {@link #end(Rook)}, and the object they provide
 * access to, are not affected by subsequent invocations of
 * {@link #next(Rook,Object)} or {@link #end(Rook)}.
 * </p>
 * 
 * <p>
 * However, classes implementing {@code YarnRingPurl} or interfaces extending
 * {@code YarnRingPurl} might provide explicit guarantees.
 * </p>
 * 
 * <h2>Design Notes</h2>
 * 
 * <p>
 * A {@code YarnRingPurl} object may (and typically will) be stateful: it may
 * accumulate information while processing elements, and use such information to
 * produce output elements.
 * </p>
 * 
 * <p>
 * A {@code YarnRingPurl} object encapsulates state and behaviour necessary to
 * carry out a single operation. The same {@code YarnRingPurl} object cannot be
 * reused to carry out two or more purl transformations. Compliant
 * implementations must throw exception accordingly.
 * </p>
 * 
 * <p>
 * {@code YarnRingPurl} is similar to {@link org.github.evenjn.yarn.YarnPurl
 * YarnPurl}. Unlike {@code YarnRingPurl}, {@code YarnPurl} does not provide
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
public interface YarnRingPurl<I, O, C> {

	/**
	 * <p>
	 * {@code next} returns a container with none of, some of, or all the output
	 * objects associated to the sequence of elements received in input so far
	 * (including the argument {@code input}), while transferring the
	 * responsiblity of closing any associated resources to the argument
	 * {@link org.github.evenjn.lang.Rook Rook}.
	 * </p>
	 * 
	 * @param rook
	 *          A {@link org.github.evenjn.lang.Rook Rook}.
	 * @param input
	 *          An input object.
	 * @return A container of output objects.
	 * @throws IllegalStateException
	 *           when {@link #end(Rook)} has already been invoked.
	 * @since 1.0
	 */
	C next( Rook rook, I input )
			throws IllegalStateException;

	/**
	 * <p>
	 * {@code end} returns a container with none of, some of, or all the output
	 * objects associated to the sequence of elements received in input so far,
	 * while transferring the responsiblity of closing any associated resources to
	 * the argument {@link org.github.evenjn.lang.Rook Rook}.
	 * </p>
	 * 
	 * @param rook
	 *          A {@link org.github.evenjn.lang.Rook Rook}.
	 * @return A container of output objects.
	 * @throws IllegalStateException
	 *           when {@link #end(Rook)} has already been invoked.
	 * @since 1.0
	 */
	C end( Rook rook )
			throws IllegalStateException;
}
