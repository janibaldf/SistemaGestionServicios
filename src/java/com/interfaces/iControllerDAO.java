
package com.interfaces;

import java.util.List;

public interface iControllerDAO<T> {

public T selectOne(int id);
public List<T> selectAll();
public boolean add( T element);
public boolean delete( int id);
public boolean update( T elemen);
public boolean updateAll( int id);
}
