package com.singlespark.websocketsse.util;


import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.*;
import java.util.function.BiConsumer;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;


public class Pairs {
    private Pairs() {
        // no instantiation
    }

    @SafeVarargs
    private static <T> T[] arrayOf(final T... elems) {
        return elems;
    }

    /**
     * Generate a map of pairs.
     *
     * @param k1 key 1
     * @param v1 value 1
     * @return map of pairs
     */
    public static <K, V> Map<K, V> pairsOf(
                final K k1, final V v1) {
        return new PairMap<>(
                    arrayOf(k1),
                    arrayOf(v1)
        );
    }

    /**
     * Generate a map of pairs.
     *
     * @param k1 key 1
     * @param v1 value 1
     * @param k2 key 2
     * @param v2 value 2
     * @return map of pairs
     */
    public static <K, V> Map<K, V> pairsOf(
                final K k1, final V v1,
                final K k2, final V v2) {
        return new PairMap<>(
                    arrayOf(k1, k2),
                    arrayOf(v1, v2)
        );
    }

    /**
     * Generate a map of pairs.
     *
     * @param k1 key 1
     * @param v1 value 1
     * @param k2 key 2
     * @param v2 value 2
     * @param k3 key 3
     * @param v3 value 3
     * @return map of pairs
     */
    public static <K, V> Map<K, V> pairsOf(
                final K k1, final V v1,
                final K k2, final V v2,
                final K k3, final V v3) {
        return new PairMap<>(
                    arrayOf(k1, k2, k3),
                    arrayOf(v1, v2, v3)
        );
    }

    /**
     * Generate a map of pairs.
     *
     * @param k1 key 1
     * @param v1 value 1
     * @param k2 key 2
     * @param v2 value 2
     * @param k3 key 3
     * @param v3 value 3
     * @param k4 key 4
     * @param v4 value 4
     * @return map of pairs
     */
    public static <K, V> Map<K, V> pairsOf(
                final K k1, final V v1,
                final K k2, final V v2,
                final K k3, final V v3,
                final K k4, final V v4) {
        return new PairMap<>(
                    arrayOf(k1, k2, k3, k4),
                    arrayOf(v1, v2, v3, v4)
        );
    }

    /**
     * Generate a map of pairs.
     *
     * @param k1 key 1
     * @param v1 value 1
     * @param k2 key 2
     * @param v2 value 2
     * @param k3 key 3
     * @param v3 value 3
     * @param k4 key 4
     * @param v4 value 4
     * @param k5 key 5
     * @param v5 value 5
     * @return map of pairs
     */
    public static <K, V> Map<K, V> pairsOf(
                final K k1, final V v1,
                final K k2, final V v2,
                final K k3, final V v3,
                final K k4, final V v4,
                final K k5, final V v5) {
        return new PairMap<>(
                    arrayOf(k1, k2, k3, k4, k5),
                    arrayOf(v1, v2, v3, v4, v5)
        );
    }

    /**
     * Generate a map of pairs.
     *
     * @param k1 key 1
     * @param v1 value 1
     * @param k2 key 2
     * @param v2 value 2
     * @param k3 key 3
     * @param v3 value 3
     * @param k4 key 4
     * @param v4 value 4
     * @param k5 key 5
     * @param v5 value 5
     * @param k6 key 6
     * @param v6 value 6
     * @return map of pairs
     */
    public static <K, V> Map<K, V> pairsOf(
                final K k1, final V v1,
                final K k2, final V v2,
                final K k3, final V v3,
                final K k4, final V v4,
                final K k5, final V v5,
                final K k6, final V v6) {
        return new PairMap<>(
                    arrayOf(k1, k2, k3, k4, k5, k6),
                    arrayOf(v1, v2, v3, v4, v5, v6)
        );
    }

    /**
     * Generate a map of pairs.
     *
     * @param k1 key 1
     * @param v1 value 1
     * @param k2 key 2
     * @param v2 value 2
     * @param k3 key 3
     * @param v3 value 3
     * @param k4 key 4
     * @param v4 value 4
     * @param k5 key 5
     * @param v5 value 5
     * @param k6 key 6
     * @param v6 value 6
     * @param k7 key 7
     * @param v7 value 7
     * @return map of pairs
     */
    public static <K, V> Map<K, V> pairsOf(
                final K k1, final V v1,
                final K k2, final V v2,
                final K k3, final V v3,
                final K k4, final V v4,
                final K k5, final V v5,
                final K k6, final V v6,
                final K k7, final V v7) {
        return new PairMap<>(
                    arrayOf(k1, k2, k3, k4, k5, k6, k7),
                    arrayOf(v1, v2, v3, v4, v5, v6, v7)
        );
    }

    /**
     * Generate a map of pairs.
     *
     * @param k1 key 1
     * @param v1 value 1
     * @param k2 key 2
     * @param v2 value 2
     * @param k3 key 3
     * @param v3 value 3
     * @param k4 key 4
     * @param v4 value 4
     * @param k5 key 5
     * @param v5 value 5
     * @param k6 key 6
     * @param v6 value 6
     * @param k7 key 7
     * @param v7 value 7
     * @param k8 key 8
     * @param v8 value 8
     * @return map of pairs
     */
    public static <K, V> Map<K, V> pairsOf(
                final K k1, final V v1,
                final K k2, final V v2,
                final K k3, final V v3,
                final K k4, final V v4,
                final K k5, final V v5,
                final K k6, final V v6,
                final K k7, final V v7,
                final K k8, final V v8) {
        return new PairMap<>(
                    arrayOf(k1, k2, k3, k4, k5, k6, k7, k8),
                    arrayOf(v1, v2, v3, v4, v5, v6, v7, v8)
        );
    }

    /**
     * Generate a map of pairs.
     *
     * @param k1 key 1
     * @param v1 value 1
     * @param k2 key 2
     * @param v2 value 2
     * @param k3 key 3
     * @param v3 value 3
     * @param k4 key 4
     * @param v4 value 4
     * @param k5 key 5
     * @param v5 value 5
     * @param k6 key 6
     * @param v6 value 6
     * @param k7 key 7
     * @param v7 value 7
     * @param k8 key 8
     * @param v8 value 8
     * @param k9 key 9
     * @param v9 value 9
     * @return map of pairs
     */
    public static <K, V> Map<K, V> pairsOf(
                final K k1, final V v1,
                final K k2, final V v2,
                final K k3, final V v3,
                final K k4, final V v4,
                final K k5, final V v5,
                final K k6, final V v6,
                final K k7, final V v7,
                final K k8, final V v8,
                final K k9, final V v9) {
        return new PairMap<>(
                    arrayOf(k1, k2, k3, k4, k5, k6, k7, k8, k9),
                    arrayOf(v1, v2, v3, v4, v5, v6, v7, v8, v9)
        );
    }

    /**
     * Generate a map of pairs.
     *
     * @param k1 key 1
     * @param v1 value 1
     * @param k2 key 2
     * @param v2 value 2
     * @param k3 key 3
     * @param v3 value 3
     * @param k4 key 4
     * @param v4 value 4
     * @param k5 key 5
     * @param v5 value 5
     * @param k6 key 6
     * @param v6 value 6
     * @param k7 key 7
     * @param v7 value 7
     * @param k8 key 8
     * @param v8 value 8
     * @param k9 key 9
     * @param v9 value 9
     * @param k10 key 10
     * @param v10 value 10
     * @return map of pairs
     */
    public static <K, V> Map<K, V> pairsOf(
                final K k1, final V v1,
                final K k2, final V v2,
                final K k3, final V v3,
                final K k4, final V v4,
                final K k5, final V v5,
                final K k6, final V v6,
                final K k7, final V v7,
                final K k8, final V v8,
                final K k9, final V v9,
                final K k10, final V v10) {
        return new PairMap<>(
                    arrayOf(k1, k2, k3, k4, k5, k6, k7, k8, k9, k10),
                    arrayOf(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10)
        );
    }

    /**
     * Generate a map of pairs.
     *
     * @param k1 key 1
     * @param v1 value 1
     * @param k2 key 2
     * @param v2 value 2
     * @param k3 key 3
     * @param v3 value 3
     * @param k4 key 4
     * @param v4 value 4
     * @param k5 key 5
     * @param v5 value 5
     * @param k6 key 6
     * @param v6 value 6
     * @param k7 key 7
     * @param v7 value 7
     * @param k8 key 8
     * @param v8 value 8
     * @param k9 key 9
     * @param v9 value 9
     * @param k10 key 10
     * @param v10 value 10
     * @param objs more keys and values, must be balanced
     * @return map of pairs
     */
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> pairsOf(
                final K k1, final V v1,
                final K k2, final V v2,
                final K k3, final V v3,
                final K k4, final V v4,
                final K k5, final V v5,
                final K k6, final V v6,
                final K k7, final V v7,
                final K k8, final V v8,
                final K k9, final V v9,
                final K k10, final V v10,
                final Object... objs) {

        final int len = 10 + (requirePairs(objs).length >>> 1);
        final K[] keys = (K[])new Object[len];
        final V[] values = (V[])new Object[len];
        keys[0] = k1;
        keys[1] = k2;
        keys[2] = k3;
        keys[3] = k4;
        keys[4] = k5;
        keys[5] = k6;
        keys[6] = k7;
        keys[7] = k8;
        keys[8] = k9;
        keys[9] = k10;
        values[0] = v1;
        values[1] = v2;
        values[2] = v3;
        values[3] = v4;
        values[4] = v5;
        values[5] = v6;
        values[6] = v7;
        values[7] = v8;
        values[8] = v9;
        values[9] = v10;
        for (int from = 0, to = 10; from < objs.length; from += 2, to += 1) {
            keys[to] = (K)objs[from];
            values[to] = (V)objs[from + 1];
        }
        return new PairMap<>(keys, values);
    }

    /**
     * Checks that the specified {@link String}s represent key-value pairs, i.e. that the arguments length is an even number.
     *
     * @param kvs the {@link String} arguments to check
     * @return {@code kvs} if representing pairs
     * @throws IllegalArgumentException if {@code kvs} doesn't represent pairs
     */
    @SafeVarargs
    public static <T> T[] requirePairs(final T... kvs) {
        if ((kvs.length & 1) == 1) {
            throw new IllegalArgumentException("key/value pairs not balanced");
        }
        return kvs;
    }

    private static final class PairMap<K, V> implements Map<K, V> {
        private final K[] keys;
        private final V[] values;

        private PairMap(final K[] keys, final V[] values) {
            this.keys = keys;
            this.values = values;
        }

        @Override
        public int size() {
            return keys.length;
        }

        @Override
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override
        public boolean containsKey(final Object k) {
            for (final K key : keys) {
                if (Objects.equals(key, k)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean containsValue(final Object v) {
            for (final Object value : values) {
                if (Objects.equals(value, v)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public V get(final Object k) {
            for (int i = 0; i < size(); ++i) {
                if (Objects.equals(keys[i], k)) {
                    return values[i];
                }
            }
            return null;
        }

        @Override
        public void forEach(final BiConsumer<? super K, ? super V> action) {
            for (int i = 0; i < size(); ++i) {
                action.accept(keys[i], values[i]);
            }
        }

        @Override
        public V put(final K key, final V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public V remove(final Object key) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void putAll(final Map<? extends K, ? extends V> ignored) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Set<K> keySet() {
            return entrySet().stream().map(Entry::getKey).collect(toSet());
        }

        @Override
        public Collection<V> values() {
            return entrySet().stream().map(Entry::getValue).collect(toList());
        }

        @Override
        public Set<Entry<K, V>> entrySet() {
            return new AbstractSet<Entry<K, V>>() {
                @Override
                public Iterator<Entry<K, V>> iterator() {
                    return new Iterator<Entry<K, V>>() {
                        private int i = 0;

                        @Override
                        public boolean hasNext() {
                            return i < size();
                        }

                        @Override
                        public Entry<K, V> next() {
                            final Entry<K, V> ret = new SimpleImmutableEntry<>(keys[i], values[i]);
                            ++i;
                            return ret;
                        }
                    };
                }

                @Override
                public int size() {
                    return PairMap.this.size();
                }
            };
        }

        @Override
        public String toString() {
            if (isEmpty()) {
                return "{}";
            }

            final StringBuilder sb = new StringBuilder(size() * 50);
            sb.append('{');
            for (int i = 0; i < size(); ++i) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(keys[i]).append('=').append(values[i]);
            }
            sb.append('}');
            return sb.toString();
        }
    }
}
