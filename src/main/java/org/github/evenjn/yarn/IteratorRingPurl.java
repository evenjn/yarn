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

import java.util.Iterator;

import org.github.evenjn.lang.Rook;

/**
 * <h1>IteratorRingPurl</h1>
 * 
 * <p>
 * An {@code IteratorRingPurl} is a {@link org.github.evenjn.yarn.YarnRingPurl
 * YarnRingPurl} that provides access to output objects via
 * {@link java.util.Iterator Iterator} containers.
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
public interface IteratorRingPurl<I, O> extends
		YarnRingPurl<I, O, Iterator<O>> {

	/**
	 * <p>
	 * {@code next} returns an {@link java.util.Iterator Iterator} with none of,
	 * some of, or all the output objects associated to the sequence of elements
	 * received in input so far (including the argument {@code input}), while
	 * transferring the responsiblity of closing any associated resources to the
	 * argument {@link org.github.evenjn.lang.Rook Rook}.
	 * </p>
	 * 
	 * @param rook
	 *          A {@link org.github.evenjn.lang.Rook Rook}.
	 * @param input
	 *          An input object.
	 * @return An {@link java.util.Iterator Iterator} of output objects.
	 * @throws IllegalStateException
	 *           when {@link #end(Rook)} has already been invoked.
	 * @since 1.0
	 */
	@Override
	Iterator<O> next( Rook rook, I input );

	/**
	 * <p>
	 * {@code end} returns an {@link java.util.Iterator Iterator} with none of,
	 * some of, or all the output objects associated to the sequence of elements
	 * received in input so far, while transferring the responsiblity of closing
	 * any associated resources to the argument {@link org.github.evenjn.lang.Rook
	 * Rook}.
	 * </p>
	 * 
	 * @param rook
	 *          A {@link org.github.evenjn.lang.Rook Rook}.
	 * @return An {@link java.util.Iterator Iterator} of output objects.
	 * @throws IllegalStateException
	 *           when {@link #end(Rook)} has already been invoked.
	 * @since 1.0
	 */
	@Override
	Iterator<O> end( Rook rook );
}
