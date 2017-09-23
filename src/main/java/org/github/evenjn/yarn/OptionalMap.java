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
 * <h1>OptionalMap</h1>
 * 
 * <p>
 * An {@code OptionalMap} is a {@linkplain org.github.evenjn.yarn.Map Map} that
 * provides access to objects via {@link java.util.Optional} containers.
 * </p>
 *
 * @param <I>
 *          The type of input objects.
 * @param <O>
 *          The type of output objects.
 */
@FunctionalInterface
public interface OptionalMap<I, O> extends
		Map<I, O> {

	/**
	 * Returns an {@link java.util.Optional} with the output object associated to
	 * the argument input..
	 * 
	 * @param input
	 *          An input object.
	 * @return An empty {@link java.util.Optional}, or an
	 *         {@link java.util.Optional} with the output object.
	 */
	@Override
	Optional<O> get( I object );
}
