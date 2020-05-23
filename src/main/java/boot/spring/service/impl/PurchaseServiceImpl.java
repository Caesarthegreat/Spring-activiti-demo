package boot.spring.service.impl;

import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import boot.spring.mapper.PurchaseApplyMapper;
import boot.spring.po.PurchaseApply;
import boot.spring.service.PurchaseService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=5)
@Service
public class PurchaseServiceImpl implements PurchaseService{
	@Autowired
	PurchaseApplyMapper purchasemapper;
	@Autowired
	IdentityService identityservice;
	@Autowired
	RuntimeService runtimeservice;
	@Autowired
	TaskService taskservice;

	/**
	 * 功能描述: 启动流程
	 * @param apply
	 * @param userid
	 * @param variables
	 * @Description TODO
	 * @return org.activiti.engine.runtime.ProcessInstance
	 * @Author Caesar
	 * @Date 17:43 2020/5/13
	 **/
	public ProcessInstance startWorkflow(PurchaseApply apply, String userid,Map<String, Object> variables) {
		purchasemapper.save(apply);
		String businesskey=String.valueOf(apply.getId());//使用leaveapply表的主键作为businesskey,连接业务数据和流程数据
		identityservice.setAuthenticatedUserId(userid);
		// 使用流程定义的key启动流程实例，默认会按照最新版本启动流程实例
		ProcessInstance instance=runtimeservice.startProcessInstanceByKey("purchase",businesskey,variables);
//		String instanceid=instance.getId();
		return instance;
	}

	public PurchaseApply getPurchase(int id) {
		return purchasemapper.getPurchaseApply(id);
	}

	public void updatePurchase(PurchaseApply a) {
		purchasemapper.updateByPrimaryKeySelective(a);
	}

}
