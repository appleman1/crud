package net.vfalkenberg.examples.crud.view.converter;

public interface ViewConverter<E, V> {

    V toView(E entity);

    E toEntity(V view);
}
