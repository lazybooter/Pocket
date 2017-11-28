package cn.tarpas.pocket.mapper;

import java.util.List;

public interface IMapper<T> {
	int insert(T pojo);
	
	int update(T pojo);
	
	int delete(Long id);
	
	List<T> select (T pojo);
}
