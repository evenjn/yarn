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
import org.github.evenjn.lang.Tuple;

/**
 * <h1>TupleRingMap</h1>
 * 
 * <p>
 * A {@code TupleRingMap} is a {@linkplain org.github.evenjn.yarn.YarnRingMap
 * YarnRingMap} that provides access to output objects via
 * {@link org.github.evenjn.lang.Tuple Tuple} containers.
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
@FunctionalInterface
public interface TupleRingMap<I, O> extends
		YarnRingMap<I, O, Tuple<O>> {

	/**
	 * <p>
	 * {@code get} returns a {@link org.github.evenjn.lang.Tuple Tuple} with
	 * output objects associated to the argument input after transferring the
	 * responsiblity of closing any associated resources to the argument
	 * {@link org.github.evenjn.lang.Rook Rook}.
	 * </p>
	 * 
	 * @param rook
	 *          A {@link org.github.evenjn.lang.Rook Rook}.
	 * @param input
	 *          An input object.
	 * @return A {@link org.github.evenjn.lang.Tuple Tuple} of output objects.
	 * @since 1.0
	 */
	@Override
	Tuple<O> get( Rook rook, I input );
}
