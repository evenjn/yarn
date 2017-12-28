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
 * <h1>YarnRingMap</h1>
 * 
 * <p>
 * A {@code YarnRingMap} provides a {@link #get(Rook,Object)} method to retrieve
 * the output objects, if any, associated to given input objects while
 * transferring the responsiblity of closing any associated
 * {@linkplain java.lang.AutoCloseable auto-closeable} resources to
 * {@link org.github.evenjn.lang.Rook Rook} objects.
 * </p>
 * 
 * <h2>Service Contract</h2>
 * 
 * <p>
 * An object implementing the {@code YarnRingMap} interface fulfils the
 * following contract.
 * </p>
 * 
 * <p>
 * The {@link #get(Rook,Object)} method never returns {@code null}.
 * </p>
 * 
 * <p>
 * When processing an invocation of {@link #get(Rook,Object)} requires opening
 * {@linkplain java.lang.AutoCloseable closeable} resources (e.g. files) in
 * order to produce output objects, and those resources must stay open for the
 * output objects to work as intended, the {@code YarnRingMap} opens those
 * resources and hooks them to the argument {@link org.github.evenjn.lang.Rook
 * Rook}, which takes the responsibility of closing those resources.
 * </p>
 * 
 * <h2>Disclaimer</h2>
 * 
 * <p>
 * An object implementing the {@code YarnRingMap} interface does not provide
 * implicit guarantees.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that all elements in the containers returned
 * by {@link #get(Rook,Object)} are not {@code null}. There is no implicit
 * guarantee that the containers returned by {@link #get(Rook,Object)} are never
 * empty.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that the {@link #get(Rook,Object)} works with
 * any input. In particular, it might or it might not work with {@code null}
 * input. We recommend that implementations throw an
 * {@link java.lang.IllegalArgumentException IllegalArgumentException} when
 * {@link #get(Rook,Object)} is invoked with an argument that is not supported.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that multiple invocations of
 * {@link #get(Rook,Object)} with the same argument return identical containers.
 * (Two containers {@code S} and {@code T} are identical if and only if
 * {@code S == T}.)
 * </p>
 * 
 * <p>
 * There is no implicit guarantee of thread safety. This means that a system
 * that receives a {@code YarnRingMap} should not assume that it is safe to have
 * multiple threads invoke {@link #get(Rook,Object)} on the same
 * {@code YarnRingMap} object.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that containers returned by invocations of
 * {@link #get(Rook,Object)}, and the object they provide access to, are not
 * affected by subsequent invocations of {@link #get(Rook,Object)}.
 * </p>
 * 
 * <p>
 * However, classes implementing {@code YarnRingMap} or interfaces extending
 * {@code YarnRingMap} might provide explicit guarantees.
 * </p>
 * 
 * <p>
 * This interface is part of package {@link org.github.evenjn.yarn Yarn}.
 * </p>
 *
 * @param <I>
 *          The type of input objects.
 * @param <O>
 *          The type of output object.
 * @param <C>
 *          The type of output object containers.
 * @since 1.0
 */
@FunctionalInterface
public interface YarnRingMap<I, O, C> {

	/**
	 * <p>
	 * Returns a container with output objects associated to the argument input
	 * while transferring the responsiblity of closing any associated resources to
	 * the argument {@link org.github.evenjn.lang.Rook Rook}.
	 * </p>
	 * 
	 * @param rook
	 *          A {@link org.github.evenjn.lang.Rook Rook}.
	 * @param input
	 *          An input object.
	 * @return A container of output objects.
	 * @since 1.0
	 */
	C get( Rook rook, I input );
}
