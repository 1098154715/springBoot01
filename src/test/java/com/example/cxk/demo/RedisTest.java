package com.example.cxk.demo;


import com.example.cxk.demo.entity.AccountLogin;
import com.example.cxk.demo.entity.TreeNode;
import com.example.cxk.demo.service.AccountLoginService;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest{

    @Test
    public void set1(){
        List<AccountLogin> nc=new ArrayList<>();
        for(int i=1;i<10;i++){
            AccountLogin accountLogin=new AccountLogin();
            accountLogin.setId("qq"+i);
            nc.add(accountLogin);
        }
     List<String> dtr=nc.stream().map(item->item.getId()).collect(Collectors.toList());
        System.out.println(dtr);
    }

    public static List<TreeNode> filterNode(TreeNode treeNode, List<String> targetNode) {

        List<TreeNode> nodes = treeNode.getChildren();
        List<TreeNode> newNodes = Lists.newArrayList();
        List<TreeNode> tagNodes = Lists.newArrayList();

        for (TreeNode node : nodes) {
            if (targetNode.contains(node.getNodeName())) {
                newNodes.add(node);
            }
            if (node.getChildren() != null && node.getChildren().size() > 0) {
                List<TreeNode> retNodes = filterNode(node, targetNode);
                if (retNodes.size() > 0) {
                    node.setChildren(retNodes);
                } else {
                    // 没有子节点情况
                    node.setChildren(null);
                    // 标记,循环结束后删除
                    tagNodes.add(node);
                }
            }
        }
        nodes.removeAll(tagNodes);
        return newNodes;
    }

}
