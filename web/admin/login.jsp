<%--
  Created by DylanHo.
  Date: 05/01/2018
  Email: imhhb1997@gmail.com
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <link rel="stylesheet" type="text/css" href="../css/element-ui.css">

    <style>
        .item {
            margin-top: 10px;
            margin-right: 40px;
        }
    </style>
</head>
<body>

<div id="app">
    <el-button @click="visible = true">按钮</el-button>
    <el-dialog :visible.sync="visible" title="Hello world">
        <p>欢迎使用 Element</p>
    </el-dialog>


    <el-button class="share-button" icon="el-icon-share" type="primary"></el-button>
    </el-badge>

    <el-row>
        <el-col :span="8">
            <div class="grid-content bg-purple"></div>
            <el-badge is-dot class="item">数据查询</el-badge>
            <el-badge is-dot class="item">嘻嘻</el-badge>
            <el-badge is-dot class="item"></el-badge>
        </el-col>
        <el-col :span="8">
            <el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
        </el-col>
        <el-col :span="8">
            <div class="grid-content bg-purple"></div>
        </el-col>
    </el-row>


</div>
</body>
<script src="../js/vue.js" type="text/javascript"></script>
<script src="../js/element-ui.js" type="text/javascript"></script>
<script>
    new Vue({
        el: '#app',
        data: function () {
            return {
                data: [{
                    label: '一级 1',
                    children: [{
                        label: '二级 1-1',
                        children: [{
                            label: '三级 1-1-1'
                        }]
                    }]
                }, {
                    label: '一级 2',
                    children: [{
                        label: '二级 2-1',
                        children: [{
                            label: '三级 2-1-1'
                        }]
                    }, {
                        label: '二级 2-2',
                        children: [{
                            label: '三级 2-2-1'
                        }]
                    }]
                }, {
                    label: '一级 3',
                    children: [{
                        label: '二级 3-1',
                        children: [{
                            label: '三级 3-1-1'
                        }]
                    }, {
                        label: '二级 3-2',
                        children: [{
                            label: '三级 3-2-1'
                        }]
                    }]
                }],
                visible: true,
                defaultProps: {
                    children: 'children',
                    label: 'label'
                }
            }
        },
        methods: {
            handleNodeClick(data) {
                console.log(data);
            }
        }
    })
</script>
</html>
