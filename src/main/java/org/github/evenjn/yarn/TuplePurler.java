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

import java.util.function.Supplier;

/**
 * <p>
 * A {@code TuplePurler} is a {@link Supplier} of {@link TuplePurl}. Each
 * invocation of {@link #get()} returns a new object.
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
public interface TuplePurler<I, O> extends
		Supplier<TuplePurl<I, O>> {
}
