/**
 * <p>
 * Package Yarn is a collection of interfaces that enable lazy transformation of
 * sequences by means of processes with state and auto-closeable resources
 * management.
 * </p>
 * 
 * <p>
 * Sequence access interfaces: {@link org.github.evenjn.yarn.Tuple Tuple},
 * {@link org.github.evenjn.yarn.Cursable Cursable} and
 * {@link org.github.evenjn.yarn.Cursor Cursor}, and the related exception
 * {@link org.github.evenjn.yarn.EndOfCursorException EndOfCursorException}.
 * </p>
 * 
 * <p>
 * Sequence transformation interfaces extending
 * {@link org.github.evenjn.yarn.YarnMap YarnMap}:
 * </p>
 * 
 * <ul>
 * <li>{@link org.github.evenjn.yarn.ArrayMap ArrayMap}</li>
 * <li>{@link org.github.evenjn.yarn.CursableMap CursableMap}</li>
 * <li>{@link org.github.evenjn.yarn.CursorMap CursorMap}</li>
 * <li>{@link org.github.evenjn.yarn.IteratorMap IteratorMap}</li>
 * <li>{@link org.github.evenjn.yarn.IterableMap IterableMap}</li>
 * <li>{@link org.github.evenjn.yarn.OptionalMap OptionalMap}</li>
 * <li>{@link org.github.evenjn.yarn.TupleMap TupleMap}</li>
 * </ul>
 * 
 * <p>
 * Sequence transformation interfaces extending
 * {@link org.github.evenjn.yarn.YarnPurl YarnPurl}:
 * </p>
 * 
 * <ul>
 * <li>{@link org.github.evenjn.yarn.ArrayPurl ArrayPurl}</li>
 * <li>{@link org.github.evenjn.yarn.ArrayPurler ArrayPurler}</li>
 * <li>{@link org.github.evenjn.yarn.CursablePurl CursablePurl}</li>
 * <li>{@link org.github.evenjn.yarn.CursablePurler CursablePurler}</li>
 * <li>{@link org.github.evenjn.yarn.CursorPurl CursorPurl}</li>
 * <li>{@link org.github.evenjn.yarn.CursorPurler CursorPurler}</li>
 * <li>{@link org.github.evenjn.yarn.IteratorPurl IteratorPurl}</li>
 * <li>{@link org.github.evenjn.yarn.IteratorPurler IteratorPurler}</li>
 * <li>{@link org.github.evenjn.yarn.IterablePurl IterablePurl}</li>
 * <li>{@link org.github.evenjn.yarn.IterablePurler IterablePurler}</li>
 * <li>{@link org.github.evenjn.yarn.OptionalPurl OptionalPurl}</li>
 * <li>{@link org.github.evenjn.yarn.OptionalPurler OptionalPurler}</li>
 * <li>{@link org.github.evenjn.yarn.TuplePurl TuplePurl}</li>
 * <li>{@link org.github.evenjn.yarn.TuplePurler TuplePurler}</li>
 * </ul>
 * 
 * <p>
 * Sequence transformation interfaces extending
 * {@link org.github.evenjn.yarn.YarnRookMap YarnRookMap}:
 * </p>
 * 
 * <ul>
 * <li>{@link org.github.evenjn.yarn.CursableRookMap CursableRookMap}</li>
 * <li>{@link org.github.evenjn.yarn.CursorRookMap CursorRookMap}</li>
 * <li>{@link org.github.evenjn.yarn.IteratorRookMap IteratorRookMap}</li>
 * <li>{@link org.github.evenjn.yarn.IterableRookMap IterableRookMap}</li>
 * <li>{@link org.github.evenjn.yarn.OptionalRookMap OptionaRookMap}</li>
 * <li>{@link org.github.evenjn.yarn.StreamRookMap StreamRookMap}</li>
 * <li>{@link org.github.evenjn.yarn.TupleRookMap TupleRookMap}</li>
 * </ul>
 * 
 * <p>
 * Sequence transformation interfaces extending
 * {@link org.github.evenjn.yarn.YarnRookPurl YarnRookPurl}:
 * </p>
 * 
 * <ul>
 * <li>{@link org.github.evenjn.yarn.CursableRookPurl CursableRookPurl}</li>
 * <li>{@link org.github.evenjn.yarn.CursableRookPurler CursableRookPurler}</li>
 * <li>{@link org.github.evenjn.yarn.CursorRookPurl CursorRookPurl}</li>
 * <li>{@link org.github.evenjn.yarn.CursorRookPurler CursorRookPurler}</li>
 * <li>{@link org.github.evenjn.yarn.IteratorRookPurl IteratorRookPurl}</li>
 * <li>{@link org.github.evenjn.yarn.IteratorRookPurler IteratorRookPurler}</li>
 * <li>{@link org.github.evenjn.yarn.IterableRookPurl IterableRookPurl}</li>
 * <li>{@link org.github.evenjn.yarn.IterableRookPurler IterableRookPurler}</li>
 * <li>{@link org.github.evenjn.yarn.OptionalRookPurl OptionaRookPurl}</li>
 * <li>{@link org.github.evenjn.yarn.OptionalRookPurler OptionaRookPurler}</li>
 * <li>{@link org.github.evenjn.yarn.StreamRookPurl StreamRookPurl}</li>
 * <li>{@link org.github.evenjn.yarn.StreamRookPurler StreamRookPurler}</li>
 * <li>{@link org.github.evenjn.yarn.TupleRookPurl TupleRookPurl}</li>
 * <li>{@link org.github.evenjn.yarn.TupleRookPurler TupleRookPurler}</li>
 * </ul>
 * 
 * @since 1.0
 */
package org.github.evenjn.yarn;
