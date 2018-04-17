package com.bvicam.entity;

import java.sql.SQLException;

public interface Crud {
	public Object create(Object o) throws SQLException;
	public Object read(Object o);
	public Object update(Object o);
	public Object delete(Object o);
}
