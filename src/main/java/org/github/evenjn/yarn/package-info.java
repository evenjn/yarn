/**
 * <p>
 * Package Yarn is a collection of interfaces that enable folding and unfolding
 * with state and resources.
 * </p>
 * 
 * <h1>Purl</h1>
 * <p>
 * To purl a sequence of elements means to transform it into another sequence of
 * elemenets by means of a purl. A purl is a system designed to receive input
 * elements one by one, and for each input, to produce zero, one or more output
 * elements. The purl may (and will) be stateful: it may accumulate information
 * while processing elements, and use such information to produce output
 * elements. Moreover, a purl is designed to be invoked one last time after it
 * has received all the input elements. At that time the purl has a chance to
 * produce more output elements.
 * </p>
 */
package org.github.evenjn.yarn;
