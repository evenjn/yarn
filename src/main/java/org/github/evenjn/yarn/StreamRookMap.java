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

import java.util.stream.Stream;

/**
 * <h1>StreamRookMap</h1>
 * 
 * <p>
 * A {@code StreamRookMap} is a {@linkplain org.github.evenjn.yarn.RookMap
 * RookMap} that provides access to output objects via
 * {@link java.util.stream.Stream Stream} containers.
 * </p>
 * 
 * @param <I>
 *          The type of input objects.
 * @param <O>
 *          The type of output objects.
 * @since 1.0
 */
public interface StreamRookMap<I, O> extends
		RookMap<I, O> {

	/**
	 * Returns a {@link java.util.stream.Stream Stream} with output objects
	 * associated to the argument input after transferring the responsiblity of
	 * closing any associated resources to the argument
	 * {@link org.github.evenjn.yarn.Rook Rook}.
	 * 
	 * @param rook
	 *          A {@link org.github.evenjn.yarn.Rook Rook}.
	 * @param input
	 *          An input object.
	 * @return A {@link java.util.stream.Stream Stream} of output objects.
	 * @since 1.0
	 */
	@Override
	Stream<O> get( Rook rook, I input );
}
