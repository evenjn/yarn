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
 * A hook represents a system that takes the responsability to close any
 * autocloseable objects it receives.
 * 
 * Methods which take as argument a hook typically return objects that can no
 * longer be used after the hooked objects are closed.
 * 
 */
public interface Hook {

	/**
	 * Assigns to this hook the responsibility to close the argument object.
	 * 
	 * @param <T>
	 *          the type of the object that needs to be closed.
	 * @param auto_closeable
	 *          the object that needs to be closed
	 * @return the object that needs to be closed.
	 */

	<T extends java.lang.AutoCloseable> T hook( T auto_closeable );
}
