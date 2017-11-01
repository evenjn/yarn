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
 * <h1>CursorRookPurl</h1>
 * 
 * <p>
 * A {@code CursorRookPurl} is a {@link org.github.evenjn.yarn.YarnRookPurl
 * YarnRookPurl} that provides access to output objects via
 * {@link org.github.evenjn.yarn.Cursor Cursor} containers.
 * </p>
 * 
 * <p>
 * This class is part of package {@link org.github.evenjn.yarn Yarn}.
 * </p>
 *
 * @param <I>
 *          The type of input objects.
 * @param <O>
 *          The type of output objects.
 * @since 1.0
 */
public interface CursorRookPurl<I, O> extends
		YarnRookPurl<I, Cursor<O>> {

	/**
	 * <p>
	 * Returns a {@link org.github.evenjn.yarn.Cursor Cursor} with none of, some
	 * of, or all the output objects associated to the sequence of elements
	 * received in input so far (including the argument {@code input}), while
	 * transferring the responsiblity of closing any associated resources to the
	 * argument {@link org.github.evenjn.yarn.Rook Rook}.
	 * </p>
	 * 
	 * @param rook
	 *          A {@link org.github.evenjn.yarn.Rook Rook}.
	 * @param input
	 *          An input object.
	 * @return A {@link org.github.evenjn.yarn.Cursor Cursor} of output objects.
	 * @throws IllegalStateException
	 *           when {@link #end(Rook)} has already been invoked.
	 * @since 1.0
	 */
	@Override
	Cursor<O> next( Rook rook, I input );

	/**
	 * <p>
	 * Returns a {@link org.github.evenjn.yarn.Cursor Cursor} with none of, some
	 * of, or all the output objects associated to the sequence of elements
	 * received in input so far, while transferring the responsiblity of closing
	 * any associated resources to the argument {@link org.github.evenjn.yarn.Rook
	 * Rook}.
	 * </p>
	 * 
	 * @param rook
	 *          A {@link org.github.evenjn.yarn.Rook Rook}.
	 * @return A {@link org.github.evenjn.yarn.Cursor Cursor} of output objects.
	 * @throws IllegalStateException
	 *           when {@link #end(Rook)} has already been invoked.
	 * @since 1.0
	 */
	@Override
	Cursor<O> end( Rook rook );
}
