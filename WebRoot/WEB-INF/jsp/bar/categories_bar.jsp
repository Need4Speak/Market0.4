<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<style type="text/css">
body {
    background-color: #efefef;
}

.footbar {
    background-color: #ffffff;
    text-align: center;
    font-size: 18px;
}

a {
    color: #000000;
    text-decoration: none;
}
</style>
<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
    <div class="footbar" style="height:auto; border:0px; padding:10px;">
        <table border="0" cellpadding="0" cellspacing="0" width="100%">
            <tr>
                <td style="width:20%;">
                    <div>
                        <a href="showGoodsController">首页</a>
                    </div>
                </td>
                <td style="width:20%;">
                    <div>
                        <a href="collectionListController?collectionStatus=1">收藏</a>
                    </div>
                </td>
                <td style="width: 20%;">
                    <div>
                        <a href="goodInputController">发布</a>
                    </div>
                </td>
                <td style="width: 20%;">
                    <div>
                        <a href="goodListController">卖的</a>
                    </div>
                </td>
                <td style="width: 20%;">
                    <div>
                        <a href="userInfoController">我</a>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</nav>
