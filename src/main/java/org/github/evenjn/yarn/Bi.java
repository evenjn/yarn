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

/*
 * Bi objects are not invariant, and we recommend to use them as a carrier.
 */
public final class Bi<A, B> {

	public static <A, B> Bi<A, B> nu( A first, B second ) {
		return new Bi<A, B>( ).set( first, second );
	}
	
	public A first;

	public B second;
	
	public Bi<A, B> set(A first, B second) {
		this.first = first;
		this.second = second;
		return this;
	}
}
