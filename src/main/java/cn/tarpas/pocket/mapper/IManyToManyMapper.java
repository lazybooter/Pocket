package cn.tarpas.pocket.mapper;

import java.util.List;

public interface IManyToManyMapper<T,F,S> extends IMapper<T> {
    
	//通过F的id删除F和S的所有关系
    int deleteByFirstId(Long firstId);

    //通过S的id删除F和S的所有关系
    int deleteBySecondId(Long secondId);

    //通过S的id查询F依赖S的列表
    List<F> selectFirstListBySecondId(Long secondId);

  //通过F的id查询S依赖F的列表
    List<S> selectSecondListByFirstId(Long firstId);	
}
