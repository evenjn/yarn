/**
 * <p>
 * Package Yarn is a collection of interfaces that enable lazy transformation of
 * sequences by means of processes with state and auto-closeable resources
 * management.
 * </p>
 * 
 * <p>
 * Lazy sequence access interfaces: {@link org.github.evenjn.yarn.Cursable
 * Cursable} and {@link org.github.evenjn.yarn.Cursor Cursor}, and the related
 * exception {@link org.github.evenjn.yarn.EndOfCursorException
 * EndOfCursorException}.
 * </p>
 * 
 * <p>
 * The {@link org.github.evenjn.yarn.RingFunction RingFunction} interface.
 * </p>
 * 
 * <p>
 * Transformation interfaces extending {@link org.github.evenjn.yarn.YarnMap
 * YarnMap}:
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
 * Transformation interfaces extending {@link org.github.evenjn.yarn.YarnPurl
 * YarnPurl}:
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
 * Transformation interfaces extending {@link org.github.evenjn.yarn.YarnRingMap
 * YarnRingMap}:
 * </p>
 * 
 * <ul>
 * <li>{@link org.github.evenjn.yarn.CursableRingMap CursableRingMap}</li>
 * <li>{@link org.github.evenjn.yarn.CursorRingMap CursorRingMap}</li>
 * <li>{@link org.github.evenjn.yarn.IteratorRingMap IteratorRingMap}</li>
 * <li>{@link org.github.evenjn.yarn.IterableRingMap IterableRingMap}</li>
 * <li>{@link org.github.evenjn.yarn.OptionalRingMap OptionaRingMap}</li>
 * <li>{@link org.github.evenjn.yarn.StreamRingMap StreamRingMap}</li>
 * <li>{@link org.github.evenjn.yarn.TupleRingMap TupleRingMap}</li>
 * </ul>
 * 
 * <p>
 * Transformation interfaces extending
 * {@link org.github.evenjn.yarn.YarnRingPurl YarnRingPurl}:
 * </p>
 * 
 * <ul>
 * <li>{@link org.github.evenjn.yarn.CursableRingPurl CursableRingPurl}</li>
 * <li>{@link org.github.evenjn.yarn.CursableRingPurler CursableRingPurler}</li>
 * <li>{@link org.github.evenjn.yarn.CursorRingPurl CursorRingPurl}</li>
 * <li>{@link org.github.evenjn.yarn.CursorRingPurler CursorRingPurler}</li>
 * <li>{@link org.github.evenjn.yarn.IteratorRingPurl IteratorRingPurl}</li>
 * <li>{@link org.github.evenjn.yarn.IteratorRingPurler IteratorRingPurler}</li>
 * <li>{@link org.github.evenjn.yarn.IterableRingPurl IterableRingPurl}</li>
 * <li>{@link org.github.evenjn.yarn.IterableRingPurler IterableRingPurler}</li>
 * <li>{@link org.github.evenjn.yarn.OptionalRingPurl OptionaRingPurl}</li>
 * <li>{@link org.github.evenjn.yarn.OptionalRingPurler OptionaRingPurler}</li>
 * <li>{@link org.github.evenjn.yarn.StreamRingPurl StreamRingPurl}</li>
 * <li>{@link org.github.evenjn.yarn.StreamRingPurler StreamRingPurler}</li>
 * <li>{@link org.github.evenjn.yarn.TupleRingPurl TupleRingPurl}</li>
 * <li>{@link org.github.evenjn.yarn.TupleRingPurler TupleRingPurler}</li>
 * </ul>
 * 
 * @since 1.0
 */
package org.github.evenjn.yarn;
