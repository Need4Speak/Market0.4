<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<style type="text/css">
body {
    background-color: #efefef;
}

.footbar {
    background-color: #ffffff;
    text-align: center;
    font-size: 18px;
    background:#d9534f;
}

a {
    color: #000000;
    text-decoration: none;
}

.whiteFont {
	color:#FFFFFF;
}
</style>
<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
    <div class="footbar" style="height:auto; border:0px; padding:10px;">
        <table border="0" cellpadding="0" cellspacing="0" width="100%">
            <tr>
                <td style="width:20%;">
                    <div>
                        <a href="showGoodsController"><span class="whiteFont">首页</span></a>
                    </div>
                </td>
                <td style="width:20%;">
                    <div>
                        <a href="collectionListController?collectionStatus=1"><span class="whiteFont">收藏</span></a>
                    </div>
                </td>
                <td style="width: 20%;">
                    <div>
                        <a href="goodInputController"><span class="whiteFont">发布</span></a>
                    </div>
                </td>
                <td style="width: 20%;">
                    <div>
                        <a href="goodListController"><span class="whiteFont">卖的</span></a>
                    </div>
                </td>
                <td style="width: 20%;">
                    <div>
                        <a href="userInfoController"><span class="whiteFont">我</span></a>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</nav>
