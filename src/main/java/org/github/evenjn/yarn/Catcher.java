/**
 *
 * Copyright 2016 Marco Trevisan
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
 * A Catcher provides methods to silence checked exceptions.
 * 
 * @since 1.0
 *
 */
public interface Catcher {

	/**
	 * Reports that an exception was caught, and the computation cannot continue.
	 * Wraps the argument exception into a {@code RuntimeException} and returns
	 * it. The invoker must throw the resulting {@code RuntimeException}.
	 * 
	 * @param throwable
	 *          any Throwable.
	 * @return a runtime exception wrapping the argument throwable.
	 * @since 1.0
	 */
	default RuntimeException quit( Throwable throwable ) {
		return new RuntimeException( throwable );
	}

	/**
	 * Reports that an exception was caught, and the computation will continue.
	 * 
	 * @param throwable
	 *          any Throwable.
	 * @since 1.0
	 */
	default void log( Throwable throwable ) {
		throwable.printStackTrace( );
	}

}