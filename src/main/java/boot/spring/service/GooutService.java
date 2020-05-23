package boot.spring.service;

import boot.spring.po.GooutApply;
import boot.spring.po.LeaveApply;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;
import java.util.Map;


public interface GooutService {
	public ProcessInstance startWorkflow(GooutApply apply, String userid, Map<String, Object> variables);
	public List<GooutApply> getpagedepttask(String userid, int firstrow, int rowcount);
	public int getalldepttask(String userid);
	public GooutApply getgoout(int id);
	public List<GooutApply> getpagehrtask(String userid, int firstrow, int rowcount);
	public int getallhrtask(String userid);
	public List<GooutApply> getpageXJtask(String userid, int firstrow, int rowcount);
	public int getallXJtask(String userid);
	public List<GooutApply> getpageupdateapplytask(String userid, int firstrow, int rowcount);
	public int getallupdateapplytask(String userid);
	public void completereportback(String taskid, String realstart_time, String realend_time);
	public void updatecomplete(String taskid, GooutApply leave, String reappply);
	public List<String> getHighLightedFlows(ProcessDefinitionEntity deployedProcessDefinition, List<HistoricActivityInstance> historicActivityInstances);
}
