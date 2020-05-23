package boot.spring.mapper;

import boot.spring.po.GooutApply;

public interface GooutApplyMapper {
	void save(GooutApply apply);

	GooutApply getGooutApply(int id);

	int updateByPrimaryKey(GooutApply record);
}
