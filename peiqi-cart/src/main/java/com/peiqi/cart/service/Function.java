package com.peiqi.cart.service;

public interface Function<T, E> {

    public T callback(E e);

}
