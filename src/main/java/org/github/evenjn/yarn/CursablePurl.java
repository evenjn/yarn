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
 * <h1>CursablePurl</h1>
 * 
 * <p>
 * A {@code CursablePurl} is a {@link org.github.evenjn.yarn.YarnPurl YarnPurl}
 * that provides access to output objects via
 * {@link org.github.evenjn.yarn.Cursable Cursable} containers.
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
public interface CursablePurl<I, O> extends
		YarnPurl<I, O, Cursable<O>> {

	/**
	 * <p>
	 * {@code next} returns a {@link org.github.evenjn.yarn.Cursable Cursable}
	 * with none of, some of, or all the output objects associated to the sequence
	 * of elements received in input so far (including the argument
	 * {@code input}).
	 * </p>
	 * 
	 * @param input
	 *          An input object.
	 * @return A {@link org.github.evenjn.yarn.Cursable Cursable} of output
	 *         objects.
	 * @throws IllegalStateException
	 *           when {@link #end()} has already been invoked.
	 * @since 1.0
	 */
	@Override
	Cursable<O> next( I input );

	/**
	 * <p>
	 * {@code end} returns a {@link org.github.evenjn.yarn.Cursable Cursable} with
	 * none of, some of, or all the output objects associated to the sequence of
	 * elements received in input so far.
	 * </p>
	 * 
	 * @return A {@link org.github.evenjn.yarn.Cursable Cursable} of output
	 *         objects.
	 * @throws IllegalStateException
	 *           when {@link #end()} has already been invoked.
	 * @since 1.0
	 */
	@Override
	Cursable<O> end( );
}
