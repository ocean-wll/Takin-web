package io.shulie.takin.web.data.dao.tracenode;

import java.util.List;

import io.shulie.takin.web.data.param.tracenode.TraceNodeInfoParam;
import io.shulie.takin.web.data.result.tracenode.TraceNodeInfoResult;

/**
 * @author 无涯
 * @date 2020/12/29 12:13 下午
 */
public interface TraceNodeDao {
    /**
     * 插入调用栈数据
     */
    void batchInsert(List<TraceNodeInfoParam> params);

    /**
     * 获取节点信息根据 traceId,与rpcId 与 customerId
     *
     * @return
     */
    TraceNodeInfoResult getNode(String traceId, String rpcId, Long customerId, Integer logType, String agentId, String appName);

    /**
     * 获取节点信息List
     *
     * @return
     */
    List<TraceNodeInfoResult> getNodeList(String traceId, Long customerId);

    /**
     * 节点个数
     *
     * @return
     */
    Integer getNodeCount(String traceId, Long customerId);

    /**
     * 异常节点个数
     *
     * @return
     */
    Long getExceptionNodeCount(String traceId, Long customerId);

    /**
     * 未知节点个数
     *
     * @return
     */
    Long getUnknownNodeCount(String traceId, Long customerId);

    /**
     * 未知节点list
     *
     * @return
     */
    List<TraceNodeInfoResult> getUnknownNodes(String traceId, Long customerId);

    /**
     * 根据id获取
     *
     * @return
     */
    TraceNodeInfoResult getById(Long id);

}
