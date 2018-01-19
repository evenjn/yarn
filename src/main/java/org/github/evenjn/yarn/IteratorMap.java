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

/**
 * <h1>IteratorMap</h1>
 * 
 * <p>
 * An {@code IteratorMap} is a {@linkplain org.github.evenjn.yarn.YarnMap
 * YarnMap} that provides access to output objects via {@link java.util.Iterator
 * Iterator} containers.
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
public interface IteratorMap<I, O> extends
		YarnMap<I, O, Iterator<O>> {

	/**
	 * <p>
	 * {@code get} returns an {@link java.util.Iterator Iterator} with the output
	 * objects associated to the argument {@code input}.
	 * </p>
	 * 
	 * @param input
	 *          An input object.
	 * @return An {@link java.util.Iterator Iterator} of output objects.
	 * @since 1.0
	 */
	@Override
	Iterator<O> get( I input );
}
