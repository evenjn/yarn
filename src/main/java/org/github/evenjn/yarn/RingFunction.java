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
 * <p>
 * Returns an object associated to the argument object after passing the
 * responsibility to close associated resources to the argument
 * {@link org.github.evenjn.lang.Rook Rook}.
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
public interface RingFunction<I, O> {

	/**
	 * <p>
	 * {@code get} returns an object associated to the argument object after
	 * passing the responsibility to close associated resources to the argument
	 * {@link org.github.evenjn.lang.Rook Rook}.
	 * </p>
	 * 
	 * @param rook
	 *          A {@link org.github.evenjn.lang.Rook Rook}.
	 * @param object
	 *          An input object.
	 * @return An output object.
	 * @since 1.0
	 */
	O apply( Rook rook, I object );
}
