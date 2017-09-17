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
 * An ArrayMap provides a method to retrieve the array of output elements
 * associated to any given input element.
 * </p>
 * 
 * <h2>Service Contract</h2>
 * 
 * <p>
 * An object implementing the {@code ArrayMap} interface fulfils the following
 * contract.
 * </p>
 * 
 * <p>
 * The {@link #get(Object)} method never returns {@code null}.
 * </p>
 * 
 * <p>
 * Multiple invocations of {@link #get(Object)} with the same argument return
 * arrays with equal length and equal content.
 * </p>
 * 
 * <p>
 * Arrays returned by invocations of {@link #get(Object)} are not affected by
 * subsequent invocations of {@link #get(Object)}.
 * </p>
 * 
 * <p>
 * There are no additional constraints in the service contract.
 * </p>
 * 
 * 
 * <h2>Disclaimer</h2>
 * 
 * <p>
 * An object implementing the {@code ArrayMap} interface does not provide
 * implicit guarantees.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that all elements the array returned by
 * {@link #get(Object)} are not {@code null}. There is no implicit guarantee
 * that the array returned by {@link #get(Object)} is not empty.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee that multiple invocations of
 * {@link #get(Object)} with the identical, equal or equivalent arguments return
 * identical arrays.
 * </p>
 * 
 * <p>
 * There is no implicit guarantee of thread safety. This means that a system
 * that receives a {@code ArrayMap} should not assume that it is safe to have
 * multiple threads invoke {@link #get(Object)} on the same object.
 * </p>
 * 
 * <p>
 * However, classes implementing ArrayMap or interfaces extending ArrayMap might
 * provide explicit guarantees.
 * </p>
 *
 * @param <I>
 *          The type of input objects.
 * @param <O>
 *          The type of output objects.
 */
@FunctionalInterface
public interface ArrayMap<I, O> {

	/**
	 * Retrieve the array of output references associated to the argument input
	 * reference. The resulting array may be empty.
	 * 
	 * @param input
	 *          An input object.
	 * @return An array of references to output objects. The array is never
	 *         {@code null}. The array may be empty. There is go guarantee that
	 *         all elements of the array are not {@code null}.
	 */
	O[] get( I input );
}
