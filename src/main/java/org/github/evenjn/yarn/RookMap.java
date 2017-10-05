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
 * <h1>RookMap</h1>
 * 
 * <p>
 * A {@code RookMap} provides a {@link #get(Rook,Object)} method to retrieve the
 * output object(s), if any, associated to a given input object while
 * transferring the responsiblity of closing any resources to the input
 * {@link org.github.evenjn.yarn.Rook Rook}.
 * </p>
 * 
 * <h2>Service Contract</h2>
 * 
 * <p>
 * An object implementing the {@code RookMap} interface fulfils the following
 * contract.
 * </p>
 * 
 * <p>
 * The {@link #get(Rook,Object)} method never returns {@code null}.
 * </p>
 * 
 * <p>
 * Multiple invocations of {@link #get(Rook,Object)} with the same argument
 * return containers with equal content.
 * </p>
 * 
 * <p>
 * Containers returned by invocations of {@link #get(Rook,Object)}, and the
 * object they provide access to, are not affected by subsequent invocations of
 * {@link #get(Rook,Object)}.
 * </p>
 * 
 * <p>
 * When processing an invocation of {@link #get(Rook,Object)} requires opening
 * {@linkplain java.lang.AutoCloseable closeable} resources (e.g. files) in
 * order to produce output objects, and those resources must stay open for the
 * output objects to work as intended, the {@code RookMap} opens those resources
 * and hooks them to the argument {@link org.github.evenjn.yarn.Rook Rook},
 * which takes the responsibility of closing those resources.
 * </p>
 * 
 * 
 * <h2>Disclaimer</h2>
 * 
 * <p>
 * An object implementing the {@code RookMap} interface does not provide
 * implicit guarantees.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that all elements in the cursor returned by
 * {@link #get(Rook,Object)} are not {@code null}. There is no implicit
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
 * that receives a {@code RookMap} should not assume that it is safe to have
 * multiple threads invoke {@link #get(Rook,Object)} on the same object.
 * </p>
 * 
 * <p>
 * However, classes implementing {@code RookMap} or interfaces extending
 * {@code RookMap} might provide explicit guarantees.
 * </p>
 *
 * @param <I>
 *          The type of input objects.
 * @param <O>
 *          The type of output objects.
 * @since 1.0
 */
@FunctionalInterface
public interface RookMap<I, O> {

	/**
	 * Returns a container with output objects associated to the argument input
	 * while transferring the responsiblity of closing any associated resources to
	 * the argument {@link org.github.evenjn.yarn.Rook Rook}.
	 * 
	 * @param rook
	 *          A {@link org.github.evenjn.yarn.Rook Rook}.
	 * @param input
	 *          An input object.
	 * @return A container of output objects.
	 * @since 1.0
	 */
	Object get( Rook rook, I input );
}
