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
 * <h1>Map</h1>
 * 
 * <p>
 * A {@code Map} provides a {@link #get(Object)} method to obtain the output
 * objects, if any, associated to a given input object.
 * </p>
 * 
 * <h2>Service Contract</h2>
 * 
 * <p>
 * An object implementing the {@code Map} interface fulfils the following
 * contract.
 * </p>
 * 
 * <p>
 * The {@link #get(Object)} method never returns {@code null}.
 * </p>
 * 
 * <h2>Disclaimer</h2>
 * 
 * <p>
 * An object implementing the {@code Map} interface does not provide implicit
 * guarantees.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that all elements in the containers returned
 * by {@link #get(Object)} are not {@code null}. There is no implicit guarantee
 * that the containers returned by {@link #get(Object)} are never empty.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that the {@link #get(Object)} works with any
 * input. In particular, it might or it might not work with {@code null} input.
 * We recommend that implementations throw an
 * {@link java.lang.IllegalArgumentException IllegalArgumentException} when
 * {@link #get(Object)} is invoked with an argument that is not supported.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that multiple invocations of
 * {@link #get(Object)} with the same argument return identical containers. (Two
 * containers {@code S} and {@code T} are identical if and only if
 * {@code S == T}.)
 * </p>
 * 
 * <p>
 * There is no implicit guarantee of thread safety. This means that a system
 * that receives a {@code Map} should not assume that it is safe to have
 * multiple threads invoke {@link #get(Object)} on the same object.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that containers returned by invocations of
 * {@link #get(Object)}, and the object they provide access to, are not affected
 * by subsequent invocations of {@link #get(Object)}.
 * </p>
 * 
 * <p>
 * However, classes implementing {@code Map} or interfaces extending {@code Map}
 * might provide explicit guarantees.
 * </p>
 *
 * @param <I>
 *          The type of input objects.
 * @param <O>
 *          The type of output objects.
 * @since 1.0
 */
public interface Map<I, O> {

	/**
	 * <p>
	 * Returns a container with output objects associated to the argument
	 * {@code input}.
	 * </p>
	 * 
	 * @param input
	 *          An input object.
	 * @return A container of output objects.
	 * @since 1.0
	 */
	Object get( I input );
}
