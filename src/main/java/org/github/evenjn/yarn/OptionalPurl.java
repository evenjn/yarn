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

import java.util.Optional;

/**
 * <h1>OptionalPurl</h1>
 * 
 * <p>
 * An {@code OptionalPurl} is a {@link org.github.evenjn.yarn.YarnPurl YarnPurl}
 * that provides access to output objects via {@link java.util.Optional}
 * containers.
 * </p>
 * 
 * <p>
 * This interface is part of package {@link org.github.evenjn.yarn Yarn}.
 * </p>
 *
 * @param <I>
 *          The type of input objects.
 * @param <O>
 *          The type of output objects.
 * @since 1.0
 */
public interface OptionalPurl<I, O> extends
		YarnPurl<I, O, Optional<O>> {

	/**
	 * <p>
	 * {@code next} returns an {@link java.util.Optional Optional} with none or
	 * one of the output objects associated to the sequence of elements received
	 * in input so far (including the argument {@code input}).
	 * </p>
	 * 
	 * @param input
	 *          An input object.
	 * @return An {@link java.util.Optional Optional} output object.
	 * @throws IllegalStateException
	 *           when {@link #end()} has already been invoked.
	 * @since 1.0
	 */
	@Override
	Optional<O> next( I input );

	/**
	 * <p>
	 * {@code end} returns an {@link java.util.Optional Optional} with none or one
	 * of the output objects associated to the sequence of elements received in
	 * input so far.
	 * </p>
	 * 
	 * @return An {@link java.util.Optional Optional} output object.
	 * @throws IllegalStateException
	 *           when {@link #end()} has already been invoked.
	 * @since 1.0
	 */
	@Override
	Optional<O> end( );

}
